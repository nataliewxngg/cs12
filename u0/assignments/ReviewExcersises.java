package u0.assignments;

import java.util.Scanner;

public class ReviewExcersises {
    public static void main(String[] args) {

        // 1
        // Variables
        // Scanner in = new Scanner(System.in);

        // double base;
        // double height;

        // System.out.print("Enter the base of the triangle: ");
        // base = Double.parseDouble(in.nextLine());
        // while (base < 0) {
        // System.out.print("Invalid base. Enter again: ");
        // base = Double.parseDouble(in.nextLine());
        // }
        // System.out.print("Enter the height of the triangle: ");
        // height = Double.parseDouble(in.nextLine());
        // while (height < 0) {
        // System.out.print("Invalid height. Enter again: ");
        // height = Double.parseDouble(in.nextLine());
        // }

        // System.out.printf("The length of the hypoteneuse is %.2f%n",
        // Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2)));

        // // Terminating Variables
        // in.close();

        // 2
        // Variables
        // Scanner in = new Scanner(System.in);
        // double num1;
        // double num2;
        // double num3;
        // double num4;
        // double num5;

        // // Main Code
        // System.out.print("Enter a number");
        // num1 = Double.parseDouble(in.nextLine());
        // System.out.print("Enter a number");
        // num2 = Double.parseDouble(in.nextLine());
        // System.out.print("Enter a number");
        // num3 = Double.parseDouble(in.nextLine());
        // System.out.print("Enter a number");
        // num4 = Double.parseDouble(in.nextLine());
        // System.out.print("Enter a number");
        // num5 = Double.parseDouble(in.nextLine());

        // System.out.printf("The average is %.2f", (num1 + num2 + num3 + num4 + num5) /
        // 5);
        // System.out.printf("The highest number entered is %.2f",
        // Math.max(Math.max(Math.max(num1, num2), Math.max(num2, num3)), Math.max(num3,
        // num4)),
        // Math.max(num4, num5));

        // // Terminating Variables
        // in.close();

        // 3
        // Variables
        // Scanner in = new Scanner(System.in);
        // String str = "";

        // // Main Code
        // System.out.print("Enter a sentence/word: ");
        // str = in.nextLine();

        // if (str.length() % 2 == 0) {
        // for (int i = 0; i < str.length(); i += 2) {
        // System.out.println(str.charAt(i));
        // }
        // } else {
        // for (int i = 1; i < str.length(); i += 2) {
        // System.out.println(str.charAt(i));
        // }
        // }

        // // Terminating Variables
        // in.close();

        // 4
        // Variables
        // Scanner in = new Scanner(System.in);
        // String word;
        // String palindrome = "";

        // // Main Code
        // System.out.print("Enter a word: ");
        // word = in.nextLine();

        // for (int i = word.length() - 1; i >= 0; i--) {
        // palindrome += word.charAt(i);
        // }
        // if (word.equalsIgnoreCase(palindrome)) {
        // System.out.println("This is a palindrome.");
        // } else {
        // System.out.println("This is NOT a palindrome.");
        // }

        // // Terminating Variable
        // in.close();

        // 5
        // Variables
        String[] translations = { "zero ", "one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ",
                "nine " };
        Scanner in = new Scanner(System.in);
        String num;
        String singleNum = "";
        int convertedNum;
        String phrase = "";

        // Main Code
        System.out.print("Enter a number: ");
        num = in.nextLine();

        for (int i = 0; i < num.length(); i++) {
            singleNum += num.charAt(i);
            convertedNum = Integer.parseInt(singleNum);

            phrase += translations[convertedNum];

            singleNum = "";
            convertedNum = 0;
        }

        System.out.println(phrase);

        // Terminating Variables
        in.close();
    }
}
