package u1;

import java.util.*;

public class L5_StringTokenizer {
    public static void main(String[] args) {

        // 1. Using a while loop, print all the tokens from a StringTokenizer
        // String s = "I am 10 years old.";
        // StringTokenizer st = new StringTokenizer(s);

        // while (st.hasMoreTokens()) {
        // System.out.println(st.nextToken());
        // }

        // // 2. Same as 1, but using a for loop
        // StringTokenizer st2 = new StringTokenizer(s);
        // int numOfTokens = st2.countTokens();

        // // i = 0; i < 5; i++
        // for (int i = 0; i < numOfTokens; i++) {
        // System.out.println(st2.nextToken());
        // }

        String s1 = "kkk";
        String[] list = s1.split("k");
        for (int i = 0; i < list.length; i++) {
            System.out.println("");
        }
        System.out.println("poo");

    }
}
