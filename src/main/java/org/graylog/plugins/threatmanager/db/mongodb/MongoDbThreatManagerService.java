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
import org.graylog.plugins.threatmanager.db.ThreatManagerDao;
import org.graylog.plugins.threatmanager.db.ThreatManagerService;
import org.graylog2.bindings.providers.MongoJackObjectMapperProvider;
import org.graylog2.database.MongoConnection;
import org.graylog2.database.NotFoundException;
import org.mongojack.DBCursor;
import org.mongojack.DBSort;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.Collection;
import java.util.Collections;

public class MongoDbThreatManagerService implements ThreatManagerService {
    private static final Logger log = LoggerFactory.getLogger(MongoDbThreatManagerService.class);

    private static final String COLLECTION = "pipeline_processor_pipelines";

    private final JacksonDBCollection<ThreatManagerDao, String> dbCollection;

    @Inject
    public MongoDbThreatManagerService(MongoConnection mongoConnection, MongoJackObjectMapperProvider mapper) {
        dbCollection = JacksonDBCollection.wrap(
                mongoConnection.getDatabase().getCollection(COLLECTION),
                ThreatManagerDao.class,
                String.class,
                mapper.get());
        dbCollection.createIndex(DBSort.asc("title"), new BasicDBObject("unique", true));
    }

    @Override
    public ThreatManagerDao save(ThreatManagerDao pipeline) {
        final WriteResult<ThreatManagerDao, String> save = dbCollection.save(pipeline);
        return save.getSavedObject();
    }

    @Override
    public ThreatManagerDao load(String id) throws NotFoundException {
        final ThreatManagerDao pipeline = dbCollection.findOneById(id);
        if (pipeline == null) {
            throw new NotFoundException("No pipeline with id " + id);
        }
        return pipeline;
    }

    @Override
    public Collection<ThreatManagerDao> loadAll() {
        try {
            final DBCursor<ThreatManagerDao> daos = dbCollection.find();
            return Sets.newHashSet(daos.iterator());
        } catch (MongoException e) {
            log.error("Unable to load pipelines", e);
            return Collections.emptySet();
        }
    }

    @Override
    public void delete(String id) {
        dbCollection.removeById(id);
    }
}
