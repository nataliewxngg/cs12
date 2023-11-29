package u3.assignment5;

import java.util.StringTokenizer;

public class Fraction {
    // Attributes + Data encapsulation
    private int numerator;
    private int denominator;

    // Constructor - creates a Fraction object given a String in fraction format -
    // separates it (using a "/") by numerator and denominator
    public Fraction(String fraction) {
        StringTokenizer st = new StringTokenizer(fraction, "/");
        this.numerator = Integer.parseInt(st.nextToken());
        this.denominator = Integer.parseInt(st.nextToken());
    }

    // Returns true only if a fraction object is between 0 and 1 (inclusive)
    public boolean valid(boolean upper, Fraction f) {
        Double numerator = this.numerator * 1.0;
        Double denominator = this.denominator * 1.0;

        // If the fraction inputted is the LOWER limit, only check for the validity
        // of the fraction
        if (!upper) {
            return (numerator / denominator) >= 0 && (numerator / denominator) <= 1;
        }
        // If the fraction inputted is the UPPER limit, check for the validity of the
        // fraction AND make sure it is larger than the lower limit
        else {
            Double lowerNumerator = f.numerator * 1.0;
            Double lowerDenominator = f.denominator * 1.0;

            if ((numerator / denominator) >= 0 && (numerator / denominator) <= 1) {
                if (numerator / denominator > lowerNumerator / lowerDenominator)
                    return true;
                else {
                    System.out.print("Upper limit entered is greater than lower input! ");
                    return false;
                }
            }
            System.out.print("Invalid input. ");
            return false;
        }
    }
}
