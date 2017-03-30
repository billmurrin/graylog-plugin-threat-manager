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
import com.google.common.collect.Sets;
import org.graylog.plugins.threatmanager.db.IndicatorDao;
import org.graylog.plugins.threatmanager.db.IndicatorService;
import org.graylog2.database.NotFoundException;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * A RuleService that does not persist any data, but simply keeps it in memory.
 */
public class InMemoryIndicatorService implements IndicatorService {

    // poor man's id generator
    private AtomicLong idGen = new AtomicLong(0);

    private Map<String, IndicatorDao> store = new MapMaker().makeMap();
    private Map<String, String> titleToId = new MapMaker().makeMap();

    @Override
    public IndicatorDao save(IndicatorDao rule) {
        IndicatorDao toSave = rule.id() != null
                ? rule
                : rule.toBuilder().id(createId()).build();
        // enforce the title unique constraint
        if (titleToId.containsKey(toSave.name())) {
            // if this is an update and the title belongs to the passed rule, then it's fine
            if (!titleToId.get(toSave.name()).equals(toSave.id())) {
                throw new IllegalArgumentException("Duplicate indicators are not allowed: " + toSave.name());
            }
        }
        titleToId.put(toSave.name(), toSave.id());
        store.put(toSave.id(), toSave);

        return toSave;
    }

    @Override
    public IndicatorDao load(String id) throws NotFoundException {
        final IndicatorDao rule = store.get(id);
        if (rule == null) {
            throw new NotFoundException("No such rule with id " + id);
        }
        return rule;
    }

    @Override
    public Collection<IndicatorDao> loadAll() {
        return ImmutableSet.copyOf(store.values());
    }

    @Override
    public void delete(String id) {
        if (id == null) {
            return;
        }
        final IndicatorDao removed = store.remove(id);
        // clean up title index if the rule existed
        if (removed != null) {
            titleToId.remove(removed.name());
        }
    }

    @Override
    public Collection<IndicatorDao> loadNamed(Collection<String> ruleNames) {
        final Set<String> needles = Sets.newHashSet(ruleNames);
        return store.values().stream()
                .filter(IndicatorDao -> needles.contains(IndicatorDao.name()))
                .collect(Collectors.toList());
    }

    private String createId() {
        return String.valueOf(idGen.incrementAndGet());
    }
}
