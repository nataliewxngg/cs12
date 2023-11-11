package u2.assignment4;

import java.util.*;

public class SortCardsByHP implements Comparator<Card> {
    public int compare(Card c1, Card c2) {
        return c1.getHP() - c2.getHP();
    }
}
