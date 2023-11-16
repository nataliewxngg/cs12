package u2.test;

import java.util.*;

public class SortByName implements Comparator<MsWong> {
    public int compare(MsWong w1, MsWong w2) {
        return w1.getFirstName().toLowerCase().compareTo(w2.getFirstName().toLowerCase());
    }
}
