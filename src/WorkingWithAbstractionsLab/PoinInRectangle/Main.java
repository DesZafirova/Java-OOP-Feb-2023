package WorkingWithAbstractionsLab.PoinInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] coordinates = parse(scanner);
        int bottomLeftX = coordinates[0];
        int bottomLeftY = coordinates[1];
        int topRightX = coordinates[2];
        int topRightY = coordinates[3];
        Point bottomLeft = new Point(bottomLeftX, bottomLeftY);
        Point topRight = new Point(topRightX, topRightY);
        Rectangle rectangle = new Rectangle(bottomLeft, topRight);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            int[] checkPointCoordinates = parse(scanner);
            int x = checkPointCoordinates[0];
            int y = checkPointCoordinates[1];
            Point searchedPoint = new Point(x, y);
            System.out.println(rectangle.contains(searchedPoint));
        }
    }

    private static int[] parse(Scanner scanner) {
        int[] coordinates = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        return coordinates;
    }
}
