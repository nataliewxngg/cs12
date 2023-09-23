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
            if (n % 2 == 0) // Even
                return Math.round(((1.0 / Math.abs(n)) + sumDiff(n - 2)) * 100000.0) / 100000.0;
            else { // Odd
                if (n == 1)
                    return 1.0;
                return Math.round(((1.0 / Math.abs(n)) * sumDiff(n - 2)) * 100000.0) / 100000.0;
            }
        } else { // Negative
            if (n % 2 == 0) // Even
                return Math.round(((1.0 / Math.abs(n)) * sumDiff(n + 2)) * 100000.0) / 100000.0;
            else { // Odd
                if (n == -1)
                    return 1.0;
                return Math.round(((1.0 / Math.abs(n)) + sumDiff(n + 2)) * 100000.0) / 100000.0;
            }
        }

        // odd - product
        // even - add
        // negative num - switch operations
    }

    // Program 3: divide()
    public static int divide(int dividend, int divisor) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(fangs(-10)); // 0
        System.out.println(fangs(0)); // 0
        System.out.println(fangs(4)); // 10

        System.out.println(sumDiff(-7)); // 1.67619
        System.out.println(sumDiff(-6)); // 0.02083
    }
}
