package u2;

import java.util.*;

public class L4_ComparatorInterface {
    public static void main(String[] args) {// Comparator

        // IMPORTANT NOTE
        // YOU MUST INCLUDE IMPORT JAVA.UTIL.*; IN ALL COMPARATOR CLASSES

        // QUESTION #1: How do I sort a list of objects with different sorting
        // criterias?
        // ANSWER: You have to "implement" the "Comparator interface" by writing the
        // "compare" method

        // QUESTION #2: What if I want to sort/search by a 3rd or 4th or ... criteria?
        // ANSWER: Create a new class for every sorting criteria that implements
        // Comparator

        // format:
        // Collections.sort(aList, new Comparator())

        ArrayList<L1_MsWong1> wong = new ArrayList<>(Arrays.asList(
                new L1_MsWong1("J", "CS", 25), new L1_MsWong1("N", "COMPENG", 17), new L1_MsWong1("A", "TEACHER", 50)));

        System.out.println(wong);

        // Sort by Age
        Collections.sort(wong, new L4_SortByAge()); // OVERLOADED .sort() method, to take in an extra COMPARATOR
                                                    // parameter
        System.out.println(wong);

        // BINARYSEARCH FOR COMPARATORS REQUIRE A THIRD PARAMETER (FOR COMPARATOR) SO
        // THEY KNOW WHAT TO ATTRIBUTE SEARCH FOR
        // eg. if you are finding a MsWong with a first name of J, indicate the
        // comparator sortByFirstName in the parameter so that java will compare the
        // first name fields instead of, for eg. the age fields
        System.out.println(Collections.binarySearch(wong, new L1_MsWong1("J", "CS", 25), new L4_SortByAge())); // {17,25,50}
                                                                                                               // --> 1

        Collections.sort(wong, new L4_SortByFirstName());
        System.out
                .println(Collections.binarySearch(wong, new L1_MsWong1("P", "IEWJOIJ", 30), new L4_SortByFirstName())); // {A,J,N}
                                                                                                                        // -->
                                                                                                                        // neg
                                                                                                                        // #
        System.out.println(Collections.binarySearch(wong, new L1_MsWong1("N", "YO", 1), new L4_SortByFirstName())); // {A,J,N}
                                                                                                                    // -->
                                                                                                                    // 2

    }
}
