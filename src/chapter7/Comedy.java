package chapter7;

import java.util.Objects;

public class Comedy extends AbstractShow implements Cloneable {

	private String aComedian;

	public Comedy(String pComedian, String pTitle, int pTime) {
		super(pTitle, pTime);
		this.aComedian = pComedian;
	}

	public Comedy(Comedy pComedy) {
		super(pComedy.title(), pComedy.time());
		this.aComedian = pComedy.aComedian;
	}

	@Override
	protected String extraInfo() {
		return String.format("by %s", aComedian);
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
		return this.aComedian == pComedy.aComedian && title() == pComedy.title() && time() == pComedy.time();
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.aComedian, title(), time());
	}
	
	@Override
	public Comedy clone() {
		try {
			return (Comedy) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
