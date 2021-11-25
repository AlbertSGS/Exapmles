package chapter6;

import java.util.Collections;
import java.util.Iterator;

/**
 * A performance that can take place in a Theater
 */
public interface Show extends Iterable<Show> {
	
	private static Show createNull() {
		return new Show() {

			@Override
			public int time() {
				return 0;
			}

			@Override
			public String description() {
				return "No Show";
			}

			@Override
			public boolean isNull() {
				return true;
			}
			
			@Override
			public Show copy() {
				return createNull();
			}
		};
	}

	static final Show NULL_SHOW = createNull();

	/**
	 * @return The total running time of the show
	 */
	int time();

	/**
	 * @return A description of the show to appear
	 */
	String description();
	
	Show copy();

	default boolean isNull() {
		return false;
	}

	@Override
	default Iterator<Show> iterator() {
		return Collections.emptyIterator();
	}

}
