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

    // binarySearch algorithm (iterative approach) - to find the ranking of a game
    // given its ranking
    public static int binarySearch_Rating(ArrayList<Games> games, double key, int left, int right) {

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

    // binarySearch algorithm (recursive approach) - to search case insensitively
    // for game types
    public static int binarySearch_Type(ArrayList<Games> games, String key, int left, int right) {
        int mid = (left + right) / 2;

        if (left > right)
            return -left - 1;

        if (key.equalsIgnoreCase(games.get(mid).type))
            return mid;
        else if (key.toLowerCase().compareTo(games.get(mid).type.toLowerCase()) < 0) {
            return binarySearch_Type(games, key, left, mid - 1);
        } else
            return binarySearch_Type(games, key, mid + 1, right);
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
                        else if (userLine.length() > 0) {
                            // Sort games alphabetically and search for the inputted game name (case
                            // insensitive)
                            Collections.sort(games);

                            // Search for index of game
                            indexOfGame = binarySearch_Name(games, userLine, 0, games.size() - 1);

                            // Game not found in list - goes back to prompting for game titles
                            if (indexOfGame < 0) {
                                System.out.println("You don't own this game :(");
                            }
                            // If the game is found in the list, display the statistics for the game
                            else {
                                System.out.print(games.get(indexOfGame));

                                // Display the ranking of the game
                                System.out.println(
                                        "Ranking: " + (binarySearch_Rating(games, games.get(indexOfGame).rating, 0,
                                                games.size() - 1) + 1) + " out of " + games.size());
                            }
                        } else {
                            System.out.print("\nInvalid input.");
                        }

                    }

                    // If user SEARCHES BY TYPE, continuously prompt for type until "exit" -
                    // which returns back to prompting for searchBy
                    while (searchBy.equalsIgnoreCase("type")) {
                        System.out.print("\nEnter a type or exit: ");
                        userLine = userIn.nextLine().strip();

                        if (userLine.equalsIgnoreCase("exit")) {
                            break;
                        } else if (userLine.length() > 0) {
                            // Sort games by type and search for the inputted type (case insensitive) -
                            // search for the FIRST occurrence

                            ArrayList<Games> gamesEdited = new ArrayList<>(games); // used to remove all instances of
                                                                                   // the games with the same types
                            Collections.sort(gamesEdited, new SortByType());

                            int indexOfGame = binarySearch_Type(gamesEdited, userLine, 0, gamesEdited.size() - 1);

                            if (indexOfGame < 0) {
                                System.out.println("You don't own a game of this type :(");
                            } else {
                                ArrayList<Games> gamesInType = new ArrayList<>(); // only has games of the inputted type

                                // Add all other games with the same type into the gamesInType ArrayList
                                do {
                                    gamesInType.add(gamesEdited.get(indexOfGame));
                                    gamesEdited.remove(indexOfGame);
                                    indexOfGame = binarySearch_Type(gamesEdited, userLine, 0,
                                            gamesEdited.size() - 1);
                                } while (indexOfGame >= 0);

                                Collections.sort(gamesInType); // Sort the games with the same type by their names in
                                                               // alphabetical order
                                                               // check

                                // Display all the games in gamesInType
                                Collections.sort(games);

                                for (int game = 0; game < gamesInType.size(); game++) {
                                    System.out.print(gamesInType.get(game));

                                    // Display the ranking of the game
                                    System.out.println("Ranking: "
                                            + (binarySearch_Rating(games, gamesInType.get(game).rating, 0,
                                                    games.size() - 1) + 1)
                                            + " out of " + games.size());
                                }
                            }
                        } else {
                            System.out.print("\nInvalid input.");
                        }
                    }

                    if (!searchBy.equalsIgnoreCase("type") && !searchBy.equalsIgnoreCase("game")
                            && !searchBy.equalsIgnoreCase("exit"))
                        System.out.print("\nInvalid input.");
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
