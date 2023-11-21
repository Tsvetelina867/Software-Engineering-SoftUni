package ReflectionExercise.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Class<BlackBoxInt> clazz = BlackBoxInt.class;

        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBox = constructor.newInstance();

        while (!line.equals("END")) {
            String[] tokens = line.split("_");
            String command = tokens[0];
            int value = Integer.parseInt(tokens[1]);

            Method method = clazz.getDeclaredMethod(command, int.class);
            method.setAccessible(true);
            method.invoke(blackBox, value);

            Field innerValue = clazz.getDeclaredField("innerValue");
            innerValue.setAccessible(true);
            System.out.println(innerValue.get(blackBox));

            line = scanner.nextLine();
        }
    }
}
