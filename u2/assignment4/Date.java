package u2.assignment4;

import java.util.*;

public class Date {

    // Instance Variables + Data Encapsulation
    private String month;
    private String date;
    private String year;

    // DESCRIPTION: The CONSTRUCTOR method - utilized to create new Date objects
    // and to initialize each object's instance variables
    public Date(String date) { // PARAMETERS: A date, in string format, in the form of MM/DD/YYYY
        StringTokenizer st = new StringTokenizer(date, "/");

        // Initializes the instance variables of the new Date object!
        this.month = st.nextToken();
        this.date = st.nextToken();
        this.year = st.nextToken();

        // RETURNS: none (constructors do not return any value)
    }

    // DESCRIPTION: Getter methods - allows the files utilizing Date objects to
    // access its private attributes
    // PARAMETERS: none
    // RETURNS: dependent on each attribute's data type - all int in this case
    public int getMonth() {
        return Integer.parseInt(this.month);
    }

    public int getDate() {
        return Integer.parseInt(this.date);
    }

    public int getYear() {
        return Integer.parseInt(this.year);
    }

    // DESCRIPTION: Utilized to check if a date is valid/realistic
    public boolean valid() { // PARAMETERS: none
        int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int year = Integer.parseInt(this.year);
        int month = Integer.parseInt(this.month);
        int date = Integer.parseInt(this.date);

        // RETURNS:
        // If the year of the date is valid (1000-2023 inclusively),
        // if the month of the date is valid (1-12 inclusively),
        // and if the date of the date is valid (dependent on the days int[] array),
        // return true
        // Otherwise, return false
        if (year >= 1000 && year <= 2023) {
            if (month >= 1 && month <= 12) {
                if (date >= 1 && date <= days[month - 1]) {
                    return true;
                }
            }
        }
        return false;
    }

    // DESCRIPTION: .toString() is called whenever a Date object is to be printed
    // By default, it will print the address location of the Date object in the
    // computer.
    // However, by overriding (writing) the .toString() method like so ourselves,
    // it allows us to change what is to be displayed instead.

    // Likewise, this method will allow us to display the Date object in a string
    // format instead.
    public String toString() {
        return this.month + "/" + this.date + "/" + this.year;
    }
}
