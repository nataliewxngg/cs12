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

        // If the fraction inputted is the LOWER limit, check for the validity of the
        // fraction and make sure it is NOT at maximum (1) already
        if (!upper) {
            if (numerator / denominator == 1) {
                System.out.print("Lower limit CANNOT be 1! ");
                return false;
            } else if ((numerator / denominator) >= 0 && (numerator / denominator) < 1) {
                return true;
            }
            System.out.print("Invalid input. ");
            return false;
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

    // Returns a double of the fraction
    public double toDecimal() {
        return this.numerator * 1.0 / this.denominator;
    }

    // Overrides the method .toString() - changes content a Fraction object displays
    // when outputted
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    // Getters and Setters
    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }
}
