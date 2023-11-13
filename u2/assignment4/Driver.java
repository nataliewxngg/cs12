// Natalie Wong
// Due Sunday, November 12, 2023

// Assignment #4 - My Pokemon Cards Collection (WITHOUT BONUS)
// This program allows the user to - utilizing user input - interactively organize their Pokemon cards collection! 

package u2.assignment4;

import java.util.*;
import java.io.*;

public class Driver {

    // DESCRIPTION: Utilized for Menu #1 - Submenu #1:
    // Displays the ALBUM # and DATE OF ALBUM CREATION of ALL albums in the
    // collection
    public static void displayAlbums(ArrayList<Album> albums) { // PARAMETERS: An ArrayList containing all the albums in
                                                                // the collection

        // If there are 0 albums in the collection,
        // inform the user of it and exit the method
        if (albums.size() == 0)
            System.out.println("You own 0 albums.\n");

        // If there is/are 1+ albums in the collection,
        // display each's album # and date of album creation
        // (in ascending order of their album #s)
        else {
            Collections.sort(albums);

            // Display each album's album # and date of creation
            for (int album = 0; album < albums.size(); album++) {
                System.out.printf("\nAlbum Number: %d\nDate: %s\n", albums.get(album).getNum(),
                        albums.get(album).getDateDisplay());
            }
            System.out.println();
        }

        // RETURNS: none (void method)
    }

    // DESCRIPTION: Utilized for Menu #1 - Submenu #2:
    // Prompts the user for an existing album in the collection
    // and displays its album #, date, max capacity, # of cards, and total HP
    public static void displayInfo(Scanner in, ArrayList<Album> albums) { // PARAMETERS:
                                                                          // 1. A scanner to acquire user input
                                                                          // 2. An ArrayList containing all the albums
                                                                          // in the collection
        int index;
        System.out.println();

        // Display a list of ALL albums by album #, in ascending order
        Collections.sort(albums);
        for (int album = 0; album < albums.size(); album++) {
            System.out.printf("%d. Album #%d\n", album + 1, albums.get(album).getNum());
        }

        // Continuously prompt the user for an album to select from until a valid input
        // is inputted
        // (by selecting the # the album was listed off by in the previous list
        // displayed)
        do {
            try {
                System.out.print("Select an Album (by LIST #): ");
                index = Integer.parseInt(in.nextLine().strip()) - 1;

                if (index < 0 || index >= albums.size())
                    throw new NumberFormatException();
                else {
                    System.out.println("");
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.print("Invalid input. ");
            }
        } while (true);

        // Display the album #, date, max capacity, # of cards, and total HP of the
        // selected album
        albums.get(index).displayInfo();

        // RETURNS: none (void method)
    }

    // DESCRIPTION: Utilized for Menu #1 - Submenu #3:
    // Adds a new album into the collection given the filename of the txt file that
    // stores the album's information
    public static void addAlbum(ArrayList<Album> albums, Scanner in) throws IOException { // PARAMETERS:
                                                                                          // 1. An ArrayList containing
                                                                                          // all the albums in the
                                                                                          // collection
                                                                                          // 2. A scanner to acquire
                                                                                          // user input
                                                                                          // THROWS IOEXCEPTION: For the
                                                                                          // BufferedReader, which
                                                                                          // collects input from the
                                                                                          // textfile

        System.out.print("Enter the file name (exclude .txt): ");

        // Variables
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

        // Collects information of the new album from the textfile and -
        // given all fields are valid - adds the album into the collection
        try {
            BufferedReader inFile = new BufferedReader(new FileReader(fileName + ".txt"));

            // Acquires the album # - do NOT allow for negative/0 album #s
            albumNum = Integer.parseInt(inFile.readLine().strip());
            if (albumNum <= 0) { // If the album # is <=0, inform the user that this album contains an invalid
                                 // album # and exit the method
                inFile.close();
                System.out.println(
                        "This album contains an invalid album # (<=0) - Album not added into collection.\n");
                return;
            }

            Collections.sort(albums);
            // If the album already exists in the collection, inform the user of it and exit
            // the method
            if (Collections.binarySearch(albums, new Album(albumNum, 0, emptyArrList, new Date("00/00/0000"))) >= 0)
                System.out.println("This album already exists!\n");
            // Otherwise, if the album doesn't exist in the collection yet, continue to read
            // from its textfile
            else {

                // Acquires the album's date of creation - do NOT allow for invalid dates
                date = new Date(inFile.readLine().strip());
                if (!date.valid()) { // If the album's date of creation is invalid, inform the user of it
                                     // and exit the method
                    System.out.println(
                            "This album contains an invalid creation date - Album not added into collection.\n");
                    inFile.close();
                    return;
                }

                // Acquires the maximum capacity of the album - do NOT allow for a capacity of
                // less than 1
                capacity = Integer.parseInt(inFile.readLine().strip());
                if (capacity < 1) { // If the capacity of the album is less than 1, inform the user of it and exit
                                    // the method
                    System.out.println(
                            "The maximum capacity of this album is invalid (<1) - Album not added into collection.\n");
                    inFile.close();
                    return;
                }

                // Acquires the number of cards in the album - do NOT allow for a negative # of
                // cards, or a total # of cards larger than the maximum capacity
                numCards = Integer.parseInt(inFile.readLine().strip());
                if (numCards < 0) { // If the album contains a negative number of cards, inform the user of it and
                                    // exit the method
                    System.out.println(
                            "This album contains an invalid number of cards (<0) - Album not added into collection.\n");
                    inFile.close();
                    return;
                } else if (numCards > capacity) { // If the album contains more cards than it can store (> maximum
                                                  // capacity), inform the user of it and exit the method
                    System.out.println(
                            "This album contains more cards than its maximum capacity - Album not added into collection.\n");
                    inFile.close();
                    return;
                }

                // Acquires the name, HP, type, date of purchase/trade, and attack(s) of EVERY
                // card in the album
                for (int card = 0; card < numCards; card++) {

                    // Acquires the card name
                    cardName = inFile.readLine().strip();

                    // Acquires the HP of card - do NOT allow for an HP of less than 1
                    HP = Integer.parseInt(inFile.readLine().strip());
                    if (HP < 1) { // If the HP of the current card is less than 1, inform the user of it and exit
                                  // the method
                        System.out.println(
                                "A card in this album contains an invalid HP (<1) - Album not added into collection.\n");
                        inFile.close();
                        return;
                    }

                    // Acquires the card type
                    type = inFile.readLine();

                    // Acquires the date of purchase/trade of the card - do NOT allow for invalid
                    // dates
                    dateOfCard = new Date(inFile.readLine().strip());
                    if (!dateOfCard.valid()) { // If the date of purchase/trade of the card is invalid, inform the user
                                               // of it and exit the method
                        System.out.println(
                                "The date of purchase/trade of an existing card in this album is invalid - Album not added into collection.\n");
                        inFile.close();
                        return;
                    }

                    // Acquires the number of attacks of the card - do NOT allow for a negative # of
                    // attacks
                    numAttacks = Integer.parseInt(inFile.readLine().strip());
                    if (numAttacks < 0) { // If the card contains a negative # of attacks, inform the user of it and
                                          // exit the method
                        System.out.println(
                                "A card in this album contains an invalid # of attacks (<0) - Album not added into collection.\n");
                        inFile.close();
                        return;
                    }

                    attacks = new ArrayList<>();
                    // Acquires the name, description, and damage of EVERY attack the current card
                    // contains
                    for (int attack = 0; attack < numAttacks; attack++) {
                        attackNameAndDesc = new StringTokenizer(inFile.readLine(), "-");

                        // Acquires the attack name
                        attackName = attackNameAndDesc.nextToken().strip();

                        // If the attack contains a description, acquire it
                        // Otherwise, set the description of the current attack to an empty string
                        if (attackNameAndDesc.hasMoreTokens()) {
                            attackDesc = attackNameAndDesc.nextToken().strip();
                        } else
                            attackDesc = "";

                        // Acquires the attack damage
                        attackDamage = inFile.readLine().strip();

                        // Adds the new attack to the card
                        attacks.add(new Attack(attackName, attackDesc, attackDamage));
                    }

                    // Adds the new card into the album
                    cards.add(new Card(cardName, HP, type, dateOfCard, attacks));
                }

                // Adds the new album into the collection
                albums.add(new Album(albumNum, capacity, cards, date));
                System.out.printf("YAY! Album #%d was added into the collection!\n\n", albumNum);
            }
            inFile.close();

        } catch (FileNotFoundException e) { // If the textfile of the album (given by the user) doesn't exist, inform
                                            // the user of it and exit the method
            System.out.println("This album doesn't exist.\n");
        } catch (NumberFormatException e) { // If there are invalid integer inputs in the new album, inform the user of
                                            // it and exit the method
            System.out.println("This file consists an invalid integer input - Album not added into collection.\n");
        }

        // RETURNS: none (void method)
    }

    // DESCRIPTION: Utilized for Menu #1 - Submenu #4:
    // Removes an album from the collection either by ALBUM # or by DATE (of album
    // creation)
    public static void removeAlbum(ArrayList<Album> albums, Scanner in) { // PARAMETERS:
                                                                          // 1. An ArrayList containing all the albums
                                                                          // in the collection
                                                                          // 2. A scanner to acquire user input
        int index;
        int option = 0;

        Date date;
        ArrayList<Card> emptyArrList = new ArrayList<>();

        ArrayList<Album> albumsCopy = new ArrayList<>(albums);
        ArrayList<Album> albumsWithDate = new ArrayList<>();

        ArrayList<String> noDuplicateDates = new ArrayList<>();
        int removeChoice;

        // Continuously prompts to
        // 1. remove by album # OR
        // 2. remove by date
        // until a valid input is inputted (1/2)
        System.out.print("\n1. Album Number \n2. Date (MM/DD/YYYY)\n");
        do {
            try {
                System.out.print("Remove by: ");
                option = Integer.parseInt(in.nextLine().strip());

                if (option != 1 && option != 2)
                    throw new NumberFormatException();
                else {
                    System.out.println("");
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.print("Invalid input. ");
            }
        } while (true);

        // If the user chooses to remove by album #, display a list of ALL the albums in
        // the collection (ordered in ascending order of album #s) and prompt for which
        // album to remove
        if (option == 1) {

            // Display a list of all the albums in the collection (ordered in ascending
            // order of album #s)
            Collections.sort(albums);
            for (int album = 0; album < albums.size(); album++) {
                System.out.printf("%d. Album #%d\n", album + 1, albums.get(album).getNum());
            }

            // Continuously prompt the user for an album to remove until a valid input is
            // inputted
            do {
                try {
                    System.out.print("Select an Album to remove (by LIST #): ");
                    index = Integer.parseInt(in.nextLine().strip()) - 1;

                    if (index < 0 || index >= albums.size())
                        throw new NumberFormatException();
                    else { // If a valid input is inputted by the user, stop prompting the user for an
                           // album to remove
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. ");
                }
            } while (true);

            // Remove the album from the collection, update the collection's static
            // variables, and inform the user of it
            System.out.printf("\nAlbum %d has been successfully removed!\n\n", albums.get(index).getNum());
            Album.updateVars(albums.get(index));
            albums.remove(index);

        }
        // Otherwise, if the user chooses to remove by album date,
        // display a list of the dates of ALL albums in the collection (without
        // displaying duplicate dates)
        // and prompt user for which "date" to remove.

        // If 1+ album(s) contain this selected "date", prompt for which of those albums
        // the user would like to remove
        else {
            // Stores the dates of all albums into a separate ArrayList (as Strings), but
            // exclude duplicates
            Collections.sort(albums, new SortAlbumsByDate());
            for (int album = 0; album < albums.size(); album++) {
                if (!noDuplicateDates.contains(albums.get(album).getDateDisplay())) { // Add the date of the current
                                                                                      // album into the ArrayList of
                                                                                      // dates only if it's not already
                                                                                      // in there
                    noDuplicateDates.add(albums.get(album).getDateDisplay());
                }
            }

            // Displays the dates of all albums, without duplicates
            for (int displayedDate = 0; displayedDate < noDuplicateDates.size(); displayedDate++) {
                System.out.printf("%d. %s\n", displayedDate + 1, noDuplicateDates.get(displayedDate));
            }

            // Continuously prompts the user for which date to "remove" ("" because it
            // removes the ALBUM with THAT date of creation, not the date itself) until a
            // valid input is inputted
            do {
                try {
                    System.out.print("Select a date (by LIST #): ");
                    index = Integer.parseInt(in.nextLine().strip()) - 1;

                    if (index < 0 || index >= noDuplicateDates.size())
                        throw new NumberFormatException();
                    else { // Once a date has been selected, create a date object with it.
                           // It will be utilized for binary search later.
                        date = new Date(noDuplicateDates.get(index));
                        System.out.println("");
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. ");
                }
            } while (true);

            // Stores all of the albums with the same date of creation selected into a
            // separate ArrayList called albumsWithDate
            do {
                Collections.sort(albumsCopy, new SortAlbumsByDate());

                // If there is still an album with the same date of creation in albumsCopy
                // (a copy of the ArrayList albums), store it into albumsWithDate and remove it
                // from albumsCopy

                // Evidently, albumsCopy will, after a few more times of looping here, contain
                // no more albums with the same date of creation. It is then that the ArrayList
                // albumsWithDate is complete.
                if ((index = Collections.binarySearch(albumsCopy, new Album(0, 0, emptyArrList,
                        date),
                        new SortAlbumsByDate())) >= 0) {
                    albumsWithDate.add(albumsCopy.get(index));
                    albumsCopy.set(index,
                            new Album(0, 0, emptyArrList, new Date("00/00/0000")));
                } else // If there are no more albums with the selected date of creation in albumsCopy,
                       // exit this loop and start displaying/prompting for the album to remove
                    break;
            } while (true);

            // If there is only 1 album in the entire collection with the same date of
            // creation, remove it
            if (albumsWithDate.size() == 1) {
                System.out.printf("Album #%d has been successfully removed!\n\n",
                        albumsWithDate.get(0).getNum());
                Album.updateVars(albumsWithDate.get(0));
                albums.remove(Collections.binarySearch(albums, new Album(0, 0, emptyArrList,
                        date),
                        new SortAlbumsByDate()));
            } else { // If there are more than one albums with the same date of creation in the
                     // collection, prompt the user for which album to remove

                System.out.printf("There are %d albums with the same date of creation:\n",
                        albumsWithDate.size());

                // Displays a list of all the albums with the same date of creation
                Collections.sort(albumsWithDate);
                for (int albumWithDate = 0; albumWithDate < albumsWithDate.size(); albumWithDate++) {
                    System.out.printf("%d. Album #%d\n", albumWithDate + 1,
                            albumsWithDate.get(albumWithDate).getNum());
                }

                // Continuously prompt the user for an album to remove until a valid input is
                // inputted
                do {
                    try {
                        System.out.print("Select an Album to remove (by LIST #): ");
                        removeChoice = Integer.parseInt(in.nextLine());

                        if (removeChoice < 1 || removeChoice > albumsWithDate.size())
                            throw new NumberFormatException();
                        else {
                            // Once an album is selected, remove the album from the collection, update the
                            // collection's static variables, and inform the user of it
                            System.out.printf("\nAlbum #%d has been successfully removed!\n\n",
                                    albumsWithDate.get(removeChoice - 1).getNum());
                            Album.updateVars(albumsWithDate.get(removeChoice - 1));
                            albums.remove(albums.indexOf(albumsWithDate.get(removeChoice - 1)));
                            break;
                        }

                    } catch (NumberFormatException e) {
                        System.out.print("Invalid input. ");
                    }
                } while (true);

            }
        }
        // RETURNS: none (void method)
    }

    // DESCRIPTION: Utilized for Menu #1 - Submenu #5:
    // Displays the
    // 1. # of cards out of total capacity and
    // 2. average HP
    // of EACH album AND of ALL albums (total for entire collection)
    public static void stats(ArrayList<Album> albums) { // PARAMETERS: An ArrayList containing all the albums in
                                                        // the collection

        Collections.sort(albums);
        System.out.println();

        // Displays the number of cards out of total capacity and average HP of each
        // album in the collection
        for (int album = 0; album < albums.size(); album++) {
            System.out.printf("%-10s: %d out of %d%n", "Album " + albums.get(album).getNum(),
                    albums.get(album).getCards().size(), albums.get(album).getCapacity());
            System.out.printf("%-10s: %.1f%n", "",
                    albums.get(album).getTotalHP() * 1.0 / albums.get(album).getCards().size());
        }

        // Displays the number of cards out of total capacity and average HP of ALL
        // albums in the collection
        System.out.printf("%s: %d out of %d\n", "ALL albums", Album.getTotalNumOfCards(), Album.getTotalCapacity());
        System.out.printf("%-10s: %.1f\n\n", "", 1.0 * Album.getTotalHPOfAllAlbums() / Album.getTotalNumOfCards());

        // RETURNS: none (void method)
    }

    // DESCRIPTION: The main method acquires user input and utilizes
    // methods to interactively organize the user's pokemon collection
    public static void main(String[] args) throws IOException { // PARAMETERS: args not used
                                                                // THROWS IOEXCEPTION: For the BufferedReader, which
                                                                // collects input from the textfile (Menu #1 -
                                                                // Submenu #3)
        // Variables
        ArrayList<Album> albums = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        int choice = 0;
        int subChoice;

        int index;
        Album chosenAlbum;

        System.out.println("Welcome to My Pokemon Cards Collection!");

        // Prompts the user for input - Allows the user to navigate between menus and
        // organize their respective pokemon collection
        while (true) {
            choice = 0; // Menu choice (#1 or #2, or #3 for exit)
            subChoice = 0; // Submenu choice (#1 - #1, 2, 3, 4, 5, or 6 | #2 - #1, 2, 3, 4, 5, 6, or 7)

            System.out.println(
                    "\n----------  MAIN MENU  -----------\n1) Accessing your list of albums\n2) Accessing within a particular album\n3) Exit\n----------------------------------\n");

            // Continuously prompt the user for a menu to enter (Given menus #1 and #2,
            // and option #3 which exits the program entirely) until a valid input is
            // inputted
            do {
                try {
                    System.out.print("Enter your choice: ");
                    choice = Integer.parseInt(in.nextLine().strip());

                    if (choice < 1 || choice > 3)
                        throw new NumberFormatException();
                    else if (choice == 2 && albums.size() == 0) { // If the user selects to enter menu #2 with NO
                                                                  // albums in the collection, inform the user of it and
                                                                  // return back to main menu to prompt again
                        System.out.println("You don't own any albums.");
                        choice = 0;
                        break;
                    } else { // Once the user selects a valid menu (#1, #2, or #3), break out of this loop
                             // - which stops prompting the user for which menu to enter - and enter the
                             // submenu desired
                        if (choice == 1)
                            System.out.println("");
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. ");
                }
            } while (true);

            // If the user chooses to enter menu #1, display menu #1 and allow the user to
            // interactively organize their pokemon collection using the submenus
            // (1,2,3,4,5,or 6) available
            while (choice == 1) {

                // Display menu #1
                System.out.println(
                        "---------  SUB-MENU #1  ----------\n1) Display a list of all albums\n2) Display information on a particular album\n3) Add an album\n4) Remove an album\n5) Show statistics\n6) Return back to main menu\n----------------------------------\n");

                // Continuously prompt for submenu option until a valid input (1,2,3,4,5,or 6)
                // is inputted
                do {
                    try {
                        System.out.print("Enter your choice: ");
                        subChoice = Integer.parseInt(in.nextLine().strip());

                        if (subChoice < 1 || subChoice > 6)
                            throw new NumberFormatException();
                        else // Once a valid submenu has been chosen, break out of this loop, which will stop
                             // prompting the user for a submenu option
                            break;
                    } catch (NumberFormatException e) {
                        System.out.print("Invalid input. ");
                    }
                } while (true);

                // If the user selects submenu #1, display a list of ALL the albums in the
                // collection
                // (Menu #1 Submenu #1)
                if (subChoice == 1) {
                    displayAlbums(albums);
                }
                // If the user selects submenu #2, display the information of a particular album
                // (user will be prompted for an album in the displayInfo method)

                // However, if there are currently 0 albums in the collection, inform the user
                // of it and reprompt for a submenu option
                // (Menu #1 Submenu #2)
                else if (subChoice == 2) {
                    if (albums.size() > 0)
                        displayInfo(in, albums);
                    else
                        System.out.println("You own 0 albums.\n");
                }
                // If the user selects submenu #3, allow the user to add a new album (user will
                // be further prompted in the addAlbum method)
                // (Menu #1 Submenu #3)
                else if (subChoice == 3) {
                    addAlbum(albums, in);
                }
                // If the user selects submenu #4, allow the user to remove an album either by
                // album # or by date of album creation (user will be further prompted in
                // removeAlbum)

                // However, if there are currently 0 albums in the collection, inform the user
                // of it and reprompt for a submenu option
                // (Menu #1 Submenu #4)
                else if (subChoice == 4) {
                    if (albums.size() > 0)
                        removeAlbum(albums, in);
                    else
                        System.out.println("You own 0 albums.\n");
                }
                // If the user selects submenu #5, display the statistics of the current pokemon
                // collection (details of statistics are listed on lines 471-475)

                // However, if there are currently 0 albums in the collection, inform the user
                // of it and reprompt for a submenu option
                // (Menu #1 Submenu #5)
                else if (subChoice == 5) {
                    if (albums.size() > 0)
                        stats(albums);
                    else
                        System.out.println("You own 0 albums.\n");
                }
                // If the user selects option #6, navigate the user back to main menu
                // (Menu #1 Submenu #6)
                else if (subChoice == 6) {
                    // Exit
                    break;
                }
            }

            // If the user chooses to enter menu #2, display menu #2 and allow the user to
            // interactively organize their pokemon collection using the submenus
            // (1,2,3,4,5,6,or 7) available
            if (choice == 2) {

                // Display a list of all the albums in the collection, listed in ascending order
                // of their album #s
                Collections.sort(albums);
                System.out.println();
                for (int album = 0; album < albums.size(); album++) {
                    System.out.printf("%d. Album #%d\n", album + 1, albums.get(album).getNum());
                }

                // Continuously prompts the user for an album to enter menu #2 with until a
                // valid input is inputted
                do {
                    try {
                        System.out.print("Select an album (enter LIST #): ");
                        index = Integer.parseInt(in.nextLine().strip()) - 1;

                        if (index < 0 || index >= albums.size())
                            throw new NumberFormatException();
                        else { // Once an album has been selected, set chosenAlbum to the album chosen
                               // (chosenAlbum will be utilized A LOT in menu #2) and inform/verify the user of
                               // the album
                               // they chose
                            chosenAlbum = albums.get(index);
                            System.out.printf("You selected album #%d!\n\n", chosenAlbum.getNum());
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.print("Invalid input. ");
                    }
                } while (true);

                // Continuously prompt the user for navigations/options in menu #2 until the
                // user chooses to return back to main menu (option #7)
                while (true) {
                    System.out.println(
                            "---------  SUB-MENU #2  ----------\n1) Display all cards (in the last sorted order)\n2) Display information on a particular card\n3) Add a card\n4) Remove a card (4 options)\n5) Edit attack\n6) Sort cards (3 options)\n7) Return back to main menu\n----------------------------------\n");

                    // Continuously prompt for submenu option until a valid input (1,2,3,4,5,6,or 7)
                    // is inputted
                    do {
                        try {
                            System.out.print("Enter your choice: ");
                            subChoice = Integer.parseInt(in.nextLine().strip());

                            if (subChoice < 1 || subChoice > 7)
                                throw new NumberFormatException();
                            else // Once a valid submenu has been chosen, break out of this loop, which will stop
                                 // prompting the user for a submenu option
                                break;
                        } catch (NumberFormatException e) {
                            System.out.print("Invalid input. ");
                        }
                    } while (true);

                    // If the user selects submenu #1, display all the cards in the chosen album (in
                    // the last sorted order)
                    // (Menu #2 Submenu #1)
                    if (subChoice == 1) {
                        chosenAlbum.displayAllCards();
                    }
                    // If the user selects submenu #2, display information on a particular card
                    // (user will be prompted for a card in the displayCard method)
                    // (Menu #2 Submenu #2)
                    else if (subChoice == 2) {
                        chosenAlbum.displayCard(in);
                    }
                    // If the user selects submenu #3, allow the user to add a card
                    // (user will be prompted for the name, HP, type, attacks, and date of the card
                    // in the addCard method)
                    // (Menu #2 Submenu #3)
                    else if (subChoice == 3) {
                        chosenAlbum.addCard(in);
                    }
                    // If the user selects submenu #4, allow the user to remove a card
                    // (user will be prompted for the 4 options they are given to remove a card by:
                    // 1. remove by name
                    // 2. remove by HP
                    // 3. remove first listed card in album
                    // 4. remove last listed card in album)
                    // (Menu #2 Submenu #4)
                    else if (subChoice == 4) {
                        chosenAlbum.removeCard(in);
                    }
                    // If the user selects submenu #5, allow the user to edit an attack (name,
                    // description, or damage) of a particular card
                    // (user will be further prompted for card, attack field, and its new value in
                    // the editAttack method)
                    // (Menu #2 Submenu #5)
                    else if (subChoice == 5) {
                        chosenAlbum.editAttack(in);
                    }
                    // If the user selects submenu #6, allow the user to either sort cards by name,
                    // by HP, or by date.
                    // (user will be prompted for which sort by requirement in the sortCards method)
                    // (Menu #2 Submenu #6)
                    else if (subChoice == 6) {
                        chosenAlbum.sortCards(in);
                    }
                    // If the user selects submenu #7, navigate the user back to main menu
                    // (Menu #2 Submenu #7)
                    else if (subChoice == 7) {
                        // Exit
                        break;
                    }
                }

            }

            // If the user chooses option #3 in the main menu (exit), then display a
            // farewell message and terminate the program
            if (choice == 3) {
                System.out.println("\nThank you for visiting my Pokemon Cards Collection! See you next time :)\n");
                in.close();
                break;
            }
        }
        // RETURNS: none (void method)
    }
}
