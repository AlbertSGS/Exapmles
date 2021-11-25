package chapter6;

import java.util.Objects;

public class Comedy implements Show {

	private String aComedian;
	private String aTitle;
	private int aTime;

	public Comedy(String pComedian, String pTitle, int pTime) {
		this.aComedian = pComedian;
		this.aTitle = pTitle;
		this.aTime = pTime;
	}

	public Comedy(Comedy pComedy) {
		this.aComedian = pComedy.aComedian;
		this.aTitle = pComedy.aTitle;
		this.aTime = pComedy.aTime;
	}

	@Override
	public int time() {
		return this.aTime;
	}

	@Override
	public String description() {
		return String.format("[%s by %s: %d minutes]", aTitle, aComedian, aTime);
	}

	@Override
	public Show copy() {
		return new Comedy(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || obj.getClass() != this.getClass())
			return false;
		Comedy pComedy = (Comedy) obj;
		return this.aComedian == pComedy.aComedian && this.aTitle == pComedy.aTitle && this.aTime == pComedy.aTime;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.aComedian, this.aTitle, this.aTime);
	}

}
