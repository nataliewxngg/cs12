package u1;

public class L6_RecursionPractice {
    public static String convert(int num) {
        if (num >= 0) {
            if (num == 0)
                return "";
            else if (num % 2 == 0)
                return convert(num / 2) + "0";
            else
                return convert(num / 2) + "1";
        }

        else {
            if (num % 2 == 0)
                return convert(num / 2) + "1";
            else
                return convert(num / 2) + "0";
        }
    }

    public static void main(String[] args) {
        System.out.println(convert(123));
        System.out.println(convert(-123));
    }
}
