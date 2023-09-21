package u1;

import java.util.Scanner;
import java.io.*;

public class L3_MultipleExceptions {
    public static void main(String[] args) {
        try {

        } catch (Exception e) { // includes ALL exception
            // NOT good practice
        }

        try {
            Scanner in = new Scanner(new File("input.txt"));
        } catch (IOException e) {

        }
        // catch (FileNotFound e) { // will NOT work as FileNotFound class is under
        // IOException
        // }

        // if catching multiple exceptions, make sure you catch the most specific one
        // first, and the most exception at last
    }
}
