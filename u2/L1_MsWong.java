package u2;

public class L1_MsWong {
    public static void main(String[] args) {
        // Initializing objects
        L1_MsWong1 wong1 = new L1_MsWong1("J", "CS", 25);
        L1_MsWong1 wong2 = new L1_MsWong1("E");
        L1_MsWong1 wong3 = new L1_MsWong1("N", "CENG", 41);

        // Data Encapsulation - cannot be accessed

        // WON'T WORK
        // System.out.println(wong1.firstName);
        // System.out.println(wong1.age);

        // Use a getter method
        System.out.println(wong1.getAge()); // wong1 age --> 25+1 = 26

        wong1.birthday();
        System.out.println(wong1.getAge()); // 26
        System.out.println(wong2.getAge()); // will display 0 --> age was not initialized
        System.out.println(wong3.getAge()); // 41

        L1_MsWong1.changeSchools("UW");

        System.out.println(wong1.toString());
        System.out.println(wong2.toString()); // uninitialized variables are null or are values of 0
    }
}
