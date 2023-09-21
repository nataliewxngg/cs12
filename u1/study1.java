package u1;

import java.util.Scanner;
import java.io.*;

public class study1 {
    public static void main(String[] args) {
        // Scanner - USER INPUT
        Scanner in = new Scanner(System.in);
        in.close();

        // BufferedReader - USER INPUT
        try {
            BufferedReader in1 = new BufferedReader(new InputStreamReader(System.in));
            in1.close();
        } catch (RuntimeException e) {
            System.out.println("Reading Error");
        } catch (IOException e) {
            System.out.println("ooh");
        }
    }
}
