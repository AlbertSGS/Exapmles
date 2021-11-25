package chapter6;

import java.util.Objects;

/**
 * @author sgs09
 *
 */
public class Movie implements Show {

	private String aTitle;
	private int aYear;
	private int aTime;

	public Movie(String pTitle, int pYear, int pTime) {
		this.aTitle = pTitle;
		this.aYear = pYear;
		this.aTime = pTime;
	}

	public Movie(Movie pMovie) {
		this.aTitle = pMovie.aTitle;
		this.aYear = pMovie.aYear;
		this.aTime = pMovie.aTime;
	}

	@Override
	public int time() {
		return this.aTime;
	}

	@Override
	public String description() {
		return String.format("[%s (%d): %d minutes]", aTitle, aYear, aTime);
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
		return this.aYear == pMovie.aYear && this.aTitle == pMovie.aTitle && this.aTime == pMovie.aTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.aYear, this.aTitle, this.aTime);
	}

}
