package WorkingWithAbstractionsExercise.CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Card.Rank rank = Card.Rank.valueOf(scanner.nextLine());
        Card.Suit suit= Card.Suit.valueOf(scanner.nextLine());
        Card card = new Card(rank, suit);
        System.out.println("Card name: " + card.getName() + "; Card power: " + card.getPower());
    }
}
