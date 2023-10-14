package u2;

import java.util.*;

public class L4_SortByAge implements Comparator<L1_MsWong1> {
    public int compare(L1_MsWong1 w1, L1_MsWong1 w2) {
        return w1.getAge() - w2.getAge(); // must .getAge since you are no longer in the same class
    }
}
