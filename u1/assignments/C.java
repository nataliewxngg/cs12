// Natalie Wong
// Due September 14, 2023

// This program reads strings from a text file and 
// determines the longest palindromes in each string, which may
// begin at any index and be any length long.

package u1.assignments;

import java.util.Scanner;
import java.io.*;

public class C {
    public static void findLargestPalindrome(String s) {
        String word;
        String flippedWord = "";

        for (int i = s.length(); i > 0; i--) {
            for (int n = 0; n <= s.length() - i; n++) {

                word = s.substring(n, n + i);
                // System.out.println(word);

                for (int x = word.length() - 1; x >= 0; x--) {
                    flippedWord += word.charAt(x);
                }
                // System.out.println(flippedWord);

                if (word.equalsIgnoreCase(flippedWord)) {
                    System.out.println("Screen Output");
                    System.out.println("\tFinding the largest palindrome");
                    System.out.printf("\tLargest palindrome: %s%n", word);
                    System.out.printf("\tStarting position: %d%n", n + 1);
                    System.out.printf("\tLength: %d%n%n", word.length());

                    return;
                }
                flippedWord = "";
            }
        }
    }

    public static void main(String[] args) {
        // Variables
        String s;

        // Main Code
        try {
            Scanner inputFile = new Scanner(new File("input.txt"));

            while (inputFile.hasNextLine()) {
                s = inputFile.nextLine();

                System.out.printf("File input: \n\t%s%n%n", s);

                findLargestPalindrome(s);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
        }
    }
}
