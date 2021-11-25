package chapter3;

public class Card implements Comparable<Card> {

	private final Suit s;
	private final Rank r;
	private final Color c;

	/**
	 * @param s Suit of this Card
	 * @param r Rank of this Card
	 * 
	 * @pre s != null && r != null
	 */
	public Card(Suit s, Rank r) {
		assert s != null && r != null;

		this.s = s;
		this.r = r;
		if (this.s == Suit.DIAMONDS || this.s == Suit.HEARTS) {
			this.c = Color.RED;
		} else {
			this.c = Color.BLACK;
		}
	}
	
	/**
	 * @param pCard
	 * @pre pCard != null
	 */
	public Card(Card pCard) {
		assert pCard != null;
		
		this.s = pCard.s;
		this.r = pCard.r;
		this.c = pCard.c;
	}

	public Rank getRank() {
		return this.r;
	}

	public Suit getSuit() {
		return this.s;
	}

	public Color getColor() {
		return this.c;
	}

	/**
	 * @param c Card to be compared to
	 */
	public int compareTo(Card c) {
		int bySuit = this.s.ordinal() - c.s.ordinal();

		if (bySuit == 0) {
			return this.r.ordinal() - c.r.ordinal();
		} else {
			return bySuit;
		}
	}

	public String toString() {
		return this.r + " of " + this.s;
	}
}
