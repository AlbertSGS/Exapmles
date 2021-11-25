package chapter2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private final List<Card> aCards;

	public Deck() {
		this.aCards = new ArrayList<>();

		for (Suit aSuit : Suit.values()) {
			for (Rank aRank : Rank.values()) {
				aCards.add(new Card(aSuit, aRank));
			}
		}

		Collections.shuffle(aCards);
	}
	
	public int getSize() {
		return this.aCards.size();
	}

	public List<Card> getCards() {
		return new ArrayList<>(this.aCards);
	}

	public Card draw() {
		return new Card(this.aCards.remove(0));
	}
	public void sort() {
		Collections.sort(this.aCards);
	}
	
	public String toString() {
		return this.aCards.toString();
	}
	
	
}
