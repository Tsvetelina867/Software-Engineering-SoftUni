package BasicSyntax;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        String typeOfGroup = scanner.nextLine();
        String day = scanner.nextLine();
        double pricePerPerson = 0.00;

        if (day.equals("Friday")) {
            if (typeOfGroup.equals("Students")) {
                pricePerPerson = 8.45;
            } else if (typeOfGroup.equals("Business")) {
                pricePerPerson = 10.90;
            } else if (typeOfGroup.equals("Regular")) {
                pricePerPerson = 15;
            }
        } else if (day.equals("Saturday")) {
            if (typeOfGroup.equals("Students")) {
                pricePerPerson = 9.80;
            } else if (typeOfGroup.equals("Business")) {
                pricePerPerson = 15.60;
            } else if (typeOfGroup.equals("Regular")) {
                pricePerPerson = 20;
            }
        } else if (day.equals("Sunday")) {
            if (typeOfGroup.equals("Students")) {
                pricePerPerson = 10.46;
            } else if (typeOfGroup.equals("Business")) {
                pricePerPerson = 16;
            } else if (typeOfGroup.equals("Regular")) {
                pricePerPerson = 22.50;
            }
        }
        double totalPrice = people * pricePerPerson;

        if (typeOfGroup.equals("Students") && people >= 30) {
            totalPrice *= 0.85;
        } else if (typeOfGroup.equals("Business") && people >= 100) {
            totalPrice -= 10 * pricePerPerson;
        } else if (typeOfGroup.equals("Regular") && people >= 10 && people <= 20) {
            totalPrice *= 0.95;
        }
        System.out.printf("Total price: %.2f", totalPrice);
    }
}
