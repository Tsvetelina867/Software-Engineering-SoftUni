package SetsAndMapsLab;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> data = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            data.putIfAbsent(continent, new LinkedHashMap<>());
            LinkedHashMap<String, ArrayList<String>> countries = data.get(continent);
            countries.putIfAbsent(country, new ArrayList<>());
            countries.get(country).add(city);
        }

        for (Map.Entry<String, LinkedHashMap<String, ArrayList<String>>> dataByContinent : data.entrySet()) {
            System.out.println(dataByContinent.getKey() + ":");
            LinkedHashMap<String, ArrayList<String>> dataByCountry = dataByContinent.getValue();
            for (Map.Entry<String, ArrayList<String>> dataCity : dataByCountry.entrySet()) {
                System.out.println(dataCity.getKey() + " -> "+ String.join(", ", dataCity.getValue()));
            }
        }
    }
}
