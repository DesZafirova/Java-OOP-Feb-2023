package restaurant.repositories;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.repositories.interfaces.BeverageRepository;

import java.util.*;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages> {
    private List<Beverages> beverages;

    public BeverageRepositoryImpl() {
        beverages = new ArrayList<>();
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
       return beverages.stream().filter(b -> b.getName().equals(drinkName) && b.getBrand().equals(drinkBrand))
               .findFirst().orElse(null);
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return beverages;
    }

    @Override
    public void add(Beverages entity) {
        beverages.add(entity);
    }
}
