package u1;

import java.util.Scanner;

public class U1_Review_3 {
    public static void main(String[] args) throws NumberFormatException {
        // 3. You should understand how Exceptions work

        // a. using try and catch statements
        // - prevents an unusual situation/error (exception) to crash/terminate your
        // program
        // - there are multiple exceptions applicable
        // - error checks non-int inputs

        // eg.
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter your age: ");
            int age = Integer.parseInt(in.nextLine());

            in.close(); // <-- close before throwing a potential exception

            if (age < 0 || age > 110) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid age!");
        }

        // b. checked and unchecked exceptions

        // UNCHECKED EXCEPTIONS:
        // - exceptions that you are NOT forced to handle
        // - subclasses of the RuntimeException
        // - eg. NumberFormatException, ArithmeticException, indexOutOfBoundsException

        // CHECKED EXCEPTIONS:
        // - exceptions you MUST handle
        // - not subclasses of the RuntimeException
        // - eg. IOException and FileNotFoundException

        // c. Throwing vs. catching exceptions

        // 1. Catching the exception (try and catch) --> allows the program to continue
        // even after an exception

        // 2. Catching the exception
        // a) in the method header
        // - will terminate the program (NOT crash)
        // - must add throws statement to all calling methods
        // * MOST COMMON FOR IOEXCEPTION

        // b) within the code
        // - when you wish to force a program to stop/terminate
        // - can include String parameter to display

        // eg.
        // public static void main(String[] args) throws NumberFormatException
        Scanner in = new Scanner(System.in);
        System.out.print("Age: ");
        int age = Integer.parseInt(in.nextLine());
        in.close();

        if (age < 0 || age > 110) {
            throw new NumberFormatException("bruh"); // will display
        }

        // public static void main(String[] args) throws NumberFormatException
        try {
            Scanner in1 = new Scanner(System.in);
            System.out.println("Age: ");
            int age1 = Integer.parseInt(in1.nextLine());

            in1.close();

            if (age1 < 0 || age1 > 110)
                throw new NumberFormatException("asdlkfjaslsdkfjasldjk"); // will not display, will go into catch
        } catch (NumberFormatException e) {
            System.out.println("Invalid age");
        }

        // d. catching multiple exceptions
        // **RULE: CATCH THE MOST TO LEAST SPECIFIC EXCEPTION

    }
}
