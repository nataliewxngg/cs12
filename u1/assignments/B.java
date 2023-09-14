// Natalie Wong
// Due September 14, 2023

// This program determines the number of n-digit (where n is between 1-7 inclusively) numbers
// that satisfy a specific property: 
// the numbers multiplied by 3 will produce a product made up of the same digits as the original numbers

// For example. 24714 multiplied by 3 will produce 74142
//              24714 and 74142 both use the same digits the same number of times

package u1.assignments;

import java.util.Scanner;

public class B {
    // Description: This method returns the first n-digit(s) number
    // It will be used as the variable initialization value to initiate the for loop
    // in the main method
    // eg. n = 4 --> This method will return 1000
    public static int startingVal(int n) { // Parameter: The value of 'n' as inputted by the user, which represents
                                           // 'n'-digits
        String index = "1";

        // Adds n-1 zeroes behind the string index, "1", to create the first n-digit
        // number as type STRING
        // eg. n = 4 --> adds 3 "0"s behind the "1" to create "1000"
        for (int i = 0; i < n - 1; i++) {
            index += "0";
        }
        return Integer.parseInt(index); // Returns the first n-digit(s) number as an integer (int)
    }

    // Description: This method returns the first (n+1)-digit(s) number divided by 3
    // and added by 1
    // It will be utilized to stop the for loop in the main method
    // (It is divided by 3 and added by 1 for improved runtime.)

    // eg. n = 4 --> This method will return 10000/3 + 1 = 3334
    // (In the for loop, 3333 (condition statement: i<3334) will be the last
    // number ran. 3333*3 is 9999,
    // there's no need to check 3334*3 and onwards (as it'll exceed the # of
    // digits)).
    public static int conditionVal(int n) { // Parameter: The value of 'n' as inputted by the user, which represents
                                            // 'n'-digits
        String index = "1";

        // Adds n zeroes behind the string index, "1", to create the first (n+1)-digit
        // number in STRING
        // eg. n = 4 --> adds 4 "0"s behind the "1" to create "10000"
        for (int i = 0; i < n; i++) {
            index += "0";
        }
        return Integer.parseInt(index) / 3 + 1; // Returns the first (n+1)-digit(s) number as an integer (int), divided
                                                // by 3 and added by 1
    }

    // Description: This method checks if a given number satisfies the condition
    // (where a number*3's product uses the same digits)
    // It will return true if the number satisfies the condition, but false
    // otherwise
    public static boolean satisfyProperty(String originalNum, String product) { // Parameters (both STRINGS):
                                                                                // 1. The original number
                                                                                // 2. The product of the original number
                                                                                // when multiplied by 3

        // Checks if the original number's digit is in the product index by index,
        // excluding the last
        // digit
        for (int i = 0; i < originalNum.length() - 1; i++) {
            if (product.indexOf(originalNum.charAt(i)) != -1) {
                product = product.substring(0, product.indexOf(originalNum.charAt(i))) +
                        product.substring(product.indexOf(originalNum.charAt(i)) + 1);
            } else {
                return false; // Returns false if the original number's current digit is NOT FOUND in the
                              // product
            }
        }

        // Checks if the original number's last digit is the remaining digit left in the
        // substringed product, which now only has 1 digit left, and should equal to the
        // original number's last digit if the number satisfies the condition
        if (Character.toString(originalNum.charAt(originalNum.length() - 1)).equals(product)) {
            return true; // Returns true if the original number's last digit is equal to the product
        }
        return false; // Returns false if the original number's last digit is NOT equal to the product
    }

    // Description: The main method acquires the input for n (in 'n'-digits) and
    // displays the # of n-digit numbers that satisfy the condition
    public static void main(String[] args) { // Parameter: args not used
        // Variables
        Scanner in = new Scanner(System.in);
        int n;
        int product;
        int quantity = 0;

        // Main Code
        System.out.print("Enter 'n' for n-digit numbers: ");

        // Collects input for 'n' (n-digits) from the user.
        // Continuously prompts the user for the input until a valid number (1<=n<=7) is
        // entered
        while (true) {
            try {
                n = Integer.parseInt(in.nextLine().trim());
                if (n < 1 || n > 7)
                    throw new NumberFormatException();
                else
                    break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid. Enter 'n' for n-digit numbers: ");
            }
        }

        // For all n-digit numbers, utilize the satisfyProperty() method to check if
        // they satisfy the condition
        // If they do, print out the number and accumulate to the quantity variable
        for (int i = startingVal(n); i < conditionVal(n); i++) {
            product = i * 3;
            if (satisfyProperty(Integer.toString(i), Integer.toString(product))) {
                System.out.println(i);
                quantity++;
            }
        }

        System.out.printf("%d %d-digit numbers satisfy this property.", quantity, n);

        // Variable(s) Termination
        in.close();
    }
}
