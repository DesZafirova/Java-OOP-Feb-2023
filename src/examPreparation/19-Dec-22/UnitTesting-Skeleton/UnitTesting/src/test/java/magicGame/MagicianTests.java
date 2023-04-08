package magicGame;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MagicianTests {
    Magician magician;
    Magic magic;

    @Before
    public void prepare() {
        magician = new Magician("Ivana", 100);
        magic = new Magic("Afrodita", 60);

    }

    @Test(expected = NullPointerException.class)
    public void testSetNameOfTheMagicianShouldThrowWhenIsNull() {
        Magician magician2 = new Magician(null, 120);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameOfTheMagicianShouldThrowWhenIsEmpty() {
        Magician magician2 = new Magician("     ", 120);
    }

    @Test
    public void testSetNameOfTheMagicianShouldSetIt() {
        Magician magician2 = new Magician("Drago", 120);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetHealthShouldReturnExceptionWhenIsNegative() {
        Magician magician2 = new Magician("Drago", -10);
    }
    @Test
    public void testGetUsername(){
        String actual = magician.getUsername();
        assertEquals("Ivana", actual);
    }

    @Test
    public void testShouldAddMagicsToMagician() {
        magician.addMagic(magic);
        List<Magic> magics = magician.getMagics();
        assertEquals(1, magics.size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testUnmodifiableMagics() {
        magician.addMagic(magic);
        List<Magic> magics = magician.getMagics();
        this.magician.getMagics().clear();
    }

    @Test
    public void testTakeDamageShouldReduceHealth() {
        magician.addMagic(magic);
        magician.takeDamage(10);
        int actual = magician.getHealth();
        assertEquals(90, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamageShouldReturnExceptionWhenHealthIsNegative() {
        Magician magician2 = new Magician("test_Magician", 10);
        magician2.takeDamage(10);
        magician2.takeDamage(10);

    }

    @Test
    public void testTakeDamageShouldReturnZeroHealthIfIsNegative() {
        Magician magician2 = new Magician("test_Magician", 10);
        magician2.takeDamage(15);

        int actual = magician2.getHealth();
        assertEquals(0, actual);
    }

    @Test(expected = NullPointerException.class)
    public void testAddMagicShouldReturnExceptionWhenMagicIsNull() {
        magician.addMagic(null);
        assertEquals(0, magician.getMagics());
    }

    @Test
    public void testRemoveMagic() {
        magician.addMagic(magic);
        Magic anotherMagic = new Magic("another_magic", 20);
        magician.addMagic(anotherMagic);
        assertEquals(2, magician.getMagics().size());
        magician.removeMagic(anotherMagic);
        assertEquals(1, magician.getMagics().size());
    }

    @Test
    public void testGetMagicShouldReturnByName() {
        magician.addMagic(magic);
        Magic anotherMagic = new Magic("another_magic", 20);
        magician.addMagic(anotherMagic);
        assertEquals(2, magician.getMagics().size());
        Magic expected = magician.getMagic("Afrodita");
        Magic actual = magician.getMagics().stream().filter(m -> m.getName().equals("Afrodita")).findFirst().orElse(null);
        assertEquals(expected, actual);
    }
}
