package u0;

import java.util.Scanner;

public class Review {

    // 7. Methods

    // Terminologies (ie. parameters, modifiers, return, local vs global variables,
    // etc.)
    static int globalVariable = 3;
    int localVariable = 5;

    public static void poopMethod(String name, int age) {
        // name and age are LOCAL VARIABLES
        globalVariable = 5;
    }

    // MODIFIER return type METHOD NAME(parameters) {
    // RETURN
    // }

    // Know how to write a method heading
    public static int biggestNum(int x, int y) {
        return Math.max(x, y);
    }

    // Passing by value vs. passing by reference
    public static String changeStringToPoop(String pee) {
        pee = "poo";
        return pee;
    }

    public static int changeIntValue(int yo) {
        yo = 5;
        return yo;
    }

    public static int[] changeArr(int[] arr) {
        arr[1] = 100;
        return arr;
    }

    // -----------------------------------------------------------------------

    public static void main(String[] args) {
        // 1. Basic input and output

        // Special characters like \n, \t
        System.out.println("Hello \\n\n\n\\n Natali\n\\\\\\neWong");
        // Hello \n
        //
        // \n Natali
        // \\\neWong

        System.out.println("abc\tefgh"); // abc efgh
        System.out.println("ab\tce\tfgh"); // ab cd fgh

        // Reading input with Scanner (weird problem with Scanner)
        Scanner in = new Scanner(System.in);
        in.close();

        // -----------------------------------------------------------------

        // 2. Variables

        // int, double, char, boolean, String
        int age = 17;
        double birthday = 5.9;
        char nameInitial = 'n';
        boolean dumb = true;
        String name = "Natalie";

        System.out.println(age + birthday + name + nameInitial + dumb);

        // Converting between types --> CAST!
        String jersey = "9";

        System.out.println(Integer.parseInt(jersey)); // converts str --> int
        System.out.println(Double.parseDouble(jersey)); // converts str --> double
        System.out.println((int) (97.5));
        System.out.println((int) ('c'));
        System.out.println((double) (98));
        System.out.println((double) ('b'));

        // Constants

        // -----------------------------------------------------------------

        // 3. Arithmetic Operations

        // BEDMAS
        System.out.println(5 + 3 / 2); // 5 + 1 = 6
        System.out.println(6 / 4 - 1); // 1 - 1 = 0

        // Modulus
        System.out.println(22 % 7); // 1
        System.out.println(36 % 2.5); // 1.0

        // ++, --, +=, -=, *=, /=
        int i = 3;
        System.out.println(i++); // 3
        i = 3;
        System.out.println(++i); // 4
        i = 3;
        int d = i++;
        System.out.println(d); // 3
        System.out.println(i); // 4

        // Math.pow, Math.sqrt, Math.round
        System.out.println(Math.pow(2, 3)); // 8.0
        System.out.println(Math.sqrt(16)); // 4.0
        System.out.println(Math.round(3.59)); // 4

        // Rounding formulas
        System.out.println(Math.round(3.59 * 10.0) / 10.0); // 3.6
        System.out.println(Math.round(126.3 * 0.1) / 0.1); // 130.0

        // Random number generator
        // (int)(Math.random()*(max-min+1))+min
        // random num 1-10
        int randomNum = (int) (Math.random() * (10 - 1 + 1)) + 1;
        System.out.println(randomNum);
        // random num 50-100
        int randomNum1 = (int) (Math.random() * (100 - 50 + 1)) + 50;
        System.out.println(randomNum1);

        // --------------------------------------------------------------------

        // 4. Formatting using PRINTF
        System.out.printf("%+012d", 36);

        // 5. Control Structures

        // IF statements and Boolean expressions (&&, ||, !)
        int x = 3;
        int y = 3;

        if (x > y) {
            System.out.println("x is greater than y");
        } else if (x < y) {
            System.out.println("x is less than y");
        } else {
            System.out.println("x is equal to y");
        }

        // FOR loops
        for (int n = 1; n <= 10; n++) {
            System.out.println(n);
        }

        // WHILE and DO-WHILE loops
        // while (3 > 5) {
        // System.out.println("This will never run lol");
        // }
        do {
            System.out.println("This will atleast run once");
        } while (3 > 5);

        // ------------------------------------------------------------------

        // 6. Strings

        // Characteristics of Strings (object, immutable)
        String s = "Hello bro";
        s = "bro"; // Address is now different
        System.out.println(s);

        // String methods
        String s1 = "apple Apple applesauce";
        System.out.println(s1.lastIndexOf("ple", 2)); // 2
        System.out.println(s1.indexOf("sau", 17)); // 17
        // EVEN THO WORDS ARE CUT OFF AFTERWORDS, THE SEARCHING INDEX
        // WILL LOOK AT THE LETTERS BEHIND THE LAST INDEX AS WELL

        // -------------------------------------------------------------------

        // 7. Methods
        poopMethod("nat", 17);
        System.out.println(globalVariable); // changed to 5!

        String pee = "pee";
        System.out.println(changeStringToPoop(pee));
        System.out.println(pee); // VARIABLE IS STILL POO!
        // shows that string is like pass by value

        int bro = 9;
        System.out.println(changeIntValue(bro));
        System.out.println(bro); // STILL 9!

        int[] intArr = { 1, 2, 3, 4, 5 };
        System.out.println(changeArr(intArr));
        System.out.println(intArr[1]); // got changed because of pass by reference

        // ----------------------------------------------------------------------

        // 8. Arrays

        // One-dimensional arrays AND Two-dimensional arrays
        int[] arr1 = new int[5];
        int[] arr2 = { 1, 2, 3, 4, 5 };

        int[][] arr3 = new int[3][4];
        int[][] arr4 = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8, 9 } };

        // Know how to loop through an array (using length)
        for (int bruh = 0; bruh < arr2.length; bruh++) {
            System.out.println(arr2[bruh]);
        }

        for (int row = 0; row < arr4.length; row++) {
            for (int col = 0; col < arr4[row].length; col++) {
                System.out.print(arr4[row][col]);
            }
            System.out.println("");
        }

        System.out.println("video".compareTo("videogames"));
        System.out.println("roblox".compareTo("minecraft"));
        System.out.println("NOOB".compareTo("mob"));
    }

}
