package christmasRaces.repositories.interfaces;

import christmasRaces.entities.races.Race;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class RaceRepository implements Repository<Race>{

    private Map<String, Race> races;

    public RaceRepository() {
        races = new LinkedHashMap<>();
    }

    @Override
    public Race getByName(String name) {

        return races.get(name);
    }

    @Override
    public Collection<Race> getAll() {
        return races.values();
    }

    @Override
    public void add(Race model) {
        races.put(model.getName(), model);
    }

    @Override
    public boolean remove(Race model) {
        return remove(model);
    }
}
