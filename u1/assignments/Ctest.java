// Natalie Wong
// Due September 14, 2023

// This program reads strings from a text file and 
// determines the longest palindromes in each string, which may
// begin at any index and be any length long.

package u1.assignments;

import java.util.Scanner;
import java.io.*;

public class Ctest {

    public static void findLargestPalindrome(String s) {
        int count = 1;
        // theme
        // index = 3 (m)
        // 2, 3
        // 3, 4

        for (int index = 1; index < s.length() - 1; index++) {
            // System.out.println(s.substring(index - count, index + count));
            if (s.substring(index - count, index).equals(s.substring(index, index + count))) {
                System.out.println(s.substring(index - count, index + count));
                return;
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

                if (s.length() >= 10_000) {
                    System.out.printf("File input: \n\t%s%n%n", s.substring(0, 50));
                } else if (s.length() > 0) {
                    System.out.printf("File input: \n\t%s%n%n", s);
                }

                findLargestPalindrome(s);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
        }
    }
}