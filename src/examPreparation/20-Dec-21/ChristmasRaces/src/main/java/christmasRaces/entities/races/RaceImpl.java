package christmasRaces.entities.races;

import christmasRaces.entities.cars.Car;
import christmasRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static christmasRaces.common.ExceptionMessages.*;

public class RaceImpl implements Race {
    private String name;
    private int laps;
    private List<Driver> drivers;

    public RaceImpl(String name, int laps) {
        setName(name);
        setLaps(laps);
        drivers = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 5) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, 5));
        }
        this.name = name;
    }

    public void setLaps(int laps) {
        if (laps < 1) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_LAPS, 1));

        }
        this.laps = laps;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLaps() {
        return laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return drivers;
    }

    @Override
    public void addDriver(Driver driver) {
        if(driver == null){
            throw new IllegalArgumentException(DRIVER_INVALID);
        }

        if(driver.getCanParticipate()){
            throw new IllegalArgumentException(String.format(DRIVER_NOT_PARTICIPATE, driver));
        }
        for (Driver existingDriver : drivers) {
            if(existingDriver.equals(driver)){
                throw new IllegalArgumentException(String.format(DRIVER_ALREADY_ADDED, driver, name));
            }
        }
        drivers.add(driver);

    }
}
