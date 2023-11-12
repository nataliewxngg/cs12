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

        this.month = st.nextToken();
        this.date = st.nextToken();
        this.year = st.nextToken();
    }

    // Getters + Setters
    public int getMonth() {
        return Integer.parseInt(this.month);
    }

    public int getDate() {
        return Integer.parseInt(this.date);
    }

    public int getYear() {
        return Integer.parseInt(this.year);
    }

    // valid() - to check if a date is a valid date
    public boolean valid() {
        int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int year = Integer.parseInt(this.year);
        int month = Integer.parseInt(this.month);
        int date = Integer.parseInt(this.date);

        if (year >= 1000 && year <= 2023) { // year: 1000-2023
            if (month >= 1 && month <= 12) { // month: 1-12
                if (date >= 1 && date <= days[month - 1]) {
                    return true;
                }
            }
        }
        return false;
    }

    // toString() - for display
    public String toString() {
        return this.month + "/" + this.date + "/" + this.year;
    }
}
