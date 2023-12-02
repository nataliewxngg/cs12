// Natalie Wong
// Due Sunday, December 3, 2023

// Assignment #5 - Dynamic Data Structures - PROBLEM #1
// This program acquires String inputs from a textfile and determines the number of distinct substrings available for each case

package u3.assignment5;

import java.io.*;
import java.util.*;

public class Problem1 {

    // DESCRIPTION: The main method acquires the textfile input and determines the
    // number of distinct substrings for each case
    public static void main(String[] args) throws IOException { // PARAMETERS: args not used
                                                                // THROWS EXCEPTION: For the BufferedReader, which
                                                                // collects input from the textfile
        try {

            // Variables
            BufferedReader inFile = new BufferedReader(new FileReader("input.txt"));
            Set<String> substrings;
            int numOfCases;
            String s;

            // If the textfile is empty, inform the user of it and terminate the program
            if ((s = inFile.readLine().strip()) == null) {
                System.out.println("The textfile is empty!");
                inFile.close();
                return;
            }

            // If the textfile is NOT empty, determine the number of cases and the number of
            // distinct substrings for each case
            else {
                numOfCases = Integer.parseInt(s);

                // Do NOT allow for an invalid number of test cases (anything less than 0)
                if (numOfCases < 0) {
                    inFile.close();
                    throw new NumberFormatException();
                }
                // If the textfile has 1 test case, inform the user of it and terminate the
                // program
                else if (numOfCases == 0) {
                    System.out.println("The textfile contains 0 test cases.");
                    inFile.close();
                    return;
                }

                // For each case, ouput the number of distinct substrings
                System.out.println("Finding the number of Substrings");
                for (int i = 0; i < numOfCases; i++) {
                    substrings = new HashSet<>();
                    s = inFile.readLine().strip();

                    // Create a double for loop, one index for the start index, and one for the end.
                    // Substring the case by these indexes each time and add them into the hashset
                    // 'substrings'
                    // Duplicates will NOT be added automatically as a hashset is utilized!
                    for (int start = 0; start < s.length(); start++) {
                        for (int end = start + 1; end <= s.length(); end++) {
                            substrings.add(s.substring(start, end).toLowerCase()); // .toLowerCase() each substring to
                                                                                   // make distinct substrings case
                                                                                   // INSENSITIVE
                        }
                    }

                    // Display the results
                    System.out.printf("%nString: %s%n", s);
                    System.out.printf("No. of Substrings: %d%n", substrings.size() + 1);
                }
            }

            System.out.println();
            inFile.close();

        } catch (FileNotFoundException e) { // If the input textfile was not found - inform the user of it and terminate
                                            // the program
            System.out.println("File not found.");
        } catch (NumberFormatException e) { // If there is 1+ invalid input(s) in the input textfile - inform the user
                                            // of it and terminate the program
            System.out.println("The textfile contains invalid input(s).");
        }

        // RETURNS: none (void method)
    }
}
