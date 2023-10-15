package u2.assignment1;

public class Games implements Comparable<Games> {

    // Natural sorting order - sort game names alphabetically and case insensitively
    public int compareTo(Games game) {
        return this.name.toLowerCase().compareTo(game.name.toLowerCase());
    }

    // Instance Variables
    String name;
    double rating;
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
