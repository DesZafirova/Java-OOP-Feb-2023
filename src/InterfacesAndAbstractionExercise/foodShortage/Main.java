package InterfacesAndAbstractionExercise.foodShortage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Buyer> buyers = new HashMap<>();

        int buyerCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < buyerCount; i++) {
            String[] infoData = scanner.nextLine().split("\\s+");
            String name = infoData[0];
            int age = Integer.parseInt(infoData[1]);
            Buyer buyer;
            if (infoData.length == 3) {
                String groupName = infoData[2];
                buyer = new Rebel(name, age, groupName);
                buyers.put(name, buyer);
            } else if (infoData.length == 4) {
                String id = infoData[2];
                String birthDate = infoData[3];
                buyer = new Citizen(name, age, id, birthDate);
                buyers.put(name, buyer);
            }

        }
        String name = scanner.nextLine();
        while (!name.equals("End")) {
            Buyer buyer = buyers.get(name);
            if (buyer != null) {
                buyer.buyFood();
            }

            name = scanner.nextLine();
        }
        int totalFood = buyers.values()
                .stream().mapToInt(Buyer::getFood)
                .sum();
        System.out.println(totalFood);
    }
}
