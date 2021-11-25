package chapter4;

import java.util.Optional;

public class Card implements Comparable<Card> {

	private final Optional<Suit> s;
	private final Optional<Rank> r;
	private final Color c;

	private static final Card[][] CARDS = new Card[Suit.values().length][Rank.values().length];
	private static final Card[] JOKERS = new Card[2];

	static {
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				CARDS[suit.ordinal()][rank.ordinal()] = new Card(suit, rank);
			}
		}
		JOKERS[0] = new Card(Color.BLACK);
		JOKERS[1] = new Card(Color.RED);
	}

	public static Card access(Suit pSuit, Rank pRank) {
		return CARDS[pSuit.ordinal()][pRank.ordinal()];
	}

	public static Card access(Color c) {
		return JOKERS[c.ordinal()];
	}

	/**
	 * @param s Suit of this Card
	 * @param r Rank of this Card
	 * 
	 * @pre s != null && r != null
	 */
	private Card(Suit s, Rank r) {
		assert s != null && r != null;

		this.s = Optional.of(s);
		this.r = Optional.of(r);
		if (this.s.get() == Suit.DIAMONDS || this.s.get() == Suit.HEARTS) {
			this.c = Color.RED;
		} else {
			this.c = Color.BLACK;
		}
	}

	private Card(Color c) {
		assert c != null;

		this.s = Optional.empty();
		this.r = Optional.empty();

		this.c = c;
	}

	public Rank getRank() {
		return this.r.get();
	}

	public Suit getSuit() {
		return this.s.get();
	}

	public Color getColor() {
		return this.c;
	}

	/**
	 * @param c Card to be compared to
	 */
	public int compareTo(Card pCard) {
		if (this.s.isEmpty() || this.r.isEmpty()) {
			return this.c.ordinal() - pCard.c.ordinal();
		}
		int bySuit = this.s.get().ordinal() - pCard.s.get().ordinal();

		if (bySuit == 0) {
			return this.r.get().ordinal() - pCard.r.get().ordinal();
		} else {
			return bySuit;
		}
	}

	public String toString() {
		if (this.r.isEmpty() || this.s.isEmpty()) {
			return this.c + " JOKER";
		}
		return this.r.get() + " of " + this.s.get();
	}

	public boolean equal(Object pObject) {
		if (pObject == null) {
			return false;
		}

		if (pObject == this) {
			return true;
		}

		if (pObject.getClass() != this.getClass()) {
			return false;
		}

		return this.r == ((Card) pObject).r && this.c == ((Card) pObject).c && this.s == ((Card) pObject).s;
	}

	public int hashcode() {
		int result = 1;
		int prime = 31;
		result = prime * result + (this.r.hashCode());
		result = prime * result + (this.s.hashCode());
		result = prime * result + (this.c.hashCode());
		return result;
	}
}
