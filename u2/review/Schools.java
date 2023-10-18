package u2.review;

public class Schools {
    // In a CUSTOM CLASS like this one,
    // Variables --> Attribute/State
    // Methods --> Behavior

    // -------------------------------------------

    // Instance Variables
    // - States associated with an INSTANCE OBJECT
    // - Each instance object has its OWN COPY
    // - Accessible only to instance objects
    double rating;
    private String name; // Data Encapsulation
    private int capacity; // Data Encapsulation

    // Static Variables
    // - States associated with THE CLASS
    // - ONLY HAS 1 COPY
    private static String country = "Canada";

    // DATA ENCAPSULATION:
    // - hiding of internal data
    // - makes a variable accessible only to its PARENT/HOME class
    // - requires getter/setter methods to access/modify their contents

    // ------------------------------------------

    // Instance methods
    // - A behavior associated with an INSTANCE OBJECT
    // - Can access BOTH INSTANCE AND CLASS variables
    // - MUST be called with instance object
    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public static String getCountry() {
        return country;
    }

    public void newName(String newName) {
        this.name = newName;
    }

    public void newStudent() {
        this.capacity++;
    }

    // Static/Class methods
    // - Can ONLY access class variables
    // - Can be called with instance object OR class
    public static void countryNameChange(String newCountryName) {
        country = newCountryName;
    }

    // Constructor - special method automatically when creating a new object
    // - CAN OVERLOAD!!!!!!!!!!!! :):):)
    // - Initializes the instance variables
    // - NO RETURN TYPE
    // - SAME NAME AS CLASS
    public Schools(double rating, String name, int capacity) {
        this.rating = rating;
        this.name = name;
        this.capacity = capacity;
    }

    public Schools(double rating, String name, int capacity, String country) {
        this.rating = rating;
        this.name = name;
        this.capacity = capacity;

        this.country = country;
        // OR
        // Schools.country = country;
    }

    public Schools(String name) {
        this.name = name;
    }

    // PRINTING OBJECTS
    // - automatically calls the method .toString(), which will display its memory
    // address location
    // - can modify what it displays by writing your own .toString() method
    public String toString() {
        return "Ew " + this.name + " is such a bad school. It only has a rating of " + this.rating + " and has "
                + this.capacity + " students lol sucks to suck";
    }
}
