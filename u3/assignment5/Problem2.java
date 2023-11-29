// Natalie Wong
// Due Sunday, December 3, 2023

// Assignment #5 - Dynamic Data Structures - PROBLEM #2
// This program determines the total number of reduced fractions between 0 and 1 (inclusive) with a denominator, N, inputted by the user
// Moreover, it may determine the number of fractions valid between a lower and upper limit.

package u3.assignment5;

import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int denominator;
        Fraction lowerLimit;
        Fraction upperLimit;

        System.out.println("\nPROGRAM #2\n");

        // Maximum denominator
        do {
            System.out.print("Enter the maximum denominator: ");
            try {
                denominator = Integer.parseInt(in.nextLine());

                if (denominator >= 1 && denominator <= 1000)
                    break;
                else
                    throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. ");
            }
        } while (true);

        // Lower limit
        do {
            System.out.print("Enter the lower limit: ");
            lowerLimit = new Fraction(in.nextLine());

            if (lowerLimit.valid(false, new Fraction("1/1")))
                break;
            else
                System.out.print("Invalid input. ");
        } while (true);

        // Upper limit
        do {
            System.out.print("Enter the upper limit: ");
            upperLimit = new Fraction(in.nextLine());

            if (upperLimit.valid(true, lowerLimit))
                break;
        } while (true);

        in.close();
    }
}
