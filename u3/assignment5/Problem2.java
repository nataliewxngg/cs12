// Natalie Wong
// Due Sunday, December 3, 2023

// Assignment #5 - Dynamic Data Structures - PROBLEM #2
// This program determines the total number of reduced fractions between 0 and 1 (inclusive) with a denominator, N, inputted by the user
// Moreover, it may determine the number of fractions valid between a lower and upper limit.

package u3.assignment5;

import java.util.*;

public class Problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int denominator;
        Fraction lowerLimit;
        Fraction upperLimit;
        Set<Double> fractions = new TreeSet<Double>();
        Set<Double> subList;

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
        } while (true);

        // Upper limit
        do {
            System.out.print("Enter the upper limit: ");
            upperLimit = new Fraction(in.nextLine());

            if (upperLimit.valid(true, lowerLimit))
                break;
        } while (true);

        // Display results
        // Determine TOTAL number of fractions
        fractions.add(0.0);
        for (int d = denominator; d >= 1; d--) {
            for (int n = 1; n < d; n++) {
                fractions.add(n * 1.0 / d);
            }
        }
        fractions.add(1.0);

        System.out.printf("Total number of fractions: %d%n", fractions.size());

        // Determine number of fractions between the lower and upper limit (inclusive)

        if (!fractions.contains(lowerLimit.toDecimal())) {
            if (!fractions.contains(upperLimit.toDecimal())) {
                // doesn't contain both lower and upper limits
                fractions.add(lowerLimit.toDecimal());
                fractions.add(upperLimit.toDecimal());
            }
        }
        fractions.add(lowerLimit.toDecimal());

        fractions.add(upperLimit.toDecimal());

        subList =
                // System.out.println(
                // "Number of fractions between " + lowerLimit + " and " + upperLimit + "
                // inclusive: "
                // + fractionsSUBLISTOFLIMITS.size());

                in.close();
    }
}
