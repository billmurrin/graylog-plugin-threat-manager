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

import com.google.common.collect.Sets;
import com.google.common.eventbus.EventBus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.graylog.plugins.threatmanager.audit.ThreatManagerAuditEventTypes;
import org.graylog.plugins.threatmanager.db.ThreatManagerService;
import org.graylog.plugins.threatmanager.db.ThreatManagerStreamConnectionsService;
import org.graylog.plugins.threatmanager.events.ThreatManagerConnectionsChangedEvent;
import org.graylog2.audit.jersey.AuditEvent;
import org.graylog2.database.NotFoundException;
import org.graylog2.events.ClusterEventBus;
import org.graylog2.plugin.rest.PluginRestResource;
import org.graylog2.shared.rest.resources.RestResource;
import org.graylog2.shared.security.RestPermissions;
import org.graylog2.streams.StreamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Set;
import java.util.stream.Collectors;

@Api(value = "Pipelines/Connections", description = "Stream connections of processing pipelines")
@Path("/system/pipelines/connections")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequiresAuthentication
public class ThreatManagerConnectionsResource extends RestResource implements PluginRestResource {
    private static final Logger LOG = LoggerFactory.getLogger(ThreatManagerConnectionsResource.class);

    private final ThreatManagerStreamConnectionsService connectionsService;
    private final ThreatManagerService pipelineService;
    private final StreamService streamService;
    private final EventBus clusterBus;

    @Inject
    public ThreatManagerConnectionsResource(ThreatManagerStreamConnectionsService connectionsService,
                                       ThreatManagerService pipelineService,
                                       StreamService streamService,
                                       ClusterEventBus clusterBus) {
        this.connectionsService = connectionsService;
        this.pipelineService = pipelineService;
        this.streamService = streamService;
        this.clusterBus = clusterBus;
    }

    @ApiOperation(value = "Connect processing pipelines to a stream", notes = "")
    @POST
    @Path("/to_stream")
    @RequiresPermissions(ThreatManagerRestPermissions.THREATLIST_CONNECTION_EDIT)
    @AuditEvent(type = ThreatManagerAuditEventTypes.THREATLIST_CONNECTION_UPDATE)
    public ThreatManagerConnections connectPipelines(@ApiParam(name = "Json body", required = true) @NotNull ThreatManagerConnections connection) throws NotFoundException {
        final String streamId = connection.streamId();
        // verify the stream exists
        checkPermission(RestPermissions.STREAMS_READ, streamId);
        streamService.load(streamId);

        // verify the pipelines exist
        for (String s : connection.pipelineIds()) {
            checkPermission(ThreatManagerRestPermissions.THREATLIST_READ, s);
            pipelineService.load(s);
        }
        return saveThreatManagerConnections(connection);
    }

    @ApiOperation(value = "Connect streams to a processing pipeline", notes = "")
    @POST
    @Path("/to_pipeline")
    @RequiresPermissions(ThreatManagerRestPermissions.THREATLIST_CONNECTION_EDIT)
    @AuditEvent(type = ThreatManagerAuditEventTypes.THREATLIST_CONNECTION_UPDATE)
    public Set<ThreatManagerConnections> connectStreams(@ApiParam(name = "Json body", required = true) @NotNull ThreatManagerReverseConnections connection) throws NotFoundException {
        final String pipelineId = connection.pipelineId();
        final Set<ThreatManagerConnections> updatedConnections = Sets.newHashSet();

        // verify the pipeline exists
        checkPermission(ThreatManagerRestPermissions.THREATLIST_READ, pipelineId);
        pipelineService.load(pipelineId);

        // get all connections where the pipeline was present
        final Set<ThreatManagerConnections> pipelineConnections = connectionsService.loadAll().stream()
                .filter(p -> p.pipelineIds().contains(pipelineId))
                .collect(Collectors.toSet());

        // remove deleted pipeline connections
        for (ThreatManagerConnections pipelineConnection : pipelineConnections) {
            if (!connection.streamIds().contains(pipelineConnection.streamId())) {
                final Set<String> pipelines = pipelineConnection.pipelineIds();
                pipelines.remove(connection.pipelineId());
                pipelineConnection.toBuilder().pipelineIds(pipelines).build();

                updatedConnections.add(pipelineConnection);
                saveThreatManagerConnections(pipelineConnection);
                LOG.debug("Deleted stream {} connection with pipeline {}", pipelineConnection.streamId(), pipelineId);
            }
        }

        // update pipeline connections
        for (String streamId : connection.streamIds()) {
            // verify the stream exist
            checkPermission(RestPermissions.STREAMS_READ, streamId);
            streamService.load(streamId);

            ThreatManagerConnections updatedConnection;
            try {
                updatedConnection = connectionsService.load(streamId);
            } catch (NotFoundException e) {
                updatedConnection = ThreatManagerConnections.create(null, streamId, Sets.newHashSet());
            }

            final Set<String> pipelines = updatedConnection.pipelineIds();
            pipelines.add(pipelineId);
            updatedConnection.toBuilder().pipelineIds(pipelines).build();

            updatedConnections.add(updatedConnection);
            saveThreatManagerConnections(updatedConnection);
            LOG.debug("Added stream {} connection with pipeline {}", streamId, pipelineId);
        }

        return updatedConnections;
    }

    @ApiOperation("Get pipeline connections for the given stream")
    @GET
    @Path("/{streamId}")
    @RequiresPermissions(ThreatManagerRestPermissions.THREATLIST_CONNECTION_READ)
    public ThreatManagerConnections getPipelinesForStream(@ApiParam(name = "streamId") @PathParam("streamId") String streamId) throws NotFoundException {
        // the user needs to at least be able to read the stream
        checkPermission(RestPermissions.STREAMS_READ, streamId);

        final ThreatManagerConnections connections = connectionsService.load(streamId);
        // filter out all pipelines the user does not have enough permissions to see
        return ThreatManagerConnections.create(
                connections.id(),
                connections.streamId(),
                connections.pipelineIds()
                        .stream()
                        .filter(id -> isPermitted(ThreatManagerRestPermissions.THREATLIST_READ, id))
                        .collect(Collectors.toSet())
        );
    }

    @ApiOperation("Get all pipeline connections")
    @GET
    @RequiresPermissions(ThreatManagerRestPermissions.THREATLIST_CONNECTION_READ)
    public Set<ThreatManagerConnections> getAll() throws NotFoundException {
        final Set<ThreatManagerConnections> pipelineConnections = connectionsService.loadAll();

        final Set<ThreatManagerConnections> filteredConnections = Sets.newHashSetWithExpectedSize(pipelineConnections.size());
        for (ThreatManagerConnections pc : pipelineConnections) {
            // only include the streams the user can see
            if (isPermitted(RestPermissions.STREAMS_READ, pc.streamId())) {
                // filter out all pipelines the user does not have enough permissions to see
                filteredConnections.add(ThreatManagerConnections.create(
                        pc.id(),
                        pc.streamId(),
                        pc.pipelineIds()
                                .stream()
                                .filter(id -> isPermitted(ThreatManagerRestPermissions.THREATLIST_READ, id))
                                .collect(Collectors.toSet()))
                );
            }
        }

        return filteredConnections;
    }

    private ThreatManagerConnections saveThreatManagerConnections(ThreatManagerConnections connection) {
        final ThreatManagerConnections save = connectionsService.save(connection);
        clusterBus.post(ThreatManagerConnectionsChangedEvent.create(save.streamId(), save.pipelineIds()));
        return save;
    }

}
