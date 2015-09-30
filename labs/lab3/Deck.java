public class Deck {
	
	private Card[] deck;
	private int cardsUsed;

	public Deck() {
		deck = new Card[52];
		int cardsUsed = 0;
		int cardCount = 0;
		for (int suit = 0; suit <= 3; suit++) {
			for (int value = 1; value <= 13; value++) {
				deck[cardCount] = new Card(value, suit);
				cardCount++;
			}
		}
	}

	public void shuffle() {
		for (int i=deck.length-1; i > 0; i--) {
			int index = (int)(52*Math.random());
			Card tmp = deck[i];
			deck[i] = deck[index];
			deck[index] = tmp;
		}
		cardsUsed = 0;
	}

	public int cardsLeft() {
		return deck.length - cardsUsed;
	}

	public Card dealCard() {
		Card c = deck[cardsUsed];
		cardsUsed++;
		return c;
	}
}