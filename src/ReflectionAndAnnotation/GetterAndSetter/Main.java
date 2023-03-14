package ReflectionAndAnnotation.GetterAndSetter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> clazz = Reflection.class;
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
        Set<Field> fields = Arrays.stream(clazz.getDeclaredFields())
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Field::getName))));

        for (Field field : fields) {
            int modifier = field.getModifiers();
            if(!Modifier.isPrivate(modifier)){
                System.out.println(field.getName() + "must be private!");
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
