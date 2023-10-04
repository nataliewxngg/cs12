package u1;

public class L8_Pigeon {

    // Instance Variables
    String name;
    int age;
    String color;
    double wingspan;

    // Static Variables
    static String address;
    static int numOfPigeons = 0;

    // Instance Methods
    public void birthday() {
        age++;
    }

    public void changeColor(String color) {
        this.color = color;
    }

    // Static/Class Methods
    public static void incPigeon() {
        numOfPigeons++;
    }

}
