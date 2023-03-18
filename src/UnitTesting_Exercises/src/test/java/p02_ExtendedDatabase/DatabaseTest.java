package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    private Database database;
    private Person person;
    private Person pesho = new Person(1, "Pesho");
    private Person toshko = new Person(2, "Toshko");
    private Person goshko = new Person(3, "Goshko");

    @Before
    public void prepare() throws OperationNotSupportedException {

        database = new Database(pesho, toshko, goshko);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameShouldThrowWithNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindUsernameShouldThrowIfMissing() throws OperationNotSupportedException {
        database.findByUsername("Sashko");
    }

    @Test
    public void testFindByUsernameShouldReturnUser() throws OperationNotSupportedException {
        Person person = database.findByUsername(pesho.getUsername());
        Assert.assertEquals(person.getId(), pesho.getId());
        Assert.assertEquals(person.getUsername(), pesho.getUsername());
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testFindIdShouldThrowIfMissing() throws OperationNotSupportedException {
        database.findById(4);
    }
    @Test
    public void testFindByIdShouldReturnId() throws OperationNotSupportedException {
        Person person = database.findById(pesho.getId());
        Assert.assertEquals(person.getId(), pesho.getId());
        Assert.assertEquals(person.getUsername(), pesho.getUsername());
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowIfIsNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddPerson() throws OperationNotSupportedException {
        Person sasho = new Person(3, "Sasho");
        int countBeforeAdd = database.getElements().length;
        database.add(sasho);
        int countAfterAdd = database.getElements().length;
        Assert.assertEquals(countBeforeAdd +1, countAfterAdd);
        Assert.assertEquals(database.getElements().length, sasho.getId() + 1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowIfEmptyDB() throws OperationNotSupportedException {
        int count = database.getElements().length;
        for (int i = 0; i < count; i++) {
            database.remove();
        }
        database.remove();
    }

}