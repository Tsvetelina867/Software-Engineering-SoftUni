package BasicSyntax;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double lightsaberPrice = Double.parseDouble(scanner.nextLine());
        double robePrice = Double.parseDouble(scanner.nextLine());
        double beltPrice = Double.parseDouble(scanner.nextLine());

        int lightsaberCount = (int) Math.ceil(students * 1.1);
        double totalLightsaberCost = lightsaberCount * lightsaberPrice;

        double totalRobeCost = students * robePrice;

        int beltCount = students - (students / 6);
        double totalBeltCost = beltCount * beltPrice;

        double neededMoney = totalLightsaberCost + totalRobeCost + totalBeltCost;


        if (neededMoney <= money) {
            System.out.printf("The money is enough - it would cost %.2flv.", neededMoney);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", neededMoney - money);
        }

    }
}
