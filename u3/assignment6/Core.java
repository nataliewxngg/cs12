package u3.assignment6;

import java.io.*;
import java.util.*;

public class Core {
    public static void main(String[] args) {
        Map<Word, Integer> words = new TreeMap<>(); // uses .compareTo()

        try {
            BufferedReader in = new BufferedReader(new FileReader("ALICE.TXT"));

            String s;
            Word w;
            StringTokenizer st;
            while ((s = in.readLine()) != null) {
                st = new StringTokenizer(s);

                while (st.hasMoreTokens()) {
                    w = new Word(st.nextToken().toLowerCase(), 1);

                    if (words.containsKey(w)) {
                        words.remove(w);
                        w.addFreq();
                    }

                    words.put(w, w.getFrequency());
                }
                System.out.println(words);
            }

        } catch (IOException e) {
            System.out.println("File not Found!");
        }
    }
}
