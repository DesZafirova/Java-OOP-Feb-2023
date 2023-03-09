package PolymorphismLab.shapes;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(2.00, 4.00);

        Shape circle = new Circle(5.00);
        printShape(rectangle);
        printShape(circle);
    }

    private static void printShape(Shape shape) {
        System.out.println(shape.calculateArea());
        System.out.println(shape.calculatePerimeter());
    }
}
