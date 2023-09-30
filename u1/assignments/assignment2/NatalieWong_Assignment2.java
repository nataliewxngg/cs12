// Natalie Wong
// Due October 4, 2023

// This program is designated to determine the quickest route for Ms. Wong to 
// reach Suki. The route will be determined according to a given map of Ms. Wong's house, which
// is illustrated by a 2D array of characters ('W','S','X','-').

package assignment2;

import java.util.Scanner;
import java.io.*;

public class NatalieWong_Assignment2 {

    public static char[] findShortestRoute(char[] shortestRoute, char[] newRoute) {
        if (shortestRoute.length == 0)
            shortestRoute = newRoute;
        else if (newRoute.length < shortestRoute.length)
            shortestRoute = newRoute;
        return shortestRoute;
    }

    public static char[] addDirection(char[] route, char newDirection) {
        char[] newRoute = new char[route.length + 1];

        for (int i = 0; i < route.length; i++) {
            newRoute[i] = route[i];
        }
        newRoute[newRoute.length - 1] = newDirection;

        return newRoute;
    }

    public static char[] shortestRoute(char[][] map, int currentRow, int currentCol, char[] shortestRoute,
            char[] route) {

        // if currentRow or currentCol is out of range
        if (currentRow < 0 || currentRow >= map.length || currentCol < 0 || currentCol >= map[currentRow].length)
            return shortestRoute;

        // // CHECK MAP
        // for (int x = 0; x < map.length; x++) {
        // for (int m = 0; m < map[x].length; m++) {
        // System.out.print(map[x][m]);
        // }
        // System.out.println();
        // }
        // System.out.println();
        // // CHECK MAP END

        if (map[currentRow][currentCol] == 'X'
                || map[currentRow][currentCol] == '*') {
            return shortestRoute;
        } else if (map[currentRow][currentCol] == 'S') {
            shortestRoute = findShortestRoute(shortestRoute, route);
            return shortestRoute;
        }
        if (!(currentRow == 0 && currentCol == 0))
            map[currentRow][currentCol] = '*';

        shortestRoute = shortestRoute(map, currentRow, currentCol + 1, shortestRoute, addDirection(route, 'E'));
        shortestRoute = shortestRoute(map, currentRow, currentCol - 1, shortestRoute, addDirection(route, 'W'));
        shortestRoute = shortestRoute(map, currentRow - 1, currentCol, shortestRoute, addDirection(route, 'N'));
        shortestRoute = shortestRoute(map, currentRow + 1, currentCol, shortestRoute, addDirection(route, 'S'));

        if (!(currentRow == 0 && currentCol == 0))
            map[currentRow][currentCol] = '-'; // change back for checking the coming routes

        return shortestRoute;
    }

    public static void main(String[] args) {

        // Variables
        int numOfMaps;
        char[][] map;
        char[] shortestRoute;
        char[] route;
        String line;

        // Main Code
        try {
            Scanner in = new Scanner(new File("input.txt"));

            numOfMaps = Integer.parseInt(in.nextLine());
            for (int mapNum = 1; mapNum <= numOfMaps; mapNum++) {
                map = new char[Integer.parseInt(in.nextLine())][Integer.parseInt(in.nextLine())];

                // Saves the whole map into a 2D array
                for (int row = 0; row < map.length; row++) {
                    line = in.nextLine();
                    for (int col = 0; col < map[row].length; col++) {
                        map[row][col] = line.charAt(col);
                    }
                }

                shortestRoute = new char[0];
                route = new char[0];

                // display results here
                shortestRoute = shortestRoute(map, 0, 0, shortestRoute, route);

                System.out.printf("Layout #%d:%n", mapNum);

                for (int row = 0; row < map.length; row++) {
                    for (int col = 0; col < map[row].length; col++) {
                        System.out.print(map[row][col]);
                    }
                    System.out.println("");
                }

                if (shortestRoute.length == 0) {
                    System.out.println("\nOH NO! There is no way for Ms. Wong to reach Suki!\n");
                } else {
                    System.out.printf("\nFastest # of steps: %d%n", shortestRoute.length);
                    System.out.print("Direction: ");

                    for (int direction = 0; direction < shortestRoute.length; direction++)
                        System.out.print(shortestRoute[direction] + " ");
                    System.out.println("\n");
                }
            }

            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
        }

    }
}
