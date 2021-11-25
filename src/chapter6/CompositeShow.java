package chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class CompositeShow implements Show, Iterable<Show> {

	private final List<Show> aShows = new ArrayList<>();

	public CompositeShow(Show... pShows) {
//		this.aShows = Arrays.asList(pShows);
//		if (pShows.length < 2 || pShows.length > 5) {
//			throw new IllegalArgumentException("Arguments should be between two and five shows inclusively");
//		}
		aShows.addAll(Arrays.asList(pShows));
	}

	@Override
	public int time() {
		int time = 0;
		for (Show show : this.aShows) {
			time += show.time();
		}
		return time;
	}

	@Override
	public String description() {
		StringBuilder description = new StringBuilder("[");
		for (Show show : this.aShows) {
			description.append(show.description()).append(";");
		}
		return description.append("]").toString();
	}

//	public void add(Show pShow) {
//		assert pShow != null;
//		this.aShows.add(pShow);
//	}

	@Override
	public int hashCode() {
		return Objects.hash(this.aShows);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositeShow other = (CompositeShow) obj;
		return Objects.equals(aShows, other.aShows);
	}

	@Override
	public Iterator<Show> iterator() {
		return this.aShows.iterator();
	}

	@Override
	public Show copy() {
		CompositeShow aCopy = new CompositeShow();
		for(Show show : this.aShows) {
			aCopy.aShows.add(show.copy());
		}
		return aCopy;
	}

}
