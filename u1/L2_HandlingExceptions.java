package u1;

import java.util.Scanner;
import java.io.*;

public class L2_HandlingExceptions {

    // Exception: An object that gives information on an UNUSUAL event that has
    // occurred

    // Unchecked exceptions:
    // An exception you are NOT forced to "handle"
    // Includes subclasses of the RuntimeException

    // Checked exceptions:
    // An exception you MUST "handle"
    // Any exceptions that are NOT subclasses of the RuntimeException

    // Method 1: Using try and catch
    // public static void main(String[] args) {
    // int age;
    // try {
    // Scanner in = new Scanner(System.in);
    // System.out.print("What is your age?: ");
    // age = Integer.parseInt(in.nextLine());

    // in.close();
    // } catch (NumberFormatException e) {
    // System.out.println("Invalid input");
    // }
    // }

    // Method 2: Within the code
    // public static void main(String[] args) {
    // int age;
    // try {
    // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    // System.out.print("What is your age?: ");
    // age = Integer.parseInt(in.readLine());

    // if (age < 0 || age > 110) {
    // throw new NumberFormatException();
    // }

    // in.close();
    // } catch (NumberFormatException e) {
    // System.out.println("Invalid age");
    // } catch (IOException e) {
    // System.out.println("Invalid input");
    // }
    // }

    // public static void main(String[] args) throws NumberFormatException {
    // throw new NumberFormatException("This will be displayed too!!!!");
    // }
}
