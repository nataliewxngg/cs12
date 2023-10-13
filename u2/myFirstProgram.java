package u2;

import java.util.*;

public class myFirstProgram {
    // iterative approach
    public static int binarySearch2(int[] list, int key, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (key == list[mid])
                return mid;
            else if (key < list[mid]) {
                right = mid - 1;
            } else
                left = mid + 1;
        }
        // When key is not found
        return -left - 1;
    }

    // recursive approach
    public static int binarySearch(int[] list, int key, int left, int right) {
        int mid = (left + right) / 2;

        if (left > right)
            return -left - 1;
        if (key == list[mid])
            return mid;
        if (key < list[mid])
            return binarySearch(list, key, left, mid - 1);
        else
            return binarySearch(list, key, mid + 1, right);
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println(binarySearch2(arr1, 9, 0, 6));
    }
}