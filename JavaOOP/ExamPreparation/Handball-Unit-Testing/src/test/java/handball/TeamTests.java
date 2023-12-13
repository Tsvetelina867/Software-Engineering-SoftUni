package handball;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeamTests {

    @Test(expected = NullPointerException.class)
    public void settingName_NullShouldThrow() {
        new Team(null, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void settingPosition_LessThanZero_ShouldThrow() {
        new Team("test", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addPlayer_ShouldThrowWhen_SizeIsAt_LastPosition() {
        Team team = new Team("test", 1);
        team.add(new HandballPlayer("test name"));
        team.add(new HandballPlayer("test name2"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removePlayer_ShouldThrowWhen_PlayerIsNotFound() {
        Team team = new Team("test", 1);
        team.remove("test");
    }

    @Test(expected = IllegalArgumentException.class)
    public void playerForAnotherTeam_ShouldThrowWhen_PlayerIsNotFound() {
        Team team = new Team("test", 1);
        team.playerForAnotherTeam("test");
    }

    @Test
    public void playerForAnotherTeam_SetsActiveStatusProperly() {
        Team team = new Team("test", 1);
        HandballPlayer player = new HandballPlayer("test name");
        team.add(player);
        team.playerForAnotherTeam("test name");

        assertFalse(player.isActive());
    }

    @Test
    public void getStatistics_ReturnsProperOutput() {
        Team team = new Team("test", 2);
        HandballPlayer player = new HandballPlayer("test1");
        HandballPlayer player2 = new HandballPlayer("test2");

        team.add(player);
        team.add(player2);

        String expectedOutput = "The player test1, test2 is in the team test.";

        assertEquals(expectedOutput, team.getStatistics());
    }

    @Test
    public void getCount_ShouldReturnCorrect_AfterRemovingPlayer() {
        Team team = new Team("test", 2);
        HandballPlayer player = new HandballPlayer("test1");
        HandballPlayer player2 = new HandballPlayer("test2");
        team.add(player);
        team.add(player2);

        team.remove("test1");

        assertEquals(1, team.getCount());
    }
}
