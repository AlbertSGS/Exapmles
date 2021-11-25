package chapter6;

import java.util.Iterator;

public class DoubleBill implements Show {

	private final Movie aMovie1;
	private final Movie aMovie2;

	public DoubleBill(Movie pMovie1, Movie pMovie2) {
		this.aMovie1 = pMovie1;
		this.aMovie2 = pMovie2;
	}

	public DoubleBill(DoubleBill pDoubleBill) {
		this.aMovie1 = new Movie(pDoubleBill.aMovie1);
		this.aMovie2 = new Movie(pDoubleBill.aMovie2);
	}

	@Override
	public int time() {
		return this.aMovie1.time() + this.aMovie2.time();
	}

	@Override
	public String description() {
		return this.aMovie1.description() + " followed by " + this.aMovie2.description();
	}

	@Override
	public Iterator<Show> iterator() {
		return new Iterator<Show>() {

			private int counter = 0;

			@Override
			public boolean hasNext() {
				return (counter != 2);
			}

			@Override
			public Show next() {
				counter++;
				return (counter == 1 ? aMovie1 : aMovie2);
			}

		};
	}

	@Override
	public Show copy() {
		return new DoubleBill(this.aMovie1.copy(), this.aMovie2.copy());
	}

}
