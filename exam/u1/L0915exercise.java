package exam.u1;

import java.util.*;
import java.io.*;

public class L0915exercise {
    public static void main(String[] args) {

        // 1.
        StringBuilder out = new StringBuilder();

        try {
            BufferedReader in = new BufferedReader(new FileReader("input.txt"));
            String s;

            while ((s = in.readLine()) != null) {
                out.append(s.charAt(0));
            }

            in.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }

        System.out.println(out.toString().toUpperCase());

        // 2.
        StringBuilder shift = new StringBuilder("natalie");
        int n = 2;
        for (int i = 0; i < n; i++) {
            shift.insert(0, shift.charAt(shift.length() - 1));
            shift.deleteCharAt(shift.length() - 1);
        }
        System.out.println(shift);
    }

}
