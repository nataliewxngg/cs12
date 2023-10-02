package u0;

import java.math.BigInteger;

public class test {

    // returns n! (n factorial)
    public static int factorial(int n) {
        if (n == 1)
            return 1;
        return n * factorial(n - 1);
    }

    // returns a string reversed with asterisks in between
    public static String backStars(String s) {
        if (s.length() == 1)
            return s;
        return s.charAt(s.length() - 1) + "*" + backStars(s.substring(0, s.length() - 1));
    }

    // converts a given # to binary (negative - bits are flipped only)
    public static String convert(int num) {
        if (num == 0)
            return "";
        if (num > 0) {
            if (num % 2 == 0)
                return convert(num / 2) + "0";
            return convert(num / 2) + "1";
        } else {
            if (num % 2 == 0)
                return convert(num / 2) + "1";
            return convert(num / 2) + "0";
        }
    }

    // returns a string of characters all in uppercase
    public static String scream(char c, int times) {
        if (times == 1) {
            return Character.toString(c).toUpperCase();
        }
        return Character.toString(c).toUpperCase() + scream(c, times - 1);
    }

    // returns true if sentence is a palindrome of words
    public static boolean palinWords(String s) {
        if (s.indexOf(" ") < 0)
            return true;

        if (!(s.substring(0, s.indexOf(" ")).equalsIgnoreCase(s.substring(s.lastIndexOf(" ") + 1, s.length()))))
            return false;

        return palinWords(s.substring(s.indexOf(" ") + 1, s.lastIndexOf(" ")));
    }

    public static void main(String[] args) {
        BigInteger first = new BigInteger("+000012345");
        BigInteger second = BigInteger.valueOf(-0012345);

        System.out.println(first.equals(second));
        System.out.println(first.pow(2));

        System.out.println(first.compareTo(second));
        System.out.println(first.toString());

        BigInteger one = new BigInteger("9");
        BigInteger two = BigInteger.valueOf(2);

        System.out.println(one.compareTo(two));

        // Recursions
        System.out.println(factorial(4));
        System.out.println(backStars("hello"));
        System.out.println(convert(123));
        System.out.println(scream('f', 4));
        System.out.println(palinWords("apple kiwi mango"));
        System.out.println(palinWords("apple kiwi orange kiwi APPLE"));
        System.out.println(palinWords("apple"));
    }
}
