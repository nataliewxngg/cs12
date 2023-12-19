package u3.assignment6;

import java.util.*;
import java.io.*;

public class sdlfkjsd {
    public static void main(String[] args) throws IOException {
        HashSet<String> a = new HashSet(Arrays.asList("natalie", "lorraine", "amanda"));
        HashSet<String> b = new HashSet(Arrays.asList("poopalie", "natalie", "what"));
        HashSet<String> c = new HashSet(Arrays.asList("yoyo", "natalie", "poop"));

        HashSet<String> allThree = new HashSet<>();
        allThree.addAll(a);
        allThree.retainAll(b);
        allThree.retainAll(c);

        System.out.println(allThree);
    }
}
