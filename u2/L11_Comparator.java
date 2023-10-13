package u2;

import java.util.ArrayList;

public class L11_Comparator {
    public static void main(String[] args) {// Comparator

        // QUESTION: How do I sort a list of objects with different sorting criteria?
        // ANSWER: You have to "implement the Comparator interface" by writing the
        // "compare" method

        // QUESTION: What if I want to sort/search by a 3rd or 4th or ... criteria?
        // ANSWER: Create a new class for every sorting criteria that implements
        // Comparator

        L1_MsWong1 wong1 = new L1_MsWong1("J", "CS", 25);
        ArrayList<L1_MsWong1> list = new ArrayList<>();
        list.add(wong1);
        list.add(new L1_MsWong1("E", "Math", 30));
        list.add(new L1_MsWong1("S", "Geo", 26));

    }

}
