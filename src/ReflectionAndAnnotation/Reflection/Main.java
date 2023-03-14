package ReflectionAndAnnotation.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Reflection> clazz = Reflection.class;
        System.out.println(clazz);
        System.out.println(clazz.getSuperclass());
        Arrays.stream(clazz.getInterfaces())
                .forEach(System.out::println);

        Constructor<Reflection> ctor = clazz.getDeclaredConstructor();
        Reflection reflection = ctor.newInstance();
        System.out.println(reflection);
        Comparator<Method> comparator = Comparator.comparing(Method::getName);
        Set<Method> getters = new TreeSet<>(comparator);
        Set<Method> setters = new TreeSet<>(comparator);
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            String methodName = method.getName();

            if (methodName.contains("get")) {
                getters.add(method);
            } else if (methodName.contains("set")) {
                setters.add(method);
            }
        }
        for (Method getter : getters) {
            System.out.printf("%s will return class %s%n", getter.getName(), getter.getReturnType().getName());
        }
        for (Method setter : setters) {
            System.out.printf("%s and will set field of class %s%n", setter.getName(), setter.getParameterTypes()[0].getName());
        }

    }
}
