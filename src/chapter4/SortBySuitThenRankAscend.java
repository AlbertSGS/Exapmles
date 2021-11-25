package chapter4;

import java.util.Comparator;

public class SortBySuitThenRankAscend implements SortConfig {

	@Override
	public Comparator<Card> getSortConfig() {
		return new Comparator<Card>() {
			public int compare(Card pCard1, Card pCard2) {
				int bySuit = pCard1.getSuit().ordinal() - pCard2.getSuit().ordinal();
				if (bySuit == 0) {
					return pCard1.getRank().ordinal() - pCard2.getRank().ordinal();
				}
				return bySuit;
			}
		};
	}

}
