package HandballExamPreparation.src.main.java.handball.core;


import HandballExamPreparation.src.main.java.handball.entities.equipment.ElbowPad;
import HandballExamPreparation.src.main.java.handball.entities.equipment.Equipment;
import HandballExamPreparation.src.main.java.handball.entities.equipment.Kneepad;
import HandballExamPreparation.src.main.java.handball.entities.gameplay.Gameplay;
import HandballExamPreparation.src.main.java.handball.entities.gameplay.Indoor;
import HandballExamPreparation.src.main.java.handball.entities.gameplay.Outdoor;
import HandballExamPreparation.src.main.java.handball.entities.team.Bulgaria;
import HandballExamPreparation.src.main.java.handball.entities.team.Germany;
import HandballExamPreparation.src.main.java.handball.entities.team.Team;
import HandballExamPreparation.src.main.java.handball.repositories.EquipmentRepository;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static HandballExamPreparation.src.main.java.handball.common.ConstantMessages.*;
import static HandballExamPreparation.src.main.java.handball.common.ExceptionMessages.*;


public class ControllerImpl implements Controller{
    private EquipmentRepository equipment;
    private Map<String, Gameplay> gameplays;

    public ControllerImpl() {
        this.equipment = new EquipmentRepository();
        this.gameplays = new LinkedHashMap<>();
    }

    @Override
    public String addGameplay(String gameplayType, String gameplayName) {
        Gameplay gameplay;
        switch (gameplayType){
            case "Outdoor":
                gameplay = new Outdoor(gameplayName);
                break;
            case "Indoor":
                gameplay = new Indoor(gameplayName);
                break;
            default: throw new NullPointerException(INVALID_GAMEPLAY_TYPE);
        }
        gameplays.put(gameplayName, gameplay);
        return String.format(SUCCESSFULLY_ADDED_GAMEPLAY_TYPE, gameplayType);
    }

    @Override
    public String addEquipment(String equipmentType) {
        Equipment equipmentItem;
        switch (equipmentType) {
            case "Kneepad":
                equipmentItem = new Kneepad();
                break;
            case "ElbowPad":
                equipmentItem = new ElbowPad();
                break;
            default: throw new IllegalArgumentException(INVALID_EQUIPMENT_TYPE);
        }
        this.equipment.add(equipmentItem);
        return String.format(SUCCESSFULLY_ADDED_EQUIPMENT_TYPE, equipmentType);
    }

    @Override
    public String equipmentRequirement(String gameplayName, String equipmentType) {
        Equipment desiredEquipment = equipment.findByType(equipmentType);
        if (desiredEquipment == null) {
            throw new IllegalArgumentException(String.format(NO_EQUIPMENT_FOUND, equipmentType));
        }
        this.gameplays.get(gameplayName).addEquipment(desiredEquipment);
        this.equipment.remove(desiredEquipment);
        return String.format(SUCCESSFULLY_ADDED_EQUIPMENT_IN_GAMEPLAY, equipmentType, gameplayName);
    }

    @Override
    public String addTeam(String gameplayName, String teamType, String teamName, String country, int advantage) {
        Team team;
        Gameplay gameplay = gameplays.get(gameplayName);
        switch (teamType) {
            case "Bulgaria":
                team = new Bulgaria(teamName, country, advantage);
                break;
            case "Germany":
                team = new Germany(teamName, country, advantage);
                break;
            default: throw new IllegalArgumentException(INVALID_TEAM_TYPE);
        }
        String output = "";
        if (isTeamSuitable(teamType, gameplay)){
            gameplay.addTeam(team);
            output = String.format(SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY, teamType, gameplayName);
        } else {
            output = GAMEPLAY_NOT_SUITABLE;
        }
        return output;
    }
    private boolean isTeamSuitable(String teamType, Gameplay gameplay) {
        String gameplayType = gameplay.getClass().getSimpleName();
        if (teamType.equals("Bulgaria") && gameplayType.equals("Outdoor")) {
            return true;
        } else if (teamType.equals("Germany") && gameplayType.equals("Indoor")) {
            return true;
        }
        return false;
    }

    @Override
    public String playInGameplay(String gameplayName) {
        Gameplay currentGameplay = this.gameplays.get(gameplayName);
        currentGameplay.teamsInGameplay();

        return String.format(TEAMS_PLAYED, currentGameplay.getTeam().size());
    }

    @Override
    public String percentAdvantage(String gameplayName) {
        Gameplay currentGameplay = this.gameplays.get(gameplayName);
        int sum = currentGameplay.getTeam().stream().mapToInt(Team::getAdvantage).sum();
        return String.format(ADVANTAGE_GAMEPLAY, gameplayName, sum);
    }

    @Override
    public String getStatistics() {
        return gameplays.values()
                .stream()
                .map(Gameplay::toString)
                .collect(Collectors.joining(System.lineSeparator())).trim();
    }
}
