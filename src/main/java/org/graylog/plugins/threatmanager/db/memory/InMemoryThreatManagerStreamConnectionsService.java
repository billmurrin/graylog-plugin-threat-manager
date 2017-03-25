package org.graylog.plugins.threatmanager.db.memory;
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
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.MapMaker;
import org.graylog.plugins.threatmanager.db.ThreatManagerStreamConnectionsService;
import org.graylog.plugins.threatmanager.rest.ThreatManagerConnections;
import org.graylog2.database.NotFoundException;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryThreatManagerStreamConnectionsService implements ThreatManagerStreamConnectionsService {

    // poor man's id generator
    private AtomicLong idGen = new AtomicLong(0);

    private Map<String, ThreatManagerConnections> store = new MapMaker().makeMap();

    @Override
    public ThreatManagerConnections save(ThreatManagerConnections connections) {
        ThreatManagerConnections toSave = connections.id() != null
                ? connections
                : connections.toBuilder().id(createId()).build();
        store.put(toSave.id(), toSave);

        return toSave;
    }

    @Override
    public ThreatManagerConnections load(String streamId) throws NotFoundException {
        final ThreatManagerConnections connections = store.get(streamId);
        if (connections == null) {
            throw new NotFoundException("No such pipeline connections for stream " + streamId);
        }
        return connections;
    }

    @Override
    public Set<ThreatManagerConnections> loadAll() {
        return ImmutableSet.copyOf(store.values());
    }

    @Override
    public void delete(String streamId) {
        try {
            final ThreatManagerConnections connections = load(streamId);
            store.remove(connections.id());
        } catch (NotFoundException e) {
            // Do nothing
        }
    }

    private String createId() {
        return String.valueOf(idGen.incrementAndGet());
    }
}
