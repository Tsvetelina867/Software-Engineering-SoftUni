package ReflectionExercise.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		Class<RichSoilLand> clazz = RichSoilLand.class;
		Field[] fields = clazz.getDeclaredFields();

		Consumer<Field> printField = field -> System.out.printf("%s %s %s%n",
										Modifier.toString(field.getModifiers()),
										field.getType().getSimpleName(),
										field.getName());


		while (!input.equals("HARVEST")) {
            if (input.equals("all")) {
                Arrays.stream(fields)
                        .forEach(printField);
            } else {
                String finalModifierName = input;
                Arrays.stream(fields)
                        .filter(f -> Modifier.toString(f.getModifiers()).equals(finalModifierName))
                        .forEach(printField);
            }
			input = scanner.nextLine();
		}
	}
}
