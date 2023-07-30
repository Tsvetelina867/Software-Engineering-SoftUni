package ObjectsAndClassesExercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class TeamworkProjects {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfTeams = Integer.parseInt(scanner.nextLine());
        ArrayList<Team> teams = new ArrayList<>();

        LinkedHashMap<String, String> teamCreators = new LinkedHashMap<>();

        for (int i = 0; i < countOfTeams; i++) {
            String[] input = scanner.nextLine().split("-");
            String creator = input[0];
            String teamName = input[1];

            if (teamCreators.containsKey(creator)) {
                System.out.printf("%s cannot create another team!%n", creator);
            } else if (teams.stream().anyMatch(t -> t.getName().equals(teamName))) {
                System.out.printf("Team %s was already created!%n", teamName);
            } else {
                Team team = new Team(teamName, creator);
                teams.add(team);
                teamCreators.put(creator, teamName);
                System.out.printf("Team %s has been created by %s!%n", teamName, creator);
            }
        }

        String input;
        while (!(input = scanner.nextLine()).equals("end of assignment")) {
            String[] inputTokens = input.split("->");
            String user = inputTokens[0];
            String teamToJoin = inputTokens[1];

            Team team = teams.stream().filter(t -> t.getName().equals(teamToJoin)).findFirst().orElse(null);
            if (team == null) {
                System.out.printf("Team %s does not exist!%n", teamToJoin);
            } else if (team.getUsers().contains(user) || teamCreators.containsKey(user)) {
                System.out.printf("Member %s cannot join team %s!%n", user, teamToJoin);
            } else {
                team.getUsers().add(user);
            }
        }


        teams.sort(Comparator.comparing(Team::getMemberCount).reversed().thenComparing(Team::getName));
        for (Team team : teams) {
            if (team.getUsers().size() > 1) {
                System.out.println(team.getName());
                System.out.println("- " + team.getCreatorName());
                team.getUsers().stream()
                        .filter(user -> !user.equals(team.getCreatorName()))
                        .sorted()
                        .forEach(user -> System.out.println("-- " + user));
            }
        }


        System.out.println("Teams to disband:");
        teams.stream().filter(team -> team.getUsers().size() == 1).forEach(team -> System.out.println(team.getName()));
    }

    public static class Team {
        private String name;
        private ArrayList<String> users;

        public Team(String name, String creatorName) {
            this.name = name;
            this.users = new ArrayList<>();
            this.users.add(creatorName);
        }

        public String getName() {
            return name;
        }

        public String getCreatorName() {
            return users.get(0);
        }

        public ArrayList<String> getUsers() {
            return users;
        }

        public int getMemberCount() {
            return users.size();
        }
    }
}
