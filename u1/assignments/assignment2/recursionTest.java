package assignment2;

public class recursionTest {
    // Global Variables
    public static String[][] paths = new String[0][0];

    public static String[] addDirection(String[] directions, String prevDir) {
        String[] newDirections = new String[directions.length + 1];

        for (int i = 0; i < directions.length; i++) {
            newDirections[i] = directions[i];
        }
        newDirections[newDirections.length - 1] = prevDir;

        return newDirections;
    }

    public static char[][] isPath(char[][] map, int currentRow, int currentCol) {

    }

    // public static String[][] savePaths(String[] newPath) {

    // }

    public static int goThroughMap(char[][] map, int currentRow, int currentCol, String prevDir,
            String[] directions) {

        // CHECK MAP
        for (int x = 0; x < map.length; x++) {
            for (int m = 0; m < map[x].length; m++) {
                System.out.print(map[x][m]);
            }
            System.out.println();
        }
        System.out.println();

        // add the direction here (into the array)
        if (!(map[currentRow][currentCol] == 'W'))
            directions = addDirection(directions, prevDir);

        if (map[currentRow][currentCol] == 'X'
                || map[currentRow][currentCol] == '*') {
            return 0;
        }

        if (map[currentRow][currentCol] == 'S') {
            // CHECK DIRECTIONS
            for (int poo = 0; poo < directions.length; poo++) {
                System.out.print(directions[poo]);
            }
            System.out.println();
            // CHECK DIRECTIONS END

            // paths = savePaths(directions); // CONTINUE THIS, ADD NEW DIRECTIONS OF THE
            // PATH INTO THE 2D ARRAY PATHS
            return 0;
        }

        if (!(currentRow == 0 && currentCol == 0))
            map[currentRow][currentCol] = '*';

        if (currentRow == 0) { // first row
            if (currentCol == 0) { // (only check south and east)
                return goThroughMap(map, currentRow, currentCol + 1, "east", directions)
                        + goThroughMap(map, currentRow + 1, currentCol, "south", directions)
                        + 1;
            } else if (currentCol == map[0].length - 1) { // if last column (only check west or south)
                if (prevDir == "east")
                    return goThroughMap(map, currentRow + 1, currentCol, "south", directions) + 1;
                else if (prevDir == "north")
                    return goThroughMap(map, currentRow, currentCol - 1, "west", directions) + 1;

                else
                    return goThroughMap(map, currentRow + 1, currentCol, "south", directions)
                            + goThroughMap(map, currentRow, currentCol - 1, "west", directions)
                            + 1;
            }

            else { // check east, south, west
                if (prevDir == "east")
                    return goThroughMap(map, currentRow + 1, currentCol, "south", directions)
                            + goThroughMap(map, currentRow, currentCol + 1, "east", directions) + 1;
                else if (prevDir == "north")
                    return goThroughMap(map, currentRow, currentCol - 1, "west", directions)
                            + goThroughMap(map, currentRow, currentCol + 1, "east", directions) + 1;
                else if (prevDir == "west")
                    return goThroughMap(map, currentRow, currentCol - 1, "west", directions)
                            + goThroughMap(map, currentRow + 1, currentCol, "south", directions) + 1;
                else
                    return goThroughMap(map, currentRow, currentCol - 1, "west", directions)
                            + goThroughMap(map, currentRow + 1, currentCol, "south", directions)
                            + goThroughMap(map, currentRow, currentCol + 1, "east", directions) + 1;
            }

        } else if (currentRow == map.length - 1) { // last row
            if (currentCol == 0) { // (only check north and east)
                if (prevDir == "west")
                    return goThroughMap(map, currentRow - 1, currentCol, "north", directions) + 1;
                else if (prevDir == "south")
                    return goThroughMap(map, currentRow, currentCol + 1, "east", directions) + 1;
                else
                    return goThroughMap(map, currentRow, currentCol + 1, "east", directions)
                            + goThroughMap(map, currentRow - 1, currentCol, "north", directions)
                            + 1;
            } else if (currentCol == map[0].length - 1) { // if last column (only check north or west)
                if (prevDir == "east")
                    return goThroughMap(map, currentRow - 1, currentCol, "north", directions) + 1;
                else if (prevDir == "south")
                    return goThroughMap(map, currentRow, currentCol - 1, "west", directions) + 1;

                else
                    return goThroughMap(map, currentRow - 1, currentCol, "north", directions)
                            + goThroughMap(map, currentRow, currentCol - 1, "west", directions)
                            + 1;
            }

            else { // check east, north, west
                if (prevDir == "east")
                    return goThroughMap(map, currentRow - 1, currentCol, "north", directions)
                            + goThroughMap(map, currentRow, currentCol + 1, "east", directions) + 1;
                else if (prevDir == "south")
                    return goThroughMap(map, currentRow, currentCol - 1, "west", directions)
                            + goThroughMap(map, currentRow, currentCol + 1, "east", directions) + 1;
                else if (prevDir == "west")
                    return goThroughMap(map, currentRow, currentCol - 1, "west", directions)
                            + goThroughMap(map, currentRow - 1, currentCol, "north", directions) + 1;
                else
                    return goThroughMap(map, currentRow, currentCol - 1, "west", directions)
                            + goThroughMap(map, currentRow - 1, currentCol, "north", directions)
                            + goThroughMap(map, currentRow, currentCol + 1, "east", directions) + 1;
            }
        } else { // middle rows
            if (currentCol == 0) { // check north, east, south
                if (prevDir == "west")
                    return goThroughMap(map, currentRow - 1, currentCol, "north", directions)
                            + goThroughMap(map, currentRow + 1, currentCol, "south", directions) + 1;
                else if (prevDir == "north")
                    return goThroughMap(map, currentRow - 1, currentCol, "north", directions)
                            + goThroughMap(map, currentRow, currentCol + 1, "east", directions) + 1;
                else if (prevDir == "south")
                    return goThroughMap(map, currentRow, currentCol + 1, "east", directions)
                            + goThroughMap(map, currentRow + 1, currentCol, "south", directions) + 1;
                else
                    return goThroughMap(map, currentRow, currentCol + 1, "east", directions)
                            + goThroughMap(map, currentRow - 1, currentCol, "north", directions)
                            + goThroughMap(map, currentRow + 1, currentCol, "south", directions) + 1;
            } else if (currentCol == map[0].length - 1) { // check north, west, south
                if (prevDir == "east")
                    return goThroughMap(map, currentRow - 1, currentCol, "north", directions)
                            + goThroughMap(map, currentRow + 1, currentCol, "south", directions) + 1;
                else if (prevDir == "south")
                    return goThroughMap(map, currentRow, currentCol - 1, "west", directions)
                            + goThroughMap(map, currentRow + 1, currentCol, "south", directions) + 1;
                else if (prevDir == "north")
                    return goThroughMap(map, currentRow - 1, currentCol, "north", directions)
                            + goThroughMap(map, currentRow, currentCol - 1, "west", directions) + 1;
                else
                    return goThroughMap(map, currentRow - 1, currentCol, "north", directions) +
                            goThroughMap(map, currentRow, currentCol - 1, "west", directions)
                            + goThroughMap(map, currentRow + 1, currentCol, "south", directions) + 1;
            } else { // check all
                if (prevDir == "east")
                    return goThroughMap(map, currentRow, currentCol + 1, "east", directions)
                            + goThroughMap(map, currentRow - 1, currentCol, "north", directions)
                            + goThroughMap(map, currentRow + 1, currentCol, "south", directions) + 1;
                else if (prevDir == "west")
                    return goThroughMap(map, currentRow, currentCol - 1, "west", directions)
                            + goThroughMap(map, currentRow - 1, currentCol, "north", directions)
                            + goThroughMap(map, currentRow + 1, currentCol, "south", directions) + 1;
                else if (prevDir == "north")
                    return goThroughMap(map, currentRow, currentCol + 1, "east", directions)
                            + goThroughMap(map, currentRow - 1, currentCol, "north", directions)
                            + goThroughMap(map, currentRow, currentCol - 1, "west", directions);
                else // prevDir == "south"
                    return goThroughMap(map, currentRow + 1, currentCol, "south", directions)
                            + goThroughMap(map, currentRow, currentCol - 1, "west", directions)
                            + goThroughMap(map, currentRow, currentCol + 1, "east", directions);
            }
        }
    }

    public static void main(String[] args) {
        char[][] map = { { 'W', '-', '-', '-', '-', '-', 'X', 'X', 'X', 'X' },
                { 'X', 'X', '-', 'X', 'X', '-', '-', '-', '-', 'X' },
                { 'X', '-', '-', '-', '-', '-', 'X', 'X', '-', 'X' },
                { 'X', '-', 'X', 'X', 'X', 'X', 'X', 'X', '-', 'X' },
                { 'X', '-', '-', '-', '-', '-', '-', '-', '-', 'S' } };
        String[] directions = new String[0];

        System.out.println(goThroughMap(map, 0, 0, null, directions)); // returns number of open spaces you can walk
                                                                       // through
    }
}
