package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseTests {
    private Cat cat;
    private House house;
    @Before
    public void prepare(){
        house = new House("test_house", 3);
        cat = new Cat("test_cat");
    }

    @Test
    public void testSetNameOfTheCat(){
        Cat catName = new Cat("test");
        Assert.assertEquals("test", catName.getName());

    }
    @Test(expected = NullPointerException.class)
    public void testSetNameOfTheCatShouldFailWhenIsNull(){
      House testHouse = new House(null, 5);
      Assert.assertNull(testHouse.getName());
    }
    @Test(expected = NullPointerException.class)
    public void testSetNameOfTheCatShouldFailWhenIsEmpty(){
        House testHouse = new House("   ", 5);

    }
    @Test
    public void testSetCapacity(){

        Cat catName = new Cat("test");
        house.addCat(cat);
        house.addCat(catName);
        Assert.assertEquals(2, house.getCount());

    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldFailWhenCapacityIsNegative(){
        House testHouse = new House("Some_Name", -1);

    }
    @Test
    public void testGetCapacityShouldReturnCorrect(){
        int actual = house.getCapacity();
        Assert.assertEquals(3, actual);
    }
    @Test
    public void testAddCat(){
        house.addCat(cat);
        Assert.assertEquals(1, house.getCount());
        house.addCat(new Cat("George"));
        Assert.assertEquals(2, house.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddCatShouldFailWhenNoCapacity(){
        house.addCat(cat);
        Assert.assertEquals(1, house.getCount());
        house.addCat(new Cat("George"));
        house.addCat(new Cat("Sam"));
        house.addCat(new Cat("test"));
        Assert.assertEquals(3, house.getCount());
    }
    @Test
    public void testRemoveCatShouldRemove(){
        house.addCat(cat);
        Assert.assertEquals(1, house.getCount());
        house.removeCat("test_cat");
        Assert.assertEquals(0, house.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatShouldFailWhenNoSuchName(){
        house.addCat(cat);
        Assert.assertEquals(1, house.getCount());
        house.removeCat("test");
        Assert.assertEquals(1, house.getCount());
    }
    @Test
    public void testCatForSaleShouldRemove(){
        house.addCat(cat);
        Assert.assertEquals(1, house.getCount());
        house.catForSale("test_cat");
        Assert.assertEquals(1, house.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleShouldFailWhenNoSuchName(){
        house.addCat(cat);
        Assert.assertEquals(1, house.getCount());
        house.catForSale("test");
        Assert.assertEquals(1, house.getCount());
    }
    @Test
    public void testGetStatistic(){
        house.addCat(cat);
        String houseName = house.getName();
        String catName = cat.getName();
        Assert.assertEquals("test_house", houseName);
        Assert.assertEquals("test_cat", catName);
        house.addCat(new Cat("George"));
        house.addCat(new Cat("Sam"));
        String actual = house.statistics();
        String expected = "The cat test_cat, George, Sam is in the house test_house!";
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void testGetCapacity(){
        house.addCat(cat);
        house.addCat(new Cat("George"));
        house.addCat(new Cat("Sam"));
        int capacity = house.getCapacity();
        Assert.assertEquals(3, capacity);

    }



}
