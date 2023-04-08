package robotService.entities.robot;

import robotService.entities.supplements.BaseSupplement;

public class FemaleRobot extends BaseRobot {
    private static final int KILOGRAMS = 7;

    public FemaleRobot(String name, String kind, double price) {
        super(name, kind, KILOGRAMS, price);
    }

    @Override
    public void eating() {
        this.setKilograms(getKilograms() + 1);
    }
}
