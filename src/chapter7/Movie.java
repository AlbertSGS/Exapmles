package chapter7;

import java.util.Objects;

/**
 * @author sgs09
 *
 */
public class Movie extends AbstractShow {
	
	private int aYear;

	public Movie(String pTitle, int pYear, int pTime) {
		super(pTitle, pTime);
		this.aYear = pYear;
	}

	public Movie(Movie pMovie) {
		super(pMovie.title(), pMovie.time());
		this.aYear = pMovie.aYear;
	}
	
	@Override
	protected String extraInfo() {
		return String.format("(%)", aYear);
	}

	@Override
	public Movie copy() {
		return new Movie(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || obj.getClass() != this.getClass())
			return false;
		Movie pMovie = (Movie) obj;
		return this.aYear == pMovie.aYear && title() == pMovie.title() && title() == pMovie.title();
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.aYear, title(), time());
	}

}
