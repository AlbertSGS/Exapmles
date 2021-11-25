package chapter3;

import java.util.List;
import java.util.ArrayList;

public class AllRedConfig implements DeckConfig {

	@Override
	public List<Card> configDeck() {
		List<Card> result = new ArrayList<>();

		for (Suit s : Suit.values()) {
			if (s.getColor() == Color.BLACK)
				continue;
			for (Rank r : Rank.values()) {
				result.add(new Card(s, r));
			}
		}
		return result;
	}

}
