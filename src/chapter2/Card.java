package chapter2;

public class Card implements Comparable<Card> {

	private final Suit aSuit;
	private final Rank aRank;

	/**
	 * Constructor.
	 * 
	 * @param pSuit
	 * @param pRank
	 * 
	 * @pre pSuit != null && pRank != null
	 */
	public Card(Suit pSuit, Rank pRank) {
		assert pSuit != null && pRank != null;

		this.aSuit = pSuit;
		this.aRank = pRank;
	}

	/**
	 * Copy Constructor.
	 * 
	 * @param pCard
	 * 
	 * @pre pCard != null
	 */
	public Card(Card pCard) {
		assert pCard != null;

		this.aSuit = pCard.aSuit;
		this.aRank = pCard.aRank;
	}

	/**
	 * @return the Suit of this Card.
	 */
	public Suit getSuit() {
		return this.aSuit;
	}

	/**
	 * @return the Rank of this Card.
	 */
	public Rank getRank() {
		return this.aRank;
	}

	public String toString() {
		return this.aRank + " of " + this.aSuit;
	}

	@Override
	public int compareTo(Card pCard) {
		assert pCard != null;
		return this.aRank.ordinal() - pCard.aRank.ordinal();
	}

}
