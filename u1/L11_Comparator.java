package u1;

import java.util.ArrayList;

public class L11_Comparator {
    public static void main(String[] args) {// Comparator

        // QUESTION: How do I sort a list of objects with different sorting criteria?
        // ANSWER: You have to "implement the Comparator interface" by writing the
        // "compare" method

        // QUESTION: What if I want to sort/search by a 3rd or 4th or ... criteria?
        // ANSWER: Create a new class for every sorting criteria that implements
        // Comparator

        MsWong wong1 = new MsWong("J", "CS", 25);
        ArrayList<MsWong> list = new ArrayList<>();
        list.add(wong1);
        list.add(new MsWong("E", "Math", 30));
        list.add(new MsWong("S", "Geo", 26));

    }

}
