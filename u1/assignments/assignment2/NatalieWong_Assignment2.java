// Natalie Wong
// Due October 4, 2023

// This program is designated to determine the quickest route for Ms. Wong to 
// reach Suki. The route will be determined according to a given map of Ms. Wong's house, which
// is illustrated by a 2D array of characters ('W','S','X','-').

package assignment2;

import java.util.Scanner;
import java.io.*;

public class NatalieWong_Assignment2 {
    {// current direction should be a parameter
     // public static int findRoutes(char[][] map, int currentRow, int currentCol,
     // char previousDir) {
     // // check north (if currentrow != 0)
     // // check east (if currentcol != map[row].length-1)
     // // check south (if currentrow != map.length-1)
     // // check west (if currentcol != 0)

        // map[currentRow][currentCol] = '*';

        // for (int x = 0; x < map.length; x++) {
        // for (int m = 0; m < map[x].length; m++) {
        // System.out.print(map[x][m]);
        // }
        // System.out.println();
        // }
        // System.out.println();
        // }
    }

    public static int goThroughMap(char[][] map, int currentRow, int currentCol, String prevDir) {

        // display array
        for (int x = 0; x < map.length; x++) {
            for (int m = 0; m < map[x].length; m++) {
                System.out.print(map[x][m]);
            }
            System.out.println();
        }
        System.out.println();
        // display array end

        if (map[currentRow][currentCol] == 'X' || map[currentRow][currentCol] == 'S'
                || map[currentRow][currentCol] == '*') {
            return 0;
        }

        if (!(currentRow == 0 && currentCol == 0))
            map[currentRow][currentCol] = '*';

        if (currentRow == 0) { // first row
            if (currentCol == 0) { // (only check south and east)
                if (prevDir == "west")
                    return goThroughMap(map, currentRow + 1, currentCol, "south") + 1;
                else if (prevDir == "south")
                    return goThroughMap(map, currentRow, currentCol + 1, "east") + 1;
                else
                    return goThroughMap(map, currentRow, currentCol + 1, "east")
                            + goThroughMap(map, currentRow + 1, currentCol, "south")
                            + 1;
            } else if (currentCol == map[0].length - 1) { // if last column (only check west or south)
                if (prevDir == "east")
                    return goThroughMap(map, currentRow + 1, currentCol, "south") + 1;
                else if (prevDir == "north")
                    return goThroughMap(map, currentRow, currentCol - 1, "west") + 1;

                else
                    return goThroughMap(map, currentRow + 1, currentCol, "south")
                            + goThroughMap(map, currentRow, currentCol - 1, "west")
                            + 1;
            }

            else { // check east, south, west
                if (prevDir == "east")
                    return goThroughMap(map, currentRow + 1, currentCol, "south")
                            + goThroughMap(map, currentRow, currentCol + 1, "east") + 1;
                else if (prevDir == "north")
                    return goThroughMap(map, currentRow, currentCol - 1, "west")
                            + goThroughMap(map, currentRow, currentCol + 1, "east") + 1;
                else if (prevDir == "west")
                    return goThroughMap(map, currentRow, currentCol - 1, "west")
                            + goThroughMap(map, currentRow + 1, currentCol, "south") + 1;
                else
                    return goThroughMap(map, currentRow, currentCol - 1, "west")
                            + goThroughMap(map, currentRow + 1, currentCol, "south")
                            + goThroughMap(map, currentRow, currentCol + 1, "east") + 1;
            }

        } else if (currentRow == map.length - 1) { // last row
            if (currentCol == 0) { // (only check north and east)
                if (prevDir == "west")
                    return goThroughMap(map, currentRow - 1, currentCol, "north") + 1;
                else if (prevDir == "south")
                    return goThroughMap(map, currentRow, currentCol + 1, "east") + 1;
                else
                    return goThroughMap(map, currentRow, currentCol + 1, "east")
                            + goThroughMap(map, currentRow - 1, currentCol, "north")
                            + 1;
            } else if (currentCol == map[0].length - 1) { // if last column (only check north or west)
                if (prevDir == "east")
                    return goThroughMap(map, currentRow - 1, currentCol, "north") + 1;
                else if (prevDir == "south")
                    return goThroughMap(map, currentRow, currentCol - 1, "west") + 1;

                else
                    return goThroughMap(map, currentRow - 1, currentCol, "north")
                            + goThroughMap(map, currentRow, currentCol - 1, "west")
                            + 1;
            }

            else { // check east, north, west
                if (prevDir == "east")
                    return goThroughMap(map, currentRow - 1, currentCol, "north")
                            + goThroughMap(map, currentRow, currentCol + 1, "east") + 1;
                else if (prevDir == "south")
                    return goThroughMap(map, currentRow, currentCol - 1, "west")
                            + goThroughMap(map, currentRow, currentCol + 1, "east") + 1;
                else if (prevDir == "west")
                    return goThroughMap(map, currentRow, currentCol - 1, "west")
                            + goThroughMap(map, currentRow - 1, currentCol, "north") + 1;
                else
                    return goThroughMap(map, currentRow, currentCol - 1, "west")
                            + goThroughMap(map, currentRow - 1, currentCol, "north")
                            + goThroughMap(map, currentRow, currentCol + 1, "east") + 1;
            }
        } else { // middle rows
            if (currentCol == 0) { // check north, east, south
                if (prevDir == "west")
                    return goThroughMap(map, currentRow - 1, currentCol, "north")
                            + goThroughMap(map, currentRow + 1, currentCol, "south") + 1;
                else if (prevDir == "north")
                    return goThroughMap(map, currentRow - 1, currentCol, "north")
                            + goThroughMap(map, currentRow, currentCol + 1, "east") + 1;
                else if (prevDir == "south")
                    return goThroughMap(map, currentRow, currentCol + 1, "east")
                            + goThroughMap(map, currentRow + 1, currentCol, "south") + 1;
                else
                    return goThroughMap(map, currentRow, currentCol + 1, "east")
                            + goThroughMap(map, currentRow - 1, currentCol, "north")
                            + goThroughMap(map, currentRow + 1, currentCol, "south") + 1;
            } else if (currentCol == map[0].length - 1) { // check north, west, south
                if (prevDir == "east")
                    return goThroughMap(map, currentRow - 1, currentCol, "north")
                            + goThroughMap(map, currentRow + 1, currentCol, "south") + 1;
                else if (prevDir == "south")
                    return goThroughMap(map, currentRow, currentCol - 1, "west")
                            + goThroughMap(map, currentRow + 1, currentCol, "south") + 1;
                else if (prevDir == "north")
                    return goThroughMap(map, currentRow - 1, currentCol, "north")
                            + goThroughMap(map, currentRow, currentCol - 1, "west") + 1;
                else
                    return goThroughMap(map, currentRow - 1, currentCol, "north") +
                            goThroughMap(map, currentRow, currentCol - 1, "west")
                            + goThroughMap(map, currentRow + 1, currentCol, "south") + 1;
            } else { // check all
                if (prevDir == "east")
                    return goThroughMap(map, currentRow, currentCol + 1, "east")
                            + goThroughMap(map, currentRow - 1, currentCol, "north")
                            + goThroughMap(map, currentRow + 1, currentCol, "south") + 1;
                else if (prevDir == "west")
                    return goThroughMap(map, currentRow, currentCol - 1, "west")
                            + goThroughMap(map, currentRow - 1, currentCol, "north")
                            + goThroughMap(map, currentRow + 1, currentCol, "south") + 1;
                else if (prevDir == "north")
                    return goThroughMap(map, currentRow, currentCol + 1, "east")
                            + goThroughMap(map, currentRow - 1, currentCol, "north")
                            + goThroughMap(map, currentRow, currentCol - 1, "west") + 1;
                else // prevDir == "south"
                    return goThroughMap(map, currentRow + 1, currentCol, "south")
                            + goThroughMap(map, currentRow, currentCol - 1, "west")
                            + goThroughMap(map, currentRow, currentCol + 1, "east") + 1;
            }
        }
    }

    public static void main(String[] args) {

        // Rules/Outlines:
        // 1. Ms. Wong CANNOT move diagonally
        // 2. W and S' starting positions will ALWAYS be the same

        // Variables
        int numOfCases;
        char[][] map;

        String line;

        // Main Code
        try {
            Scanner in = new Scanner(new File("input.txt"));

            numOfCases = Integer.parseInt(in.nextLine());
            for (int i = 0; i < numOfCases; i++) {
                map = new char[Integer.parseInt(in.nextLine())][Integer.parseInt(in.nextLine())];

                // Saves the whole map into a 2D array
                for (int row = 0; row < map.length; row++) {
                    line = in.nextLine();
                    for (int col = 0; col < map[row].length; col++) {
                        map[row][col] = line.charAt(col);
                    }
                }

                // FIND THE ROUTES HERE*************************************
                System.out.println(goThroughMap(map, 0, 0, null)); // displays the total number of asterisks + 1

                // // PRINT THE ARRAY
                // for (int x = 0; x < map.length; x++) {
                // for (int m = 0; m < map[x].length; m++) {
                // System.out.print(map[x][m]);
                // }
                // System.out.println();
                // }
                // System.out.println();
                // // PRINT THE ARRAY
            }

            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
        }

        // Hints:
        // 1. create a program to find all possible routes first
        // 2. add * at all visited spots
        // 3. determine global and local vars

        // 4. recursive method should contain ATLEAST 3 parameters:
        // the array, current row position, current column position

    }
}
