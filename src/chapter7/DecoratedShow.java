package chapter7;

public abstract class DecoratedShow implements Show, Cloneable {

	private Show aShow; // Should be final except for clone()
	
	protected DecoratedShow(Show pShow) {
		this.aShow = pShow;
	}
	
	@Override
	public int time() {
		return aShow.time();
	}
	
	@Override
	public String description() {
		return aShow.description();
	}
	
	@Override
	public Show copy() {
		return this.aShow;
	}
}
