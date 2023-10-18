package u2.review;

import java.util.*; // MUST BE IMPORTED for ArrayList

public class L2_ArrayList {
    public static void main(String[] args) {
        // Arrays:
        // ADVANTAGE: Faster than ArrayLists
        // DISADVANTAGE: Fixed in size

        // ArrayLists:
        // ADVANTAGE: Variable in size - can grow/shrink in size
        // DISADVANTAGE: ONLY STORES OBJECTS, Slower than ArrayLists

        // CREATING ARRAYLISTS.................
        ArrayList<Games> list = new ArrayList<>();
        list.add(new Games(9.98, "Valorant", "FPS"));
        Games mc = new Games(7.81, "Minecraft", "Adventure");
        list.add(mc);

        // FIND # OF ELEMENTS....................
        System.out.println(list.size()); // 2

        // GET OBJECT FROM LIST
        System.out.println(list.get(1)); // DISPLAYS MINECRAFT'S INFO

        // CHECKS IF CONTAINS OBJECT
        System.out.println(list.contains(mc)); // true
        System.out.println(list.contains(new Games(9.98, "Valorant", "FPS"))); // true <-- equals() exist;
                                                                               // false otherwise

        // FIND INDEX OF AN OBJECT
        System.out.println(list.indexOf(mc)); // 1
        System.out.println(list.indexOf(new Games(9.98, "Valorant", "FPS"))); // 0 <-- equals() exist;
                                                                              // -1 otherwise

        // QUESTION 1:
        // HOW CAN YOU ALTER THE "contains" AND "indexOf" FUNCTIONS, TO SEARCH FOR AN
        // ELEMENT THAT LOOKS THE SAME BUT IS NOT THE SAME OBJECT?

        // answer in Games.java

        // QUESTION 2: What will this output?
        ArrayList<MsWong> MsWongList = new ArrayList<>();
        MsWong wong = new MsWong("J", "CS", 25);
        MsWongList.add(wong);
        MsWongList.add(new MsWong("E"));

        ArrayList<MsWong> newList = MsWongList;
        newList.remove(0);

        System.out.println(MsWongList.get(0)); // MsWong("E")
        System.out.println(newList.get(0)); // MsWong("E")

        // TO PASS BY VALUE INSTEAD OF PASS BY REFERENCE:
        ArrayList<MsWong> passByVal = new ArrayList<>(MsWongList);
    }
}
