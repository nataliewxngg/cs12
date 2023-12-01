// Natalie Wong
// Due Sunday, December 3, 2023

// Assignment #5 - Dynamic Data Structures - PROBLEM #3
// This program determines the original order of cards, considering they all fall under the same sequence until facing upwards.

package u3.assignment5;

import java.util.*;

public class Problem3CORE { // NO ERROR CHECKS ARE DONE IN HERE
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCards;
        Stack<Integer> stack = new Stack<>();
        Deque<Integer> original = new ArrayDeque<>();

        System.out.print("Enter the number of cards: ");
        numCards = Integer.parseInt(in.nextLine());

        // Initialize stack (in order) first
        for (int i = 1; i <= numCards; i++) {
            stack.add(i);
        }

        // Go through sequence to make Deque
        while (stack.size() > 1) {
            // take
            original.addFirst(stack.pop());
            // on top
            original.addFirst(original.removeLast());
        }
        original.addFirst(stack.pop());

        System.out.println("The original sequence was: " + original);

        in.close();
    }
}
