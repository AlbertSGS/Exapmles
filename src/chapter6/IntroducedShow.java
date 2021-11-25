package chapter6;

public class IntroducedShow implements Show {

	private final Show aShow;

	private final String aSpeaker;
	private final int aTime;

	public IntroducedShow(Show pShow, String pSpeaker, int pSpeechTime) {
		this.aShow = pShow;
		this.aSpeaker = pSpeaker;
		this.aTime = pSpeechTime;
	}

	@Override
	public int time() {
		return this.aTime + this.aShow.time();
	}

	@Override
	public String description() {
		return this.aShow.description() + " introduced by " + this.aSpeaker;
	}
	
	@Override
	public Show copy() {
		return new IntroducedShow(aShow.copy(), aSpeaker, aTime);
	}

}
