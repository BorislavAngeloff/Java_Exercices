import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//You will be given two hands of cards, which will be integer numbers.
// Assume that you have two players. You must find the winning deck and,
// respectively, the winner.

//You start from the beginning of both hands.
//Compare the cards from the first deck to those from the second.
//The player, who has a bigger card, takes both cards and puts them on the back
//of his hand - the second player's card is last, and the first person's card
//(the winning one) is before it (second to last), and the player with the
//smaller card must remove the card from his deck. If both players'
//cards have the same values - no one wins, and the two cards must be removed
//from the decks. The game is over when one of the decks is left without any cards.
//You have to print the winner on the console and the sum of the left cards:
//"{First/Second} player wins! Sum: {sum}".

//Example

//Input:
//20 30 40 50
//10 20 30 40

//Output:
//First player wins! Sum: 240

public class CardsGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondPlayerCards = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        while (!firstPlayerCards.isEmpty() && !secondPlayerCards.isEmpty()) {

            int firstPlayerCard = firstPlayerCards.get(0);
            int secondPlayerCard = secondPlayerCards.get(0);

            firstPlayerCards.remove(0);
            secondPlayerCards.remove(0);

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayerCards.add(firstPlayerCard);
                firstPlayerCards.add(secondPlayerCard);
            } else if (secondPlayerCard > firstPlayerCard) {
                secondPlayerCards.add(secondPlayerCard);
                secondPlayerCards.add(firstPlayerCard);
            }
        }

        if (!firstPlayerCards.isEmpty()) {
            int sum = firstPlayerCards.stream().mapToInt(Integer::intValue).sum();
            System.out.println("First player wins! Sum: " + sum);
        } else {
            int sum = secondPlayerCards.stream().mapToInt(Integer::intValue).sum();
            System.out.println("Second player wins! Sum: " + sum);
        }
    }
}
