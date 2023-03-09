package PolymorphismLab.shapes;

public class Circle extends Shape {
    private final Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public final Double getRadius() {
        return radius;
    }

    @Override
    public Double calculatePerimeter() {
        if (perimeter == null) {
            perimeter = getPerimeter();
        }
        return perimeter;
    }

    private double getPerimeter() {

        return 2 * Math.PI * radius;
    }

    @Override
    public Double calculateArea() {
        if (area == null) {
            area = getArea();
        }
        return area;
    }

    private double getArea() {
        return Math.PI * radius * radius;
    }
}
