package chapter7;

@SuppressWarnings("unused")
public class Client {

	private static final Movie CARVE_UP = new Movie("What a Carve Up!", 1961, 87);
	private static final Movie GIANT_CLAW = new Movie("The Giant Claw", 1957, 75);
	private static final Movie ALLIGATOR = new Movie("The Alligator People", 1959, 74);

	private static final Comedy CHAVEZ = new Comedy("Martha Chaves", "Rebel Without a Pause", 87);

	public static void main(String[] args) {
		Comedy comedy = new SponsoredComedy("Martha", "Whoa", 32, "Me", 4);
		IntroducedShow show = new IntroducedShow(comedy, "Ali", 5);
		
		System.out.print(show.description());
	}

}
