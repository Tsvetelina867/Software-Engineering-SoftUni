package ReflectionLab.Reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Reflection.class;
        System.out.println(clazz);
        System.out.println(clazz.getSuperclass());
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> i : interfaces) {
            System.out.println(i);
        }
        Object reflection = clazz.getConstructor().newInstance();
        System.out.println(reflection);
    }
}
