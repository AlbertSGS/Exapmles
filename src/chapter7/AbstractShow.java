package chapter7;

public abstract class AbstractShow implements Show {

	private final String aTitle;
	private final int aTime;
	
	protected AbstractShow(String pTitle, int pTime) {
		this.aTitle = pTitle;
		this.aTime = pTime;
	}
	
	
	protected String title() {
		return this.aTitle;
	}
	
	@Override
	public int time() {
		return this.aTime;
	}
	
	protected abstract String extraInfo();

	@Override
	public final String description() {
		return String.format("[%s %s: %d minutes]", title(), extraInfo(), time());
	}
}
