package u2.review;

public class L1_OOPIntro {
    public static void main(String[] args) {

        // Instance variables, constructor, getter and setters
        Schools markville = new Schools(1.1, "Markville Secondary School", 20);
        Schools ssgps = new Schools(10.99, "St. Stephen's Girls' Primary School", 10000000);
        Schools ups = new Schools(0.1, "Unionville Public School", 1);

        System.out.println("\n" + ups + "\n");
        System.out.println(markville + "\n");

        System.out.println(markville.rating); // 1.1

        ssgps.newStudent();
        System.out.println(ssgps.getCapacity()); // 10000001

        System.out.println(ups.getName()); // Unionville Public School

        // Static/class methods
        System.out.println(markville.getCountry()); // Canada
        Schools.countryNameChange("Conodo");
        System.out.println(Schools.getCountry()); // Conodo
        System.out.println(markville.getCountry()); // Conodo

        // Overloaded constructor
        Schools newSchool = new Schools("STILL IN CONSTRUCTION School");
        System.out.println("\n" + newSchool + "\n");
    }
}
