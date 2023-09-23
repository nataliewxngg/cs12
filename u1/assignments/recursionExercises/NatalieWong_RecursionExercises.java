// Natalie Wong - Recursion Exercises
// Due September 26, 2023

package recursionExercises;

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
        if (((dividend * 1.0) / divisor) < 0.5)
            return 0; // 0 divided by anything is UNDEFINED
                      // anything divided by 0 is ZERO

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

        // convert to string first then do it backwards
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

    // Program 7: largest
    public static int largest(int[] ia) {
        if (ia.length == 1)
            return ia[0];

    }

    public static void main(String[] args) {

        // Test Cases

        // Program 1
        System.out.println(fangs(-10)); // 0
        System.out.println(fangs(0)); // 0
        System.out.println(fangs(1)); // 3
        System.out.println(fangs(4)); // 10

        System.out.println("---------------------------");

        // Program 2
        System.out.println(sumDiff(-7)); // 1.67619
        System.out.println(sumDiff(-6)); // 0.02083

        System.out.println("---------------------------");

        // Program 3
        System.out.println(divide(18, 6)); // 3
        System.out.println(divide(20, 3)); // 7
        System.out.println(divide(25, 6)); // 4
        System.out.println(divide(2, 3)); // 1
        System.out.println(divide(1, 2)); // 1

        System.out.println("---------------------------");

        // Program 4
        System.out.println(find("")); // 0
        System.out.println(find("alsdkjfalkdsjfasdklfj")); // 0
        System.out.println(find("HarrY pOTTEr!?!")); // 10
        System.out.println(find("HELLOxx!!")); // 7

        System.out.println("---------------------------");

        // Program 5
        System.out.println(insert("bruh", '!')); // bruh
        System.out.println(insert("jiggly", '!')); // jig!gly
        System.out.println(insert("jig?gly puffy", '@')); // jig?gly puffy
        System.out.println(insert("aaAA", '.')); // a.a.A.A
        System.out.println(insert("rilaaaaakkum?????????][[21?ma", '.')); // rila.a.a.a.ak.kum.ma

        System.out.println("---------------------------");

        // Program 6
        System.out.println(commas(0)); // 0
        System.out.println(commas(9)); // +9
        System.out.println(commas(123456)); // +123,456

        System.out.println(commas(-2)); // -2
        System.out.println(commas(-9876)); // -9,876

        System.out.println("---------------------------");

        // Program 7
        System.out.println();
    }
}
