package climbers.models.climber;

public class WallClimber extends BaseClimber{
    public WallClimber(String name) {
        super(name, 90);
    }

    @Override
    public void climb() {
        this.setStrength(getStrength() - 30);
        if (!this.canClimb()) {
            this.setStrength(0);
        }
    }
}
