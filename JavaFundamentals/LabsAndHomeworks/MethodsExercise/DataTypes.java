package MethodsExercise;

import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dataType = scanner.nextLine();
        String data = scanner.nextLine();

        if (dataType.equals("int")){
            int num = Integer.parseInt(data);
            modifyData(num);
        } else if (dataType.equals("real")){
            double dNum = Double.parseDouble(data);
            modifyData(dNum);
        } else if (dataType.equals("string")) {
            modifyData(data);
        }
    }

    public static void modifyData(int number) {
        System.out.println(number * 2);
    }
    public static void modifyData(double number) {
        System.out.printf("%.2f", number * 1.5);
    }
    public static void modifyData(String text) {
        System.out.println("$" + text + "$");
    }
}
