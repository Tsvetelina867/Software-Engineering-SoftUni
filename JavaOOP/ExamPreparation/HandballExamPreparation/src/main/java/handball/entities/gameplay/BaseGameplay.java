package HandballExamPreparation.src.main.java.handball.entities.gameplay;


import HandballExamPreparation.src.main.java.handball.entities.equipment.Equipment;
import HandballExamPreparation.src.main.java.handball.entities.team.Team;


import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static HandballExamPreparation.src.main.java.handball.common.ExceptionMessages.*;


public abstract class BaseGameplay implements Gameplay{
    private String name;
    private int capacity;
    private Collection<Equipment> equipments;
    private Collection<Team> teams;

    protected BaseGameplay(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        this.equipments = new ArrayList<>();
        this.teams = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new NullPointerException(GAMEPLAY_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int allProtection() {
        return this.equipments.stream().mapToInt(Equipment::getProtection).sum();
    }

    @Override
    public void addTeam(Team team) {
        this.teams.add(team);
    }

    @Override
    public void removeTeam(Team team) {
        this.teams.remove(team);
    }

    @Override
    public void addEquipment(Equipment equipment) {
        this.equipments.add(equipment);
    }

    @Override
    public void teamsInGameplay() {
        teams.forEach(Team::play);
    }

    @Override
    public Collection<Team> getTeam() {
        return this.teams;
    }

    @Override
    public Collection<Equipment> getEquipments() {
        return this.equipments;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("%s %s%n", this.name, this.getClass().getSimpleName())
                + String.format("Team: %s%n", this.getTeam().isEmpty()
        ? "none"
        : this.teams.stream().map(Team::getName).collect(Collectors.joining(" ")).trim())
                + String.format("Equipment: %d, Protection: %d", this.getEquipments().size(), this.allProtection());
    }
}
