package InterfacesAndAbstractionLab.BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        List<Identifiable> identifiables = new ArrayList<>();
        while (!command.equals("End")) {
            String[] partsInfo = command.split("\\s+");
            Identifiable identifiable;
            if (partsInfo.length == 3) {
                String name = partsInfo[0];
                int age = Integer.parseInt(partsInfo[1]);
                String id = partsInfo[2];
                identifiable = new Citizen(name, age, id);

            } else {
                String model = partsInfo[0];
                String id = partsInfo[1];
                identifiable = new Robot(model, id);
            }
            identifiables.add(identifiable);

            command = scanner.nextLine();
        }String fakeIdPostFix = scanner.nextLine();
        identifiables.stream()
                .map(Identifiable::getId)
                .filter(id -> id.endsWith(fakeIdPostFix))
                .forEach(System.out::println);

    }
}
