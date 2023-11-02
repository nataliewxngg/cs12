package u2.assignment4;

import java.util.*;
import java.io.*;

// Driver class: You must have a main program that properly reads in options from the user,
// with proper error checks done.

// You must have the following functions properly implemented:
// - Display a list of your albums (Menu #1 – Submenu #1)
// - Display information on a particular album (Menu #1 – Submenu #2)
//  Be able to add multiple albums onto ArrayList (read in from input file)
// (Menu #1 – Submenu #3)
//  Be able to remove an album (Menu #1 – Submenu #4)
//  Display a list of cards in a particular album (Menu #2 – Submenu #1)
//  Display information on a particular card (Menu #2 – Submenu #2)

public class Driver {
    public static void displayAlbums(ArrayList<Album> albums) { // #1-#1
        if (albums.size() == 0) // own 0 albums
            System.out.println("You own 0 albums... :(");
        else { // own 1+ albums
            Collections.sort(albums); // sort by album #
            for (int album = 0; album < albums.size(); album++) {
                System.out.printf("\nAlbum Number: %d\nDate: %s\n", albums.get(album).getNum(),
                        albums.get(album).getDate());
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
            albumNum = Integer.parseInt(in.nextLine());

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

    public static void addAlbum(ArrayList<Album> albums, Scanner in) throws IOException {
        System.out.print("Enter the file name (exclude .txt): ");
        String fileName = in.nextLine();

        ArrayList<Card> emptyArrList = new ArrayList<>();

        int albumNum;
        Date date;
        int capacity;

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
            else { // album is new!

                // Date of album
                date = new Date(inFile.readLine());

                if (date.valid()) {
                    // IF DATE IS VALID

                    // Maximum capacity of the album
                    capacity = Integer.parseInt(inFile.readLine());
                    if (capacity < 1) {
                        System.out.println(
                                "The maximum capacity of this album is invalid... Album not added into collection. :(");
                        inFile.close();
                        throw new NumberFormatException();
                    }

                    // Number of cards in album

                } else {
                    // IF DATE IS INVALID
                    System.out.println("The date of album creation is invalid... Album not added into collection. :(");
                    inFile.close();
                    throw new NumberFormatException();
                }

            }

            inFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("This album doesn't exist :(\n");
        } catch (NumberFormatException e) {
        }
    }

    public static void main(String[] args) throws IOException {
        // Variables
        ArrayList<Album> albums = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        int choice = 0;
        int subChoice;
        String fileName;

        // TESTING ONLY
        ArrayList<Card> emptyArrList = new ArrayList<>();
        albums.add(new Album(1, 4, emptyArrList, new Date("05/09/2006")));
        albums.add(new Album(3, 99, emptyArrList, new Date("01/11/2005")));

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
                    choice = Integer.parseInt(in.nextLine());

                    if (choice < 1 || choice > 3)
                        throw new NumberFormatException();
                    else {
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
                        subChoice = Integer.parseInt(in.nextLine());

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
                    displayInfo(in, albums);
                } else if (subChoice == 3) { // Menu #1 Submenu #3
                    addAlbum(albums, in);

                    // // WORKING ON THIS - DONT ALLOW FOR DUPLICATE ALBUMS
                    // albumNum = Integer.parseInt(inFile.readLine());
                    // Collections.sort(albums);
                    // int index = Collections.binarySearch(albums,
                    // new Album(albumNum, 0, emptyArrList, new Date("00/00/0000")));

                    // if (index >= 0) // already has a duplicate
                    // System.out.println("This album already exists!");
                    // else // not in albums yet

                } else if (subChoice == 4) {
                    // Menu #1 Submenu #4
                } else if (subChoice == 5) {
                    // Menu #1 Submenu #5
                } else if (subChoice == 6) {
                    // Exit
                    break;
                }

            }

            while (choice == 2) {
                // Submenu 2
                System.out.println(
                        "---------  SUB-MENU #2  ----------\n1) Display all cards (in the last sorted order)\n2) Display information on a particular card\n3) Add a card\n4) Remove a card (4 options)\n5) Edit attack\n6) Sort cards (3 options)\n7) Return back to main menu\n----------------------------------\n");

                // Prompt for submenu option
                do {
                    try {
                        System.out.print("Enter your choice: ");
                        subChoice = Integer.parseInt(in.nextLine());

                        if (subChoice < 1 || subChoice > 7)
                            throw new NumberFormatException();
                        else
                            break;
                    } catch (NumberFormatException e) {
                        System.out.print("Invalid input. ");
                    }
                } while (true);

                if (subChoice == 1) {
                    // Menu #2 Submenu #1
                } else if (subChoice == 2) {
                    // Menu #2 Submenu #2
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

            if (choice == 3) {
                // Exit
                System.out.println("\nThank you for visiting my Pokemon Cards Collection! See you next time :)\n");
                in.close();
                break;
            }
        }
    }
}
