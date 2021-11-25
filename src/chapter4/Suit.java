package chapter4;

public enum Suit {
	CLUBS, DIAMONDS, SPADES, HEARTS;

	public Color getColor() {
		if (this == Suit.CLUBS || this == Suit.SPADES) {
			return Color.BLACK;
		} else {
			return Color.RED;
		}
	}
}
