/*
 * Hand.java
 * Author: Cynthia He
 * Submission Date: December 2, 2018
 *
 * Purpose: This program contains methods relating to the Hand class. It represents the
 * cards in a player or dealers hands during a game of Black Jack.
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
 *
 * @author ghyzel
 *
 */
public class Hand {

    /**
     * The cards in the hand
     */
    private Card [] cards;

    /**
     * Creates an empty hand
     */
    public Hand() {
        //Initializing an empty array.
        //Calling cards.length on this array would return 0
        cards = new Card[0];
    }

    /**
     * Adds Card c to the hand
     *
     * @param c card to be added
     */
    public void addCard(Card c) {
        Card[] oldCards = new Card[cards.length + 1]; // create new array
        for(int i = 0; i < cards.length; i++) {
            oldCards[i] = cards[i]; // copy over old elements to the new array
        }
        oldCards[oldCards.length - 1] = c;
        cards = new Card[oldCards.length];
        for(int i = 0; i < oldCards.length; i++) {
            cards[i] = oldCards[i]; // copy over old elements to the new array
        }
    }

    /**
     * @return number of cards in the hand
     */
    public int size() {
        return cards.length;
    }

    /**
     * Returns an array of all the cards in the hand
     *
     * @return the cards in the hand
     */
    public Card[] getCards() {
        // Ensure you return reference to the copy of the cards array
        // and not a reference actual cards array!
        Card[] oldCards = new Card[cards.length];
        for(int i = 0; i < cards.length; i++) {
            oldCards[i] = cards[i];
        }
        return oldCards;
    }

    /**
     * Empties the hand, and returns an array containing the discarded cards.
     *
     * @return the discarded cards
     */
    public Card[] emptyHand() {
        Card[] oldCards = new Card[cards.length];
        for(int i = 0; i < cards.length; i++) {
            oldCards[i] = cards[i];
        }
        cards = new Card[0]; // set size of the cards array back to 0
        return oldCards;
    }

    /**
     * Returns a String representation of the hand
     *
     * E.g.
     *
     * "Empty Hand"
     * "1. ACE OF SPADES\n2. QUEEN OF HEARTS"
     *
     * @return a String representing the hand
     */
    @Override
    public String toString() {
        String cardsInHand = "";
        if(cards.length != 0) {
            for(int i = 0, j = 1; i < cards.length; i++, j++) {
                cardsInHand += j + "." + cards[i].toString() + "\n";
            }
        }
        else {
            cardsInHand = "Empty hand";
        }
        return cardsInHand;
    }
}
