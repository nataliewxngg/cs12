// Natalie Wong
// Due September 14, 2023

// This program determines the number of n-digit (where n is between 1-7 inclusively) numbers
// that satisfy a specific property: 
// a number multiplied by 3 will produce a product made up of the same digits as the original numbers.

// For example. 24714 multiplied by 3 will produce 74142
//              24714 and 74142 both use the same digits the same number of times

package u1.assignments;

import java.util.Scanner;

public class B {
    public static int startingVal(int n) {
        String index = "1";
        for (int i = 0; i < n - 1; i++) {
            index += "0";
        }
        return Integer.parseInt(index);
    }

    public static int conditionVal(int n) {
        String index = "1";
        for (int i = 0; i < n; i++) {
            index += "0";
        }
        return Integer.parseInt(index);
    }

    public static boolean satisfyProperty(String originalNum, String product) {
        for (int i = 0; i < originalNum.length() - 1; i++) {
            if (product.indexOf(originalNum.charAt(i)) != -1) {
                product = product.substring(0, product.indexOf(originalNum.charAt(i))) +
                        product.substring(product.indexOf(originalNum.charAt(i)) + 1);
            } else {
                return false;
            }
        }
        if (Character.toString(originalNum.charAt(originalNum.length() - 1)).equals(product)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // Variables
        Scanner in = new Scanner(System.in);
        int n;
        int product;
        int quantity = 0;

        // Main Code
        System.out.print("Enter 'n' for n-digit numbers: ");
        n = Integer.parseInt(in.nextLine());

        for (int i = startingVal(n); i < conditionVal(n); i++) {
            product = i * 3;
            if (satisfyProperty(Integer.toString(i), Integer.toString(product))) {
                System.out.println(i);
                quantity++;
            }
        }

        System.out.printf("%d %d-digit numbers satisfy this property.", quantity, n);

        // Terminating Variables
        in.close();
    }
}
