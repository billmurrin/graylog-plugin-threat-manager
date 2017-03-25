/**
 * This file is part of Graylog Pipeline Processor.
 *
 * Graylog Pipeline Processor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Graylog Pipeline Processor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Graylog Pipeline Processor.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.graylog.plugins.threatmanager.rest;

import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.graylog.plugins.threatmanager.ast.Pipeline;
import org.graylog.plugins.threatmanager.audit.ThreatManagerAuditEventTypes;
import org.graylog.plugins.threatmanager.db.ThreatManagerDao;
import org.graylog.plugins.threatmanager.db.ThreatManagerService;
import org.graylog.plugins.threatmanager.events.ThreatManagerChangedEvent;
import org.graylog.plugins.threatmanager.parser.ParseException;
import org.graylog.plugins.threatmanager.parser.PipelineRuleParser;
import org.graylog2.audit.jersey.AuditEvent;
import org.graylog2.audit.jersey.NoAuditEvent;
import org.graylog2.database.NotFoundException;
import org.graylog2.events.ClusterEventBus;
import org.graylog2.plugin.rest.PluginRestResource;
import org.graylog2.shared.rest.resources.RestResource;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;

@Api(value = "Pipelines/Pipelines", description = "Pipelines for the pipeline message processor")
@Path("/system/pipelines/pipeline")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequiresAuthentication
public class ThreatManagerResource extends RestResource implements PluginRestResource {

    private static final Logger log = LoggerFactory.getLogger(ThreatManagerResource.class);

    private final ThreatManagerService pipelineService;
    private final PipelineRuleParser pipelineRuleParser;
    private final EventBus clusterBus;

    @Inject
    public PipelineResource(ThreatManagerService pipelineService,
                        PipelineRuleParser pipelineRuleParser,
                        ClusterEventBus clusterBus) {
        this.pipelineService = pipelineService;
        this.pipelineRuleParser = pipelineRuleParser;
        this.clusterBus = clusterBus;
    }

    @ApiOperation(value = "Create a processing pipeline from source", notes = "")
    @POST
    @RequiresPermissions(ThreatManagerRestPermissions.THREATLIST_CREATE)
    @AuditEvent(type = ThreatManagerAuditEventTypes.THREATLIST_CREATE)
    public ThreatManagerSource createFromParser(@ApiParam(name = "pipeline", required = true) @NotNull ThreatManagerSource pipelineSource) throws ParseException {
        final Pipeline pipeline;
        try {
            pipeline = pipelineRuleParser.parsePipeline(pipelineSource.id(), pipelineSource.source());
        } catch (ParseException e) {
            throw new BadRequestException(Response.status(Response.Status.BAD_REQUEST).entity(e.getErrors()).build());
        }
        final ThreatManagerDao pipelineDao = ThreatManagerDao.builder()
                .title(pipeline.name())
                .description(pipelineSource.description())
                .source(pipelineSource.source())
                .createdAt(DateTime.now())
                .modifiedAt(DateTime.now())
                .build();
        final ThreatManagerDao save = pipelineService.save(pipelineDao);
        clusterBus.post(ThreatManagerChangedEvent.updatedPipelineId(save.id()));
        log.debug("Created new pipeline {}", save);
        return ThreatManagerSource.fromDao(pipelineRuleParser, save);
    }

    @ApiOperation(value = "Parse a processing pipeline without saving it", notes = "")
    @POST
    @Path("/parse")
    @NoAuditEvent("only used to parse a pipeline, no changes made in the system")
    public ThreatManagerSource parse(@ApiParam(name = "pipeline", required = true) @NotNull ThreatManagerSource pipelineSource) throws ParseException {
        final Pipeline pipeline;
        try {
            pipeline = pipelineRuleParser.parsePipeline(pipelineSource.id(), pipelineSource.source());
        } catch (ParseException e) {
            throw new BadRequestException(Response.status(Response.Status.BAD_REQUEST).entity(e.getErrors()).build());
        }
        return ThreatManagerSource.builder()
                .title(pipeline.name())
                .description(pipelineSource.description())
                .source(pipelineSource.source())
                .createdAt(DateTime.now())
                .modifiedAt(DateTime.now())
                .build();
    }

    @ApiOperation(value = "Get all processing pipelines")
    @GET
    public Collection<ThreatManagerSource> getAll() {
        final Collection<ThreatManagerDao> daos = pipelineService.loadAll();
        final ArrayList<ThreatManagerSource> results = Lists.newArrayList();
        for (ThreatManagerDao dao : daos) {
            if (isPermitted(ThreatManagerRestPermissions.THREATLIST_READ, dao.id())) {
                results.add(ThreatManagerSource.fromDao(pipelineRuleParser, dao));
            }
        }

        return results;
    }

    @ApiOperation(value = "Get a processing pipeline", notes = "It can take up to a second until the change is applied")
    @Path("/{id}")
    @GET
    public ThreatManagerSource get(@ApiParam(name = "id") @PathParam("id") String id) throws NotFoundException {
        checkPermission(ThreatManagerRestPermissions.THREATLIST_READ, id);
        final ThreatManagerDao dao = pipelineService.load(id);
        return ThreatManagerSource.fromDao(pipelineRuleParser, dao);
    }

    @ApiOperation(value = "Modify a processing pipeline", notes = "It can take up to a second until the change is applied")
    @Path("/{id}")
    @PUT
    @AuditEvent(type = ThreatManagerAuditEventTypes.THREATLIST_UPDATE)
    public ThreatManagerSource update(@ApiParam(name = "id") @PathParam("id") String id,
                             @ApiParam(name = "pipeline", required = true) @NotNull ThreatManagerSource update) throws NotFoundException {
        checkPermission(ThreatManagerRestPermissions.THREATLIST_EDIT, id);

        final ThreatManagerDao dao = pipelineService.load(id);
        final Pipeline pipeline;
        try {
            pipeline = pipelineRuleParser.parsePipeline(update.id(), update.source());
        } catch (ParseException e) {
            throw new BadRequestException(Response.status(Response.Status.BAD_REQUEST).entity(e.getErrors()).build());
        }
        final ThreatManagerDao toSave = dao.toBuilder()
                .title(pipeline.name())
                .description(update.description())
                .source(update.source())
                .modifiedAt(DateTime.now())
                .build();
        final ThreatManagerDao savedPipeline = pipelineService.save(toSave);
        clusterBus.post(ThreatManagerChangedEvent.updatedPipelineId(savedPipeline.id()));

        return ThreatManagerSource.fromDao(pipelineRuleParser, savedPipeline);
    }

    @ApiOperation(value = "Delete a processing pipeline", notes = "It can take up to a second until the change is applied")
    @Path("/{id}")
    @DELETE
    @AuditEvent(type = ThreatManagerAuditEventTypes.THREATLIST_DELETE)
    public void delete(@ApiParam(name = "id") @PathParam("id") String id) throws NotFoundException {
        checkPermission(ThreatManagerRestPermissions.THREATLIST_DELETE, id);

        pipelineService.load(id);
        pipelineService.delete(id);
        clusterBus.post(ThreatManagerChangedEvent.deletedPipelineId(id));
    }

}
