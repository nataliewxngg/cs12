package u2.assignment1;

import java.util.*;

public class SortByRating implements Comparator<Games> {
    public int compare(Games g1, Games g2) {
        if (g1.rating == g2.rating)
            return 0;
        else if (g1.rating < g2.rating)
            return -1;
        else
            return 1;
    }
}
