package chapter4;

public class Player {

	private Hand aHand;
	private String aName;
	private static final int CHANGE_LIMIT = 1;
	private int timeChanged = 0;

	public Player(String pName) {
		this.aHand = new Hand();
		this.aName = pName;
	}

	public Hand getHand() {
		return new Hand(this.aHand);
	}

	public String getName() {
		return this.aName;
	}

	public void draw(Card pCard) {
		assert pCard != null;
		
		this.aHand.addCard(pCard);
	}
	
	public void changeCard(Card pCard) {
		assert pCard != null;
		
		if(timeChanged == CHANGE_LIMIT) {
			System.out.println("Failed to change card; limit reached.");
		}
	}

}
