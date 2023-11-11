package u2.assignment4;

import java.util.*;

public class SortCardsByDate implements Comparator<Card> {
    public int compare(Card c1, Card c2) {
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
