package u1;

import java.util.*;

public class L10_ArrayList {
    public static void main(String[] args) {
        // ARRAYLIST
        // ADVANTAGE: An array that can grow/shrink in size
        // DISADVANTAGE: Stores objects only, slower

        MsWong wong1 = new MsWong("J", "CS", 25);

        ArrayList<MsWong> list = new ArrayList<>();
        list.add(wong1);
        list.add(new MsWong("E"));
    }
}
