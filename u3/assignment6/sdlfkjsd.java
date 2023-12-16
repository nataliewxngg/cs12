package u3.assignment6;

import java.util.*;
import java.io.*;

public class sdlfkjsd {
    public static void main(String[] args) throws IOException {
        BufferedReader inputFile = new BufferedReader(new FileReader("contractions.txt"));
        String s;
        while ((s = inputFile.readLine()) != null) {
            System.out.println(s.toLowerCase());
        }
        inputFile.close();
    }
}
