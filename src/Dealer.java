/*
 * Dealer.java
 * Author: Cynthia He
 * Submission Date: December 2, 2018
 *
 * Purpose: This program contains methods relating to the Dealer class. It represents the
 * dealer in the Black Jack game. He draws (hits) until he reaches 17 points or 5 cards.
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing
 * or posting of source code for this project is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia.
 */

/**
 * The Dealer in your game of BlackJack. Draws until he/she gets 17 points or has 5 cards.
 *
 */
public class Dealer {
    /**
     * The dealers hand
     */
    Hand hand;

    /**
     * Construct a new dealer with an empty hand
     */
    public Dealer() {
        hand = new Hand(); // hand instance variable to an empty hand
    }

    /**
     * Dealer draws a card if his hand is worth less than 17 points and has less than 5 cards in in his hand.
     *
     * @param deck
     * @return
     */
    public Card playTurn(Deck deck) {
        // if less than 17 points and contains less than 5 cards
        if(BlackJack.getValueOfHand(hand) < 17 && this.hand.size() < 5) {
            Card cardDraw = deck.draw();
            this.hand.addCard(cardDraw);
            return cardDraw;
        }
        else {
            return null;
        }
    }

    /**
     * A method to check if the dealer has busted
     * @return boolean true if the dealer has busted
     */
    public boolean busted() {
        if(BlackJack.getValueOfHand(hand) > 21) { // return true if greater than 21
            return true;
        }
        else
            return false;
    }

    /**
     * A method to check if the dealer will draw a card.
     * @return
     */
    public boolean isDone() {
        // dealer draws if his hand is less than 17 points and has less than 5 cards
        if(BlackJack.getValueOfHand(hand) > 17 && hand.size() > 5) {
            return true;
        }
        else
            return false;
    }

    /**
     * Returns the dealers cards to the deck
     * @param d Deck to return the cards to
     */
    public void returnCardstoDeck(Deck d) {
        int numCards = hand.size();
        for(int i = 0; i < numCards; i++) {
            d.addToBottom(hand.getCards()[i]); // returns discarded cards to bottom of deck
        }
        hand.emptyHand();
    }
    /**
     * @return Hand the dealer's hand
     */
    public Hand getHand() {
        return hand;
    }
}
