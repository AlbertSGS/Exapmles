package chapter3;

import java.util.Iterator;

public class Client {

	public static void main(String[] args) {

		DeckConfig aConfig = new DefaultConfig();
		SortConfig aSortConfig = new SortBySuitThenRankAscend();

		Deck d = new Deck(aConfig);

		System.out.println(d);
		d.sort(aSortConfig);
		System.out.println(d);

		Iterator<Card> iter = d.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		iter = d.iterator();

	}

}
