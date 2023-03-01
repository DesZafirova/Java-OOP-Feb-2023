package EncapsulationExercise.AnimalFarm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        Chicken chicken = new Chicken(name, age);
        try {
            System.out.println(chicken.toString());

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
