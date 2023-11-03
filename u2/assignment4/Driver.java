package u2.assignment4;

import java.util.*;
import java.io.*;

public class Driver {
    public static void displayAlbums(ArrayList<Album> albums) { // #1-#1
        if (albums.size() == 0) // own 0 albums
            System.out.println("You own 0 albums... :(\n");
        else { // own 1+ albums
            Collections.sort(albums); // sort by album #
            for (int album = 0; album < albums.size(); album++) {
                System.out.printf("\nAlbum Number: %d\nDate: %s\n", albums.get(album).getNum(),
                        albums.get(album).getDateDisplay());
            }
            System.out.println();
        }
    }

    public static void displayInfo(Scanner in, ArrayList<Album> albums) { // #1-#2
        int albumNum;
        ArrayList<Card> emptyArrList = new ArrayList<>();

        try {
            // Prompt for album
            System.out.print("Enter the album #: ");
            albumNum = Integer.parseInt(in.nextLine().strip());

            if (albumNum <= 0) { // don't allow for negative/0 album #s
                throw new NumberFormatException();
            }

            Collections.sort(albums); // sort by album # and see if album already exists
            int index = Collections.binarySearch(albums,
                    new Album(albumNum, 0, emptyArrList, new Date("00/00/0000")));

            if (index >= 0) { // album found
                albums.get(index).displayInfo();
            } else { // album not found
                System.out.println("You don't own this album... :(\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid album #.\n");
        }
    }

    public static void addAlbum(ArrayList<Album> albums, Scanner in) throws IOException { // #1-#3
        System.out.print("Enter the file name (exclude .txt): ");
        String fileName = in.nextLine().strip();

        ArrayList<Card> emptyArrList = new ArrayList<>();

        int albumNum;
        Date date;
        int capacity;
        int numCards;

        ArrayList<Card> cards = new ArrayList<>();
        String cardName;
        int HP;
        String type;
        Date dateOfCard;
        int numAttacks;

        ArrayList<Attack> attacks = new ArrayList<>();
        StringTokenizer attackNameAndDesc;
        String attackName;
        String attackDesc;
        String attackDamage;

        try {
            BufferedReader inFile = new BufferedReader(new FileReader(fileName + ".txt"));

            albumNum = Integer.parseInt(inFile.readLine());
            if (albumNum <= 0) { // don't allow for negative/0 album #s
                inFile.close();
                System.out.println(
                        "The album number of this album is invalid... Album not added into collection. :(");
                throw new NumberFormatException();
            }

            // check for duplicates
            Collections.sort(albums);
            int index = Collections.binarySearch(albums, new Album(albumNum, 0, emptyArrList, new Date("00/00/0000")));

            if (index >= 0) // album already exists
                System.out.println("This album already exists!\n");
            else {
                // Date of album
                date = new Date(inFile.readLine());

                if (!date.valid()) { // Stop if date entered is invalid
                    System.out.println("The date of album creation is invalid... Album not added into collection. :(");
                    inFile.close();
                    throw new NumberFormatException();
                }

                // Maximum capacity of the album
                capacity = Integer.parseInt(inFile.readLine());

                if (capacity < 1) { // Invalid capacity - less than 1
                    System.out.println(
                            "The maximum capacity of this album is invalid... Album not added into collection. :(");
                    inFile.close();
                    throw new NumberFormatException();
                }

                // Number of cards in album
                numCards = Integer.parseInt(inFile.readLine());

                if (numCards < 0) { // have negative # of cards
                    System.out.println(
                            "The number of cards in this album is invalid... Album not added into collection. :(");
                    inFile.close();
                    throw new NumberFormatException();
                } else if (numCards > capacity) {
                    System.out.println(
                            "The number of cards in this album exceeds maximum capacity... Album not added into collection. :(");
                    inFile.close();
                    throw new NumberFormatException();
                }

                // Loops for ALL cards in the album
                for (int card = 0; card < numCards; card++) {
                    // Name of card
                    cardName = inFile.readLine();

                    // HP of card
                    HP = Integer.parseInt(inFile.readLine());
                    if (HP < 1) { // HP of pokemon cards must ATLEAST be 1
                        System.out.println("A card in this album is invalid... Album not added into collection :(");
                        inFile.close();
                        throw new NumberFormatException();
                    }

                    type = inFile.readLine();

                    // Date of purchase/trade
                    dateOfCard = new Date(inFile.readLine());

                    if (!dateOfCard.valid()) {
                        System.out.println("A card in this album is invalid... Album not added into collection :(");
                        inFile.close();
                        throw new NumberFormatException();
                    }

                    // Number of attacks
                    numAttacks = Integer.parseInt(inFile.readLine());
                    if (numAttacks < 0) { // Don't allow for negative # of attacks
                        System.out.println("A card in this album is invalid... Album not added into collection :(");
                        inFile.close();
                        throw new NumberFormatException();
                    }

                    // Attacks
                    attacks = new ArrayList<>();
                    for (int attack = 0; attack < numAttacks; attack++) {
                        attackNameAndDesc = new StringTokenizer(inFile.readLine(), "-");
                        attackName = attackNameAndDesc.nextToken().strip();

                        if (attackNameAndDesc.hasMoreTokens()) {
                            attackDesc = attackNameAndDesc.nextToken().strip();
                        } else
                            attackDesc = "";
                        attackDamage = inFile.readLine();

                        attacks.add(new Attack(attackName, attackDesc, attackDamage));
                    }
                    cards.add(new Card(cardName, HP, type, dateOfCard, attacks));
                }
                albums.add(new Album(albumNum, capacity, cards, date));
                System.out.printf("YAY! Album #%d was added into the collection!\n\n", albumNum);
            }

            inFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("This album doesn't exist :(\n");
        } catch (NumberFormatException e) {
            System.out.println();
        }
    }

    public static void removeAlbum(ArrayList<Album> albums, Scanner in) { // #1-#4
        int option = 0;
        int albumNum;

        String inDate;
        StringTokenizer st;
        Date date;
        ArrayList<Card> emptyArrList = new ArrayList<>();

        do {
            try {
                System.out.print("\n1. Album Number \n2. Date (MM/DD/YYYY)\nRemove by: ");
                option = Integer.parseInt(in.nextLine().strip());

                if (option != 1 && option != 2)
                    throw new NumberFormatException();
                else {
                    System.out.println("");
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.print("\nInvalid input. ");
            }
        } while (true);

        if (option == 1) { // remove by album #
            System.out.print("Enter the album #: ");

            try {
                albumNum = Integer.parseInt(in.nextLine().strip());

                Collections.sort(albums);
                int index = Collections.binarySearch(albums,
                        new Album(albumNum, 0, emptyArrList, new Date("00/00/0000")));

                if (index >= 0) { // already exists
                    albums.remove(index);
                    System.out.printf("Album %d has been successfully removed!\n\n", albumNum);
                } else {
                    System.out.println("Enter an album you actually own next time...\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid album #.");
            }
        } else { // remove by album date
            System.out.print("Enter the date (MM/DD/YYYY): ");

            inDate = in.nextLine().strip();
            st = new StringTokenizer(inDate, "/");

            if (st.countTokens() == 3) {
                // make sure all the tokens are integers
                try {
                    Integer.parseInt(st.nextToken());
                    Integer.parseInt(st.nextToken());
                    Integer.parseInt(st.nextToken());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid date inputted\n");
                    return;
                }

                date = new Date(inDate);

                if (date.valid()) {
                    Collections.sort(albums, new SortAlbumsByDate());
                    int index = Collections.binarySearch(albums, new Album(0, 0, emptyArrList, date),
                            new SortAlbumsByDate());

                    if (index >= 0) {
                        albums.remove(index);
                        System.out.println("Album removed!\n");
                    } else {
                        System.out.println("You don't own an album with this album creation date...\n");
                    }
                } else {
                    System.out.println("Invalid date inputted...\n");
                }
            } else {
                System.out.println("Invalid date inputted...\n");
            }
        }

    }

    public static void main(String[] args) throws IOException {
        // Variables
        ArrayList<Album> albums = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        int choice = 0;
        int subChoice;

        ArrayList<Card> emptyArrList = new ArrayList<>();

        int albumNum;
        int index;

        // Main Code
        System.out.println("Welcome to My Pokemon Cards Collection!");

        // Prompt the user for input
        while (true) {
            choice = 0;
            subChoice = 0;

            System.out.println(
                    "\n----------  MAIN MENU  -----------\n1) Accessing your list of albums\n2) Accessing within a particular album\n3) Exit\n----------------------------------\n");

            // Prompt for menu option
            do {
                try {
                    System.out.print("Enter your choice: ");
                    choice = Integer.parseInt(in.nextLine().strip());

                    if (choice < 1 || choice > 3)
                        throw new NumberFormatException();
                    else if (choice == 2 && albums.size() == 0) {
                        System.out.println("You don't own any albums.");
                        choice = 0;
                        break;
                    } else {
                        if (choice == 1)
                            System.out.println("");
                        break;
                    }

                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. ");
                }
            } while (true);

            while (choice == 1) {
                // Submenu 1
                System.out.println(
                        "---------  SUB-MENU #1  ----------\n1) Display a list of all albums\n2) Display information on a particular album\n3) Add an album\n4) Remove an album\n5) Show statistics\n6) Return back to main menu\n----------------------------------\n");

                // Prompt for submenu option
                do {
                    try {
                        System.out.print("Enter your choice: ");
                        subChoice = Integer.parseInt(in.nextLine().strip());

                        if (subChoice < 1 || subChoice > 6)
                            throw new NumberFormatException();
                        else
                            break;
                    } catch (NumberFormatException e) {
                        System.out.print("Invalid input. ");
                    }
                } while (true);

                if (subChoice == 1) { // Menu #1 Submenu #1
                    displayAlbums(albums);
                } else if (subChoice == 2) { // Menu #1 Submenu #2
                    if (albums.size() > 0)
                        displayInfo(in, albums);
                    else
                        System.out.println("You own 0 albums... :(\n");
                } else if (subChoice == 3) { // Menu #1 Submenu #3
                    addAlbum(albums, in);
                } else if (subChoice == 4) { // Menu #1 Submenu #4
                    if (albums.size() > 0)
                        removeAlbum(albums, in);
                    else
                        System.out.println("You own 0 albums... :(\n");
                } else if (subChoice == 5) {
                    // Menu #1 Submenu #5
                } else if (subChoice == 6) {
                    // Exit
                    break;
                }
            }

            if (choice == 2) {
                // Obtain the album number
                System.out.print("Enter the album #: ");

                try {
                    albumNum = Integer.parseInt(in.nextLine().strip());

                    if (albumNum <= 0) {
                        throw new NumberFormatException();
                    }

                    // Check if album exists
                    Collections.sort(albums);
                    index = Collections.binarySearch(albums,
                            new Album(albumNum, 0, emptyArrList, new Date("00/00/0000")));
                    System.out.println();

                    if (index < 0) {
                        System.out.println("You don't own this album... Returning back to main menu");
                    } else {
                        while (true) {
                            // Submenu 2
                            Album chosenAlbum = albums.get(index);
                            System.out.println(
                                    "---------  SUB-MENU #2  ----------\n1) Display all cards (in the last sorted order)\n2) Display information on a particular card\n3) Add a card\n4) Remove a card (4 options)\n5) Edit attack\n6) Sort cards (3 options)\n7) Return back to main menu\n----------------------------------\n");

                            // Prompt for submenu option
                            do {
                                try {
                                    System.out.print("Enter your choice: ");
                                    subChoice = Integer.parseInt(in.nextLine().strip());

                                    if (subChoice < 1 || subChoice > 7)
                                        throw new NumberFormatException();
                                    else
                                        break;
                                } catch (NumberFormatException e) {
                                    System.out.print("Invalid input. ");
                                }
                            } while (true);

                            if (subChoice == 1) { // Menu #2 Submenu #1
                                chosenAlbum.displayAllCards();
                            } else if (subChoice == 2) { // Menu #2 Submenu #2
                                System.out.print("Enter the card name: ");
                                chosenAlbum.displayCard(in.nextLine().strip());
                            } else if (subChoice == 3) {
                                // Menu #2 Submenu #3
                            } else if (subChoice == 4) {
                                // Menu #2 Submenu #4
                            } else if (subChoice == 5) {
                                // Menu #2 Submenu #5
                            } else if (subChoice == 6) {
                                // Menu #2 Submenu #6
                            } else if (subChoice == 7) {
                                // Exit
                                break;
                            }
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid album #.");
                }

            }

            if (choice == 3) {
                // Exit
                System.out.println("\nThank you for visiting my Pokemon Cards Collection! See you next time :)\n");
                in.close();
                break;
            }
        }
    }
}
