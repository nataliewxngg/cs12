package u2.assignment1;

import java.util.*;

public class SortByRating implements Comparator<Games> {

    // DESCRIPTION: A compare method utilized for the comparator interface, which
    // sorts an ArrayList of Games Objects by rating, in ascending order
    public int compare(Games g1, Games g2) { // PARAMETERS: 2 Games objects
        if (g1.rating == g2.rating)
            return 0;
        else if (g1.rating < g2.rating)
            return -1;
        else
            return 1;
    }
}
