package u0;

import java.util.Scanner;

public class L5_strings {
    public static void main(String[] args) {
        // Write a program that asks the user for a word and a
        // sentence, and your program will find out how many times
        // that word appears in the sentence. (CASE INSENSITIVE)

        // --> MAKE TWO DIFF SOLUTIONS FOR THIS!!!!!!!!!!!!!!
        // e.g. I can typetypehaha TYPE type faster than Asvin!
        // tYpe
        // --> 4

        // Variables
        Scanner in = new Scanner(System.in);
        String word;
        String sentence;
        int acc = 0;

        // Main Code
        System.out.print("Enter a sentence: ");
        sentence = in.nextLine();
        System.out.print("Enter a word: ");
        word = in.nextLine();

        // Method 1
        while (sentence.toLowerCase().indexOf(word.toLowerCase()) != -1) {
            acc++;
            sentence = sentence.substring(sentence.toLowerCase().indexOf(word.toLowerCase()) + 1);
        }

        // Method 2
        for (int i = 0; i < sentence.length() - word.length(); i++) {
            if (sentence.substring(i, i + word.length()).equalsIgnoreCase(word))
                acc++;
        }
        System.out.println(acc);

        // Terminating variables
        in.close();
    }
}
