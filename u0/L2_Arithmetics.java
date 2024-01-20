package u0;

public class L2_Arithmetics {
    public static void main(String[] args) {
        // Variables
        int x = 10;
        int y = 3;
        double z = 5.5;

        // Main
        System.out.println(x + y); // 13
        System.out.println(z - y); // 2.5

        System.out.println(x * y); // 30

        System.out.println(x / y); // 3
        System.out.println(5 / 2); // 2

        System.out.println(x % y); // 1
        System.out.println(x % z); // 4.5

        // ALL THESE OPERATIONS RETURN IN "DUMB ROUNDING" (truncate rounding)
        // EG.
        System.out.println(7 / 2); // 3.5 --> 3

        // Math methods
        System.out.println(Math.pow(3, 3)); // 27; RETURNS A DOUBLE
        System.out.println(Math.sqrt(4)); // 2; RETURNS A DOUBLE

        System.out.println(Math.max(3, 7)); // 7
        System.out.println(Math.max(1.2, 3.4)); // 3.4; RETURNS DOUBLE IF 1+ PARAMETERS DOUBLE

        System.out.println(Math.min(3, 7)); // 3
        System.out.println(Math.min(1.2, 3.4)); // 1.2; RETURNS DOUBLE IF 1+ PARAMETERS DOUBLE

        System.out.println(Math.round(7.5)); // 8; SMART ROUNDING!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        // More Rounding
        System.out.println(Math.round(12.3456 * 100.0) / 100.0); // 12.35
        System.out.println(Math.round(12.3456 * 10.0) / 10.0); // 12.3
        System.out.println(Math.round(12.3456 / 10.0) * 10.0); // 10.0

        System.out.println((int) (Math.random() * (10 - 1 + 1) + 10)); // generate a random num, where min-max are
                                                                       // inclusive

        // more arithmetic ops
        int age = 17;
        age += 1; // 18
        age -= 16; // 2
        age *= 4; // 8
        age /= 2; // 4
        age %= 3; // 1
        age++; // 2
        age--; // 1
        System.out.println(age);

        // NOTE: x++/x-- IS DIFFERENT FROM ++x/--x
        // x++/x-- CHANGES X AFTER AN OPERATION BUT ++x/--x CHANGES X BEFORE IT
        // eg.
        int a = 10;
        int b = 20;
        b += a++;
        System.out.println(b); // 30

        b = 20;
        a = 10;
        b += ++a;
        System.out.println(b); // 31

        // BEDMAS
        System.out.println(2 + 3 * 4);
    }
}
