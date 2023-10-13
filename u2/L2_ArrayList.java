package u2;

import java.util.*; // Required for ArrayList

public class L2_ArrayList {
    public static void main(String[] args) {
        // ARRAYS
        // DISADVANTAGE: - Fixed in Size
        // - Requires a method to "edit" the array

        // ARRAYLIST
        // ADVANTAGE: Can grow/shrink in size
        // DISADVANTAGE: Stores OBJECTS ONLY, Slower

        // Initiating ArrayLists
        L1_MsWong1 wong1 = new L1_MsWong1("J", "CS", 25);
        ArrayList<L1_MsWong1> list = new ArrayList<>();
        list.add(wong1);
        list.add(new L1_MsWong1("E"));

        // Return the number of elements in the ArrayList
        System.out.println(list.size()); // 2

        // Getting an object from the list - SHARES SAME ADDRESS
        L1_MsWong1 wong3 = list.get(1); // .get() instead of using []
        System.out.println(wong3);

        wong3.setAge(3); // Changes for BOTH lists since they share the same address
        System.out.println(wong3.getAge()); // 3
        System.out.println(list.get(1).getAge()); // 3

        // Check if list contains a specific element
        System.out.println(list.contains(wong1)); // true
        System.out.println(list.contains(new L1_MsWong1("J", "CS", 25))); // false - .contains searches by address - new
                                                                          // ArrayList = new address
    }
}
