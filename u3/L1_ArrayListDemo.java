package u3;

import java.util.*;

// A demonstration of the dynamic data structure, ArrayList
// (Part of the List interface)

public class L1_ArrayListDemo {
    public static void main(String[] args) {
        System.out.println("ArrayList Demo");

        // ArrayList made under the List interface/class
        List<String> myList = new ArrayList<String>();

        myList.add("apple");
        myList.add("peach");
        myList.add("banana");
        System.out.println(myList); // [apple, peach, banana]

        myList.add(1, "lemon");
        System.out.println(myList); // [apple, lemon, peach, banana]

        System.out.println(myList.size()); // 4

        String fruit = myList.get(2);
        System.out.println(fruit); // peach

        String removedFruit = myList.set(2, "apple");
        System.out.println(removedFruit); // peach
        System.out.println(myList); // [apple, lemon, apple, banana]

        int index = myList.indexOf("apple");
        System.out.println(index); // 0
        index = myList.lastIndexOf("apple");
        System.out.println(index); // 2

        System.out.println(myList.contains("lemon")); // true
        System.out.println(myList.contains("peach")); // false

        removedFruit = myList.remove(2);
        System.out.println(removedFruit); // apple
        // myList.add(new Integer(1)); // ERRRRRRRRORRRRRRRRRRRRRRRRRRR
        System.out.println(myList); // [apple, lemon, apple, banana]

        ArrayList<Integer> newList = new ArrayList<Integer>();
        for (int number = 1; number <= 10; number++) {
            newList.add(new Integer(number));
        }
        System.out.println(newList); // [1,2,3,4,5,6,7,8,9,10]

        ArrayList<Integer> newList2 = new ArrayList<Integer>();
        newList2.addAll(0, newList); // .addAll() IS NEW!!!!!!!!!!!!
        newList2.add(new Integer(1));
        System.out.println(newList2); // [1,2,3,4,5,6,7,8,9,10,1]

        List<Integer> subList = newList2.subList(0, 10);
        System.out.println(subList); // [1,2,3,4,5,6,7,8,9,10]

        System.out.println(subList.equals(newList)); // true
        System.out.println(subList.equals(newList2)); // false

        newList2.removeAll(newList);
        System.out.println(newList2); // []
        System.out.println(newList); // [1,2,3,4,5,6,7,8,9,10]
        System.out.println(subList); // ERROR --> subList is only a view (error when original is empty)

        Collections.sort(myList);
        System.out.println(myList); // [1,2,3,4,5,6,7,8,9,10]

        System.out.println(newList.isEmpty()); // false
        newList.clear();
        System.out.println(newList.isEmpty()); // true

        System.out.println(myList); // [apple, banana, lemon]

        // Traversing method #1
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        // Traversing method #2
        ListIterator<String> scan = myList.listIterator();
        while (scan.hasNext()) {
            System.out.println(scan.next());
        }

        // Traversing method #3
        Object[] myArray = myList.toArray();
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }

        // Traversing method #4
        String[] strArray = new String[myList.size()];
        myList.toArray(strArray);

        for (int i = 0; i < strArray.length; i++) {
            System.out.println(strArray[i]);
        }
    }
}
