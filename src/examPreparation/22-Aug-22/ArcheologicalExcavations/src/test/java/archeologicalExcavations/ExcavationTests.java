package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class ExcavationTests {
    private static final String EXCAVATION_NAME = "Pernik";
    private static final int CAPACITY = 10;
    private Excavation excavation;


    @Test
    public void testCreateExcavation() {
        excavation = new Excavation(EXCAVATION_NAME, CAPACITY);
        assertEquals(EXCAVATION_NAME, excavation.getName());
        assertEquals(CAPACITY, excavation.getCapacity());
        assertEquals(0, excavation.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorShouldThrowWithNullName() {
        new Excavation(null, CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorShouldThrowWithEmptyName() {
        new Excavation("   ", CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorShouldThrowWithNegativeCapacity() {
        new Excavation(EXCAVATION_NAME, -2);
    }

    @Test
    public void testAddArchaeologistShouldAdd() {
        excavation = new Excavation(EXCAVATION_NAME, CAPACITY);
        Archaeologist archaeologist = new Archaeologist("Pesho", 50);
        excavation.addArchaeologist(archaeologist);
        assertEquals(1, excavation.getCount());
        Archaeologist archaeologist2 = new Archaeologist("Gogo", 90);
        excavation.addArchaeologist(archaeologist2);
        assertEquals(2, excavation.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistAndNoMoreCapacityShouldThrow() {
        excavation = new Excavation(EXCAVATION_NAME, 0);
        Archaeologist archaeologist = new Archaeologist("Pesho", 50);
        excavation.addArchaeologist(archaeologist);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistShouldThrowWhenThePersonIsAlreadyInExcavation() {
        excavation = new Excavation(EXCAVATION_NAME, CAPACITY);
        Archaeologist archaeologist = new Archaeologist("Pesho", 50);
        excavation.addArchaeologist(archaeologist);
        assertEquals(1, excavation.getCount());
        Archaeologist archaeologist2 = new Archaeologist("Pesho", 90);
        excavation.addArchaeologist(archaeologist2);
        assertEquals(1, excavation.getCount());
    }
    @Test
    public void testRemoveArchaeologistShouldRemove() {
        excavation = new Excavation(EXCAVATION_NAME, CAPACITY);
        Archaeologist archaeologist = new Archaeologist("Pesho", 50);
        excavation.addArchaeologist(archaeologist);
        assertEquals(1, excavation.getCount());
        Archaeologist archaeologist2 = new Archaeologist("Gogo", 90);
        excavation.addArchaeologist(archaeologist2);
        assertEquals(2, excavation.getCount());
        assertEquals(true, excavation.removeArchaeologist("Pesho"));
        assertEquals(1, excavation.getCount());
    }
    @Test
    public void testRemoveShouldNotRemove(){
        excavation = new Excavation(EXCAVATION_NAME, CAPACITY);
        Archaeologist archaeologist = new Archaeologist("Ivan", 100);
        assertEquals(false, excavation.removeArchaeologist("Pesho"));
    }
}
