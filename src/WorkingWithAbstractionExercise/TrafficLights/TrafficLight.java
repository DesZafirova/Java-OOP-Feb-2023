package WorkingWithAbstractionExercise.TrafficLights;

public class TrafficLight {
    private Color color;

    public TrafficLight(Color color) {
        this.color = color;
    }

    public void changeColor() {
        switch(color){
            case RED :
                 this.color = color.GREEN;
            break;
            case GREEN :
                this.color = color.YELLOW;
                break;
            case YELLOW:
                this.color = color.RED;
                break;
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
