package robots;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ServiceTests {
    private Service service;
    private Robot robot;
    @Before
    public void prepare(){
        service = new Service("test_service", 4);
        robot = new Robot("test_robot");

    }
    @Test(expected = NullPointerException.class)
    public void testServiceNameShouldFailWhenIsNull(){
        Service service1 = new Service(null, 5);

    }
    @Test(expected = NullPointerException.class)
    public void testServiceNameShouldFailWhenIsEmpty(){
        Service service1 = new Service("   ", 5);

    }
    @Test
    public void testGetName(){
        String actual = service.getName();
        Assert.assertEquals("test_service", actual);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldFailWhenIsNegative(){
        Service service1 = new Service("test_capacity", -1);

    }
    @Test
    public void testGetCapacity(){
        service.add(new Robot("test1"));
        service.add(new Robot("test2"));
        service.add(new Robot("test3"));
        service.add(new Robot("test4"));
        int actual = service.getCapacity();
        Assert.assertEquals(4, actual);
        Service service1 = new Service("test", 0);
        Assert.assertEquals(0, service1.getCapacity());
    }
    @Test
    public void testGetCountShouldReturnRobotsSize(){
        service.add(new Robot("test1"));
        service.add(new Robot("test2"));
        service.add(new Robot("test3"));
        service.add(new Robot("test4"));
        int actual = service.getCount();
        Assert.assertEquals(4, actual);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddRobotShouldFailWhenServiceIsFull(){
        service.add(new Robot("test1"));
        service.add(new Robot("test2"));
        service.add(new Robot("test3"));
        service.add(new Robot("test4"));
        Assert.assertEquals(4, service.getCount());
        service.add(robot);
    }
    @Test
    public void testAddRobot(){
        int startCount = service.getCount();
        Assert.assertEquals(0, startCount);
        service.add(new Robot("test1"));
        service.add(new Robot("test2"));
        service.add(new Robot("test3"));
        service.add(new Robot("test4"));
        Assert.assertEquals(4, service.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveRobotByNameShouldFailWhenNoRobotWithThisName(){
        service.add(new Robot("test1"));
        service.add(new Robot("test2"));
        service.add(new Robot("test3"));
        service.add(new Robot("test4"));
        Robot robotToRemove = new Robot("False");
        service.remove(robotToRemove.getName());
        Assert.assertNull(robotToRemove.getName());
        Assert.assertEquals(4, service.getCount());
    }
    @Test
    public void testRemoveRobotByName(){
        service.add(new Robot("test1"));
        service.add(new Robot("test2"));
        service.add(new Robot("test3"));
        service.add(new Robot("test4"));
        Assert.assertEquals(4, service.getCount());
        this.service.remove("test2");
        Assert.assertEquals(3, service.getCount());
        this.service.remove("test4");
        Assert.assertEquals(2, service.getCount());


    }
    @Test(expected = IllegalArgumentException.class)
    public void testForSaleShouldFailWhenDoesntExistRobotWithThisName(){
        service.add(new Robot("test1"));
        service.add(new Robot("test2"));
        service.add(new Robot("test3"));
        service.add(new Robot("test4"));
        Assert.assertEquals(4, service.getCount());
        service.forSale("test");


    }
    @Test
    public void testForSale(){
        service.add(new Robot("test1"));
        service.add(new Robot("test2"));
        service.add(new Robot("test3"));
        service.add(new Robot("test4"));
        Robot robotForSale = service.forSale("test4");
        Assert.assertEquals(false,robotForSale.isReadyForSale());

    }
    @Test
    public void testReport(){
        service.add(new Robot("test1"));
        service.add(new Robot("test2"));
        service.add(new Robot("test3"));
        service.add(new Robot("test4"));
        String name = service.getName();
        String robots = "test1, test2, test3, test4";
        String expected = String.format("The robot %s is in the service %s!", robots, name);
        Assert.assertEquals(expected, service.report());

    }





}
