package ArraysExercise;
import java.util.Arrays;
import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstArray = scanner.nextLine().split(" ");
        String[] secondArray = scanner.nextLine().split(" ");

        for (String value : secondArray) {
            for (String s : firstArray) {
                if (value.equals(s)) {
                    System.out.print(value + " ");
                }
            }
        }

    }
}
