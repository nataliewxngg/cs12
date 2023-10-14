package u2;

import java.util.*;

public class L4_SortByFirstName implements Comparator<L1_MsWong1> {
    // Sorts First Name Alphabetically (A-Z)
    public int compare(L1_MsWong1 w1, L1_MsWong1 w2) {
        return w1.getFirstName().compareTo(w2.getFirstName());
    }
}
