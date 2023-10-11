package u1;

import java.util.*;

public class L11_SortByAge implements Comparator<MsWong> {

    public int compare(MsWong w1, MsWong w2) { // cannot use .this, must implement 2 parameters
        return w1.getAge() - w2.getAge();
    }

    // In the main:
    // Collections.sort(a list, newSortByAge());
    // This method is overloaded to take in an extra comparator parameter

    // If you have more sorting criteria, make more classes!

}
