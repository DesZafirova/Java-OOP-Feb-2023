package catHouse.entities.cat;

public class ShorthairCat extends BaseCat {
    private static final int KG = 7;

    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);

    }

    @Override
    public void eating() {
        setKilograms(KG + 1);
    }
}
