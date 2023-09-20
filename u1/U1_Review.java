package u1;

import java.util.Scanner; // Scanner: easy/convenient, SLOW FOR LARGE FILES
import java.io.*; // BufferedReader: fast, ONLY READS STRINGS

public class U1_Review {
    public static void main(String[] args) {

        // USER INPUT (Scanner and BufferedReader)
        Scanner in = new Scanner(System.in);
        in.nextLine();
        in.close();

        try {
            BufferedReader in1 = new BufferedReader(new InputStreamReader(System.in));
            in1.readLine();
            in1.close();
        } catch (IOException e) {
            System.out.println("IOException occurred.");
        }

        try {
            throw new NumberFormatException("and i oop");
        } catch (NumberFormatException e) {
            System.out.println("yo");
        }

        // StringBuilder
        // String hello = "hello";
        StringBuilder st = new StringBuilder();
        st.append("1234567890123456");
        System.out.println(st.capacity());
        st.append("1");
        System.out.println(st.capacity());
        System.out.println("poo");
    }
}
