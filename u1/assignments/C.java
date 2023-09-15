// Natalie Wong
// Due September 14, 2023

// This program reads strings from a text file and 
// determines the longest palindromes in each string, which may
// begin at any index and be any length long.

package u1.assignments;

import java.util.Scanner;
import java.io.*;

public class C {

    // Description: This method finds the largest ODD-lengthed palindrome in a given
    // string
    // If there are NO odd-lengthed palindromes (length >= 3), the method will
    // return the string array with empty strings
    public static String[] findLargestOddPalindrome(String s) { // Parameter: The string the method will search for an
                                                                // odd-lengthed palindrome in
        int count = 1;
        int index = 1;
        int[] palindromes = new int[0];
        String[] results = new String[2];

        // Appends the first palindrome indexes (middle index of length 3 palindromes)
        // into the array, palindromes, first
        while (index + count < s.length()) {
            if (s.substring(index - count, index - (count - 1))
                    .equalsIgnoreCase(s.substring(index + count, index + count + 1))) {
                palindromes = addNewPalindrome(palindromes, index);
            }
            index++;
        }

        // Continues searching the sides of the indexes stored inside of the palindromes
        // array to determine which palindrome is longest
        // The longest palindrome will be the ONLY index stored in this array afterwards
        while (palindromes.length > 1) {
            count++;
            for (int i = 0; i < palindromes.length; i++) {
                if (palindromes[i] + count < s.length() && palindromes[i] - count > -1) {
                    if (!s.substring(palindromes[i] - count, palindromes[i] - (count - 1))
                            .equalsIgnoreCase(s.substring(palindromes[i] + count, palindromes[i] + count + 1))) {
                        palindromes = removePalindrome(palindromes, palindromes[i]);
                    }
                } else {
                    palindromes = removePalindrome(palindromes, palindromes[i]);
                }
            }
        }

        // If there are no odd-lengthed palindromes in the string at all, return the
        // results array with empty strings
        if (palindromes.length < 1) {
            results[0] = "";
            results[1] = "";
            return results; // Returns an array that ONLY contains empty strings if there are 0 odd-lengthed
                            // palindromes in the string
        }

        // There is only one palindrome index left in the array, palindrome. This block
        // of code will determine the length of it
        while (true) {
            if (palindromes[0] + count < s.length() && palindromes[0] - count > -1) {
                if (!s.substring(palindromes[0] - count, palindromes[0] - (count - 1))
                        .equalsIgnoreCase(s.substring(palindromes[0] + count, palindromes[0] + count + 1))) {
                    count--;
                    break;
                }
            } else {
                count--;
                break;
            }
            count++;
        }

        // Stores the palindrome and the starting position of it inside the array,
        // results, then returns it
        results[0] = s.substring(palindromes[0] - count, palindromes[0] + count + 1); // The word itself
        results[1] = Integer.toString(palindromes[0] - count); // The index of the first letter

        return results; // Returns an array that stores the palindrome and the starting position of it
    }

    // Description: This method finds the largest EVEN-lengthed palindrome in a
    // given string
    // If there are NO even-lengthed palindromes (length >= 3), the method will
    // return the string array with empty strings
    public static String[] findLargestEvenPalindrome(String s) { // Parameter: The string the method will search for an
                                                                 // even-lengthed palindrome in
        int[][] startEndIndexes = new int[0][0];
        int count = 0;
        String[] results = new String[2];

        // Searches for side-by-side letters that are the same (essentially palindromes
        // of length 2)
        // This block of code will also store the indexes of the two letters into a
        // 2D-array called startEndIndexes
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.substring(i, i + 1).equalsIgnoreCase(s.substring(i + 1, i + 2))) {
                startEndIndexes = addStartEndIndex(startEndIndexes, i, i + 1);
                i++;
            }
        }

        // Continues searching the sides of the indexes stored inside of the palindromes
        // array to determine which palindrome is longest
        // The longest palindrome will be the ONLY index stored in this array afterwards
        while (startEndIndexes.length > 1) {
            count++;

            for (int row = 0; row < startEndIndexes.length; row++) {
                if (startEndIndexes[row][1] + count < s.length() && startEndIndexes[row][0] - count > -1) {
                    if (!s.substring(startEndIndexes[row][0] - count, startEndIndexes[row][0] - (count - 1))
                            .equalsIgnoreCase(s.substring(startEndIndexes[row][1] + count,
                                    startEndIndexes[row][1] + count + 1))) {
                        startEndIndexes = removeStartEndIndex(startEndIndexes, row);
                    }
                } else {
                    startEndIndexes = removeStartEndIndex(startEndIndexes, row);
                }
            }
        }

        // If there are no even-lengthed palindromes in the string at all, return the
        // results array with empty strings
        if (startEndIndexes.length < 1) {
            results[0] = "";
            results[1] = "";
            return results; // Returns an array that ONLY contains empty strings if there are 0 odd-lengthed
                            // palindromes in the string
        }

        // There is only one palindrome index left in the array, palindrome. This block
        // of code will determine the length of it
        while (true) {
            if (startEndIndexes[0][1] + count < s.length() && startEndIndexes[0][0] - count > -1) {
                if (!s.substring(startEndIndexes[0][0] - count, startEndIndexes[0][0] - (count - 1))
                        .equalsIgnoreCase(
                                s.substring(startEndIndexes[0][1] + count, startEndIndexes[0][1] + count + 1))) {
                    count--;
                    break;
                }
            } else {
                count--;
                break;
            }
            count++;
        }

        // Stores the palindrome and the starting position of it inside the array,
        // results, then returns it
        results[0] = s.substring(startEndIndexes[0][0] - count, startEndIndexes[0][1] + count + 1); // the word itself
        results[1] = Integer.toString(startEndIndexes[0][0] - count); // the index of the first letter

        return results; // Returns an array that stores the palindrome and the starting position of it
    }

    // Description: This method takes the startEndIndexes 2D array and returns a new
    // version of it where a given row is removed
    public static int[][] removeStartEndIndex(int[][] startEndIndexes, int dontWantRow) { // Parameters include:
                                                                                          // 1. the original array
                                                                                          // 2. the row (an index) of
                                                                                          // the original array intended
                                                                                          // on being removed

        int[][] newArr = new int[startEndIndexes.length - 1][2];
        int newArrIndex = 0;

        // Copies all the rows of the original array into the new array, except the row
        // we want to remove
        for (int row = 0; row < startEndIndexes.length; row++) {
            if (dontWantRow != row) {
                newArr[newArrIndex][0] = startEndIndexes[row][0];
                newArr[newArrIndex][1] = startEndIndexes[row][1];
                newArrIndex++;
            }
        }

        return newArr; // Returns the array startEndIndexes without the given row (length of array is 1
                       // less the original one)
    }

    // Description: This method takes the startEndIndexes 2D array and adds a new
    // row
    // It'll add in the indexes of the two same side-by-side letters into one row
    public static int[][] addStartEndIndex(int[][] startEndIndexes, int startIndex, int endIndex) {
        int[][] newArr = new int[startEndIndexes.length + 1][2];

        newArr[0][0] = startIndex;
        newArr[0][1] = endIndex;

        // Copies all the rows of the original array into the new one
        for (int row = 0; row < startEndIndexes.length; row++) {
            for (int col = 0; col < startEndIndexes[row].length; col++) {
                newArr[row + 1][col] = startEndIndexes[row][col];
            }
        }
        return newArr; // Returns the new startEndIndexes array with the new row of indexes
    }

    // Description: This method appends a new given index into an array of indexes
    // for palindromes
    public static int[] addNewPalindrome(int[] palindromes, int index) { // Parameters include:
                                                                         // 1. the original array
                                                                         // 2. the index intended on being appended
        int[] newArr = new int[palindromes.length + 1];
        newArr[0] = index;

        // Copies the indexes of the original array into the new one
        for (int i = 1; i < newArr.length; i++) {
            newArr[i] = palindromes[i - 1];
        }
        return newArr; // Returns the new array with the given index now appended
    }

    // Description: This method removes a given index from an array of indexes for
    // palindromes
    public static int[] removePalindrome(int[] palindromes, int index) { // Parameters include:
                                                                         // 1. the original array
                                                                         // 2. the index intended to be removed from the
                                                                         // original array (NOT the index of the array,
                                                                         // it is a NUMBER to be removed from the array)
        int newArrIndex = 0;
        int[] newArr = new int[palindromes.length - 1];

        // Copies all the indexes of the original array into the new one, except for the
        // index we want to remove
        for (int i = 0; i < palindromes.length; i++) {
            if (palindromes[i] != index) {
                newArr[newArrIndex] = palindromes[i];
                newArrIndex++;
            }
        }

        return newArr; // Returns the original array with the index of the palindrome removed
    }

    // Description: This method will collect the strings from the textfile and
    // determine the longest palindromes of each by utilizing methods above
    public static void main(String[] args) { // Parameter: args not used
        // Variables
        String s;

        // Main Code
        try {
            Scanner inputFile = new Scanner(new File("input.txt"));

            // Reads through all the lines of the textfile and determines the longest
            // palindrome of each line
            // It will also display the file input and the longest palindrome, starting
            // position, and length of the palindrome
            while (inputFile.hasNextLine()) {
                s = inputFile.nextLine();

                if (s.length() >= 10_000) {
                    System.out.printf("File input: \n\t%s%n%n", s.substring(0, 50));
                } else if (s.length() > 0) {
                    System.out.printf("File input: \n\t%s%n%n", s);
                }

                System.out.println("Screen output:");
                System.out.println("\tFinding the largest palindrome");

                if (findLargestOddPalindrome(s)[0].length() < findLargestEvenPalindrome(s)[0].length()) {
                    System.out.printf("\tLargest palindrome: %s%n", findLargestEvenPalindrome(s)[0]);
                    System.out.printf("\tStarting position: %d%n",
                            Integer.parseInt(findLargestEvenPalindrome(s)[1]) + 1);
                    System.out.printf("\tLength: %d%n%n", findLargestEvenPalindrome(s)[0].length());
                } else if (findLargestOddPalindrome(s)[0].length() > findLargestEvenPalindrome(s)[0].length()) {
                    System.out.printf("\tLargest palindrome: %s%n", findLargestOddPalindrome(s)[0]);
                    System.out.printf("\tStarting position: %d%n",
                            Integer.parseInt(findLargestOddPalindrome(s)[1]) + 1);
                    System.out.printf("\tLength: %d%n%n", findLargestOddPalindrome(s)[0].length());
                } else {
                    System.out.println("\tNo palindrome!");
                }
            }

        } catch (FileNotFoundException e) { // If the input file "input.txt" was not found in the current directory, the
                                            // message "File Not Found!" will be displayed in the console
            System.out.println("File Not Found!");
        }
    }
}