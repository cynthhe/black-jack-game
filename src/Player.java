/*
 * Player.java
 * Author: Cynthia He
 * Submission Date: December 2, 2018
 *
 * Purpose: This program contains methods relating to the Player class. It represents the
 * human player in the Black Jack game.
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
 * A player in a blackJack game
 *
 */
public class Player {
    /**
     * The players hand
     */
    private Hand hand;

    /**
     * Instantiates the hand instance variable.
     */
    public Player() {
        hand = new Hand();
    }

    /**
     * @return true if the player has bused
     */
    public boolean busted() {
        if(BlackJack.getValueOfHand(hand) > 21) { // return true if greater than 21
            return true;
        }
        else
            return false;
    }

    /**
     * empty the player hand into the cards
     * @param d deck that receives the cards
     */
    public void returnCardstoDeck(Deck d) {
        int numCards = hand.size();
        for(int i = 0; i < numCards; i++) {
            d.addToBottom(hand.getCards()[i]); // return discarded cards to bottom of deck
        }
        hand.emptyHand();
    }
    /**
     * @return the player's hand
     */
    public Hand getHand() {
        return hand;
    }
}
