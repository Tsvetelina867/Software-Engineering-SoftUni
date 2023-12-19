package climbers.models.climbing;

import climbers.models.climber.Climber;
import climbers.models.mountain.Mountain;

import java.util.Collection;

public class ClimbingImpl implements Climbing{
    @Override
    public void conqueringPeaks(Mountain mountain, Collection<Climber> climbers) {
        for (Climber climber : climbers) {
            while (climber.canClimb()) {
                if (mountain.getPeaksList().isEmpty()) {
                    return;
                }
                String currentPeak = mountain.getPeaksList().stream().iterator().next();
                climber.getRoster().getPeaks().add(currentPeak);
                climber.climb();
                mountain.getPeaksList().remove(currentPeak);
            }
        }
    }
}
