package MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        LinkedHashMap<String, String> contestsPass = new LinkedHashMap<>();
        LinkedHashMap<String, LinkedHashMap<String, Integer>> userPoints = new LinkedHashMap<>();
        LinkedHashMap<String, List<String>> userContest = new LinkedHashMap<>();

        while (!(input = scanner.nextLine()).equals("end of contests")) {
            String[] inputTokens = input.split(":");
            String contest = inputTokens[0];
            String password = inputTokens[1];
            contestsPass.put(contest, password);
        }

        while (!(input = scanner.nextLine()).equals("end of submissions")) {
            String[] inputTokens = input.split("=>");
            String contest = inputTokens[0];
            String password = inputTokens[1];
            String user = inputTokens[2];
            int points = Integer.parseInt(inputTokens[3]);

            if (contestsPass.containsKey(contest) && password.equals(contestsPass.get(contest))) {
                userContest.putIfAbsent(user, new ArrayList<>());
                if (!userContest.get(user).contains(contest)) {
                    userContest.get(user).add(contest);
                }
                userPoints.putIfAbsent(user, new LinkedHashMap<>());
                LinkedHashMap<String, Integer> contestPointsMap = userPoints.get(user);

                if (contestPointsMap.containsKey(contest)) {
                    int oldPoints = contestPointsMap.get(contest);
                    if (points > oldPoints) {
                        contestPointsMap.put(contest, points);
                    }
                } else {
                    contestPointsMap.put(contest, points);
                }

            }
        }


        Map<String, Integer> candidateTotalPoints = new HashMap<>();
        userPoints.forEach((user, pointsMap) -> {
            int totalPoints = pointsMap.values().stream().mapToInt(Integer::intValue).sum();
            candidateTotalPoints.put(user, totalPoints);
        });


        Map.Entry<String, Integer> bestCandidateEntry = candidateTotalPoints.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);


        if (bestCandidateEntry != null) {
            String bestCandidate = bestCandidateEntry.getKey();
            int totalPoints = bestCandidateEntry.getValue();
            System.out.println("Best candidate is " + bestCandidate + " with total " + totalPoints + " points.");
        }

        System.out.println("Ranking: ");
        userContest.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    String user = entry.getKey();
                    int totalPoints = candidateTotalPoints.get(user);
                    System.out.println(user);
                    entry.getValue().stream()
                            .sorted(Comparator.comparingInt(contest -> userPoints.get(user).getOrDefault(contest, 0))
                                    .reversed())
                            .forEach(contest -> {
                                int points = userPoints.get(user).getOrDefault(contest, 0);
                                System.out.println("#  " + contest + " -> " + points);
                            });
                });


    }

}

