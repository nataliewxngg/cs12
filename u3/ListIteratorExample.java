package u3;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExample {

    public static void main(String[] args) {
        // Creating an ArrayList
        List<String> arrayList = new ArrayList<>();
        arrayList.add("One");
        arrayList.add("Two");
        arrayList.add("Three");
        // {One, Two, Three}

        // Obtaining a ListIterator
        ListIterator<String> listIterator = arrayList.listIterator();

        // Example 1: Forward iteration
        System.out.println("Forward Iteration:");
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
        // Forward iteration:
        // One
        // Two
        // Three

        // Example 2: Backward iteration
        System.out.println("\nBackward Iteration:");
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
        // Backwaard Iteration:
        // Three
        // Two
        // One

        // Example 3: Modifying elements during iteration
        System.out.println("\nModified List:");
        while (listIterator.hasNext()) {
            String currentElement = listIterator.next();
            System.out.println("Original: " + currentElement);
            // Modify the element
            listIterator.set(currentElement + " Modified");
        }
        // Modified List:
        // Original: One
        // {One Modified, Two, Three}
        // Original: Two
        // {One Modified, Two Modified, Three}
        // Original: Three
        // {One Modified, Two Modified, Three Modified}

        // Displaying the modified ArrayList
        System.out.println("\nModified ArrayList:");
        for (String element : arrayList) {
            System.out.println(element);
        }
        // One Modified
        // Two Modified
        // Three Modified
    }
}