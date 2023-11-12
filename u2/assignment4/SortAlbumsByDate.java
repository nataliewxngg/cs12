package u2.assignment4;

import java.util.*;

public class SortAlbumsByDate implements Comparator<Album> {

    // DESCRIPTION: A compare method utilized for the sort-by-date comparator
    // interface, which sorts an ArrayList of Album Objects by date in the manner of
    // oldest to newest.

    public int compare(Album a1, Album a2) { // PARAMETERS: 2 Album objects to compare

        // RETURNS:

        // SCENARIO 1:
        // If a1.year == a2.year and a1.month == a2.month:
        // if a1.date < a2.date --> RETURNS A NEGATIVE #
        // if a1.date == a2.date --> RETURNS 0
        // if a1.date > a2.date --> RETURNS A POSITIVE #

        // SCENARIO 2:
        // If a1.year == a2.year only
        // if a1.month < a2.month --> RETURNS A NEGATIVE #
        // if a1.month == a2.month --> RETURNS 0
        // if a1.month > a2.month --> RETURNS A POSITIVE #

        // SCENARIO 3:
        // If a1.year < a2.year --> RETURNS A NEGATIVE #
        // If a1.year > a2.year --> RETURNS A POSITIVE #

        if (a1.getDate().getYear() == a2.getDate().getYear()) {
            if (a1.getDate().getMonth() == a2.getDate().getMonth()) {
                return a1.getDate().getDate() - a2.getDate().getDate();
            } else {
                return a1.getDate().getMonth() - a2.getDate().getMonth();
            }
        } else {
            return a1.getDate().getYear() - a2.getDate().getYear();
        }
    }
}
