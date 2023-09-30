package assignment2;

public class anothertest {
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

        if (currentRow < 0 || currentRow >= map.length || currentCol < 0 || currentCol >= map[currentRow].length)
            return shortestRoute;

        // CHECK MAP
        for (int x = 0; x < map.length; x++) {
            for (int m = 0; m < map[x].length; m++) {
                System.out.print(map[x][m]);
            }
            System.out.println();
        }
        System.out.println();
        // CHECK MAP END

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

        return shortestRoute;
    }

    public static void main(String[] args) {
        char[][] map = { { 'W', '-', '-' },
                { '-', 'X', '-' },
                { 'X', '-', 'S' } };
        char[][] maps = new char[0][0];

        char[] shortestRoute = new char[0];
        char[] route = new char[0];
        // String[] directions = new String[0];

        System.out.println(shortestRoute(map, 0, 0, shortestRoute, route)); // returns number of open spaces you can
                                                                            // walk

        for (int row = 0; row < maps.length; row++) {
            for (int col = 0; col < maps[row].length; col++) {
                System.out.print(maps[row][col]);
                System.out.println("sdlkfjasdlkfjawefioj");
            }
            System.out.println();
        }
        // through
    }
}
