package chapter6;

@SuppressWarnings("unused")
public class Client {

	private static final Movie CARVE_UP = new Movie("What a Carve Up!", 1961, 87);
	private static final Movie GIANT_CLAW = new Movie("The Giant Claw", 1957, 75);
	private static final Movie ALLIGATOR = new Movie("The Alligator People", 1959, 74);

	private static final Comedy CHAVEZ = new Comedy("Martha Chaves", "Rebel Without a Pause", 87);

	public static void main(String[] args) {
		CompositeShow someShow = new CompositeShow(CHAVEZ, new CompositeShow(CARVE_UP, GIANT_CLAW));
		System.out.println(someShow.description());

		IntroducedShow introducedFull = new IntroducedShow(someShow, "Me", 10);
		IntroducedShow introducedSecond = new IntroducedShow(GIANT_CLAW, "Mr S", 3);

		IntroducedShow defaultShow = new IntroducedShow(
				new CompositeShow(new IntroducedShow(CHAVEZ, "Ali Hassan", 5), CARVE_UP), "M. R.", 10);
		Program program = new Program();
		program.setDefault(defaultShow);
		program.initialize(Day.MONDAY, Day.WEDNESDAY);
		
		program.clear();
		program.initialize();
		
		System.out.println(program);
		
		program.setDefault(CARVE_UP);
		program.initialize(Day.FRIDAY);
		
		System.out.println(program);
	}

}
