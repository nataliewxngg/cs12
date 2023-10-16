package u2.assignment1;

import java.util.*;

public class SortByType implements Comparator<Games> {

    // DESCRIPTION: A compare method utilized for the sort-by-type comparator
    // interface, which sorts an ArrayList of Games Objects by type, in alphabetical
    // order case insensitively (ie. A - D - d - E - etc.)

    public int compare(Games g1, Games g2) { // PARAMETERS: 2 Games objects to compare

        // RETURN:
        // - Return a negative # if g1's type is < g2's (case insensitive,
        // lexicrographically)
        // - Return 0 if g1's type is the same as g2's (case insensitive,
        // lexicographically)
        // - Return a positive # if g1's type is > g2's (case insensitive,
        // lexicographically)

        return g1.getType().toLowerCase().compareTo(g2.getType().toLowerCase());
    }
}
