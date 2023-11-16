package u2.test;

public class MsWong implements Comparable<MsWong> {
    public int compareTo(MsWong w) {
        return this.age - w.age;
    }

    // In classes
    // Variables = Attributes/States
    // Methods = Behaviors

    // Instance Variables + data encapsulation
    private int age;
    private String subject;
    private String firstName;
    private double height;

    // Static/class Variables + data encapsulation
    private static String school = "mss";

    // Constructor
    public MsWong(String firstName, String subject, int age) {
        this.firstName = firstName;
        this.subject = subject;
        this.age = age;
    }

    public MsWong(String firstName) {
        this.firstName = firstName;
    }

    // Instance methods

    // Getter
    public String getFirstName() {
        return this.firstName;
    }

    // Getter (static)
    public static String getSchool() {
        return school;
    }

    // Setter
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void birthday() {
        this.age++;
    }

    // Setter (static)
    public static void changeSchools(String newSchool) {
        school = newSchool;
    }

    // .toString() method
    public String toString() {
        return this.firstName + " " + this.subject;
    }

    // .equals() method
    // public boolean equals(Object o) {
    // MsWong w = (MsWong) o;

    // return this.firstName.toLowerCase().equals(w.firstName.toLowerCase());
    // }
}
