package football;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FootballTeamTests {
    private static final int VACANT_POSITIONS = 12;
    private static final String PLAYER_NAME = "Pesho";
    private static final String TEAM_NAME = "Barcelona";
    private Footballer footballer;
    private FootballTeam footballTeam;


    @Before
    public void setUp(){
        this.footballer = new Footballer(PLAYER_NAME);
        this.footballTeam = new FootballTeam(TEAM_NAME, VACANT_POSITIONS);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testCreatingTeamWithNoVacantPositions(){
        new FootballTeam("testName", -1);

    }
    @Test
    public void testCreatingTeamWithActualPositionsShouldSetCorrectPositionsCount(){
        assertEquals(VACANT_POSITIONS, footballTeam.getVacantPositions());
    }
    @Test(expected = NullPointerException.class)
    public void testCreatingTeamWithNullNameShouldFail(){
        new FootballTeam(null, 1);
    }
    @Test(expected = NullPointerException.class)
    public void testCreatingTeamWithEmptyNameShouldFail(){
        new FootballTeam("  ", 1);
    }
    @Test
    public void testCreatingTeamWithNameShouldCreateTheTeam(){
        assertEquals(TEAM_NAME, footballTeam.getName());
    }
    @Test
    public void testAddPlayerShouldIncreaseTeamMembersCount(){
        footballTeam.addFootballer(footballer);
        assertEquals(1, footballTeam.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddPlayerShouldFailWhenTeamIsFull(){
        FootballTeam team = new FootballTeam(TEAM_NAME, 0);
        team.addFootballer(footballer);
    }
    @Test
    public void testRemovePlayerShouldReduceTeamCount(){
        footballTeam.addFootballer(footballer);
        assertEquals(1, footballTeam.getCount());
        footballTeam.removeFootballer(footballer.getName());
        assertEquals(0, footballTeam.getCount());

    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemovePlayerShouldFailWhenNoSuchPlayer(){
        footballTeam.addFootballer(footballer);
        footballTeam.removeFootballer("not_added");
    }
    @Test
    public void testFootballForSaleShouldDeactivatePlayer(){
        footballTeam.addFootballer(footballer);
        footballTeam.footballerForSale(footballer.getName());
        assertFalse(footballer.isActive());

    }
    @Test(expected = IllegalArgumentException.class)
    public void testFootballForSaleShouldFailIfPlayerIsMissing(){
        footballTeam.addFootballer(footballer);
        footballTeam.footballerForSale("not_added");
    }


}
