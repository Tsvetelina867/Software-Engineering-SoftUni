package MapsLambdaAndStreamAPIExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputOne = scanner.nextLine();
        LinkedHashMap<String, Integer> resourcesMap = new LinkedHashMap<>();

        while (!inputOne.equals("stop")) {
            String resource = inputOne;
            String inputTwo = scanner.nextLine();
            int qunatity = Integer.parseInt(inputTwo);
            if (resourcesMap.containsKey(resource)) {
                qunatity += resourcesMap.get(resource);
            }
            resourcesMap.put(resource, qunatity);
            inputOne = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : resourcesMap.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
