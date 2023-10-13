package u2;

import java.util.*;

public class L11_SortByAge implements Comparator<L1_MsWong1> {

    public int compare(L1_MsWong1 w1, L1_MsWong1 w2) { // cannot use .this, must implement 2 parameters
        return w1.getAge() - w2.getAge();
    }

    // In the main:
    // Collections.sort(a list, newSortByAge());
    // This method is overloaded to take in an extra comparator parameter

    // If you have more sorting criteria, make more classes!

}
