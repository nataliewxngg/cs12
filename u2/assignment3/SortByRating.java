package u2.assignment3;

import java.util.*;

public class SortByRating implements Comparator<Games> {

    // DESCRIPTION: A compare method utilized for the sort-by-rating comparator
    // interface, which sorts an ArrayList of Games Objects by rating in descending
    // order

    public int compare(Games g1, Games g2) { // PARAMETERS: 2 Games objects to compare
        // RETURN: If the rating of the two Games are the name, return 0
        if (g1.getRating() == g2.getRating())
            return 0;

        // RETURN: If the rating of the first game is less than the second, return 1
        // (can be any positive # for the purpose of the comparator)
        else if (g1.getRating() < g2.getRating())
            return 1;

        // RETURN: If the rating of the first game is greater than the second, return -1
        // (can be any negative # for the purpose of the comparator)
        else
            return -1;
    }
}
