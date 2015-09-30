import java.util.ArrayList;

public class Hand {

	private ArrayList<Card> hand;

	public Hand() {
		hand = new ArrayList<Card>();
	}

	public void clear() {
		hand.clear();
	}

	public void addCard(Card c) {
		hand.add(c);
	}

	public void removeCard(Card c) {
		hand.remove(c);
	}

	public int getCardCount() {
		return hand.size();
	}

	public Card getCard(int position) {
		return (Card)hand.get(position);
	}
}