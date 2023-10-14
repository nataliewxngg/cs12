package u2.assignment1;

public class Games {

    // Instance Variables
    double rating;
    String name;
    String type;

    // Constructor
    public Games(double rating, String name, String type) {
        this.rating = rating;
        this.name = name;
        this.type = type;
    }

    // .toString() Method
    public String toString() {
        return "\nName: " + this.name + "\nType: " + this.type + "\nRating: " + this.rating + "\n";
    }
}
