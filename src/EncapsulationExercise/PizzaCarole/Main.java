package EncapsulationExercise.PizzaCarole;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] pizzaInfo = scanner.nextLine().split("\\s+");
        String pizzaName = pizzaInfo[1];
        int numberOfToppings = Integer.parseInt(pizzaInfo[2]);

        String[] doughInfo = scanner.nextLine().split(" ");
        String flourType = doughInfo[1];
        String bakingTechnique = doughInfo[2];
        double weight = Double.parseDouble(doughInfo[3]);
        try {
            Pizza pizza = new Pizza(pizzaName, numberOfToppings);
            Dough dough = new Dough(flourType, bakingTechnique, weight);
            pizza.setDough(dough);

            String command = scanner.nextLine();
            while (!command.equals("END")) {
                String[] toppingData = command.split("\\s+");
                String toppingType = toppingData[1];
                double toppingWeightInGrams = Double.parseDouble(toppingData[2]);

                Topping topping = new Topping(toppingType, toppingWeightInGrams);
                pizza.addTopping(topping);
                command = scanner.nextLine();
            }
            System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
