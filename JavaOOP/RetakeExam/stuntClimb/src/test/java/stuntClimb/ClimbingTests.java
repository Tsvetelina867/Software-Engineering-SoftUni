package stuntClimb;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ClimbingTests {

    @Test(expected = NullPointerException.class)
    public void settingName_NullShouldReturn_Exception() {
        new Climbing(null, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void settingCapacity_LessThanZero_ShouldThrow() {
        new Climbing("test", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addingRockClimber_WhenReachedCapacity_ShouldThrow() {
        Climbing climbing = new Climbing("test",1);
        climbing.addRockClimber(new RockClimber("test name1", 2));
        climbing.addRockClimber(new RockClimber("test name2", 1));
    }

    @Test
    public void getCount_ShouldReturnCorrect_AfterAdding() {
        Climbing climbing = new Climbing("test",2);
        RockClimber climber = new RockClimber("test name", 5);
        climbing.addRockClimber(climber);

        assertEquals(1, climbing.getCount());
    }

    @Test
    public void remove_ShouldReturnFalse_WhenClimberIsNotPresent() {
        Climbing climbing = new Climbing("test",3);
        RockClimber climber = new RockClimber("test name1", 5);
        climbing.addRockClimber(climber);
        assertFalse(climbing.removeRockClimber("test name"));
    }

    @Test
    public void getName_ShouldReturnCorrectName() {
        Climbing climbing = new Climbing("test",3);
        assertEquals("test", climbing.getName());
    }

}
