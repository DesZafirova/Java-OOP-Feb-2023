package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.cocktails.interfaces.Cocktail;

import java.util.*;

public class CocktailRepositoryImpl implements CocktailRepository<Cocktail>{
    private Collection <Cocktail> cocktailRepository;

    public CocktailRepositoryImpl() {
        this.cocktailRepository = new ArrayList<>();
    }

    @Override
    public Cocktail getByName(String name) {
        return cocktailRepository.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Cocktail> getAll() {
        return Collections.unmodifiableCollection(cocktailRepository);
    }

    @Override
    public void add(Cocktail cocktail) {
        cocktailRepository.add(cocktail);
    }
}
