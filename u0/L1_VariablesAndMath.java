package u0;

import java.util.Scanner;

public class L1_VariablesAndMath {
    public static void main(String[] args) {
        // Variables
        int jerseyNum;
        double benchTime;

        // Primitive data types (has an ASCII value; CANNOT be null)
        int age = 17;
        double date = 9.5;
        char poor = 'u';
        boolean imRicher = true;

        // Non-primitive data types (takes up a RAM location; CAN be null)
        String name = "Natalie Wong";
        int[] timestamp = { 2023, 9, 5, 5, 45 };
        int[][] birthdays = { { 1, 11 }, { 3, 4 }, { 5, 9 }, { 5, 31 } };

        // Change variable type example (with scanner)
        Scanner in = new Scanner(System.in);
        System.out.print("What is your jersey number? ");
        jerseyNum = Integer.parseInt(in.nextLine()); // converts string to integer
        System.out.print("How many minutes were u on bench last game? ");
        benchTime = Double.parseDouble(in.nextLine());

        System.out.printf("Player %d was benched for %.2f minutes last game.", jerseyNum, benchTime);

        // Terminating variables
        in.close();
    }
}
