import java.util.*;

class Card {
    String symbol;
    int number;

    Card(String symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }
}

public class CardGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the number of cards
        System.out.print("Enter Number of Cards : ");
        int N = sc.nextInt();
        sc.nextLine();  // Consume the newline character

        // Map to store cards grouped by symbol
        Map<String, List<Card>> cardMap = new HashMap<>();

        // Get card details from the user
        for (int i = 1; i <= N; i++) {
            System.out.print("Enter card " + i + " symbol: ");
            String symbol = sc.nextLine();
            System.out.print("Enter card " + i + " number: ");
            int number = sc.nextInt();
            sc.nextLine();  // Consume the newline character

            // Create a new card
            Card card = new Card(symbol, number);

            // Add card to map, grouped by symbol
            cardMap.putIfAbsent(symbol, new ArrayList<>());
            cardMap.get(symbol).add(card);
        }

        // Get distinct symbols and sort them alphabetically
        System.out.println("Distinct Symbols are : ");
        List<String> symbols = new ArrayList<>(cardMap.keySet());
        Collections.sort(symbols);
        for (String symbol : symbols) {
            System.out.print(symbol + " ");
        }
        System.out.println();

        // Print details for each symbol
        for (String symbol : symbols) {
            System.out.println("Cards in " + symbol + " Symbol");
            List<Card> cards = cardMap.get(symbol);
            int sum = 0;
            for (Card card : cards) {
                System.out.println(card.symbol + " " + card.number);
                sum += card.number;
            }
            System.out.println("Number of cards : " + cards.size());
            System.out.println("Sum of Numbers : " + sum);
        }

        sc.close();
    }
}
