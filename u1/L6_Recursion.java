package u1;

public class L6_Recursion {
    // Write a recursive method that takes a String and it
    // reverses the letters in the string

    // Add to this such that you are inserting a dash between every letter
    // ie. computer --> r-e-t-u-p-m-o-c

    public static String reverse(String s) {
        if (s.length() == 1)
            return s;
        return s.charAt(s.length() - 1) + "-" + reverse(s.substring(0, s.length() - 1));
    }

    public static int fact(int n) {
        // base case (stopping condition)
        if (n == 1)
            return n;
        return n * fact(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(fact(5));
        System.out.println(reverse("hello"));
    }
}
