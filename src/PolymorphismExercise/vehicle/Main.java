package PolymorphismExercise.vehicle;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();
        vehicleMap.put("Car", getVehicle(scanner));
        vehicleMap.put("Truck", getVehicle(scanner));
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCommands; i++) {
            String[] commandsArr = scanner.nextLine().split("\\s+");
            String command = commandsArr[0];
            String vehicleType = commandsArr[1];
            double argument = Double.parseDouble(commandsArr[2]);

            switch (command) {
                case "Drive":
                    System.out.println(vehicleMap.get(vehicleType).drive(argument));
                    break;
                case "Refuel":
                    vehicleMap.get(vehicleType).refuel(argument);
                    break;

            }
        }
        vehicleMap.values().forEach(System.out::println);
    }

    private static Vehicle getVehicle(Scanner scanner) {
        String[]vehicleData = scanner.nextLine().split(" ");
        String vehicleType = vehicleData[0];
        double fuelQuantity = Double.parseDouble(vehicleData[1]);
        double litersKm = Double.parseDouble(vehicleData[2]);
        switch (vehicleType) {
            case "Car":
                return new Car(fuelQuantity, litersKm);

            case "Truck":
                return new Truck(fuelQuantity, litersKm);

            default:
                throw new IllegalArgumentException("Missing vehicle");
        }
    }
}
