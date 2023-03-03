package InterfacesAndAbstractionExercise.birthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        List<Birthable> birthables = new ArrayList<>();
        while (!command.equals("End")) {
            String[] infoLine = command.split("\\s+");
            String type = infoLine[0];
            Birthable birthable;

            switch (type) {
                case "Citizen":
                    String personName = infoLine[1];
                    int personAge = Integer.parseInt(infoLine[2]);
                    String personId = infoLine[3];
                    String birthDatePerson = infoLine[4];
                    birthable = new Citizen(personName, personAge, personId, birthDatePerson);
                   birthables.add(birthable);
                    break;
                case "Pet":
                    String petName = infoLine[1];
                    String petBirthDate = infoLine[2];
                    birthable = new Pet(petName, petBirthDate);
                    birthables.add(birthable);

                    break;
                case "Robot":
                    String robotModel = infoLine[1];
                    String robotId = infoLine[2];
                    break;
            }

            command = scanner.nextLine();
        }
        String year = scanner.nextLine();
        for (Birthable birthable : birthables ){
           if(birthable.getBirthDate().endsWith(year)){
                System.out.println(birthable.getBirthDate());
            }
        }

    }
}
