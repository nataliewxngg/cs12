package u3;

import java.util.*;

public class L2_StackQueueAndDequeue {
    public static void main(String[] args) {

        // Stack class
        // - a subclass of vector
        // (vector: a legacy class very similar to ArrayList (consecutive memory) -
        // doubles by size when capacity reached, whereas ArrayList increases by 50%)
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
        // - extends the Queue interface
        // - a DOUBLE-ENDED queue that supports addition/removal from BOTH ends
        // - FASTER than stack AND list

        // Methods:
        // addFirst/offerFirst
        // addLast/offerLast
        // removeFirst/pullFirst
        // removeLast/pullLast
        // getFirst/peekFirst
        // getLast/peekLast
    }
}
