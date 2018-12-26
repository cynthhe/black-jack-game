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
