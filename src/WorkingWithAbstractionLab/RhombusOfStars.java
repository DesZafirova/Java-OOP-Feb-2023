package WorkingWithAbstractionLab;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        //горна част - бр.на редовете=N
        printTopPart(n);
        //средна част - бр.звезди = n
        printMiddlePart(n);

        //долна част
        printBottomPart(n);
    }

    private static void printBottomPart(int n) {
        for (int row = n - 1; row >= 1; row--) {
            printRow(n, row);
        }
    }

    private static void printMiddlePart(int n) {
        for (int star = 1; star <= n; star++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    private static void printTopPart(int n) {
        for (int row = 1; row < n; row++) {
            printRow(n, row);
        }
    }

    private static void printRow(int n, int row) {
        for (int space = 1; space <= n - row; space++) {
            System.out.print(" ");
        }
        printMiddlePart(row);
    }
}
