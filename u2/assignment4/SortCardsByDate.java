package u2.assignment4;

import java.util.*;

// DESCRIPTION: A compare method utilized for the sort-by-date comparator
// interface, which sorts an ArrayList of Card Objects by date in the manner of
// oldest to newest.

public class SortCardsByDate implements Comparator<Card> { // PARAMETERS: 2 Card objects to compare
    public int compare(Card c1, Card c2) {

        // RETURN:

        // SCENARIO 1:
        // If c1.year == c2.year and c1.month == c2.month:
        // if c1.date < c2.date --> RETURNS A NEGATIVE #
        // if c1.date == c2.date --> RETURNS 0
        // if c1.date > c2.date --> RETURNS A POSITIVE #

        // SCENARIO 2:
        // If c1.year == c2.year only
        // if c1.month < c2.month --> RETURNS A NEGATIVE #
        // if c1.month == c2.month --> RETURNS 0
        // if c1.month > c2.month --> RETURNS A POSITIVE #

        // SCENARIO 3:
        // If c1.year < c2.year --> RETURNS A NEGATIVE #
        // If c1.year > c2.year --> RETURNS A POSITIVE #

        if (c1.getDate().getYear() == c2.getDate().getYear()) {
            if (c1.getDate().getMonth() == c2.getDate().getMonth()) {
                return c1.getDate().getDate() - c2.getDate().getDate();
            } else {
                return c1.getDate().getMonth() - c2.getDate().getMonth();
            }
        } else {
            return c1.getDate().getYear() - c2.getDate().getYear();
        }
    }
}
