package u2.assignment4;

import java.util.StringTokenizer;
// Necessary instance and static variables declared (can ADD more variables later)
// Constructor (can be cahnged later)

public class Date {
    // Variables
    private String month;
    private String date;
    private String year;

    // Constructor
    public Date(String date) { // MM/DD/YYYY
        StringTokenizer st = new StringTokenizer(date, "/");

        this.month = st.nextToken();
        this.date = st.nextToken();
        this.year = st.nextToken();
    }

    // Getters + Setters
    public String toString() {
        return this.month + "/" + this.date + "/" + this.year;
    }

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
}
