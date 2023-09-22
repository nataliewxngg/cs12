package assignment1;
// This program reads strings from a text file and 

// determines the longest palindromes in each string, which may
// begin at any index and be any length long.

import java.util.Scanner;
import java.io.*;

public class NatalieWong_C {

    // Description: This method will determine the largest palindrome in a given
    // string
    public static void findLargestPalindrome(String s) { // Parameter: The string teh method will search for a
                                                         // palindrome in
        String word;
        String flippedWord = "";

        // Splits the string into separate strings (longest --> shortest) and
        // determines if each one is a palindrome
        // If it is, it will display the palindrome in the console as well as the
        // starting position and length
        for (int i = s.length(); i > 1; i--) {
            for (int n = 0; n <= s.length() - i; n++) {

                word = s.substring(n, n + i);

                // Flips the split string
                // Should be equivalent to the split string itself if it is a palindrome
                for (int x = word.length() - 1; x >= 0; x--) {
                    flippedWord += word.charAt(x);
                }

                // If it IS a palindrome, display the palindrome, starting position, and length
                // of it then return nothing to stop the method
                if (word.equalsIgnoreCase(flippedWord)) {
                    System.out.println("Screen Output");
                    System.out.println("\tFinding the largest palindrome");
                    System.out.printf("\tLargest palindrome: %s%n", word);
                    System.out.printf("\tStarting position: %d%n", n + 1);
                    System.out.printf("\tLength: %d%n%n", word.length());

                    return; // Returns nothing to exit/stop the method
                }
                flippedWord = "";
            }
        }
        System.out.println("Screen Output");
        System.out.println("\tNo palindrome!\n");
    }

    // Description: This method will collect the strings from the textfile and
    // determine the longest palindromes of each by utilizing the method above
    public static void main(String[] args) {
        // Variables
        String s;

        // Main Code

        // Accesses a textfile called input.txt to read through all the lines of strings
        // and determines the longest palindrome of each line
        // It will also display the file input, which will be shortened to 50 characters
        // only if the string is longer than 10,000 characters
        try {
            Scanner inputFile = new Scanner(new File("input.txt"));

            // Takes every line of the input text file and checks for their largest
            // palindromes
            while (inputFile.hasNextLine()) {
                s = inputFile.nextLine();

                // If the string is longer than 10,000 characters, shorten the file input to 50
                // characters only
                if (s.length() >= 10_000) {
                    System.out.printf("File input: \n\t%s%n%n", s.substring(0, 50));
                } else if (s.length() > 0) {
                    System.out.printf("File input: \n\t%s%n%n", s);
                }

                findLargestPalindrome(s);
            }

        } catch (FileNotFoundException e) { // // If the input file "input.txt" was not found in the current directory,
                                            // the message "File Not Found!" will be displayed in the console
            System.out.println("File Not Found!");
        }
    }
}