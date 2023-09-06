package u0.assignments;

import java.util.Scanner;

public class StringsPractice {
    public static void main(String[] args) {

        // Variables
        String sentence;
        String word;
        Scanner in = new Scanner(System.in);
        int acc = 0;

        // 1.
        // Write a program that counts how many times a given word appears appears in a
        // given sentence. (case insensitive) (2 SOLUTIONS)
        System.out.print("Enter your sentence: ");
        sentence = in.nextLine();
        System.out.print("What word are you searching for? ");
        word = in.nextLine();

        while (sentence.indexOf(word) != -1) {
            acc++;
            sentence = sentence.substring(sentence.indexOf(word) + word.length(), sentence.length());
        }
        System.out.printf("The word appeared %d times.", acc);

        // 2.
        //

        // Terminating Variables
        in.close();
    }
}
