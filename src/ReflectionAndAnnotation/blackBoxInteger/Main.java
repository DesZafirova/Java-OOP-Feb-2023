package ReflectionAndAnnotation.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        Field hiddenValue = clazz.getDeclaredField("innerValue");
        hiddenValue.setAccessible(true);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();


        while (!input.equals("END")){
            String[] commandParts = input.split("_");
            String command= commandParts[0];
            int argument = Integer.parseInt(commandParts[1]);

            Method method = clazz.getDeclaredMethod(command, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, argument);

            System.out.println(hiddenValue.get(blackBoxInt));
            input = scanner.nextLine();
        }
    }
}
