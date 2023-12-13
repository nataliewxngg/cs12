package u3;

import java.util.*;

public class HeapsExercise {
    public static void main(String[] args) {
        // 2
        Queue<Character> queue = new PriorityQueue<>();

        queue.add('G');
        queue.add('A');
        queue.add('C');
        queue.add('E');
        queue.add('F');

        System.out.println(queue);
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
            System.out.println(queue);
        }
    }
}
