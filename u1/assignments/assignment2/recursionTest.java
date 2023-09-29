package assignment2;

public class recursionTest {
    public static int goThroughMap(char[][] map, int currentRow, int currentCol, String prevDir) {

        for (int x = 0; x < map.length; x++) {
            for (int m = 0; m < map[x].length; m++) {
                System.out.print(map[x][m]);
            }
            System.out.println();
        }
        System.out.println();

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
                            + goThroughMap(map, currentRow, currentCol - 1, "west");
                else // prevDir == "south"
                    return goThroughMap(map, currentRow + 1, currentCol, "south")
                            + goThroughMap(map, currentRow, currentCol - 1, "west")
                            + goThroughMap(map, currentRow, currentCol + 1, "east");
            }
        }
    }

    public static void main(String[] args) {
        char[][] map = { { 'W', '-', '-', '-', '-', '-', 'X', 'X', 'X', 'X' },
                { 'X', 'X', '-', 'X', 'X', '-', '-', '-', '-', 'X' },
                { 'X', '-', '-', '-', '-', '-', 'X', 'X', '-', 'X' },
                { 'X', '-', 'X', 'X', 'X', 'X', 'X', 'X', '-', 'X' },
                { 'X', '-', '-', '-', '-', '-', '-', '-', '-', 'S' } };

        System.out.println(goThroughMap(map, 0, 0, null)); // returns number of open spaces you can walk through
    }
}
