package u2.assignment3;

public class Games implements Comparable<Games> {

    // DESCRIPTION:
    // Used to compare between the names of two 'Games' objects lexicographically
    // and case insensitively
    // (GAME1.compareTo(GAME2))

    // It is moreover a method utilized for the Comparable Interface - NATURAL
    // SORTING ORDER
    // When called (Collections.sort(ARRAYLIST)), it allows the comparable interface
    // to sort an ArrayList of 'Games' objects in alphabetical order of their
    // names, lexicographically and case insensitively

    public int compareTo(Games game) { // PARAMETER: A Games object to compare to
        return this.name.toLowerCase().compareTo(game.name.toLowerCase());
        // RETURN:
        // let the variables be g1 and g2 in g1.compareTo(g2)
        // IF g1 < g2 --> RETURN A NEGATIVE #
        // IF g1 == g2 --> RETURN 0
        // IF g1 > g2 --> RETURN A POSITIVE #
    }

    // Instance Variables + Data Encapsulation
    private String name;
    private double rating;
    private String type;

    // DESCRIPTION: Getter methods - allows the files utilizing Games
    // objects to access its private attributes
    public String getName() {
        return this.name;
    }

    public double getRating() {
        return this.rating;
    }

    public String getType() {
        return this.type;
    }

    // DESCRIPTION: The CONSTRUCTOR method - utilized to create new Games objects
    // and to initialize each object's instance variables
    public Games(double rating, String name, String type) { // PARAMETER: The rating, name, and type intended to be
                                                            // initialized with for the new Games object

        // Initializes the instance variables of the new Games object!
        this.rating = rating;
        this.name = name;
        this.type = type;

        // RETURNS: none
    }

    // DESCRIPTION: .toString() is called whenever a Games object is to be printed
    // By default, it will print the address location of the Games object in the
    // computer.
    // However, by writing the .toString() method like so ourselves,
    // it allows us to change what is to be displayed instead.

    // Likewise, this method will allow us to display the name, type, and rating of
    // a Games object instead of its address location
    public String toString() { // PARAMETER: none
        return "\nName: " + this.name + "\nType: " + this.type + "\nRating: " + this.rating + "\n"; // RETURNS: A
                                                                                                    // labelled and
                                                                                                    // neatly
                                                                                                    // constructed
                                                                                                    // String of the
                                                                                                    // name, type, and
                                                                                                    // rating of a Games
                                                                                                    // object
    }
}
