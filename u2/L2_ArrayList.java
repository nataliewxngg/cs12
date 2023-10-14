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
        System.out.println(list.contains(wong3)); // true - shares the same address as list.get(1)

        // Return the index of a specific element in the ArrayList
        System.out.println(list.indexOf(wong1)); // 0
        System.out.println(list.indexOf(new L1_MsWong1("J", "CS", 25))); // -1 - returns -1 if the address of the new
                                                                         // MsWong object is not found in the ArrayList
        System.out.println(list.indexOf(wong3)); // 1 - shares same address as list.get(1)

        // ----------------

        // Question #1
        // Checks if two L1_MsWong1 objects have the same firstName
        System.out.println(list.get(0).equals(new L1_MsWong1("J", "CS", 25))); // false
        // BY DEFAULT, .EQUALS() CHECKS FOR THE
        // SAME ADDRESS
        System.out.println(list.get(0).sameName(new L1_MsWong1("J"))); // True

        // ----------------

        // Question #2
        // What is the output? What happens
        ArrayList<L1_MsWong1> newList = list; // PASS BY REFERENCE - list = newList = {{"E","CS",25},{"E"}}
        newList.remove(0); // list = newList = {{"E"}}

        // Both of these will print the L1_MsWong1 object with the first name as E only
        System.out.println(list.get(0));
        System.out.println(newList.get(0));

        // HOW TO AVOID PASS BY REFERENCE IN ARRAYLIST, BUT MAKE A DUPLICATE OF ANOTHER
        // ARRAYLIST
        // IN OTHER WORDS,
        // HOW TO PASS AN ARRAYLIST BY VALUE INSTEAD?
        ArrayList<L1_MsWong1> NEWNEWLIST = new ArrayList<>(list); // copies ALL the elements from list into NEWNEWLIST
    }
}
