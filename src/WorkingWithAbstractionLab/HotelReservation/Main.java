package WorkingWithAbstractionLab.HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputLine = scanner.nextLine().split("\\s+");
        double price = Double.parseDouble(inputLine[0]);
        int numberOfDays = Integer.parseInt(inputLine[1]);
        Season season = Season.valueOf(inputLine[2].toUpperCase());
        DiscountType discountType = DiscountType.valueOf(inputLine[3].toUpperCase());
        double tripPrice = PriceCalculator.calculateHolidayPrice(price, numberOfDays, season, discountType);
        System.out.printf("%.2f", tripPrice);

    }
}
