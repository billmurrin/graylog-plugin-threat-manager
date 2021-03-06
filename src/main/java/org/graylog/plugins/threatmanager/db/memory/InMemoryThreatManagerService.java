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
package org.graylog.plugins.threatmanager.db.memory;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.MapMaker;
import org.graylog.plugins.threatmanager.db.ThreatManagerDao;
import org.graylog.plugins.threatmanager.db.ThreatManagerService;
import org.graylog2.database.NotFoundException;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * A PipelineService that does not persist any data, but simply keeps it in memory.
 */
public class InMemoryThreatManagerService implements ThreatManagerService {

    // poor man's id generator
    private AtomicLong idGen = new AtomicLong(0);

    private Map<String, ThreatManagerDao> store = new MapMaker().makeMap();
    private Map<String, String> titleToId = new MapMaker().makeMap();

    @Override
    public ThreatManagerDao save(ThreatManagerDao pipeline) {
        ThreatManagerDao toSave = pipeline.id() != null
                ? pipeline
                : pipeline.toBuilder().id(createId()).build();
        // enforce the title unique constraint
        if (titleToId.containsKey(toSave.title())) {
            // if this is an update and the title belongs to the passed pipeline, then it's fine
            if (!titleToId.get(toSave.title()).equals(toSave.id())) {
                throw new IllegalArgumentException("Duplicate pipeline titles are not allowed: " + toSave.title());
            }
        }
        titleToId.put(toSave.title(), toSave.id());
        store.put(toSave.id(), toSave);

        return toSave;
    }

    @Override
    public ThreatManagerDao load(String id) throws NotFoundException {
        final ThreatManagerDao pipeline = store.get(id);
        if (pipeline == null) {
            throw new NotFoundException("No such pipeline with id " + id);
        }
        return pipeline;
    }

    @Override
    public Collection<ThreatManagerDao> loadAll() {
        return ImmutableSet.copyOf(store.values());
    }

    @Override
    public void delete(String id) {
        if (id == null) {
            return;
        }
        final ThreatManagerDao removed = store.remove(id);
        // clean up title index if the pipeline existed
        if (removed != null) {
            titleToId.remove(removed.title());
        }
    }

    private String createId() {
        return String.valueOf(idGen.incrementAndGet());
    }
}
