package FinalExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "@#+[A-Z][A-Za-z0-9]{4,}[A-Z]@#+";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < n; i++) {
            String barcode = scanner.nextLine();
            Matcher matcher = pattern.matcher(barcode);
            StringBuilder group = new StringBuilder();
            boolean hasDigit = false;
            if (matcher.find()) {
                for (char c : barcode.toCharArray()) {
                    if (Character.isDigit(c)) {
                        hasDigit = true;
                        group.append(c);
                    }
                }
                if (hasDigit) {
                    System.out.println("Product group: " + group);
                } else {
                    System.out.println("Product group: 00");
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
