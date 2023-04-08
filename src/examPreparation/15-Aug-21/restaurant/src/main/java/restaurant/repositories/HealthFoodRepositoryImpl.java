package restaurant.repositories;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.repositories.interfaces.HealthFoodRepository;

import java.util.*;
import java.util.stream.Collectors;

public class HealthFoodRepositoryImpl implements HealthFoodRepository<HealthyFood> {
    private Map<String, HealthyFood> healthyFood;

    public HealthFoodRepositoryImpl() {
        healthyFood = new LinkedHashMap<>();
    }
    @Override
    public HealthyFood foodByName(String name) {
        return healthyFood.get(name);
    }

    @Override
    public Collection<HealthyFood> getAllEntities() {
        return healthyFood.values();
    }

    @Override
    public void add(HealthyFood entity) {
        healthyFood.put(entity.getName(), entity);
    }
}
