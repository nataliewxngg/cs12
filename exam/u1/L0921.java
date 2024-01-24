package exam.u1;

public class L0921 {
    // factorial
    public static int factorial(int n) {
        if (n == 1)
            return 1;

        return n * factorial(n - 1);
    }

    // asterisks
    public static String why(String s) {
        if (s.length() == 1)
            return s;

        return s.charAt(s.length() - 1) + "*" + why(s.substring(0, s.length() - 1));
    }

    public static void main(String[] args) {
        System.out.println(factorial(4)); // 24
        System.out.println(why("natalie"));
    }
}
