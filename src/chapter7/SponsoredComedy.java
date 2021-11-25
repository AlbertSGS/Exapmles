package chapter7;

public class SponsoredComedy extends Comedy {

	private String aSponsor;
	private int aSponsorTime;

	public SponsoredComedy(String pComedian, String pTitle, int pTime, String pSponsor, int pSponsorTime) {
		super(pComedian, pTitle, pTime);
		this.aSponsor = pSponsor;
		this.aSponsorTime = pSponsorTime;
	}
	
	@Override
	public int time() {
		return super.time() + this.aSponsorTime;
	}
	
	public String getSponsor() {
		return this.aSponsor;
	}
	
	@Override
	protected String extraInfo() {
		return String.format("%s sponsored by %s", super.extraInfo(), aSponsor);
	}

}
