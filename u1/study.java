package u1;

import java.io.*;

public class study {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("input.txt"));
            String s;

            while ((s = in.readLine()) != null) {
                System.out.println(s);
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e);
        } catch (IOException e) {
            System.out.println("Reading Error");
        }
    }
}
