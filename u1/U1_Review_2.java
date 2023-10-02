package u1;

import java.util.Scanner;
import java.io.*;

public class U1_Review_2 {
    public static void main(String[] args) {
        // 2. Input from keyboaard and file using Scanner/BufferedReader
        // Output using .println() or PrintWriter

        // INPUT:
        // Scanner - :) easy/convenient to use, :( slower for large files
        // BufferedReader - :) faster, :( only reads in Strings

        // from keyboard:

        // import java.util.Scanner;
        Scanner in = new Scanner(System.in);
        System.out.print("What is your favorite color?: ");
        String favColor = in.nextLine();
        System.out.println("I like " + favColor.trim() + " too!");
        in.close();

        // import java.io.*;
        try {
            BufferedReader in1 = new BufferedReader(new InputStreamReader(System.in));
            // System.out.print("What is your favorite color?: ");
            // favColor = in1.readLine(); <-- *****READLINE
            // System.out.println("I love " + favColor.trim() + " more too!");
            in1.close();
        } catch (IOException e) { // BUFFEREDREADER MUST**** HANDLE IOEXCEPTION!
            System.out.println("Reading error");
        }

        // from file:

        // import java.util.Scanner;
        // import java.io.*;

        try {
            Scanner in2 = new Scanner(new File("study.txt"));
            while (in2.hasNextLine()) {
                System.out.println(in2.nextLine());
            }
            in2.close();
        } catch (FileNotFoundException e) { // SCANNER ***MUST CHECK FOR FILENOTFOUNDEXCEPTION!
            System.out.println("File was Not Found");
        }

        // import java.io.*;
        try {
            BufferedReader in3 = new BufferedReader(new FileReader("study.txt"));
            String s;

            while ((s = in3.readLine()) != null) {
                System.out.println(s);
            }
            in3.close();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found :(");
        } catch (IOException e) { // BUFFEREDREADER ***MUST CATCH IOEXCEPTION
            System.out.println("Reading error");
        }

        // AS A RULE OF THUMB, ALWAYS CATCH IOEXCEPTION WITH BUFFEREDREADER AND NEVER
        // WITH SCANNER

        // Writing to files
        // import java.io.*;
        try {
            PrintWriter out = new PrintWriter(new FileWriter("studyOutput.txt", true));
            out.println("i hate studying");
            out.println(":)");
            out.close();
        } catch (IOException e) { // PRINTWRITER ***MUST CATCH IOEXCPETION
            System.out.println("Writing error");
        }
    }
}
