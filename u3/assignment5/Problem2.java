// Natalie Wong
// Due Sunday, December 3, 2023

// Assignment #5 - Dynamic Data Structures - PROBLEM #2
// This program determines the total number of reduced fractions between 0 and 1 (inclusive) with a denominator, N, inputted by the user
// Moreover, it may determine the number of fractions valid between a lower and upper limit.

package u3.assignment5;

import java.util.*;

public class Problem2 {

    // DESCRIPTION: The main method acquires user input and displays the # of
    // fractions (total, and between lower and upper limit (inclusively))
    public static void main(String[] args) {

        // Variables
        Scanner in = new Scanner(System.in);
        int denominator;
        Fraction lowerLimit;
        Fraction upperLimit;
        Set<Double> fractions = new TreeSet<Double>();
        List<Double> subList;

        System.out.println("\nPROGRAM #2\n");

        // Prompt the user for the maximum denominator until a valid input is entered
        do {
            System.out.print("Enter the maximum denominator: ");

            // If the maximum denominator entered is a non-integer input, or is less than
            // one or greater than 1000, reprompt the user
            try {
                denominator = Integer.parseInt(in.nextLine().strip());

                if (denominator >= 1 && denominator <= 1000)
                    break;
                else
                    throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. ");
            }

        } while (true);

        // Prompt the user for the lower limit until a valid input is entered
        do {
            System.out.print("Enter the lower limit: ");
            String s = in.nextLine().strip();

            // Assume input is already in proper fraction format
            lowerLimit = new Fraction(s);

            // If the lower limit entered is invalid (is not between the range of 0-1, or is
            // equal to 1),reprompt the user
            if (lowerLimit.valid(false, new Fraction("1/1")))
                break;
        } while (true);

        // Prompt the user for the upper limit until a valid input is entered
        do {
            System.out.print("Enter the upper limit: ");
            String s = in.nextLine().strip();

            // Assume input is already in proper fraction format
            upperLimit = new Fraction(s);

            // If the upper limit entered is invalid (is not between the range of 0-1, or is
            // LESS or EQUAL TO the lower limit), reprompt
            if (upperLimit.valid(true, lowerLimit))
                break;
        } while (true);

        // Display the results

        // Determine the total number of fractions
        fractions.add(0.0);
        // Add all the reduced fractions between 0 and 1 inclusive with denominators
        // less than or equal to N into the treeset 'fractions' as Doubles
        // Each fraction expressed in Doubles will not be duplicated and will be sorted
        // in ascending order as a treeset is utilized
        for (int d = denominator; d >= 1; d--) {
            for (int n = 1; n < d; n++) {
                fractions.add(n * 1.0 / d);
            }
        }
        fractions.add(1.0);

        System.out.printf("Total number of fractions: %d%n", fractions.size());

        // ------------------------------------

        // Determine the number of fractions between the lower and upper limit
        // (inclusive) by making a sublist for it

        // If the lower and upper limits already exists in the treeset, make the sublist
        // inclusive of both indexes
        if (fractions.contains(lowerLimit.toDecimal()) && fractions.contains(upperLimit.toDecimal())) {
            subList = new ArrayList<Double>(fractions);

            subList = subList.subList(subList.indexOf(lowerLimit.toDecimal()),
                    subList.indexOf(upperLimit.toDecimal()) + 1);
        }

        // If the lower and upper limits do NOT exist in the treeset, make the sublist
        // exclusive of both indexes
        else if (!fractions.contains(lowerLimit.toDecimal()) && !fractions.contains(upperLimit.toDecimal())) {
            fractions.add(lowerLimit.toDecimal());
            fractions.add(upperLimit.toDecimal());
            subList = new ArrayList<Double>(fractions);

            subList = subList.subList(subList.indexOf(lowerLimit.toDecimal()) + 1,
                    subList.indexOf(upperLimit.toDecimal()));
        }

        // If the treeset only contains the upper limit, make the sublist inclusive of
        // the upper limit only
        else if (!fractions.contains(lowerLimit.toDecimal())) {
            fractions.add(lowerLimit.toDecimal());
            subList = new ArrayList<Double>(fractions);

            subList = subList.subList(subList.indexOf(lowerLimit.toDecimal()) + 1,
                    subList.indexOf(upperLimit.toDecimal()) + 1);
        }

        // If the treeset only contains the lower limit, make the sublist inclusive of
        // the lower limit only
        else {
            fractions.add(upperLimit.toDecimal());
            subList = new ArrayList<Double>(fractions);

            subList = subList.subList(subList.indexOf(lowerLimit.toDecimal()), subList.indexOf(upperLimit.toDecimal()));
        }

        System.out.println(
                "Number of fractions between " + lowerLimit + " and " + upperLimit + " inclusive: "
                        + subList.size());

        in.close();

        // RETURNS: none (void method)
    }
}
