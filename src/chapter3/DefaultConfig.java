package chapter3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultConfig implements DeckConfig {

	@Override
	public List<Card> configDeck() {

		List<Card> result = new ArrayList<>();

		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				result.add(new Card(s, r));
			}
		}

		Collections.shuffle(result);
		return result;

	}

}
