package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.*;

public class DelicacyRepositoryImpl implements DelicacyRepository<Delicacy>{

    private Collection <Delicacy> delicacyRepository;

    public DelicacyRepositoryImpl() {
        this.delicacyRepository = new ArrayList<>();
    }

    @Override
    public Delicacy getByName(String name) {
        return delicacyRepository
                .stream().filter(d -> d.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Delicacy> getAll() {
        return Collections.unmodifiableCollection(delicacyRepository);
    }

    @Override
    public void add(Delicacy delicacy) {
        delicacyRepository.add(delicacy);
    }
}
