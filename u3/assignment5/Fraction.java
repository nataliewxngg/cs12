package u3.assignment5;

import java.util.StringTokenizer;

public class Fraction {
    // Instance Variables + Data Encapsulation
    private int numerator;
    private int denominator;

    // DESCRPTION: The CONSTRUCTOR method - utilized to create new Fraction objects
    // given a String in fraction format -
    // separates it (using a "/") by numerator and denominator and initializes the
    // respective instance variables
    public Fraction(String fraction) { // PARAMETERS: A string in fraction format
        StringTokenizer st = new StringTokenizer(fraction, "/");

        // Initializes the instance variables of the new Fraction object!
        this.numerator = Integer.parseInt(st.nextToken());
        this.denominator = Integer.parseInt(st.nextToken());

        // RETURNS: none (constructors do not return any value)
    }

    // DESCRIPTION: determines if the lower or upper limit is valid (Returns true if
    // valid, false for invalid)
    public boolean valid(boolean upper, Fraction f) { // PARAMETERS:
                                                      // 1. A boolean set true only if it is the UPPER limit that is
                                                      // being checked for validity
                                                      // 2. The lower limit (not required for when lower limit is
                                                      // checked - can enter any random fraction)
        Double numerator = this.numerator * 1.0;
        Double denominator = this.denominator * 1.0;

        // If the fraction inputted is the LOWER limit, check for the validity of the
        // fraction and make sure it is NOT at maximum (1) already
        if (!upper) {
            if (numerator / denominator == 1) {
                System.out.print("Lower limit CANNOT be 1! ");
                return false; // RETURN: false if the lower limit is equivalent to 1
            } else if ((numerator / denominator) >= 0 && (numerator / denominator) < 1) {
                return true; // RETURN: true if the lower limit is NOT equal to 1, and is between the range
                             // of 0-1 (1 is exclusive)
            }
            System.out.print("Invalid input. ");
            return false; // RETURN: false if the lower limit entered is less than 0 or greater than 1
                          // (equivalent to 1 already checked for)
        }

        // If the fraction inputted is the UPPER limit, check for the validity of the
        // fraction and make sure it is larger than the lower limit
        else {
            Double lowerNumerator = f.numerator * 1.0;
            Double lowerDenominator = f.denominator * 1.0;

            if ((numerator / denominator) >= 0 && (numerator / denominator) <= 1) {
                if (numerator / denominator > lowerNumerator / lowerDenominator)
                    return true; // RETURN: true if the upper limit is between the range of 0-1 inclusive, and is
                                 // greater than the lower limit
                else {
                    System.out.print("Upper Limit must be GREATER than the lower limit! ");
                    return false; // RETURN: false if the upper limit is between the range of 0-1 inclusive, but
                                  // is less than or equal to the lower limit
                }
            }
            System.out.print("Invalid input. ");
            return false; // RETURN: false if the upper limit is not between the range of 0-1 inclusive
        }
    }

    // DESCRIPTION: Returns a Fraction object as a Double
    public double toDecimal() { // PARAMETERS: none
        return this.numerator * 1.0 / this.denominator; // RETURN: The Fraction object in decimal form (Double)
    }

    // DESCRIPTION: .toString() is called whenever a Fraction object is to be
    // outputted
    // By default, it will ouput the address location of the Fraction object in the
    // computer.
    // However, by overriding (writing) the .toString() method like so ourselves,
    // it allows us to change what is to be displayed instead.

    // Likewise, this method will allow us to display the Fraction object as a
    // String in proper fraction format instead of its address location
    public String toString() { // PARAMETERS: none
        return this.numerator + "/" + this.denominator; // RETURNS: A string in proper fraction format of the Fraction
                                                        // object
    }

    // DESCRIPTION: Getter methods - allows the files utilizing Fraction objects
    // to access its private attributes
    // PARAMETERS: none
    // RETURNS: dependent on each attribute's data type (all integers in this case)
    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }
}
