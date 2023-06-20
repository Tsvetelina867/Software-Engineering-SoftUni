package ListExercise;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> listSeparatedByPipe = Arrays.stream(input.split("\\|")).collect(Collectors.toList());

        Collections.reverse(listSeparatedByPipe);


        //list.toString() -> "7 8 4 5 6 1 2 3"
        System.out.println(listSeparatedByPipe.toString()
                .replace("[", "")
                .replace("]", "")
                .trim()
                .replaceAll(",", "")
                .replaceAll("\\s+", " "));
    }
}

