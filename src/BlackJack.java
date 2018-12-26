/**
 * Class representing a single player blackjack game
 */
public class BlackJack {

    private Player player;
    private Dealer dealer;
    private Deck deck;


    /**
     * Constructs and prepares for a new game of BlackJack.
     * Creates player, dealer and deck objects then shuffles
     * the deck and gives both the dealer and player two cards.
     */
    public BlackJack() {
        this.player = new Player(); // create player object
        this.dealer = new Dealer(); // create dealer object
        this.deck = new Deck(); // create deck object
        // give 2 cards each
        player.getHand().addCard(deck.draw());
        player.getHand().addCard(deck.draw());
        dealer.getHand().addCard(deck.draw());
        dealer.getHand().addCard(deck.draw());
    }
    /**
     * Restarts in a few steps
     * 1. The Player and dealer return their cards to the deck.
     * 2. The deck is shuffled.
     * 3. Both the player and the dealer receive two cards drawn form the top of the deck.
     */
    public void restart() {
        player.returnCardstoDeck(this.deck);
        dealer.returnCardstoDeck(this.deck);
        deck.shuffle();
        // player and dealer both receive 2 cards from deck
        player.getHand().addCard(deck.draw());
        player.getHand().addCard(deck.draw());
        dealer.getHand().addCard(deck.draw());
        dealer.getHand().addCard(deck.draw());
    }
    /**
     * Returns the value of a card in a standard game of Blackjack based on the type of the card
     * ex. An Ace would return 1, a 2 would return 2...
     * @param c card whose value is extracted
     * @return value of the card
     */
    public static int getValueOfCard(Card c) {
        switch (c.getType()) {
            case ACE: return 1;
            case TWO: return 2;
            case THREE: return 3;
            case FOUR: return 4;
            case FIVE: return 5;
            case SIX: return 6;
            case SEVEN: return 7;
            case EIGHT: return 8;
            case NINE: return 9;
            case TEN: return 10;
            case JACK: return 10;
            case QUEEN: return 10;
            case KING: return 10;
        }
        return 0;
    }
    /**
     * Returns the maximum value of the hand that does not result in a bust
     * @param h Hand whose value is returned
     * @return value of h
     */
    public static int getValueOfHand(Hand h) {
        int maxValue = 0;
        boolean inHand = false;
        for(int i = 0; i < h.size(); i++) {
            if(getValueOfCard(h.getCards()[i]) == 1) {
                inHand = true;
                continue;
            }
            maxValue += getValueOfCard(h.getCards()[i]);
        }
        if(inHand == true) {
            if(maxValue + 11 <= 21) {
                maxValue += 11;
                return maxValue;
            }
            else {
                maxValue += 1;
                return maxValue;
            }
        }
        else {
            return maxValue;
        }
    }

    /**
     * @return Deck used to play
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * @return Dealer of the game
     */
    public Dealer getDealer() {
        return dealer;
    }

    /**
     * @return Player playing the blackjack game
     */
    public Player getPlayer() {
        return player;
    }

}
