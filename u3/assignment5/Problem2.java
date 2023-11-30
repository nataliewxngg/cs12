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
        List<Double> subList;

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
            String s;

            if (!((s = in.nextLine()).indexOf('/') != -1))
                System.out.print("Invalid input. ");

            else {
                lowerLimit = new Fraction(s);

                if (lowerLimit.valid(false, new Fraction("1/1")))
                    break;
            }

        } while (true);

        // Upper limit
        do {
            System.out.print("Enter the upper limit: ");
            String s;

            if (!((s = in.nextLine()).indexOf('/') != -1))
                System.out.print("Invalid input. ");
            else {
                upperLimit = new Fraction(s);

                if (upperLimit.valid(true, lowerLimit))
                    break;
            }
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
        // contains both upper AND lower limits
        if (fractions.contains(lowerLimit.toDecimal()) && fractions.contains(upperLimit.toDecimal())) {
            subList = new ArrayList<Double>(fractions);

            subList = subList.subList(subList.indexOf(lowerLimit.toDecimal()),
                    subList.indexOf(upperLimit.toDecimal()) + 1);
        }

        // doesn't contain upper AND lower limits
        else if (!fractions.contains(lowerLimit.toDecimal()) && !fractions.contains(upperLimit.toDecimal())) {
            fractions.add(lowerLimit.toDecimal());
            fractions.add(upperLimit.toDecimal());
            subList = new ArrayList<Double>(fractions);

            subList = subList.subList(subList.indexOf(lowerLimit.toDecimal()) + 1,
                    subList.indexOf(upperLimit.toDecimal()));
        }

        // Only contains upper limit
        else if (!fractions.contains(lowerLimit.toDecimal())) {
            fractions.add(lowerLimit.toDecimal());
            subList = new ArrayList<Double>(fractions);

            subList = subList.subList(subList.indexOf(lowerLimit.toDecimal()) + 1,
                    subList.indexOf(upperLimit.toDecimal()) + 1);
        }

        // Only contains lower limit
        else {
            fractions.add(upperLimit.toDecimal());
            subList = new ArrayList<Double>(fractions);

            subList = subList.subList(subList.indexOf(lowerLimit.toDecimal()), subList.indexOf(upperLimit.toDecimal()));
        }

        System.out.println(
                "Number of fractions between " + lowerLimit + " and " + upperLimit + " inclusive: "
                        + subList.size());

        in.close();
    }
}
