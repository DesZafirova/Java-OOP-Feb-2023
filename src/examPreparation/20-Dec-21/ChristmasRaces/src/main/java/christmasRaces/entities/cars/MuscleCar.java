package christmasRaces.entities.cars;

public class MuscleCar extends BaseCar{
    //The minimum horsepower is 400 and the maximum horsepower is 600.
    private static final double CUBIC_CENTIMETERS = 600;
    public MuscleCar(String model, int horsePower) {
        super(model, horsePower, CUBIC_CENTIMETERS);
    }

}
