package chapter4;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Hand implements Iterable<Card> {

	private final List<Card> aCards;
	private int cardCount;
	private static final int CARD_LIMIT = 5;

	public Hand() {
		this.aCards = new ArrayList<>();
		this.cardCount = 0;
	}
	
	public Hand(Hand pHand) {
		this.aCards = new ArrayList<>(pHand.aCards);
		this.cardCount = pHand.cardCount;
	}

	public void addCard(Card pCard) {
		assert pCard != null;
		if (cardCount == CARD_LIMIT) {
			System.out.println("Failed to add card to hand; limit reached.");
		} else {
			this.aCards.add(pCard);
		}
	}

	@Override
	public Iterator<Card> iterator() {
		return this.aCards.iterator();
	}

}
