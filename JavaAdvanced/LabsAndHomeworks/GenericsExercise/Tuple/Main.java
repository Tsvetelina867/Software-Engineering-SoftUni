import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = readInput(scanner);
        String fullName = input[0] + " " + input[1];
        String address = input[2];
        String town = input[3];
        Tuple<String, String, String> tuple = new Tuple<>(fullName, address, town);
        System.out.println(tuple);

        input = readInput(scanner);
        String name = input[0];
        int litres = Integer.parseInt(input[1]);
        boolean drunkOrNot = input[2].equals("drunk");
        Tuple<String, Integer, Boolean> tuple2 = new Tuple<>(name, litres, drunkOrNot);
        System.out.println(tuple2);

        input = readInput(scanner);
        String namePerson = input[0];
        double value = Double.parseDouble(input[1]);
        String bankAccount = input[2];
        Tuple<String, Double, String> tuple3 = new Tuple<>(namePerson, value, bankAccount);
        System.out.println(tuple3);


    }
    private static String[] readInput(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }
}
