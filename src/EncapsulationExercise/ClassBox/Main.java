package EncapsulationExercise.ClassBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double length = Double.parseDouble(scanner.nextLine());
        double weight = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        Box box = new Box(length, weight, height);
        try {
            System.out.printf("Surface Area - %.2f%n", box.calculateSurfaceArea());
            System.out.printf("Lateral Surface Area - %.2f%n", box.calculateLateralSurfaceArea());
            System.out.printf("Volume - %.2f%n", box.calculateVolume());
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
