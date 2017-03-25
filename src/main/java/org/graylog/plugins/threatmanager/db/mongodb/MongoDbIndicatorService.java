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
import org.graylog.plugins.threatmanager.db.IndicatorDao;
import org.graylog.plugins.threatmanager.db.IndicatorService;
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
import java.util.Collection;
import java.util.Collections;

/**
 * A RuleService backed by a MongoDB collection.
 */
public class MongoDbIndicatorService implements IndicatorService {
    private static final Logger log = LoggerFactory.getLogger(MongoDbIndicatorService.class);

    private static final String COLLECTION = "pipeline_processor_rules";

    private final JacksonDBCollection<IndicatorDao, String> dbCollection;

    @Inject
    public MongoDbIndicatorService(MongoConnection mongoConnection, MongoJackObjectMapperProvider mapper) {
        dbCollection = JacksonDBCollection.wrap(
                mongoConnection.getDatabase().getCollection(COLLECTION),
                IndicatorDao.class,
                String.class,
                mapper.get());
        dbCollection.createIndex(DBSort.asc("title"), new BasicDBObject("unique", true));
    }

    @Override
    public IndicatorDao save(IndicatorDao rule) {
        final WriteResult<IndicatorDao, String> save = dbCollection.save(rule);
        return save.getSavedObject();
    }

    @Override
    public IndicatorDao load(String id) throws NotFoundException {
        final IndicatorDao rule = dbCollection.findOneById(id);
        if (rule == null) {
            throw new NotFoundException("No rule with id " + id);
        }
        return rule;
    }

    @Override
    public Collection<IndicatorDao> loadAll() {
        try {
            final DBCursor<IndicatorDao> ruleDaos = dbCollection.find();
            return Sets.newHashSet(ruleDaos.iterator());
        } catch (MongoException e) {
            log.error("Unable to load processing rules", e);
            return Collections.emptySet();
        }
    }

    @Override
    public void delete(String id) {
        final WriteResult<IndicatorDao, String> result = dbCollection.removeById(id);
        if (result.getN() != 1) {
            log.error("Unable to delete rule {}", id);
        }
    }

    @Override
    public Collection<IndicatorDao> loadNamed(Collection<String> ruleNames) {
        try {
            final DBCursor<IndicatorDao> ruleDaos = dbCollection.find(DBQuery.in("title", ruleNames));
            return Sets.newHashSet(ruleDaos.iterator());
        } catch (MongoException e) {
            log.error("Unable to bulk load rules", e);
            return Collections.emptySet();
        }
    }
}
