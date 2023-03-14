package solid.products.food;

public class Chips extends Food{
    public static final double CALORIES_PER_100_GRAMS = 529.00;

    public Chips(double grams) {
        super(grams, CALORIES_PER_100_GRAMS);
    }

}
