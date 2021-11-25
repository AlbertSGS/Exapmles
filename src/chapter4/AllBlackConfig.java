package chapter4;

import java.util.List;
import java.util.ArrayList;

public class AllBlackConfig implements DeckConfig {

	@Override
	public List<Card> configDeck() {
		List<Card> result = new ArrayList<>();

		for (Suit s : Suit.values()) {
			if (s.getColor() == Color.RED)
				continue;
			for (Rank r : Rank.values()) {
				result.add(Card.access(s, r));
			}
		}
		result.add(Card.access(Color.BLACK));
		return result;
	}

}
