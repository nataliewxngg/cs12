package u1;

import java.io.*;

public class study1 {
    public static void main(String[] args) {
        try {
            PrintWriter out = new PrintWriter(new FileWriter("studyOutput.txt", true));
            out.println("bruh");
            out.println("wahwahwah");

            out.close();
        } catch (IOException e) {
            System.out.println("Writing error");
        }

    }
}
