/**
 * This file is part of Graylog Threat Manager.
 *
 * Graylog Threat Manager is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Graylog Threat Manager is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Graylog Threat Manager.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.graylog.plugins.threatmanager.db.mongodb;

import com.google.common.collect.Sets;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoException;
import org.graylog.plugins.threatmanager.db.ThreatManagerStreamConnectionsService;
import org.graylog.plugins.threatmanager.rest.ThreatManagerConnections;
import org.graylog2.bindings.providers.MongoJackObjectMapperProvider;
import org.graylog2.database.MongoConnection;
import org.graylog2.database.NotFoundException;
import org.mongojack.DBCursor;
import org.mongojack.DBQuery;
import org.mongojack.DBSort;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.Collections;
import java.util.Set;

public class MongoDbThreatManagerStreamConnectionsService implements ThreatManagerStreamConnectionsService {
    private static final Logger log = LoggerFactory.getLogger(MongoDbThreatManagerStreamConnectionsService.class);

    private static final String COLLECTION = "pipeline_processor_pipelines_streams";

    private final JacksonDBCollection<ThreatManagerConnections, String> dbCollection;

    @Inject
    public MongoDbThreatManagerStreamConnectionsService(MongoConnection mongoConnection, MongoJackObjectMapperProvider mapper) {
        dbCollection = JacksonDBCollection.wrap(
                mongoConnection.getDatabase().getCollection(COLLECTION),
                ThreatManagerConnections.class,
                String.class,
                mapper.get());
        dbCollection.createIndex(DBSort.asc("stream_id"), new BasicDBObject("unique", true));
    }


    @Override
    public ThreatManagerConnections save(ThreatManagerConnections connections) {
        ThreatManagerConnections existingConnections = dbCollection.findOne(DBQuery.is("stream_id", connections.streamId()));
        if (existingConnections == null) {
            existingConnections = ThreatManagerConnections.create(null, connections.streamId(), Collections.emptySet());
        }

        final ThreatManagerConnections toSave = existingConnections.toBuilder()
                .threatListIds(connections.threatListIds()).build();
        final WriteResult<ThreatManagerConnections, String> save = dbCollection.save(toSave);
        return save.getSavedObject();
    }

    @Override
    public ThreatManagerConnections load(String streamId) throws NotFoundException {
        final ThreatManagerConnections oneById = dbCollection.findOne(DBQuery.is("stream_id", streamId));
        if (oneById == null) {
            throw new NotFoundException("No pipeline connections with for stream " + streamId);
        }
        return oneById;
    }

    @Override
    public Set<ThreatManagerConnections> loadAll() {
        try {
            final DBCursor<ThreatManagerConnections> connections = dbCollection.find();
            return Sets.newHashSet(connections.iterator());
        } catch (MongoException e) {
            log.error("Unable to load pipeline connections", e);
            return Collections.emptySet();
        }
    }

    @Override
    public void delete(String streamId) {
        try {
            final ThreatManagerConnections connections = load(streamId);
            dbCollection.removeById(connections.id());
        } catch (NotFoundException e) {
            log.debug("No connections found for stream " + streamId);
        }
    }
}
