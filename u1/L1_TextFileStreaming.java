package u1;

import java.util.Scanner;
import java.io.*;

public class L1_TextFileStreaming {
    public static void main(String[] args) {

        // Try and catch, unlike throws IOException, will continue running the code even
        // if the try {} condition could not be met
        // (whereas throws IOException will stop the entire program)
        try {
            BufferedReader in = new BufferedReader(new FileReader("input.txt"));

            String line = in.readLine();
            System.out.println(line);

            System.out.println(line);

            // Terminating Variables
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e);
        } catch (IOException e) {
            System.out.println("Reading Error");
        }

        System.out.println("HAHAHFHAHAHA");

        // Writing to files
        try {
            PrintWriter out = new PrintWriter(new FileWriter("u1/blablbla.txt", true));
            // true indicates the append flag (will add to file instead of erasing)
            out.println("hhahahahahhahahaha");
            out.println("lalalalala");

            out.close();
        } catch (IOException e) {
            System.out.println("wRITING ERROr");
        }
    }
}
