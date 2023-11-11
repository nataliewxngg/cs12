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
        int index;

        // display list
        Collections.sort(albums);
        for (int album = 0; album < albums.size(); album++) {
            System.out.printf("%d. Album #%d\n", album + 1, albums.get(album).getNum());
        }
        // prompt user for album
        do {
            try {
                System.out.print("\nSelect an album (enter album's LIST #): ");
                index = Integer.parseInt(in.nextLine().strip()) - 1;

                if (index < 0 || index >= albums.size())
                    throw new NumberFormatException();
                else {
                    System.out.println("");
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.print("\nInvalid input.");
            }
        } while (true);
        // display the info
        albums.get(index).displayInfo();
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

            albumNum = Integer.parseInt(inFile.readLine().strip());
            if (albumNum <= 0) { // don't allow for negative/0 album #s
                inFile.close();
                System.out.println(
                        "The album number of this album is invalid... Album not added into collection. :(\n");
                return;
            }

            // check for duplicates
            Collections.sort(albums);
            int index = Collections.binarySearch(albums, new Album(albumNum, 0, emptyArrList, new Date("00/00/0000")));

            if (index >= 0) // album already exists
                System.out.println("This album already exists!\n");
            else {
                // Date of album
                date = new Date(inFile.readLine().strip());

                if (!date.valid()) { // Stop if date entered is invalid
                    System.out
                            .println("The date of album creation is invalid... Album not added into collection. :(\n");
                    inFile.close();
                    return;
                }

                // Maximum capacity of the album
                capacity = Integer.parseInt(inFile.readLine().strip());

                if (capacity < 1) { // Invalid capacity - less than 1
                    System.out.println(
                            "The maximum capacity of this album is invalid... Album not added into collection. :(\n");
                    inFile.close();
                    return;
                }

                // Number of cards in album
                numCards = Integer.parseInt(inFile.readLine().strip());

                if (numCards < 0) { // have negative # of cards
                    System.out.println(
                            "The number of cards in this album is invalid... Album not added into collection. :(\n");
                    inFile.close();
                    return;
                } else if (numCards > capacity) {
                    System.out.println(
                            "The number of cards in this album exceeds maximum capacity... Album not added into collection. :(\n");
                    inFile.close();
                    return;
                }

                // Loops for ALL cards in the album
                for (int card = 0; card < numCards; card++) {
                    // Name of card
                    cardName = inFile.readLine().strip();

                    // HP of card
                    HP = Integer.parseInt(inFile.readLine().strip());
                    if (HP < 1) { // HP of pokemon cards must ATLEAST be 1
                        System.out.println("A card in this album is invalid... Album not added into collection :(\n");
                        inFile.close();
                        return;
                    }

                    type = inFile.readLine();

                    // Date of purchase/trade
                    dateOfCard = new Date(inFile.readLine().strip());

                    if (!dateOfCard.valid()) {
                        System.out.println("A card in this album is invalid... Album not added into collection :(\n");
                        inFile.close();
                        return;
                    }

                    // Number of attacks
                    numAttacks = Integer.parseInt(inFile.readLine().strip());
                    if (numAttacks < 0) { // Don't allow for negative # of attacks
                        System.out.println("A card in this album is invalid... Album not added into collection :(\n");
                        inFile.close();
                        return;
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
                        attackDamage = inFile.readLine().strip();

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
            System.out.println("This file consists an invalid integer input... Album not added into collection:(\n");
        }
    }

    public static void removeAlbum(ArrayList<Album> albums, Scanner in) { // #1-#4
        int index;
        int option = 0;

        Date date;
        ArrayList<Card> emptyArrList = new ArrayList<>();

        ArrayList<Album> albumsCopy = new ArrayList<>(albums);
        ArrayList<Album> albumsWithDate = new ArrayList<>();

        ArrayList<String> displayedDates = new ArrayList<>();
        int removeChoice;

        // prompts for remove by option
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
                System.out.print("\nInvalid input.\n");
            }
        } while (true);

        if (option == 1) { // remove by album #
            // display list
            Collections.sort(albums);
            for (int album = 0; album < albums.size(); album++) {
                System.out.printf("%d. Album #%d\n", album + 1, albums.get(album).getNum());
            }
            // prompt user for album
            do {
                try {
                    System.out.print("\nSelect an album (enter album's LIST #): ");
                    index = Integer.parseInt(in.nextLine().strip()) - 1;

                    if (index < 0 || index >= albums.size())
                        throw new NumberFormatException();
                    else {
                        System.out.println("");
                        break;
                    }

                } catch (NumberFormatException e) {
                    System.out.print("\nInvalid input.");
                }
            } while (true);

            System.out.printf("Album %d has been successfully removed!\n\n", albums.get(index).getNum());
            albums.remove(index);

        } else { // remove by album date

            // puts dates into a displayedDates, has no duplicates
            Collections.sort(albums, new SortAlbumsByDate());
            for (int album = 0; album < albums.size(); album++) {
                if (!displayedDates.contains(albums.get(album).getDateDisplay())) { // only if date is not already in
                                                                                    // the list
                    displayedDates.add(albums.get(album).getDateDisplay());
                }
            }

            // display the list of dates
            for (int displayedDate = 0; displayedDate < displayedDates.size(); displayedDate++) {
                System.out.printf("%d. %s\n", displayedDate + 1, displayedDates.get(displayedDate));
            }

            // prompts user to select a date to remove
            do {
                try {
                    System.out.print("\nSelect a date (enter #): ");
                    index = Integer.parseInt(in.nextLine().strip()) - 1;

                    if (index < 0 || index >= albums.size())
                        throw new NumberFormatException();
                    else {
                        date = new Date(displayedDates.get(index));
                        System.out.println("");
                        break;
                    }

                } catch (NumberFormatException e) {
                    System.out.print("\nInvalid input.");
                }
            } while (true);

            // finds all albums with same date and puts them into albumsWithDate
            do {
                Collections.sort(albumsCopy, new SortAlbumsByDate());

                index = Collections.binarySearch(albumsCopy, new Album(0, 0, emptyArrList,
                        date),
                        new SortAlbumsByDate());
                if (index >= 0) {
                    albumsWithDate.add(albumsCopy.get(index));
                    albumsCopy.set(index,
                            new Album(0, 0, emptyArrList, new Date("00/00/0000")));
                } else
                    break;
            } while (true);

            if (albumsWithDate.size() == 1) { // 1 album w same date of creation found
                albums.remove(Collections.binarySearch(albums, new Album(0, 0, emptyArrList,
                        date),
                        new SortAlbumsByDate()));
                System.out.println("Album removed!\n");
            } else { // more than 1 album w same date of creation found

                System.out.printf("There are %d albums with the same date of creation:\n",
                        albumsWithDate.size());

                Collections.sort(albumsWithDate);
                for (int albumWithDate = 0; albumWithDate < albumsWithDate.size(); albumWithDate++) {
                    System.out.printf("%d. Album #%d\n", albumWithDate + 1,
                            albumsWithDate.get(albumWithDate).getNum());
                }

                do {
                    try {
                        System.out.print("Which album would you like to remove? (Select the album's LIST #): ");
                        removeChoice = Integer.parseInt(in.nextLine());

                        if (removeChoice < 1 || removeChoice > albumsWithDate.size())
                            throw new NumberFormatException();
                        else {
                            // remove the album
                            albums.remove(albums.indexOf(albumsWithDate.get(removeChoice - 1)));
                            System.out.println("Album removed!\n");
                            break;
                        }

                    } catch (NumberFormatException e) {
                        System.out.print("\nInvalid input. ");
                    }
                } while (true);

            }
        }
    }

    public static void stats(ArrayList<Album> albums) { // #1-#5
        Collections.sort(albums); // sort by album # (ascending order)
        System.out.println();

        for (int album = 0; album < albums.size(); album++) {
            System.out.printf("%-10s: %d out of %d%n", "Album " + albums.get(album).getNum(),
                    albums.get(album).getCards().size(), albums.get(album).getCapacity());
            System.out.printf("%-10s: %.1f%n", "",
                    albums.get(album).getTotalHP() * 1.0 / albums.get(album).getCards().size());
        }

        System.out.printf("%s: %d out of %d\n", "ALL albums", Album.getTotalNumOfCards(), Album.getTotalCapacity());
        System.out.printf("%-10s: %.1f\n\n", "", 1.0 * Album.getTotalHPOfAllAlbums() / Album.getTotalNumOfCards());
    }

    public static void main(String[] args) throws IOException {
        // Variables
        ArrayList<Album> albums = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        int choice = 0;
        int subChoice;

        Album albumSM2; // chosen album for submenu #2
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
                } else if (subChoice == 5) { // Menu #1 Submenu #5
                    if (albums.size() > 0)
                        stats(albums);
                    else
                        System.out.println("You own 0 albums... :(\n");
                } else if (subChoice == 6) { // Menu #1 Submenu #6
                    // Exit
                    break;
                }
            }

            if (choice == 2) {

                // display list
                Collections.sort(albums);
                for (int album = 0; album < albums.size(); album++) {
                    System.out.printf("%d. Album #%d\n", album + 1, albums.get(album).getNum());
                }

                // prompt user for album
                do {
                    try {
                        System.out.print("\nSelect an album (enter LIST #): ");
                        index = Integer.parseInt(in.nextLine().strip()) - 1;

                        if (index < 0 || index >= albums.size())
                            throw new NumberFormatException();
                        else {
                            albumSM2 = albums.get(index);
                            System.out.printf("You selected album #%d!\n\n", albumSM2.getNum());
                            break;
                        }

                    } catch (NumberFormatException e) {
                        System.out.print("\nInvalid input.");
                    }
                } while (true);

                // album chosen, in submenu 2 now
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
                        chosenAlbum.displayCard(in);
                    } else if (subChoice == 3) { // Menu #2 Submenu #3
                        chosenAlbum.addCard(in);
                    } else if (subChoice == 4) { // Menu #2 Submenu #4
                        chosenAlbum.removeCard(in);
                    } else if (subChoice == 5) {
                        // Menu #2 Submenu #5
                        chosenAlbum.editAttack(in);
                    } else if (subChoice == 6) { // Menu #2 Submenu #6
                        chosenAlbum.sortCards(in);
                    } else if (subChoice == 7) { // Menu #2 Submenu #7
                        // Exit
                        break;
                    }
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
