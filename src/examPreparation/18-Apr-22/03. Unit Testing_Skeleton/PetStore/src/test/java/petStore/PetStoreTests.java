package petStore;

import org.junit.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PetStoreTests {
    Animal animal;
    PetStore petStore;

    @Before
    public void prepare() {
        animal = new Animal("mammal", 20, 120.50);
        petStore = new PetStore();

    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetUnmodifiableList() {
        addAnimals();
        this.petStore.getAnimals().clear();
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(0, petStore.getAnimals().size());
        addAnimals();
        int expected = petStore.getCount();
        int actual = petStore.getAnimals().size();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testFindAnimalsWithMaxKilogramsShouldReturnTheCorrectAnimal() {
        addAnimals();
        int kg = 20;
        List<Animal> expected = petStore.findAllAnimalsWithMaxKilograms(kg);
        List<Animal> actual = petStore.getAnimals().stream().filter(a -> a.getMaxKilograms() > kg).collect(Collectors.toList());
        Assert.assertEquals(expected, actual);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalShouldFailWhenAnimalIsNull(){
        petStore.addAnimal(null);
        int actual = petStore.getAnimals().size();
        Assert.assertEquals(0, actual);
        Assert.assertNull(petStore);
    }
    @Test
    public void testGetTheMostExpensiveAnimal(){
        addAnimals();
        Animal expected = petStore.getTheMostExpensiveAnimal();
        List<Animal> ordered = petStore.getAnimals().stream()
                .sorted(Comparator.comparing(Animal::getPrice).reversed()).collect(Collectors.toList());
        Assert.assertEquals(expected, ordered.get(0));
        Assert.assertEquals(expected.getPrice(), ordered.get(0).getPrice(), 0.00);
    }
    @Test
    public void testGetAnimalBySpecie(){
        petStore.addAnimal(animal);
        addAnimals();
        List<Animal> actual = petStore.findAllAnimalBySpecie("mammal");
        List<Animal> mammal = petStore.getAnimals().stream().filter(m -> m.getSpecie().equals("mammal")).collect(Collectors.toList());
        Assert.assertEquals(mammal, actual);
        Assert.assertEquals(actual.size(), mammal.size());
    }

    public void addAnimals() {
        petStore.addAnimal(new Animal("reptile", 30, 20.00));
        petStore.addAnimal(new Animal("insects", 1, 60.00));
        petStore.addAnimal(new Animal("bird", 3, 800.00));
        petStore.addAnimal(new Animal("amphibians", 50, 710.00));
        petStore.addAnimal(new Animal("mammal", 80, 602.00));
    }

}

