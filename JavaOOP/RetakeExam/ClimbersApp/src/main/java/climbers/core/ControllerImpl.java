package climbers.core;

import climbers.models.climber.Climber;
import climbers.models.climber.RockClimber;
import climbers.models.climber.WallClimber;
import climbers.models.climbing.ClimbingImpl;
import climbers.models.mountain.Mountain;
import climbers.models.mountain.MountainImpl;
import climbers.repositories.ClimberRepository;
import climbers.repositories.MountainRepository;

import java.util.Collection;

import static climbers.common.ConstantMessages.*;
import static climbers.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{
    private ClimberRepository climberRepository;
    private MountainRepository mountainRepository;
    public ControllerImpl() {
        this.climberRepository = new ClimberRepository();
        this.mountainRepository = new MountainRepository();
    }
    @Override
    public String addClimber(String type, String climberName) {
        Climber climber;
        switch (type) {
            case "RockClimber":
                climber = new RockClimber(climberName);
                break;
            case "WallClimber":
                climber = new WallClimber(climberName);
                break;
            default: throw new IllegalArgumentException(CLIMBER_INVALID_TYPE);
        }
        climberRepository.add(climber);
        return String.format(CLIMBER_ADDED, type, climberName);
    }

    @Override
    public String addMountain(String mountainName, String... peaks) {
        MountainImpl mountain = new MountainImpl(mountainName);
        for (String peak : peaks) {
            mountain.getPeaksList().add(peak);
        }
        mountainRepository.add(mountain);
        return String.format(MOUNTAIN_ADDED, mountainName);
    }
    @Override
    public String removeClimber(String climberName) {
        Climber wantedClimber = climberRepository.byName(climberName);
        if (wantedClimber == null) {
            throw new IllegalArgumentException(String.format(CLIMBER_DOES_NOT_EXIST, climberName));
        }
        climberRepository.remove(wantedClimber);
        return String.format(CLIMBER_REMOVE, climberName);
    }

    @Override
    public String startClimbing(String mountainName) {
        Collection<Climber> climbers = climberRepository.getCollection();
        Mountain mountain = mountainRepository.byName(mountainName);
        if (climbers.isEmpty()) {
            throw new IllegalArgumentException(THERE_ARE_NO_CLIMBERS);
        }
        ClimbingImpl climbing = new ClimbingImpl();
        climbing.conqueringPeaks(mountain, climbers);
        int removedClimberCount = (int) climbers.stream().filter(c -> !c.canClimb()).count();
        return String.format(PEAK_CLIMBING, mountainName, removedClimberCount);
    }

    @Override
    public String getStatistics() {
        Collection<Climber> climbers = climberRepository.getCollection();

        StringBuilder result = new StringBuilder();

        result.append(String.format("%d mountain/s was/were climbed.%n", mountainRepository.getCollection().size()));

        result.append("Climber's statistics:\n");

        for (Climber climber : climbers) {
            result.append(String.format("Name: %s%n", climber.getName()));
            result.append(String.format("Strength: %.0f%n", climber.getStrength()));

            Collection<String> conqueredPeaks = climber.getRoster().getPeaks();

            if (!conqueredPeaks.isEmpty()) {
                result.append("Conquered peaks: ");
                result.append(String.join(", ", conqueredPeaks));
            } else {
                result.append("Conquered peaks: None");
            }
        }

        return result.toString();
    }
}
