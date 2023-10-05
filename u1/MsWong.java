package u1;

public class MsWong {

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

}
