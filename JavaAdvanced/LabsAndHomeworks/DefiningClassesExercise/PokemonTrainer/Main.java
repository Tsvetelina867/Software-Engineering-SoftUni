package DefiningClassesExercise.PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<>();
        String line = scanner.nextLine();

        while (!line.equals("Tournament")) {
            String[] tokens = line.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);
            line = scanner.nextLine();
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainers.computeIfAbsent(trainerName, Trainer::new).addPokemon(pokemon);
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            for (Trainer trainer : trainers.values()) {
                trainer.checkElement(input);
            }
            input = scanner.nextLine();
        }
        List<Trainer> sortedTrainers = trainers.values()
                .stream()
                .sorted((t1, t2) -> Integer.compare(t2.getBadges(), t1.getBadges()))
                .collect(Collectors.toList());

        for (Trainer sortedTrainer : sortedTrainers) {
            System.out.println(sortedTrainer);
        }
    }
}
