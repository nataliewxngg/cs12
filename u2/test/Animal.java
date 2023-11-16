
public class Animal {
	int animalID;
	
	public Animal (int animalID) {
		this.animalID = animalID;
	}
	
	public void blah1 () {
		System.out.println("Animal ID" + animalID);
	}
	
	public void blah2 () {
		System.out.println("Animal ID" + animalID);
	}
	
	public void blah3 () {
		System.out.println("Animal ID" + animalID);
		blah1();
	}
}
