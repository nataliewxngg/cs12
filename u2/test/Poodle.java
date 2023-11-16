package u2.test;

public class Poodle extends Dog {

	int poodleID;

	public Poodle(int poodleID, int dogID, int animalID) {
		super(dogID, animalID);
		this.poodleID = poodleID;
	}

	public void blah1() {
		System.out.println("poodleID = " + poodleID);
	}

	public void yo() {
		System.out.println("just testing smt weewoo");
	}

}
