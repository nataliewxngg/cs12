package u2;

import java.util.*;

public class L6_BinarySearchAlgorithm {

    // Writing our own binarySearch methods using the algorithm

    // ITERATIVE APPROACH
    public static int binarySearch1(int[] list, int key, int left, int right) {

        while (left <= right) {
            int mid = (left + right) / 2;

            if (key == list[mid])
                return mid;
            else if (list[mid] < key)
                left = mid + 1;
            else
                right = mid - 1;
        }

        // When key is not found
        return -left - 1;
    }

    // RECURSIVE APPROACH
    public static int binarySearch(int[] list, int key, int left, int right) {

        int mid = (left + right) / 2;
        if (left > right)
            return -left - 1;

        if (key == list[mid])
            return mid;
        if (list[mid] < key)
            return binarySearch(list, key, mid + 1, right);
        else
            return binarySearch(list, key, left, mid - 1);
    }

    public static void main(String[] args) {

        int[] iarr = { -9, -6, -1, 0, 1, 2, 2, 2, 16, 30 };
        System.out.println(Arrays.binarySearch(iarr, 16)); // 8 - using built in method to find

        System.out.println(binarySearch1(iarr, 16, 0, iarr.length - 1)); // 8
        System.out.println(binarySearch1(iarr, 16, 0, 6)); // -8
        System.out.println(binarySearch1(iarr, 2, 0, iarr.length - 1)); // 7

        System.out.println("");

        System.out.println(binarySearch(iarr, 16, 0, iarr.length - 1)); // 8
        System.out.println(binarySearch(iarr, 16, 0, 6)); // -8
        System.out.println(binarySearch(iarr, 2, 0, iarr.length - 1)); // 7
    }
}
