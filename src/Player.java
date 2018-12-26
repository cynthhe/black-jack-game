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
