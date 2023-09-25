package recursionExercises;

public class test {
    // Program 3: Divide
    public static int divide(int dividend, int divisor) {
        if (dividend < divisor)
            return (int) (Math.round(((dividend * 1.0) / divisor))); // 0 divided by anything is UNDEFINED
        // anything divided by 0 is ZERO

        return divide(dividend - divisor, divisor) + 1;
    }

    public static void main(String[] args) {
        System.out.println(divide(-1, 2));
    }
}
