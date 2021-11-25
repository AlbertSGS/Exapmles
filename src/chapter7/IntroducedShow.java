package chapter7;

public class IntroducedShow extends DecoratedShow {

	private final String aSpeaker;
	private final int aTime;

	public IntroducedShow(Show pShow, String pSpeaker, int pSpeechTime) {
		super(pShow);
		this.aSpeaker = pSpeaker;
		this.aTime = pSpeechTime;
	}

	@Override
	public int time() {
		return super.time() + this.aTime;
	}

	@Override
	public String description() {
		return super.description() + " introduced by " + this.aSpeaker;
	}
}
