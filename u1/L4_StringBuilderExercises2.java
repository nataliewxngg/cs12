package u1;

import java.util.Scanner;
import java.io.*;

public class L4_StringBuilderExercises2 {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new File("input.txt"));
            String s;
            StringBuilder firstLetters = new StringBuilder();

            while (in.hasNextLine()) {
                s = in.nextLine();
                firstLetters.append(s.charAt(0));
            }

            System.out.println(firstLetters.toString().toUpperCase());
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found");
        } catch (IOException e) {
            System.out.println("Reading Error");
        }
    }
}
