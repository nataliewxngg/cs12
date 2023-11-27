// Natalie Wong
// Due Sunday, December 3, 2023

// Assignment #5 - Dynamic Data Structures - PROBLEM #1
// This program acquires String inputs from a textfile and determines the number of distinct substrings available for each case

package u3.assignment5;

import java.io.*;

public class Problem1 {
    public static void main(String[] args) throws IOException {
        try {
            // Variables
            BufferedReader inFile = new BufferedReader(new FileReader("input.txt"));
            int numOfCases;
            String s;

            // If textfile is empty, inform the user of it and exit the program
            if ((s = inFile.readLine()) == null) {
                System.out.println("The textfile is empty!");
                inFile.close();
                return;
            }
            // If the textfile is NOT empty, determine the number of cases and continue
            // executing the program
            else {
                numOfCases = Integer.parseInt(s);
                if (numOfCases < 0) { // Don't allow for invalid number of test cases (<0)
                    inFile.close();
                    throw new NumberFormatException();
                } else if (numOfCases == 0) { // If the textfile has 0 test cases, inform the user of it and exit the
                                              // program
                    System.out.println("The textfile contains 0 test cases.");
                    inFile.close();
                    return;
                }

                // For each test case, ouput the number of substrings
                System.out.println("Finding the number of Substrings");
                for (int i = 0; i < numOfCases; i++) {
                    s = inFile.readLine();
                    // cOCNOITNINEUEUEUUEUEUEUE

                }
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (NumberFormatException e) {
            System.out.println("The textfile contains invalid input(s).");
        }
    }
}
