package u1;

import java.math.BigInteger;

public class L7_BigInteger {

    // Write a method that uses BigInteger to store the results of a factorial. SEE
    // HOW LARGE OF A NUMBER YOU CAN CALCULATE THE FACTORIAL OF !!!!!
    public static BigInteger factorial(int n) {
        BigInteger factorial = BigInteger.valueOf(1);

        for (int i = n; i >= 1; i--) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }

    public static void main(String[] args) {
        // How to Create a BigInteger
        BigInteger eg = new BigInteger("999999999999999999999999999999999999999999999999999999999999999");

        BigInteger num = new BigInteger("0012342");
        System.out.println(num); // 12342

        int alsdkjfalskdjf = 12342;
        BigInteger num1 = BigInteger.valueOf(alsdkjfalskdjf);
        System.out.println(num1); // 12342

        System.out.println(num1.equals(num) + "\n"); // true

        // More Methods:
        BigInteger first = new BigInteger("0012345");
        BigInteger sec = BigInteger.valueOf(12345);
        BigInteger third = new BigInteger("00000012345");

        System.out.println(first.equals(sec)); // true
        System.out.println(first.equals(third)); // true

        // -----------------------

        System.out.println(first.max(sec)); // 12345

        BigInteger fourth = BigInteger.valueOf(900000);
        System.out.println(first.max(fourth) + "\n"); // 900000

        // -----------------------

        System.out.println(first.min(sec)); // 12345
        System.out.println(first.min(fourth) + "\n"); // 12345

        // -----------------------

        BigInteger two = BigInteger.valueOf(2);
        System.out.println(two.pow(3)); // 2^3 = 8
        System.out.println(two.pow(8) + "\n"); // 2^8 = 256

        // ------------------------

        BigInteger three = BigInteger.valueOf(3);
        System.out.println(first.compareTo(two) + "\n");

        // ------------------------
        System.out.println(factorial(5)); // 5*4*3*2*1 = 120
        System.out.println(factorial(8)); // 8*7*6*5*4*3*2*1 = 40320
    }
}
