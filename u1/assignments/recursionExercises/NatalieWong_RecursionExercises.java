// Natalie Wong - Recursion Exercises
// Due September 26, 2023

package u1.assignments.recursionExercises;

import java.util.Scanner;

class NatalieWong_RecursionExercises {

    // OUTLINES:
    // 1. SAME parameters (except #7)
    // 2. input/output ALL done in main method
    // 3. no printing or loops
    // 4. inputs correct datatype only

    // Program 1: fangs()
    public static int fangs(int vampires) {
        if (vampires <= 0)
            return 0;
        return (vampires % 2 + 2) + fangs(--vampires);
    }

    // Program 2: sumDiff()
    public static double sumDiff(int n) {
        if (n == 0)
            return 0; // Reciprocal of 0 = 1/0 = undefined

        if (n > 0) { // Positive
            if (n % 2 == 0) {// Even
                if (n == 2)
                    return 0.5;
                return Math.round(((1.0 / Math.abs(n)) + sumDiff(n - 2)) * 100000.0) / 100000.0;
            } else { // Odd
                if (n == 1)
                    return 1.0;
                return Math.round(((1.0 / Math.abs(n)) * sumDiff(n - 2)) * 100000.0) / 100000.0;
            }
        } else { // Negative
            if (n % 2 == 0) { // Even
                if (n == -2)
                    return 0.5;
                return Math.round(((1.0 / Math.abs(n)) * sumDiff(n + 2)) * 100000.0) / 100000.0;
            } else { // Odd
                if (n == -1)
                    return 1.0;
                return Math.round(((1.0 / Math.abs(n)) + sumDiff(n + 2)) * 100000.0) / 100000.0;
            }
        }
    }

    // Program 3: divide()
    public static int divide(int dividend, int divisor) {
        if (dividend < divisor)
            return (int) (Math.round(((dividend * 1.0) / divisor)));

        return divide(dividend - divisor, divisor) + 1;
    }

    // Program 4: find()
    public static int find(String s) {
        if (s.length() == 0)
            return 0;

        int charAscii = s.charAt(s.length() - 1); // collects the ASCII value of the character

        // If current character is NOT a lowercase alphabetical letter
        if (charAscii < 96 || charAscii > 122) { // 96: a; 122: z
            return 1 + find(s.substring(0, s.length() - 1));
        }
        return 0 + find(s.substring(0, s.length() - 1));
    }

    // Program 5: insert()
    public static String insert(String s, char c) {
        if (s.length() == 1)
            return s;

        char currentChar = s.charAt(s.length() - 2);
        if (!((currentChar >= 'a' && currentChar <= 'z') ||
                (currentChar >= 'A' && currentChar <= 'Z'))) {
            return insert(s.substring(0, s.length() - 2) + s.substring(s.length() - 1, s.length()), c);
        }

        String nextChar = s.charAt(s.length() - 1) + "";

        if ((currentChar + "").equalsIgnoreCase(nextChar)) {
            return insert(s.substring(0, s.length() - 1), c) + c + nextChar;
        }
        return insert(s.substring(0, s.length() - 1), c) + nextChar;
    }

    // Program 6: commas()
    public static String commas(int num) {
        if (num == 0) {
            return "0";
        }

        String numStr = num + "";

        if (numStr.length() > 3)
            return commas(Integer.parseInt(numStr.substring(0, numStr.length() - 3))) + ","
                    + numStr.substring(numStr.length() - 3);
        else {
            if (numStr.charAt(0) != '-')
                return '+' + numStr;
            return numStr;
        }
    }

    // Program 7: largest()
    public static int largest(int[] ia, int index, int k, int largestIndex) {
        // index = 1, k = 1, largestIndex = 0
        int largest = ia[largestIndex];

        if (ia[index] > largest) {
            largest = ia[index];
            largestIndex = index;
            k = 1;
        } else if (ia[index] == largest) {
            k++;
        }
        if (index == ia.length - 1)
            return largest * k;

        return Math.max(largest(ia, index + 1, k, largestIndex), largest * k);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean run = true;
        String runInput;
        int program;

        int[] ia = { 8, 5, 8, 8, -234 }; // EDIT THIS ARRAY FOR PROGRAM 7 INPUT

        while (run) {
            while (true) { // Prompt user for method/program/question #
                System.out.print("Enter the method/program #: ");
                try {
                    program = Integer.parseInt(in.nextLine());
                    if (program < 1 || program > 7)
                        throw new NumberFormatException();
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. ");
                }
            }

            if (program == 1) {
                System.out.print("How many vampires are there?: ");
                System.out.println(fangs(Integer.parseInt(in.nextLine())));
            } else if (program == 2) {
                int num;

                System.out.print("Enter a #: ");
                num = Integer.parseInt(in.nextLine());
                while (num == 0) {
                    System.out.print("Invalid input. Enter a #: ");
                    num = Integer.parseInt(in.nextLine());
                }

                System.out.println(sumDiff(num));
            } else if (program == 3) {
                int dividend;
                int divisor;

                System.out.print("Enter the Dividend: ");
                dividend = Integer.parseInt(in.nextLine());
                System.out.print("Enter the Divisor: ");
                divisor = Integer.parseInt(in.nextLine());

                System.out.println(divide(dividend, divisor));
            } else if (program == 4) {
                System.out.print("Enter a String: ");
                System.out.println(find(in.nextLine()));
            } else if (program == 5) {
                String s;
                char c;

                System.out.print("Enter a String: ");
                s = in.nextLine();
                System.out.print("Enter a Character: ");
                c = in.nextLine().charAt(0);

                System.out.println(insert(s, c));
            } else if (program == 6) {
                System.out.print("Enter an Integer: ");
                System.out.println(commas(Integer.parseInt(in.nextLine())));
            } else {
                System.out.println(largest(ia, 1, 1, 0)); // DO NOT alter parameters
            }

            System.out.println("");
            while (true) {
                System.out.print("Run another program?: ");
                runInput = in.nextLine();

                if (runInput.equalsIgnoreCase("y")) {
                    break;
                } else if (runInput.equalsIgnoreCase("n")) {
                    run = false;
                    break;
                } else {
                    System.out.print("Invalid input. ");
                }
            }

        }
        in.close();

    }
}
