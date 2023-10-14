package u2;

import java.util.*;

public class L3_ComparableInterface {

    // IMPORTANT NOTE:
    // YOU CANNOT PRINT OUT .SORT - SORT IT FIRST, THEN PRINT THE ARRAY(LIST)

    public static void main(String[] args) {
        // QUESTION #1: How can you sort an array of integers?
        // ANSWER: Arrays.sort(list);
        // eg.
        int[] intArr = { 1, 5, 2, 3, 7, 9, 2 };
        Arrays.sort(intArr); // Arrays is a class, and .sort is a static/class method

        for (int i = 0; i < intArr.length; i++) {
            if (i != 0)
                System.out.print(", ");
            System.out.print(intArr[i]);
        }
        System.out.println();

        // QUESTION #2: What if it is an ArrayList of integers?
        // ANSWER: Collections.sort(aList);
        // eg.
        ArrayList<Integer> intArrList = new ArrayList<>(Arrays.asList(1, 5, 2, 3, 7, 9, 2));
        Collections.sort(intArrList);
        System.out.println(intArrList);

        // QUESTION #3: What if it is an array/ArrayList of objects such as L1_MsWong1
        // objects?
        // ANSWER: "Implement" the COMPARABLE INTERFACE by writing the "compareTo"
        // method!

        // Interface
        // - a special type of class
        // - does not contain any instance variables
        // - allowed to have static or constant (final) variables
        // - can only contain EMPTY methods (method headers without bodies)

        // Implement an interface
        // - fill in ALL the empty methods with bodies

        // COMPARABLE INTERFACE
        // - Used to compare a single element in an object
        // - Existing interface
        // contains one empty method - "compareTo"

        // eg1. set MsWong ArrayList by age
        ArrayList<L3_MsWong1_SortByAge> list = new ArrayList<>();
        list.add(new L3_MsWong1_SortByAge("E", "CS", 25));
        list.add(new L3_MsWong1_SortByAge("J", "ENG", 3));
        list.add(new L3_MsWong1_SortByAge("N", "CENG", 17));

        System.out.println("");

        // PRINT CURRENTLY UNSORTED ARRAY (BY AGE)
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i).getAge());
        System.out.println("");

        Collections.sort(list); // sorts the list using the comparable interface in the class
        // PRINT CURRENTLY SORTED ARRAY (BY AGE)
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i).getAge());

        // eg2. set MsWong ArrayList by firstName
        ArrayList<L3_MsWong1_SortByFirstName> list1 = new ArrayList<>();
        list1.add(new L3_MsWong1_SortByFirstName("J", "CS", 25));
        list1.add(new L3_MsWong1_SortByFirstName("E", "ENG", 3));
        list1.add(new L3_MsWong1_SortByFirstName("A", "CENG", 17));

        System.out.println("");

        // PRINT CURRENTLY UNSORTED ARRAY (BY FIRST NAME)
        for (int i = 0; i < list1.size(); i++)
            System.out.println(list1.get(i).getFirstName());
        System.out.println("");

        Collections.sort(list1); // sorts the list using the comparable interface in the class
        // PRINT CURRENTLY SORTED ARRAY (BY FIRST NAME)
        for (int i = 0; i < list1.size(); i++)
            System.out.println(list1.get(i).getFirstName());

        // ******** AS A RULE OF THUMB,
        // ASCENDING ORDER --> THIS. COMPARESTO PARAMETER
        // DESCENDING ORDER --> PARAMETER COMPARESTO THIS.

        System.out.println("");

        // QUESTION #4: How do I take a sorted list and find an element from it?
        // ANSWER: Use binary search!

        // For arrays: Arrays.binarySearch(list, elementToFind);
        // eg.
        // int[] intArr = { 1, 5, 2, 3, 7, 9, 2 };
        // sorted --> {1, 2, 2, 3, 5, 7, 9}
        // Arrays.sort(intArr);
        System.out.println(Arrays.binarySearch(intArr, 3));

        // For ArrayList: Collections.binarySearch(aList, elementToFind)
        // eg.
        // ArrayList<L3_MsWong1_SortByAge> list = new ArrayList<>();
        // list.add(new L3_MsWong1_SortByAge("E", "CS", 25));
        // list.add(new L3_MsWong1_SortByAge("J", "ENG", 3));
        // list.add(new L3_MsWong1_SortByAge("N", "CENG", 17));

        // Collections.sort(list);

        // unsorted ages --> {25,3,17}
        // sorted ages --> {3,17,25}
        L3_MsWong1_SortByAge wong = new L3_MsWong1_SortByAge("J", "CS", 25);

        System.out.println(Collections.binarySearch(list, wong)); // returns index of the L3_MsWong1_SortByAge object
                                                                  // with the same age, when sorted
                                                                  // - Collections.binarySearch() returns -1 if cannot
                                                                  // found
                                                                  // - Only returns one of them if there are duplicates
                                                                  // - Only works with sorted list (ASCENDING OR
                                                                  // DESCENDING BOTH WORKS)

        // EXAMPLES WITH UNSORTED LIST
        ArrayList<L3_MsWong1_SortByAge> list2 = new ArrayList<>(Arrays.asList(
                new L3_MsWong1_SortByAge("J", "CS", 25), new L3_MsWong1_SortByAge("N", "CENG", 17),
                new L3_MsWong1_SortByAge("G", "RETIRED", 92)));

        // current ages --> {25,17,92}
        for (int i = 0; i < list2.size(); i++)
            System.out.println(list2.get(i).getAge());
        System.out.println("");

        System.out.println(Collections.binarySearch(list2, new L3_MsWong1_SortByAge("J", "WKEJFLKJ", 17))); // 1 -->
                                                                                                            // current
                                                                                                            // position
                                                                                                            // in
                                                                                                            // UNSORTED
                                                                                                            // list
        System.out.println(Collections.binarySearch(list2, new L3_MsWong1_SortByAge("L", "CHEMENG", 18))); // neg # -->
                                                                                                           // not
                                                                                                           // found

    }
}
