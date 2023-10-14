package u2;

import java.util.*;

public class what {
    public static void main(String[] args) {
        ArrayList<L1_MsWong1> wong = new ArrayList<>();
        wong.add(new L1_MsWong1("E", "CS", 25));
        wong.add(new L1_MsWong1("J", "ENG", 15));
        wong.add(new L1_MsWong1("A", "jobless", 50));

        Collections.sort(wong, new L4_SortByFirstName());
        System.out
                .println(Collections.binarySearch(wong, new L1_MsWong1("E"),
                        new L4_SortByFirstName())); // {A,E,J} --> 1
    }
}