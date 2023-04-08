package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {

    private Farm farm;
    private Animal animal;

    @Before
    public void prepare() {
        this.farm = new Farm("test_farm", 5);
        animal = new Animal("goat", 50);
    }

    @Test
    public void testSetNameOfTheFarm() {
        Farm farm2 = new Farm("Another_farm", 3);
        Assert.assertEquals("Another_farm", farm2.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameOfTheFarmShouldFailWhenIsEmpty() {
        Farm farm2 = new Farm("  ", 3);

    }

    @Test(expected = NullPointerException.class)
    public void testSetNameOfTheFarmShouldFailWhenIsNull() {
        Farm farm2 = new Farm(null, 3);
        Assert.assertNull(farm2.getName());
    }

    @Test
    public void testShouldReturnCapacity() {
        int actual = farm.getCapacity();
        Assert.assertEquals(5, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldFailWhenCapacityIsNegative() {
        Farm farm1 = new Farm("test_name", -1);

    }

    @Test
    public void testGetCountShouldReturnCorrectNumberOfAnimals() {
        farm.add(animal);
        Assert.assertEquals(1, farm.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalShouldFailWhenFarmIsFull() {
        Farm fullFarm = new Farm("full_farm", 2);
        fullFarm.add(animal);
        fullFarm.add(new Animal("duck", 15));
        fullFarm.add(new Animal("horse", 150));
        Assert.assertEquals(2, farm.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalShouldFailWhenAlreadyExistTheTypeAnimal() {
        addAnimalsInFarm();
        farm.add(new Animal("sheep", 60));
    }
    @Test
    public void testAddAnimalShouldAddCorrect(){
        addAnimalsInFarm();
        Assert.assertEquals(3, farm.getCount());
    }
    @Test
    public void testRemoveShouldRemoveAnimalByType(){
        addAnimalsInFarm();
        Assert.assertTrue(farm.remove("horse"));
        Assert.assertEquals(2, farm.getCount());
        Assert.assertFalse(animal.getType().equals("horse"));
    }


    public void addAnimalsInFarm() {
        farm.add(new Animal("sheep", 10));
        farm.add(new Animal("buffalo", 10));
        farm.add(new Animal("horse", 10));
    }
}
