package u2.test;

public class Dog extends Animal {
	int dogID;

	public Dog(int dogID, int animalID) {
		super(animalID);
		this.dogID = dogID;
	}

	public void blah1() {
		System.out.println("dogID = " + dogID);
		// blah2 ();
	}

	public void blah2() {
		System.out.println("dogID = " + dogID);
	}

	public void yo() {
		System.out.println("just testing smt");
	}

}
