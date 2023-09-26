package u1.assignments.recursionExercises;

public class test {
    // Program 3: Divide
    public static int divide(int dividend, int divisor) {
        if (dividend <= divisor && dividend >= divisor / 2) {
            return 1;
        } else if (dividend <= divisor && dividend < divisor / 2) {
            return 0;
        }
        return divide(dividend - divisor, divisor) + 1;
    }

    public static void main(String[] args) {
        System.out.println(divide(1, -2));
    }
}
