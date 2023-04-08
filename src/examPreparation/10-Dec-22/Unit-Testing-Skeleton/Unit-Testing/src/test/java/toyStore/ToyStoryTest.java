package toyStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ToyStoryTest {
    ToyStore toyStore;
    @Before
    public void prepare(){
        toyStore = new ToyStore();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testUnmodifiableCollection(){
        this.toyStore.getToyShelf().clear();
    }
@Test
    public void testAddShouldAdd() throws OperationNotSupportedException {
    Toy toy = new Toy("test_toy", "toy_id");
    toyStore.addToy("A", toy);
    assertTrue(toyStore.getToyShelf().containsValue(toy));

}
@Test (expected = IllegalArgumentException.class)
    public void testAddToyShouldReturnExceptionWhenShelfNotExist() throws OperationNotSupportedException {
    Toy toy = new Toy("test_toy", "toy_id");
    toyStore.addToy("Q", toy);
}
    @Test (expected = IllegalArgumentException.class)
    public void testAddToyShouldReturnExceptionWhenShelfIsAlreadyTaken() throws OperationNotSupportedException {
        Toy toy = new Toy("test_toy", "toy_id");
        Toy anotherToy = new Toy("test_toy", "toy_id");
        toyStore.addToy("A", toy);
        toyStore.addToy("A", anotherToy);

    }
    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldReturnExceptionWhenTheToyAlreadyExist() throws OperationNotSupportedException {
        Toy toy = new Toy("test_toy", "toy_id");
        toyStore.addToy("A", toy);
        toyStore.addToy("B", toy);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testRemoveToyShouldReturnExceptionWhenShelfNotExist() throws OperationNotSupportedException {
        Toy toy = new Toy("test_toy", "toy_id");
        assertNull(toyStore.removeToy("Q", null));
    }
    @Test (expected = IllegalArgumentException.class)
    public void testRemoveToyShouldReturnExceptionWhenShelfIsAlreadyTaken() throws OperationNotSupportedException {
        Toy toy = new Toy("test_toy", "toy_id");
        Toy anotherToy = new Toy("test_toy2", "toy_id2");
        toyStore.addToy("A", toy);
        toyStore.removeToy("A", anotherToy);

    }
    @Test
    public void testRemoveShouldRemoveToy() throws OperationNotSupportedException {
        Toy toy = new Toy("test_toy", "toy_id");
        toyStore.addToy("A", toy);
        toyStore.removeToy("A", toy);
        Toy emptySlot = toyStore.getToyShelf().get("A");
        Assert.assertNull(emptySlot);
    }

}