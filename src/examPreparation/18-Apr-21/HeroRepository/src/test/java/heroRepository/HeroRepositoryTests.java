package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

public class HeroRepositoryTests {
    private Hero hero;
    private HeroRepository heroes;
    @Before
    public void prepare(){
        heroes = new HeroRepository();
        hero = new Hero("test_hero", 5);
    }
    @Test
    public void testGetHeroesCount(){
        Assert.assertEquals(0, heroes.getCount());
        heroes.create(hero);
        Assert.assertEquals(1, heroes.getCount());

    }
    @Test(expected = NullPointerException.class)
    public void testCreateHeroShouldFailWhenHeroIsNull(){
        heroes.create(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCreateHeroShouldFailWhenHeroExistAlready(){
        heroes.create(new Hero("Bob", 2));
        heroes.create(new Hero("Bob", 5));
    }
    @Test
    public void testCreateHeroShouldReturnSuccessfullyMassage(){
        String actual = heroes.create(hero);
        Assert.assertEquals("Successfully added hero test_hero with level 5", actual);
    }
    @Test(expected = NullPointerException.class)
    public void testRemoveHeroShouldFailWhenNameIsNull(){
        heroes.remove(null);
        Assert.assertNull(heroes.getHeroes());
    }
    @Test(expected = NullPointerException.class)
    public void testRemoveHeroShouldFailWhenNameIsEmpty(){
        heroes.remove("   ");
        Assert.assertNull(heroes.getHeroes());
    }
    @Test
    public void testRemoveHeroShouldRemoveCorrectly(){
        heroes.create(hero);
        Assert.assertTrue(heroes.remove("test_hero"));
    }
    @Test
    public void testGetHeroWithHighestLevel(){
        heroes.create(new Hero("test1", 5));
        heroes.create(new Hero("test2", 9));
        heroes.create(new Hero("test3", 2));
        heroes.create(new Hero("test4", 7));
        heroes.create(new Hero("test5", 1));
        Hero actual = heroes.getHeroWithHighestLevel();
        Hero expected = heroes.getHeroes().stream().max(Comparator.comparing(Hero::getLevel)).orElse(null);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testGetHeroByName(){
        heroes.create(new Hero("test1", 5));
        heroes.create(new Hero("test2", 9));
        heroes.create(new Hero("test3", 2));
        heroes.create(new Hero("test4", 7));
        heroes.create(new Hero("test5", 1));
        Hero expected = heroes.getHero("test2");
        Hero actual = heroes.getHeroes().stream().filter(h -> h.getName().equals("test2")).findFirst().orElse(null);
        Assert.assertEquals(expected, actual);
    }
    @Test(expected = UnsupportedOperationException.class)
    public void testUnmodifiableCollection(){
        heroes.create(hero);
        heroes.getHeroes().clear();
    }



}
