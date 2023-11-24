package u3;

import java.util.*;

public class L2_StackQueueAndDequeue {
    public static void main(String[] args) {

        // Stack class
        // - a subclass of vector
        // - based on LIFO structure
        Stack<String> s = new Stack<>();

        // Methods:
        // push, pop, peek, empty, search

        // -----------------------------

        // Queue (Interface)
        // - based on FIFO structure
        // - uses a LinkedList/PriorityQueue/ArrayQueue
        List<String> ListL = new LinkedList<>();
        Queue<String> ListQ = new LinkedList<>();

        // ListL and ListQ access DIFFERENT methods depending on their superclasses
        // ListL: addLast, removeFirst, ...
        // ListQ: add/offer, remove/poll, peek/element, set, indexOf, size, ListIterator

        // -----------------------------

        // Deque (Interface)
    }
}
