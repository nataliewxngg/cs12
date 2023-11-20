package u3;

import java.util.*;

public class L1_DynamicDataStructures {
    public static void main(String[] args) {
        // Static data structures:
        // Structures that are fixed in size
        // eg. array --> fixed in length

        // Dynamic data structures:
        // Structures that can change in size
        // eg. ArrayList

        // ----------------------------

        // Collection
        // - An INTERFACEthat represents a container for objects (group multiple objects
        // into one unit)
        // - Used to store, retrieve, and manipulate data

        // Contains List (ArrayList, LinkedList), Set (TreeSet, HashSet), Map (TreeMap,
        // HashMap)
        // ALL ARE INTERFACES

        // -----------------------------

        // ArrayLists
        // Data are stored in CONSECUTIVE memory locations
        // ADV: fast random/direct access (address of each element can be easily
        // calculated)
        // DISADV: To insert/remove an element from a list of size n, you may have to
        // shift n elements in the worst case

        // -----------------------------

        // ListIterator
        // Creates an extra "pointer" that refers to your list
        // ADV: can be used with other list structures

        ArrayList<String> names = new ArrayList<>();
        names.add("Natalie");
        names.add("Amanada");
        names.add("Megan");

        ListIterator iter = names.listIterator();

        // Can be used to traverse an ArrayList:
        while (iter.hasNext())
            System.out.println(iter.next());

        // Other methods
        // - hasNext()
        // - hasPrevious()
        // - next()
        // - previous()
        // - nextIndex()
        // - previousIndex()
        // - add(Obj)
        // - remove()
        // - set(Obj)
    }
}
