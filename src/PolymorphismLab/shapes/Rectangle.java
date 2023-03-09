package PolymorphismLab.shapes;

public class Rectangle extends Shape {
    private final Double height;
    private final Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    @Override
    public final Double calculatePerimeter() {
        if (perimeter == null) {
            perimeter = getPerimeter();
        }
        return perimeter;
    }

    private double getPerimeter() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignored) {

        }
        return 2 * height + 2 * width;
    }

    @Override
    public final Double calculateArea() {
        if (area == null) {
            area = getArea();
        }
        return area;
    }

    private double getArea() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignored) {

        }
        return height * width;
    }
}
