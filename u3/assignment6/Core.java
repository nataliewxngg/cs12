package u3.assignment6;

import java.io.*;
import java.util.*;

public class Core {
    public static String correct(String s) {
        Map<String, String> contractions = new HashMap<>();
        contractions.put("should've", "should have");
        contractions.put("shouldn't", "should not");
        contractions.put("could've", "could have");
        contractions.put("there'll", "there will");
        contractions.put("would've", "would have");
        contractions.put("couldn't", "could not");
        contractions.put("there're", "there are");
        contractions.put("these're", "these are");
        contractions.put("those're", "those are");
        contractions.put("wouldn't", "would not");
        contractions.put("that'll", "that will");
        contractions.put("they'll", "they will");
        contractions.put("they've", "they have");
        contractions.put("doesn't", "does not");
        contractions.put("haven't", "have not");
        contractions.put("there's", "there is");
        contractions.put("they're", "they are");
        contractions.put("weren't", "were not");
        contractions.put("she'll", "she will");
        contractions.put("you'll", "you will");
        contractions.put("aren't", "are not");
        contractions.put("didn't", "did not");
        contractions.put("hadn't", "had not");
        contractions.put("hasn't", "has not");
        contractions.put("wasn't", "was not");
        contractions.put("you're", "you are");
        contractions.put("you've", "you have");
        contractions.put("won't", "will not");
        contractions.put("he'll", "he will");
        contractions.put("it'll", "it will");
        contractions.put("we'll", "we will");
        contractions.put("we've", "we have");
        contractions.put("can't", "cannot");
        contractions.put("don't", "do not");
        contractions.put("isn't", "is not");
        contractions.put("she's", "she is");
        contractions.put("we're", "we are");
        contractions.put("i'll", "i will");
        contractions.put("i've", "i have");
        contractions.put("he's", "he is");
        contractions.put("it's", "it is");
        contractions.put("i'm", "i am");

        // starting or ending with an apostrophe
        while (s.charAt(0) == '\'') {
            s = s.substring(1);
            if (s.length() == 0)
                return s;
        }
        while (s.charAt(s.length() - 1) == '\'') {
            s = s.substring(0, s.length() - 1);
            if (s.length() == 0)
                return s;
        }

        // contractions
        if (contractions.containsKey(s)) {
            s = contractions.get(s);
            return (s);
        }

        // 's
        while (s.length() >= 2) {
            if (s.substring(s.length() - 2, s.length()).equals("'s")) {
                s = s.substring(0, s.length() - 2);

                while (s.charAt(s.length() - 1) == '\'') {
                    s = s.substring(0, s.length() - 1);
                    if (s.length() == 0)
                        return s;
                }

            } else {
                break;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        Map<Word, Integer> words = new HashMap<>(); // uses .equals()
        Map<Word, Integer> sortedWords = new TreeMap<>(); // uses .compareTo()

        try {
            Long startTime = System.currentTimeMillis();
            BufferedReader in = new BufferedReader(new FileReader("input.txt"));

            String s;
            String w;
            Word word;
            StringTokenizer st;
            StringTokenizer st1;
            int freq;

            while ((s = in.readLine()) != null) {
                st = new StringTokenizer(s, " !@#$%^&*()_-+=[]{}\\|\";:,./<>?~`0123456789");

                while (st.hasMoreTokens()) {
                    w = correct(st.nextToken().toLowerCase());
                    st1 = new StringTokenizer(w);

                    while (st1.hasMoreTokens()) {
                        w = st1.nextToken();
                        // System.out.println(w + ".");

                        if (words.containsKey(new Word(w))) {
                            // System.out.println(true);
                            freq = words.get(new Word(w));

                            word = new Word(w, freq);
                            word.addFreq();

                            words.remove(new Word(w));
                        } else
                            word = new Word(w, 1);
                        words.put(word, word.getFrequency());
                    }
                }
            }

            sortedWords = new TreeMap<>(words);
            System.out.println(sortedWords);

            System.out.println(System.currentTimeMillis() - startTime + "ms");

            in.close();
        } catch (IOException e) {
            System.out.println("File not Found!");
        }
    }
}
