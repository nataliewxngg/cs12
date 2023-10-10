package u1;

public class MsWong implements Comparable<MsWong> {

    // instance variables
    int age;
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
        school = newSchool;
    }

    // Constructor
    public MsWong(String firstName, String subject) {
        this.firstName = firstName;
        this.subject = subject;
    }

    public int compareTo(MsWong w) {
        if (this.age < w.age)
            return -1;
        else if (this.age == w.age)
            return 0;
        return 1;
    }

}
