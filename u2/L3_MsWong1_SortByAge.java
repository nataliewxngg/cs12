package u2;

public class L3_MsWong1_SortByAge implements Comparable<L3_MsWong1_SortByAge> {

    // Comparable Interface
    public int compareTo(L3_MsWong1_SortByAge w) {
        // wong1.compareTo(wong2) --> returns <0 if wong1<wong2
        // returns 0 if wong1==wong2
        // returns >0 if wong1>wong2

        // Sort by age
        if (this.age < w.age)
            return -1;
        else if (this.age > w.age)
            return 1;
        else
            return 0;

        // OR

        // return (this.age-w.age) // ASCENDING ORDER
        // return (w.age - this.age) // DESCENDING ORDER
    }

    // instance variables
    private int age; // Data encapsulation - hiding of the internal data - only accessible to current
                     // class (MsWong)
                     // - accessible with getter/setter methods
    private String subject;
    private String firstName;
    private double height;

    // static/class variables
    private static String school = "MSS";

    // Constructor - initialzies instance variables
    // - NO return type
    // - same name as class name
    // - can overload
    public L3_MsWong1_SortByAge(String firstName, String subject, int age) {
        this.firstName = firstName;
        this.subject = subject;
        this.age = age;
    }

    public L3_MsWong1_SortByAge(String firstName) { // Overloaded constructor
        this.firstName = firstName;
    }

    // Instance Methods - MUST be called with an instance object (eg.
    // wong1.getAge())
    // Getter and Setter - for data encapsulated variables
    public int getAge() {
        return age;
    }

    public void birthday() {
        age++;
    }

    public String getSubject() {
        return subject;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void changeSubject(String subject) {
        this.subject = subject;
    }

    // Static Method - Can be called with an instance object or with the class name
    // (eg. wong1.changeSchools("UW") OR MsWong.changeSchools("UW"))
    public static void changeSchools(String newSchool) {
        school = newSchool;
    }

    // Originally, printing an object will print the object's address
    // This will allow the information of the MsWong object to be displayed instead
    public String toString() {
        return String.format("%nName: %s%nSubject: %s%nAge: %d%nHeight: %f%n", firstName, subject, age, height);
    }

    // Checks if a MsWong object has the same name as another MsWong object
    public boolean sameName(L3_MsWong1_SortByAge o) {
        // L1_MsWong1 wong = (L1_MsWong1) o; // if parameter was Object o instead
        L3_MsWong1_SortByAge wong = o;

        return (this.getFirstName().equals(wong.getFirstName()));
    }

}
