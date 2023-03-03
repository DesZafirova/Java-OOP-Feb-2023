package WorkingWithAbstractionLab.HotelReservation;

public class PriceCalculator {
    public static double calculateHolidayPrice(double pricePerDay, int countDays, Season season, DiscountType discountType) {
        double priceForAllDays = pricePerDay * countDays;
        priceForAllDays *= season.getMultiplyCoefficient();
        priceForAllDays = priceForAllDays - priceForAllDays * (discountType.getPercent() / 100);

        return priceForAllDays;
    }

}
