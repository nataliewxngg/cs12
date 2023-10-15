// Natalie Wong
// Due Monday, October 16, 2023

// Assignment #3: OOP: Nintendo Switch Games Assignment
// This program will input a list of Nintendo games from a txt file and allow the user to search for games by title or type

package u2.assignment1;

import java.util.*;
import java.io.*;

public class Main {

    // binarySearch algorithm (recursive approach) - to search case insensitively
    // for game titles
    public static int binarySearch_Name(ArrayList<Games> games, String key, int left, int right) {
        int mid = (left + right) / 2;

        // If key is not found in the ArrayList, return the "-insertion point"
        if (left > right)
            return -left - 1;

        // If key is found in the ArrayList, return the index of the key in the
        // ArrayList
        if (key.equalsIgnoreCase(games.get(mid).name))
            return mid;

        // If key is less than the current games' name (ie. A<Z, A<E, J>B, etc.),
        // readjust the right index to mid-1 and call binarySearch again so it only
        // checks the LEFT SIDE of mid in the ArrayList
        else if (key.toLowerCase().compareTo(games.get(mid).name.toLowerCase()) < 0) {
            return binarySearch_Name(games, key, left, mid - 1);
        }
        // Otherwise, if key is greater than the current games' name, readjust the left
        // index to mid+1 and call binarySearch again so it only checks the RIGHT SIDE
        // of mid in the ArrayList
        else
            return binarySearch_Name(games, key, mid + 1, right);
    }

    // binarySearch algorithm (iterative approach) - to find the FIRST OCCURRENCE of
    // a game's rating
    public static int binarySearch_Rating(ArrayList<Games> games, double key, int left, int right) {
        // {0.001, 8.6, 8.75, 8.8, 8.9, 8.9, 8.9, 8.98, 9.1, 9.19, 9.25, 9.25, 9.3, 9.4,
        // 9.5, 9.75}

        // mincraft - ranked 10 of 16

        Collections.sort(games, new SortByRating());

        while (left <= right) {
            int mid = (left + right) / 2;

            // Instead of returning mid right when key is found, keep searching towards the
            // left to find the FIRST occurrence
            if (key == games.get(mid).rating) {
                while (key == games.get(mid).rating) {
                    mid--;
                }
                return mid + 1;
            }

            else if (key > games.get(mid).rating) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -left - 1;
    }

    public static void main(String[] args) throws IOException {
        // Variables
        ArrayList<Games> games = new ArrayList<>();
        String line;

        double rating;
        String name;
        String type;

        String searchBy = "";
        String userLine = "";

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

            // if Array is empty: automatically exit
            if (games.size() == 0)
                System.out.println("You own 0 games... :( Automatically exiting.");

            // Otherwise, prompt user:
            else {
                Scanner userIn = new Scanner(System.in);

                // While searchBy is not "exit":
                while (!searchBy.equalsIgnoreCase("exit")) {
                    System.out.print("\nSearch by game, type, or exit?: ");
                    searchBy = userIn.nextLine().strip();

                    // Break if user exits from searchBy prompt
                    if (searchBy.equalsIgnoreCase("exit")) {
                        break;
                    }

                    // If user SEARCHES BY GAME, continuously prompt for game name until "exit" -
                    // which returns back to prompting for searchBy
                    while (searchBy.equalsIgnoreCase("game")) {
                        System.out.print("\nEnter a game or exit: ");
                        userLine = userIn.nextLine().strip();

                        int indexOfGame;

                        if (userLine.equalsIgnoreCase("exit"))
                            break;
                        else {
                            // Sort games alphabetically and search for the inputted game name (case
                            // insensitive)
                            Collections.sort(games);

                            // Search for index of game
                            indexOfGame = binarySearch_Name(games, userLine, 0, games.size() - 1);

                            // Game not found in list - goes back to prompting for game titles
                            if (indexOfGame < 0) {
                                System.out.println("You don't own this game :(\n");
                            }
                            // If the game is found in the list, display the statistics for the game
                            else {
                                System.out.print(games.get(indexOfGame));

                                // Display the ranking of the game
                                System.out.println(
                                        "Ranking: " + (binarySearch_Rating(games, games.get(indexOfGame).rating, 0,
                                                games.size() - 1) + 1) + " out of " + games.size());
                            }
                        }
                    }

                    // If user SEARCHES BY TYPE, continuously prompt for type until "exit" -
                    // which returns back to prompting for searchBy
                    while (searchBy.equalsIgnoreCase("type")) {
                        System.out.println("SEARCH BY TYPE");
                        System.out.print("Enter a type or exit: ");
                        userLine = userIn.nextLine();

                        if (userLine.equalsIgnoreCase("exit")) {
                            break;
                        } else {
                            // EDIT HERE
                            System.out.println("display the games here");
                        }
                    }

                    if (!searchBy.equalsIgnoreCase("type") && !searchBy.equalsIgnoreCase("game")
                            && !searchBy.equalsIgnoreCase("exit"))
                        System.out.print("Invalid input. ");
                }

                // User enters "exit" on enterBy prompt
                userIn.close();
            }

            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not Found.");
        }
    }
}
