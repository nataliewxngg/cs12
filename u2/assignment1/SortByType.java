package u2.assignment1;

import java.util.*;

public class SortByType implements Comparator<Games> {
    public int compare(Games g1, Games g2) {
        return g1.type.toLowerCase().compareTo(g2.type.toLowerCase());
    }
}
