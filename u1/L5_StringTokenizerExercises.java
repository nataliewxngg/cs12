package u1;

import java.util.*;

public class L5_StringTokenizerExercises {
    public static void main(String[] args) {
        String line = "March break is in three weeks!!";
        String[] words = line.split("e");

        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }

        String line1 = "To be or not to be, that is the question.";

        StringTokenizer tokens = new StringTokenizer(line1, "sbi", true);
        while (tokens.hasMoreTokens()) {
            System.out.println(tokens.nextToken());
        }

        // 1. Write a program that finds the longest word in a sentence (Keep in mind
        // that punctuation should not be included as part of a word.)
        Scanner in = new Scanner(System.in);
        String sentence;
        String longestWord = "";
        String word;

        System.out.print("Enter a sentence: ");
        sentence = in.nextLine();

        StringTokenizer st = new StringTokenizer(sentence, " ,.");

        while (st.hasMoreTokens()) {
            word = st.nextToken();

            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        System.out.println("The longest word is " + longestWord + ".");

        in.close();

        // 2. Write a program that reads in a mathematical expression (of any length).
        // The expression only consists of number and these operations: +, -, x, /, %
        // (no brackets). Evaluate the expression.
        Scanner in1 = new Scanner(System.in);
        String exp;
        double result;
        String op;

        System.out.print("Enter your mathematical expression: ");
        exp = in1.nextLine();
        StringTokenizer expt = new StringTokenizer(exp, "+-x/%", true);

        // 5+2+3

        result = Double.parseDouble(expt.nextToken()); // 5
        System.out.println(result);

        while (expt.hasMoreTokens()) {
            op = expt.nextToken();

            if (op.equals("+"))
                result += Double.parseDouble(expt.nextToken());
            else if (op.equals("-"))
                result -= Double.parseDouble(expt.nextToken());
            else if (op.equals("x"))
                result *= Double.parseDouble(expt.nextToken());
            else if (op.equals("/"))
                result /= Double.parseDouble(expt.nextToken());
            else {
                result %= Double.parseDouble(expt.nextToken());
            }
        }
        System.out.println(result);

        in1.close();
    }
}
