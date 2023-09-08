package u0;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("enter a number");
        in.nextInt();

        System.out.println("enter a word");
        in.nextLine(); // will be skipped because nextInt(); used before nextLine();

        // avoid this from happening by using separate scanners for nextInt() and
        // nextLine()
        // or consider using .nextLine() only then converting/casting later

        // in.close();
    }
}
