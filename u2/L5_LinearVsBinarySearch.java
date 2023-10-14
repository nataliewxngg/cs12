package u2;

import java.util.*;

public class L5_LinearVsBinarySearch {
    // Big O Notation (TIME COMPLEXITY)
    // - Notation used to describe the asymptote upper bound for the magnitude of
    // a function
    // - Worst case "time" that a function takes

    // LINEAR SEARCH
    // - Searching a list for the "key" starting from the FIRST INDEX
    // - ADV: Works with any unsorted list
    // - DISADV: slow (esp. for longer list)
    // - Time Complexity of O(n), where n = list size

    // BINARY SEARCH
    // - Searching a list for the "key" starting with the middle index
    // - ADV: Much faster than linear searching (especially for long lists)
    // - DISADV: Only works with SORTED lists, ANY of the keys are returned when
    // there are DUPLICATES (not guaranteed to be the first occurence)
    // - "key" not found --> returns -(current mid position)
    // - Time Complexity of O(log2n) (see 19 Oct 13 note)

    public static void main(String[] args) {
        int[] iarr = { -9, -6, -1, 0, 1, 2, 2, 2, 16, 30 };
        System.out.println(Arrays.binarySearch(iarr, 16)); // 8
        System.out.println(Arrays.binarySearch(iarr, 2)); // 7
        System.out.println(Arrays.binarySearch(iarr, 15)); // -9
        System.out.println(Arrays.binarySearch(iarr, -2)); // -3
        // System.out.println(Arrays.binarySearch(iarr, 1.5)); // -6
        // System.out.println(Arrays.binarySearch(iarr, 0.5)); // -4
        System.out.println(Arrays.binarySearch(iarr, 45)); // -11
    }
}
