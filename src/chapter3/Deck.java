package chapter3;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Deck implements Iterable<Card> {
	private final List<Card> cards;

	/**
	 * Constructor.
	 */
	public Deck() {
		this.cards = new ArrayList<>();
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				this.cards.add(new Card(s, r));
			}
		}
		Collections.shuffle(this.cards);
	}

	/**
	 * Constructor.
	 * 
	 * @param pConfig The configuration client specified to build the Deck.
	 * @pre pConfig != null;
	 */
	public Deck(DeckConfig pConfig) {
		assert pConfig != null;
		
		this.cards = new ArrayList<>(pConfig.configDeck());
		Collections.shuffle(this.cards);
	}

	/**
	 * Copy constructor.
	 * 
	 * @param d The Deck one wants to copy.
	 */
	public Deck(Deck d) {
		assert d != null;
		
		this.cards = new ArrayList<>(d.getCards());
		for (Card c : d.getCards()) {
			this.cards.add(new Card(c));
		}
	}

	/**
	 * @return the list of cards in the Deck.
	 */
	public List<Card> getCards() {
		return new ArrayList<>(this.cards);
	}

	public void sort(SortConfig pSortConfig) {
		Collections.sort(this.cards, pSortConfig.getSortConfig());
	}

	public String toString() {
		return this.cards.toString();
	}

	@Override
	public Iterator<Card> iterator() {
//		return this.cards.iterator();
		return new Iterator<Card>() {
			
			int cursor = 0;

			@Override
			public boolean hasNext() {
				return !(cursor == cards.size());
			}

			@Override
			public Card next() {
				return cards.get(cursor++);
			}
			
		};
	}

}
