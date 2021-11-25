package chapter3;

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
