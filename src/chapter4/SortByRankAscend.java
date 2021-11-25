package chapter4;

import java.util.Comparator;

public class SortByRankAscend implements SortConfig {

	@Override
	public Comparator<Card> getSortConfig() {
		return new Comparator<Card>() {

			@Override
			public int compare(Card pCard1, Card pCard2) {
				return pCard1.getSuit().ordinal() - pCard2.getSuit().ordinal();
			}

		};
	}

}
