// Natalie Wong
// Due October 4, 2023

// This program is designated to determine the quickest route for Ms. Wong to 
// reach Suki. The route will be determined according to a given map of Ms. Wong's house, which
// is illustrated by a 2D array of characters ('W','S','X','-').

package assignment2;

import java.util.Scanner;
import java.io.*;

public class NatalieWong_Assignment2 {
    public static int findRoutes(char[][] map, int currentRow, int currentCol) {
        // check north (if currentrow != 0)
        // check east (if currentcol != map[row].length-1)
        // check south (if currentrow != map.length-1)
        // check west (if currentcol != 0)

        // idk how to do this
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

                // FIND THE ROUTES HERE
                System.out.println(findRoutes(map, 0, 0));

                // PRINT THE ARRAY
                for (int x = 0; x < map.length; x++) {
                    for (int m = 0; m < map[x].length; m++) {
                        System.out.print(map[x][m]);
                    }
                    System.out.println();
                }
                System.out.println();
                // PRINT THE ARRAY
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
