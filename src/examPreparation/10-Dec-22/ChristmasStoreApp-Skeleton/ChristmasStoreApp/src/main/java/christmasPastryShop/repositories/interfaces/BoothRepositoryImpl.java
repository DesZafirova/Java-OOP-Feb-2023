package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.booths.interfaces.Booth;

import java.util.*;

public class BoothRepositoryImpl implements BoothRepository<Booth>{
    private Collection<Booth> boothRepository;

    public BoothRepositoryImpl() {
        this.boothRepository = new ArrayList<>();
    }

    @Override
    public Booth getByNumber(int number) {
        return boothRepository.stream().filter(b -> b.getBoothNumber() == number)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Booth> getAll() {
        return Collections.unmodifiableCollection(boothRepository);
    }

    @Override
    public void add(Booth booth) {
        boothRepository.add(booth);
    }
}
