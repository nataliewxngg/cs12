// Natalie Wong
// Due Friday, October 6, 2023

// Assignment #2 - Save Cat WITHOUT BONUS 
// This program determines the shortest/quickest route for Ms. Wong to reach naughty Suki, 
// who is feasting in the sink
package assignment2;

import java.io.*;
import java.util.Scanner;

public class NatalieWong_SaveCat {

    // DESCRIPTION:
    // shortestRoute() is a RECURSIVE method that determines the
    // shortest route for Ms. Wong to reach naughty Suki
    // (W --> S)

    // PARAMETERS:
    // 1. A map of the house stored in a 2D array
    // 2. The row AND column indexes (from the map) of the current
    // coordinate/position
    // 3. The current shortest path
    // 4. The current path
    public static String shortestRoute(char[][] map, int currentRow, int currentCol, String shortestRoute,
            String route) {

        // If the current coordinate is OUT OF RANGE or is a WALL or is a
        // WALL or OBSTACLE (X/*), return the current shortest route
        if (currentRow < 0 || currentRow >= map.length || currentCol < 0 || currentCol >= map[currentRow].length
                || map[currentRow][currentCol] == 'X' || map[currentRow][currentCol] == '*') {
            return shortestRoute;
        }

        // If Ms. Wong manages to Suki, determine and return the current shortest route
        if (map[currentRow][currentCol] == 'S') {
            if (shortestRoute.length() == 0 || route.length() < shortestRoute.length())
                return route;
            return shortestRoute;
        }

        // Replace the map coordinate with an asterisk (to avoid
        // backtracking/back-and-forth movement) unless it is Ms. Wong or Suki
        if (map[currentRow][currentCol] != 'W' && map[currentRow][currentCol] != 'S') {
            map[currentRow][currentCol] = '*';
        }

        // Check all 4 directinos at each step to determine or possibly replace the
        // shortest route
        shortestRoute = shortestRoute(map, currentRow, currentCol + 1, shortestRoute, route + 'E');
        shortestRoute = shortestRoute(map, currentRow, currentCol - 1, shortestRoute,
                route + 'W');
        shortestRoute = shortestRoute(map, currentRow - 1, currentCol, shortestRoute,
                route + 'N');
        shortestRoute = shortestRoute(map, currentRow + 1, currentCol, shortestRoute, route + 'S');

        // Change the map coordinate back to an empty path ('-') to check for coming
        // routes (and for displaying a clean version in console afterwards)
        if (map[currentRow][currentCol] != 'W' && map[currentRow][currentCol] != 'S'
                && map[currentRow][currentCol] != 'L')
            map[currentRow][currentCol] = '-';

        return shortestRoute; // Returns the shortest route possible in the given map
    }

    // DESCRIPTION: The main method acquires the maps from the textfile
    // and displays the shortest route possible for each map by calling the
    // shortestRoute() method

    public static void main(String[] args) { // PARAMETER: args not used

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
            // possible (to get from W --> S)
            for (int mapNum = 1; mapNum < numOfMaps + 1; mapNum++) {
                // Initialize the # of rows and columns for the map (2D array)
                map = new char[Integer.parseInt(in.nextLine())][Integer.parseInt(in.nextLine())];

                // Saves the whole map into the 2D 'map'
                for (int row = 0; row < map.length; row++) {
                    line = in.nextLine();
                    for (int col = 0; col < map[row].length; col++) {
                        map[row][col] = line.charAt(col);
                    }
                }

                // Calls the method shortestRoute() to determine the shortest route possible
                shortestRoute = shortestRoute(map, 0, 0, "", "");

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
                    if (shortestRoute.length() == 0) { // If it is impossible for Ms. Wong to reach Suki,
                                                       // inform the user
                        System.out.println(
                                "\nOH NO! There is no way for Ms. Wong to reach Suki! :(\n");
                    } else { // Otherwise, if there is a possible path, display the # of steps and directions
                             // (N,E,S,W) of the shortest path
                        System.out.printf("\nFastest # of steps: %d%n", shortestRoute.length());
                        System.out.print("Direction: ");

                        // Goes through all the directions of the shortest path and displays them each
                        // separated by a space
                        for (int direction = 0; direction < shortestRoute.length(); direction++)
                            System.out.print(shortestRoute.charAt(direction) + " ");
                        System.out.println("\n");
                    }
                }
            }
            in.close(); // Close the input file scanner
        } catch (FileNotFoundException e) { // If the file was not found in the directory (FileNotFoundException is
                                            // thrown), catch the exception and display "File not Found"
            System.out.println("File not Found");
        }
    }
}
