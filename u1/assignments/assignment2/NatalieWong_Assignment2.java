// Natalie Wong
// Due Thursday, October 5, 2023

// Assignment #2 - Save Cat WITH BONUS 
// This program determines the shortest/quickest route for Ms. Wong to 
// reach Suki AND return her into the litter box (BONUS!).

package assignment2;

import java.util.Scanner;
import java.io.*;

public class NatalieWong_Assignment2 {

    // Description: shortestRoute() is a recursive method that determines the
    // shortest route for
    // Ms. Wong to take naughty Suki from the sink to the litter box

    // Parameters: The map of the house stored in a 2D array, the row and column
    // indexes (from the map) of the current coordinate, the current shortest path,
    // current path, and an indicator of whether or not Suki has been brought away
    // from the sink
    public static String shortestRoute(char[][] map, int currentRow, int currentCol, String shortestRoute,
            String route, boolean sukiFound) {

        // If the current coordinate is OUT OF RANGE or is a WALL or OBSTACLE (X/*),
        // return the current shortest route
        if (currentRow < 0 || currentRow >= map.length || currentCol < 0 || currentCol >= map[currentRow].length
                || map[currentRow][currentCol] == 'X' || map[currentRow][currentCol] == '*') {
            return shortestRoute;
        }

        // If Ms. Wong manages to reach Suki, the boolean sukiFound is set to true so
        // that Ms. Wong will now search for the litter box (instead of Suki)
        if (map[currentRow][currentCol] == 'S') {
            sukiFound = true;
        }
        // If Ms. Wong is already carrying Suki away from the sink and reaches the
        // litter box, determine and return the current shortest route
        else if (sukiFound && map[currentRow][currentCol] == 'L') {
            if (shortestRoute.length() == 0 || route.length() < shortestRoute.length())
                return route;
            return shortestRoute;
        }

        // Replace the map coordinate with an asterisk (to avoid backtracking) unless it
        // is Ms. Wong, Suki, or the litter box
        if (map[currentRow][currentCol] != 'W' && map[currentRow][currentCol] != 'S'
                && map[currentRow][currentCol] != 'L')
            map[currentRow][currentCol] = '*';

        // Check all 4 directions at each step to determine or possible replace the
        // shortest route
        shortestRoute = shortestRoute(map, currentRow, currentCol + 1, shortestRoute, route + 'E',
                sukiFound);
        shortestRoute = shortestRoute(map, currentRow, currentCol - 1, shortestRoute, route + 'W',
                sukiFound);
        shortestRoute = shortestRoute(map, currentRow - 1, currentCol, shortestRoute, route + 'N',
                sukiFound);
        shortestRoute = shortestRoute(map, currentRow + 1, currentCol, shortestRoute, route + 'S',
                sukiFound);

        // Change the map coordinate back to an empty path ('-') to check for coming
        // routes
        if (map[currentRow][currentCol] != 'W' && map[currentRow][currentCol] != 'S'
                && map[currentRow][currentCol] != 'L')
            map[currentRow][currentCol] = '-';

        return shortestRoute; // Returns the shortest route possible in the given map
    }

    // Description: The main method acquires the maps from the textfile
    // and displays the shortest route possible for each map by calling the
    // shortestRoute() method
    public static void main(String[] args) { // Parameter: args not used

        // Variables
        int numOfMaps;
        char[][] map;
        String shortestRoute;
        String line;

        // Main Code
        // Read input from the file input.txt and display "Reading error" if the file is
        // not found
        try {
            // Inputs the number of maps/houses in the input file and stores it into a
            // variable
            Scanner in = new Scanner(new File("input.txt"));
            numOfMaps = Integer.parseInt(in.nextLine());

            // For each map/house in the textfile, determine and display the shortest route
            // possible (to get from W --> S --> L)
            for (int mapNum = 1; mapNum < numOfMaps + 1; mapNum++) {
                map = new char[Integer.parseInt(in.nextLine())][Integer.parseInt(in.nextLine())];

                // Saves the whole map into a 2D array
                for (int row = 0; row < map.length; row++) {
                    line = in.nextLine();
                    for (int col = 0; col < map[row].length; col++) {
                        map[row][col] = line.charAt(col);
                    }
                }

                // Calls the method shortestRoute() to determine the shortest route possible
                shortestRoute = shortestRoute(map, 0, 0, "", "", false);

                // Display the map # (starts at 1) and its entire map/house
                System.out.printf("Layout #%d:%n", mapNum);
                for (int row = 0; row < map.length; row++) {
                    for (int col = 0; col < map[row].length; col++) {
                        System.out.print(map[row][col]);
                    }
                    System.out.println("");
                }

                // If the map is 1 row AND 1 column in length (ONE COORDINATE ONLY) or less,
                // display that it is an invalid map
                if (map.length <= 1 && map[0].length <= 1)
                    System.out.println("Invalid map");
                else { // If the map is valid in size, display the shortest route possible
                       // If it is impossible for Ms. Wong to reach Suki and bring her to the litter
                       // box
                    if (shortestRoute.length() == 0) {
                        System.out.println(
                                "\nOH NO! There is no way for Ms. Wong to return Suki to her litter box! :(\n");
                    } else { // If a shortest path exists, display its # of steps and the directions of the
                             // path
                        System.out.printf("\nFastest # of steps: %d%n", shortestRoute.length());
                        System.out.print("Direction: ");

                        // Displays the directions of the shortest path
                        for (int direction = 0; direction < shortestRoute.length(); direction++)
                            System.out.print(shortestRoute.charAt(direction) + " ");
                        System.out.println("\n");
                    }
                }
            }
            in.close();
        } // If the file was not found (FileNotFoundException is thrown), catch the
          // exception and display "File not Found" instead
        catch (FileNotFoundException e) {
            System.out.println("File not Found");
        }

    }
}
