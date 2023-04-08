package christmasRaces.entities.cars;

public class SportsCar extends BaseCar{
    //The minimum horsepower is 250 and the maximum horsepower is 450.
    private static final double CUBIC_CENTIMETERS = 3000;
    public SportsCar(String model, int horsePower) {
        super(model, horsePower, CUBIC_CENTIMETERS);
    }
}
