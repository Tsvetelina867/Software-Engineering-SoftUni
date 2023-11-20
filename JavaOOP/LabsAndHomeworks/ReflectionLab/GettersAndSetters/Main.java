package ReflectionLab.GettersAndSetters;

import ReflectionLab.GettersAndSetters.CustomComparator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Reflection.class;
        Method[] methods = clazz.getDeclaredMethods();

        Arrays.stream(methods)
                .filter(method -> !method.getName().equals("toString"))
                .sorted(new CustomComparator())
                .forEach(m -> System.out.println(formatMethodInfo(m)));
    }

    public static String formatMethodInfo(Method m) {
        if (m.getName().startsWith("get")) {
            return m.getName() + " will return class " + m.getReturnType().getName();
        }
        return m.getName() + " and will set field of class " + m.getParameterTypes()[0].getName();
    }
}
