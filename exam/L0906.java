package exam;

import java.util.Scanner;
import java.io.*;

public class L0906 {
    public static void main(String[] args) {

        // scanner
        try {
            Scanner in = new Scanner(new File("album1.txt"));

            while (in.hasNextLine())
                System.out.println(in.nextLine());

            in.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        // bufferedreader
        try {
            BufferedReader in = new BufferedReader(new FileReader("album1.txt"));
            String s;

            while ((s = in.readLine()) != null)
                System.out.println(s);

            in.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

        // checking non-ints
        try {
            Scanner in = new Scanner(new File("album1.txt"));
            while (in.hasNextLine())
                System.out.println(Integer.parseInt(in.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println(e);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        // printwriter
        try {
            PrintWriter out = new PrintWriter(new FileWriter("hihi.txt"));
            out.println("hi");
            out.println("bro");
            out.close();
        } catch (IOException e) {
            System.out.println("writing error");
        }
    }
}
