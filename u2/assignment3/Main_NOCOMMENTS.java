package u2.assignment3;

import java.util.*;
import java.io.*;

public class Main_NOCOMMENTS {
    public static int binarySearch_Name(ArrayList<Games> games, String key, int left, int right) {
        int mid = (left + right) / 2;
        if (left > right)
            return -left - 1;
        if (key.equalsIgnoreCase(games.get(mid).getName()))
            return mid;
        else if (key.toLowerCase().compareTo(games.get(mid).getName().toLowerCase()) < 0) {
            return binarySearch_Name(games, key, left, mid - 1);
        } else
            return binarySearch_Name(games, key, mid + 1, right);
    }

    public static int findRanking(ArrayList<Games> games, double key, int left, int right) {
        Collections.sort(games, new SortByRating());
        while (left <= right) {
            int mid = (left + right) / 2;
            if (key == games.get(mid).getRating()) {
                while (key == games.get(mid).getRating() && mid != 0) {
                    mid--;
                }
                if (mid == 0)
                    return 0;
                return mid + 1;
            } else if (key > games.get(mid).getRating()) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -left - 1;
    }

    public static int binarySearch_Type(ArrayList<Games> games, String key, int left, int right) {
        int mid = (left + right) / 2;
        if (left > right)
            return -left - 1;
        if (key.equalsIgnoreCase(games.get(mid).getType()))
            return mid;
        else if (key.toLowerCase().compareTo(games.get(mid).getType().toLowerCase()) < 0) {
            return binarySearch_Type(games, key, left, mid - 1);
        } else
            return binarySearch_Type(games, key, mid + 1, right);
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Games> games = new ArrayList<>();
        String line;
        double rating;
        String name;
        String type;
        String searchBy = "";
        String userLine = "";

        try {
            BufferedReader in = new BufferedReader(new FileReader("input.txt"));
            while ((line = in.readLine()) != null) {
                line = line.strip();
                StringTokenizer st = new StringTokenizer(line);
                if (st.countTokens() >= 3) {
                    try {
                        rating = Double.parseDouble(st.nextToken());
                        if (rating < 0 || rating > 10)
                            throw new NumberFormatException();
                        name = line.substring(line.indexOf(" ") + 1, line.lastIndexOf(" "));
                        type = line.substring(line.lastIndexOf(" ") + 1);
                        games.add(new Games(rating, name, type));
                    } catch (NumberFormatException e) {
                        System.out.println("Line skipped (Invalid rating): " + line);
                    }
                } else {
                    System.out.println("Line skipped (Invalid # of input fields): " + line);
                }
            }
            if (games.size() == 0)
                System.out.println("You own 0 games... :( Automatically exiting.");
            else {
                Scanner userIn = new Scanner(System.in);
                while (!searchBy.equalsIgnoreCase("exit")) {
                    System.out.print("\nSearch by game, type, or exit?: ");
                    searchBy = userIn.nextLine().strip();
                    if (searchBy.equalsIgnoreCase("exit")) {
                        break;
                    }
                    while (searchBy.equalsIgnoreCase("game")) {
                        System.out.print("\nEnter a game or exit: ");
                        userLine = userIn.nextLine().strip();
                        int indexOfGame;
                        if (userLine.equalsIgnoreCase("exit"))
                            break;
                        else if (userLine.length() > 0) {
                            Collections.sort(games);
                            indexOfGame = binarySearch_Name(games, userLine, 0, games.size() - 1);
                            if (indexOfGame < 0) {
                                System.out.println("You don't own this game :(");
                            } else {
                                System.out.print(games.get(indexOfGame));

                                System.out.println(
                                        "Ranking: " + (findRanking(games, games.get(indexOfGame).getRating(), 0,
                                                games.size() - 1) + 1) + " out of " + games.size());
                            }
                        } else {
                            System.out.print("\nInvalid input.");
                        }
                    }
                    while (searchBy.equalsIgnoreCase("type")) {
                        System.out.print("\nEnter a type or exit: ");
                        userLine = userIn.nextLine().strip();
                        if (userLine.equalsIgnoreCase("exit")) {
                            break;
                        } else if (userLine.length() > 0) {
                            ArrayList<Games> gamesEdited = new ArrayList<>(games);
                            Collections.sort(gamesEdited, new SortByType());

                            int indexOfGame = binarySearch_Type(gamesEdited, userLine, 0, gamesEdited.size() - 1);

                            if (indexOfGame < 0) {
                                System.out.println("You don't own a game of this type :(");
                            } else {
                                ArrayList<Games> gamesInType = new ArrayList<>();
                                do {
                                    gamesInType.add(gamesEdited.get(indexOfGame));
                                    gamesEdited.remove(indexOfGame);
                                    indexOfGame = binarySearch_Type(gamesEdited, userLine, 0,
                                            gamesEdited.size() - 1);
                                } while (indexOfGame >= 0);
                                Collections.sort(gamesInType);
                                Collections.sort(games);
                                for (int game = 0; game < gamesInType.size(); game++) {
                                    System.out.print(gamesInType.get(game));

                                    System.out.println("Ranking: "
                                            + (findRanking(games, gamesInType.get(game).getRating(), 0,
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
                userIn.close();
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not Found.");
        }
    }
}
