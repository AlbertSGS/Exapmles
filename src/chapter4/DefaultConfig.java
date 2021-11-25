package chapter4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultConfig implements DeckConfig {

	@Override
	public List<Card> configDeck() {

		List<Card> result = new ArrayList<>();

		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				result.add(Card.access(s, r));
			}
		}
		
		result.add(Card.access(Color.BLACK));
		result.add(Card.access(Color.RED));

		Collections.shuffle(result);
		return result;

	}

}
