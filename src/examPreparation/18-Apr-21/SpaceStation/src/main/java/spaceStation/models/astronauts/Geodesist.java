package spaceStation.models.astronauts;

public class Geodesist extends BaseAstronaut{
    private static final double OXYGEN = 50;
    public Geodesist(String name) {
        super(name, OXYGEN);
    }

    @Override
    public void breath() {
        this.setOxygen(getOxygen() - 10);
        if(getOxygen() < 0){
            setOxygen(0);
        }
    }
}
