package climbers.models.climber;

public class RockClimber extends BaseClimber{
    public RockClimber(String name) {
        super(name, 120);
    }

    @Override
    public void climb() {
        this.setStrength(getStrength() - 60);
        if (!this.canClimb()) {
            this.setStrength(0);
        }
    }
}
