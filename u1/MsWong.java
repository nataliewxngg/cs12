package u1;

public class MsWong implements Comparable<MsWong> {

    // instance variables
    private int age; // Data encapsulation - hiding of the internal data - only accessible to current
                     // class (MsWong)
                     // - accessible with getter/setter methods
    String subject;
    String firstName;
    double height;

    // static/class variables
    static String school;

    // instance method
    public void birthday() {
        age++;
    }

    public void changeSubject(String subject) {
        this.subject = subject;
    }

    // static method
    public static void changeSchools(String newSchool) {
        // age = 2;
        school = newSchool;
    }

    // getter and setter
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Constructor - initialzies instance variables
    // - NO return type
    // - same name as class name
    // - can overload
    public MsWong(String firstName, String subject, int age) {
        this.firstName = firstName;
        this.subject = subject;
        this.age = age;
    }

    // Originally, printing an object will print the object's address
    public String toString() {
        return String.format("Name: %s%nSubject: %s%nAge: %d%nHeight: %f%n%n", firstName, subject, age, height);
    }

    // natural sorting order
    public int compareTo(MsWong w) {
        // sort by age
        if (this.age < w.age)
            return -1;
        else if (this.age == w.age)
            return 0;
        return 1;
    }

}
