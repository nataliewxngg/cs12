// Natalie Wong
// Due Monday, October 16, 2023

// Assignment #3: OOP: Nintendo Switch Games Assignment
// This program will 

package u2.assignment1;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Variables
        ArrayList<Games> games = new ArrayList<>();
        String line;

        double rating;
        String name;
        String type;

        // Inputting from txt file
        try {
            // Input line
            BufferedReader in = new BufferedReader(new FileReader("input.txt"));

            // For each line:
            while ((line = in.readLine()) != null) {

                // Separate into rating, name, and type
                line = line.strip();
                StringTokenizer st = new StringTokenizer(line);

                if (st.countTokens() >= 3) {
                    try {
                        // Rating
                        rating = Double.parseDouble(st.nextToken());
                        if (rating < 0 || rating > 10)
                            throw new NumberFormatException();

                        // Name
                        name = line.substring(line.indexOf(" ") + 1, line.lastIndexOf(" "));

                        // Type
                        type = line.substring(line.lastIndexOf(" ") + 1);

                        // Create Games object for each line
                        games.add(new Games(rating, name, type));

                    } catch (NumberFormatException e) {
                        System.out.println(line + " skipped: Invalid rating");
                    }
                } else { // has LESS THAN 3 tokens (improper inputs)
                    System.out.println(line + " skipped: Invalid # of input fields");
                }
            }

            // Print Array of games
            System.out.println(games);

            // if Array is empty: automatically exit
            if (games.size() == 0)
                System.out.println("You own 0 games :( Automatically exiting...");
            // Otherwise, prompt user:
            else {
                // Input from user (game name, type, or exit) - CASE INSENSITIVE:
                System.out.println("SDKJFSDKJHFLK");
            }

            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not Found.");
        }
    }
}
