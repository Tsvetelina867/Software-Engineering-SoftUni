package GenericsExercise.CustomList;

import GenericsExercise.CustomList.CustomList;
import GenericsExercise.CustomList.Sorter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        CustomList<String> list = new CustomList<>();

        while (!line.equals("END")) {
            String command = line.split("\\s+")[0];

            if (command.equals("Add")) {
                String element = line.split("\\s+")[1];
                list.add(element);
            } else if (command.equals("Remove")) {
                int index = Integer.parseInt(line.split("\\s+")[1]);
                list.remove(index);
            } else if (command.equals("Contains")) {
                String element = line.split("\\s+")[1];
                System.out.println(list.contains(element));
            } else if (command.equals("Swap")) {
                int index1 = Integer.parseInt(line.split("\\s+")[1]);
                int index2 = Integer.parseInt(line.split("\\s+")[2]);
                list.swap(index1, index2);
            } else if (command.equals("Greater")) {
                String element = line.split("\\s+")[1];
                System.out.println(list.countGreaterThan(element));
            } else if (command.equals("Max")) {
                System.out.println(list.getMax());
            } else if (command.equals("Min")) {
                System.out.println(list.getMin());
            }else if (command.equals("Sort")){
                Sorter.sort(list);
            } else if (command.equals("Print")) {
                list.print();
            }

            line = scanner.nextLine();
        }
    }
}
