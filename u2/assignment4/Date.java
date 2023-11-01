package u2.assignment4;

import java.util.StringTokenizer;
// Necessary instance and static variables declared (can ADD more variables later)
// Constructor (can be cahnged later)

public class Date {
    // Variables
    private int month;
    private int date;
    private int year;

    // Constructor
    public Date(String date) { // MM/DD/YYYY
        StringTokenizer st = new StringTokenizer(date, "/");

        this.month = Integer.parseInt(st.nextToken());
        this.date = Integer.parseInt(st.nextToken());
        this.year = Integer.parseInt(st.nextToken());
    }

    // Getters + Setters
    public String toString() {
        return Integer.toString(this.month) + "/" + Integer.toString(this.date) + "/" + Integer.toString(this.year);
    }

    // valid() - to check if a date is a valid date
    public boolean valid() {
        // check year
        // check month
        // check date
    }
}
