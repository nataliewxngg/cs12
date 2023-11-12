package u2.assignment4;

import java.util.*;

// DESCRIPTION: A compare method utilized for the sort-by-HP comparator
// interface, which sorts an ArrayList of Card Objects by HP, in ascending order

public class SortCardsByHP implements Comparator<Card> {
    public int compare(Card c1, Card c2) { // PARAMETERS: 2 Card objects to compare
        return c1.getHP() - c2.getHP();
        // RETURNS:
        // if c1.HP < c2.HP --> RETURNS A NEGATIVE #
        // if c1.HP == c2.HP --> RETURNS 0
        // if c1.HP > c2.HP --> RETURNS A POSITIVE #
    }
}
