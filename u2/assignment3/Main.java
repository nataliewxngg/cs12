// Natalie Wong
// Due Monday, October 16, 2023

// Assignment #3 - OOP: Nintendo Switch Games Assignment (WITHOUT BONUS)
// This program inputs a list of Nintendo games from an input.txt file and allows the user to search for the games either by title or by type.

package u2.assignment3;

import java.util.*;
import java.io.*;

public class Main {

    // DESCRIPTION: Searches case insensitively for a given game title from an
    // ArrayList
    // UTILIZES THE BINARY SEARCH ALGORITHM (RECURSIVE APPROACH)
    public static int binarySearchName(ArrayList<Games> games, String key, int left, int right) { // PARAMETERS:
                                                                                                  // 1. ArrayList to
                                                                                                  // search game title
                                                                                                  // from
                                                                                                  // 2. Game title
                                                                                                  // 3. Left and right
                                                                                                  // indexes (for
                                                                                                  // algorithm)
        int mid = (left + right) / 2;

        // If the game is not found in the ArrayList, return the "-insertion point"
        if (left > right)
            return -left - 1;

        // If the game is found, return the index of the game in the ArrayList
        if (key.equalsIgnoreCase(games.get(mid).getName()))
            return mid;

        // If the game is LESS than the current games' name case insensitively (ie. A<Z,
        // A<e, b<J, etc.),
        // readjust the right index to mid-1 and recall the method so it only
        // checks the LEFT SIDE of mid in the ArrayList

        // eg. Game you are searching for: Animal Crossing; Game at 'mid' index:
        // Minecraft (A<M)
        else if (key.toLowerCase().compareTo(games.get(mid).getName().toLowerCase()) < 0) {
            return binarySearchName(games, key, left, mid - 1);
        }

        // If the game is GREATER than the current games' name case insensitively,
        // readjust the left index to mid+1 and recall the method so it only checks the
        // RIGHT SIDE of mid in the ArrayList

        // eg. Game you are searching for: Minecraft; Game at 'mid' index: Animal
        // Crossing (M>A)
        else
            return binarySearchName(games, key, mid + 1, right);

        // RETURNS: If game is not found in the ArrayList, this recursive method will
        // return the "-insertion point"
        // However, if it IS found, it returns the index of the game in the ArrayList
    }

    // DESCRIPTION: Searches case insensitively for a game of a given type
    // from an ArrayList of Games objects
    // UTILIZES THE BINARY SEARCH ALGORITHM (RECURSIVE APPROACH)
    public static int binarySearchType(ArrayList<Games> games, String key, int left, int right) { // PARAMETERS:
                                                                                                  // 1. ArrayList to
                                                                                                  // search game of same
                                                                                                  // type from
                                                                                                  // 2. Type
                                                                                                  // 3. Left and right
                                                                                                  // indexes (for
                                                                                                  // algorithm)
        int mid = (left + right) / 2;

        // If a game of the same type cannot be found in the ArrayList, return the
        // "-insertion point"
        if (left > right)
            return -left - 1;

        // If a game of the same type is found, return the index of the game in the
        // ArrayList
        if (key.equalsIgnoreCase(games.get(mid).getType()))
            return mid;

        // If the type of the game is LESS than the current games' type (ie. A<Z, A<E,
        // J>B, etc.), readjust the right index to mid-1 and recall the method so
        // it only checks the LEFT SIDE of mid in the ArrayList

        // eg. Type of game you are looking for: Adventure | Type of game at 'mid'
        // index: RPG
        else if (key.toLowerCase().compareTo(games.get(mid).getType().toLowerCase()) < 0) {
            return binarySearchType(games, key, left, mid - 1);
        }

        // If the type of the game is GREATER than the current games' type, readjust the
        // left index to mid+1 and recall the method so it only checks the RIGHT
        // SIDE of mid in the ArrayList

        // eg. Type of game you are looking for: RPG | Type of game at 'mid' index:
        // Adventure
        else
            return binarySearchType(games, key, mid + 1, right);

        // RETURNS: If a game of the same type cannot be found in the ArrayList, this
        // recursive method will return the "-insertion point"
        // However, if it IS found, it returns the index of the game in the ArrayList
    }

    // DESCRIPTION: Finds the ranking of a game in an ArrayList of games given its
    // rating
    // UTILIZES THE BINARY SEARCH ALGORITHM (ITERATIVE APPROACH)
    public static int findRanking(ArrayList<Games> games, double key, int left, int right) { // PARAMETERS:
                                                                                             // 1. ArrayList of all the
                                                                                             // games
                                                                                             // 2. Rating of the given
                                                                                             // game
                                                                                             // 3. Left and right
                                                                                             // indexes (for algorithm)

        Collections.sort(games, new SortByRating()); // Sort the ArrayList of games by ratings IN DESCENDING ORDER

        // As long as all possible indexes have not yet been searched, continuously
        // shrink the length between left and right to determine the index of
        // ArrayList at which the FIRST OCCURRENCE of the rating can be found
        while (left <= right) {
            int mid = (left + right) / 2;

            // If a game with the same rating is found, instead of returning its
            // index right away, keep searching towards the left to determine the index of
            // the FIRST occurrence
            if (key == games.get(mid).getRating()) {

                // Move the current index left until
                // 1. Rating of the game at index 'mid' is no longer the 'key' index
                // 2. The 'mid' index is already at the leftmost position
                while (key == games.get(mid).getRating()) {
                    if (mid == 0)
                        return mid;
                    mid--;
                }

                // RETURN:
                // return an accumulated version of 'mid' to make up for the while loop above,
                // which would have moved 'mid' one extra index to the left
                return mid + 1;
            }

            // If the 'key' rating is greater than the rating of the game at the current
            // index of the ArrayList, move right to 1 left of mid to eliminate the
            // games on the right side, which are 100% less than the 'key' rating
            else if (key > games.get(mid).getRating()) {
                right = mid - 1;
            }

            // If the 'key' rating is less than the rating of the game at the current
            // index of the ArrayList, move left to 1 right of mid to eliminate the
            // games on the left side, which are 100% greater than the 'key' rating
            else {
                left = mid + 1;
            }
        }

        // RETURN: If the rating does not apply to any of the games in the ArrayList,
        // return the "-insertion point"
        return -left - 1;
    }

    // DESCRIPTION: The main method acquires input from the textfile, saves each
    // game into an ArrayList of 'Games' objects, prompts the user for searching
    // criterias, and displays the statistics given the inputs
    public static void main(String[] args) throws IOException { // PARAMETER: args not used
                                                                // THROWS IOEXCEPTION: For the BufferedReader, which
                                                                // collects input from the textfile

        // Variables
        ArrayList<Games> games = new ArrayList<>();
        String line;

        double rating;
        String name;
        String type;

        String searchBy = "";
        String userLine = "";

        // Main Code
        // Input the list of games from the textfile and store them all in an ArrayList
        // as 'Game' objects.
        // Display "Reading error" if the file is not found
        try {
            // Create a BufferedReader for accessing the textfile
            BufferedReader in = new BufferedReader(new FileReader("input.txt"));

            // Separate each line of the input file into rating, name, and type, and
            // store them in an ArrayList as 'Games' objects
            while ((line = in.readLine()) != null) {

                // Separate current line into rating, name, and type
                line = line.strip();
                StringTokenizer st = new StringTokenizer(line);

                name = "";

                // If there is a valid # of fields (3 fields: rating, name, type) in the current
                // line, separate it and initialize its 'Game' object
                if (st.countTokens() >= 3) {
                    try {
                        // Rating - NumberFormatException will be thrown if the rating
                        // inputted is NOT a valid double or is NOT between the inclusive range of 0-10
                        rating = Double.parseDouble(st.nextToken());
                        if (rating < 0 || rating > 10)
                            throw new NumberFormatException();

                        // Game Name - takes the second to 2nd last token and combines them all to
                        // create a string (for the name)
                        int numOfTokens = st.countTokens() - 1;
                        for (int token = 0; token < numOfTokens; token++)
                            name += st.nextToken() + " ";
                        name = name.strip();

                        // Type
                        type = line.substring(line.lastIndexOf(" ") + 1);

                        // Create the 'Games' object utilizing the rating, name, and type of the current
                        // game
                        games.add(new Games(rating, name, type));

                    } catch (NumberFormatException e) { // Skip the current line if the rating inputted is not a
                                                        // valid/expected input
                        System.out.println("Line skipped (Invalid rating): " + line);
                    }
                } else { // Skip the current line if it has LESS THAN 3 tokens (improper # of
                         // inputs/fields)
                    System.out.println("Line skipped (Invalid # of input fields): " + line);
                }
            }

            // If the ArrayList of games is empty, automatically exit + terminate the
            // program
            if (games.size() == 0)
                System.out.println("You own 0 games... :( Automatically exiting.");

            // If the ArrayList of games is NOT empty, prompt the user for searching
            // criterias:
            else {
                Scanner userIn = new Scanner(System.in);

                // As long as the user chooses not to exit when prompted to choose between
                // game/type, continue to prompt for furthermore searching criterias
                while (true) {
                    System.out.print("\nSearch by game, type, or exit?: ");
                    searchBy = userIn.nextLine().strip();

                    // Break if user exits when prompted to choose between game/type
                    if (searchBy.equalsIgnoreCase("exit")) {
                        break;
                    }

                    // If user chooses to SEARCH BY GAME, continuously prompt for game name until
                    // "exit" - which returns back to prompting for searching preference (game/type)
                    while (searchBy.equalsIgnoreCase("game")) {
                        System.out.print("\nEnter a game or exit: ");
                        userLine = userIn.nextLine().strip();

                        int indexOfGame;

                        // Break if user exits when prompted to enter a game name - returns back to
                        // choosing to search by game/type
                        if (userLine.equalsIgnoreCase("exit"))
                            break;
                        // If user enters a valid game name (NOT EMPTY STRING), display the game's stats
                        else if (userLine.length() > 0) {

                            // Sort games alphabetically and search for the index of the inputted game name
                            // (case insensitive)
                            Collections.sort(games);
                            indexOfGame = binarySearchName(games, userLine, 0, games.size() - 1);

                            // Game not found in list - go back to prompting for game titles
                            if (indexOfGame < 0) {
                                System.out.println("You don't own this game :(");
                            }
                            // Game is found in the list - display the statistics for the game
                            else {
                                // Displays the Name, Type, and Rating
                                System.out.print(games.get(indexOfGame));

                                // Displays the Ranking of the game
                                System.out.println(
                                        "Ranking: " + (findRanking(games, games.get(indexOfGame).getRating(), 0,
                                                games.size() - 1) + 1) + " out of " + games.size());
                            }
                        }
                        // If the user enters an empty game name to search for, display "Invalid input"
                        else {
                            System.out.print("\nInvalid input.");
                        }
                    }

                    // If user chooses to SEARCH BY TYPE, continuously prompt for type until "exit"
                    // - which returns back to prompting for searching preference (game/type)
                    while (searchBy.equalsIgnoreCase("type")) {
                        System.out.print("\nEnter a type or exit: ");
                        userLine = userIn.nextLine().strip();

                        // Break if user exits when prompted to enter a type - returns back to
                        // choosing to search by game/type
                        if (userLine.equalsIgnoreCase("exit")) {
                            break;
                        }
                        // If user enters a valid type (NOT EMPTY STRING), display the statistics of ALL
                        // the games of the same type
                        else if (userLine.length() > 0) {

                            // Create a copy of the ArrayList games and use it to selectively pick out the
                            // games with the inputted type
                            // (Continuously find and remove until none are left)
                            ArrayList<Games> gamesEdited = new ArrayList<>(games);
                            Collections.sort(gamesEdited, new SortByType()); // Sort the copy by type (case
                                                                             // insensitively)

                            // First determine if there is a game of the inputted type
                            int indexOfGame = binarySearchType(gamesEdited, userLine, 0, gamesEdited.size() - 1);

                            // No game with the inputted type was found in list - go back to prompting for
                            // types
                            if (indexOfGame < 0) {
                                System.out.println("You don't own a game of this type :(");
                            }
                            // An existing game with the desired type exists! - find all the games with the
                            // inputted type and display their statistics (in alphabetical order of their
                            // names)
                            else {
                                ArrayList<Games> gamesInType = new ArrayList<>(); // Used to store all the games of the
                                                                                  // desired type

                                // Add all the games of the desired type into the gamesInType ArrayList
                                do {
                                    gamesInType.add(gamesEdited.get(indexOfGame));
                                    gamesEdited.remove(indexOfGame);
                                    indexOfGame = binarySearchType(gamesEdited, userLine, 0,
                                            gamesEdited.size() - 1);
                                } while (indexOfGame >= 0);

                                Collections.sort(gamesInType);
                                Collections.sort(games);

                                // Display the statistics of all the games of the desired type
                                for (int game = 0; game < gamesInType.size(); game++) {
                                    // Display the game's Name, Type, and Rating
                                    System.out.print(gamesInType.get(game));

                                    // Display game's ranking
                                    System.out.println("Ranking: "
                                            + (findRanking(games, gamesInType.get(game).getRating(), 0,
                                                    games.size() - 1) + 1)
                                            + " out of " + games.size());
                                }
                            }
                        }
                        // If the user enters an empty type to search for, display "Invalid input"
                        else {
                            System.out.print("\nInvalid input.");
                        }
                    }

                    // If user enters an invalid/unexpected input when asked to search by name/by
                    // type, display "Invalid input" and return to the top of the loop (which will
                    // continue prompting for an input)
                    if (!searchBy.equalsIgnoreCase("type") && !searchBy.equalsIgnoreCase("game"))
                        System.out.print("\nInvalid input.");
                }
                userIn.close();
            }
            in.close();
        }
        // If input.txt was not found, display "File not Found."
        catch (FileNotFoundException e) {
            System.out.println("File not Found.");
        }
    }
}
