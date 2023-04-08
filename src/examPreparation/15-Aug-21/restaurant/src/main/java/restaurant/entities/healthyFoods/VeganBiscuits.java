package restaurant.entities.healthyFoods;

public class VeganBiscuits extends Food{
    private static final double VEGAN_BISCUIT_PORTION = 205;
    public VeganBiscuits(String name, double price) {
        super(name, VEGAN_BISCUIT_PORTION, price);
    }
}
