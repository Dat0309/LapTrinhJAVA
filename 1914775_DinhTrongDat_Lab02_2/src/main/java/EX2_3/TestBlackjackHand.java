/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX2_3;

/**
 *
 * @author ADMIN
 */
public class TestBlackjackHand {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            Deck deck; // A deck of cards.
            Card card; // A card dealt from the deck.
            BlackjackHand hand; // A hand of from two to six cards.
            int cardsInHand; // Number or cards in the hand.
            boolean again; // Set to true if user wants to continue.
            deck = new Deck(); // Create the deck.
            do {
                deck.shuffle();
                hand = new BlackjackHand();
                cardsInHand = 2 + (int)(Math.random()*5);
                System.out.println();
                System.out.println();
                System.out.println("Hand contains:");
                for ( int i = 1; i <= cardsInHand; i++ ) {
// Get a card from the deck, print it out,
// and add it to the hand.
                card = deck.dealCard();
                hand.addCard(card);
                System.out.println(" " + card);
        }       
                System.out.println("Value of hand is " +
                hand.getBlackjackValue());
                System.out.println();
                System.out.print("Again? ");
                again = TextIO.getlnBoolean();
            } while (again == true);

    }
    
}
