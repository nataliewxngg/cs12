package u2.assignment4;

import java.util.*;

public class Album implements Comparable<Album> {

    // DESCRIPTION:
    // Used to compare the album # of two Album objects
    // (ALBUM1.compareTo(ALBUM2))

    // It is moreover a method utilized for the Comparalbe Interface - NATURAL
    // SORTING ORDER
    // When called (Collections.sort(ARRAYLIST)), it allows the comparable interface
    // to sort an ArrayList of Album objects in ascending order of their album #s

    public int compareTo(Album a) { // PARAMETER: An Album object to compare to
        return this.num - a.num;
        // RETURNS:
        // If this.num < a.num --> RETURN A NEGATIVE #
        // If this.num == a.num --> RETURN 0
        // If this.num > a.num --> RETURN A POSITIVE #
    }

    // Instance Variables + Data Encapsulation
    private int num;
    private int capacity;
    private ArrayList<Card> cards;
    private Date date;
    private int totalHP;

    // Static/Class Variables + Data Encapsulation
    private static ArrayList<Attack> emptyArrList = new ArrayList<>();
    private static int totalNumOfCards = 0;
    private static int totalCapacity = 0;
    private static int totalHPOfAllAlbums = 0;

    // DESCRIPTION: The CONSTRUCTOR method - utilized to create new Album objects
    // and to initialize each object's instance variables
    public Album(int num, int capacity, ArrayList<Card> cards, Date date) { // PARAMETERS:
                                                                            // 1. The album #
                                                                            // 2. The maximum capacity of the album
                                                                            // 3. An ArrayList of Cards objects that
                                                                            // contains all the cards in the album
                                                                            // 4. The date of creation of the album

        // Initializes the instance variables of the new Album object!
        this.num = num;
        this.capacity = capacity;
        this.cards = cards;
        this.date = date;
        for (int card = 0; card < cards.size(); card++) { // Initializes the totalHP of the new album by adding up the
                                                          // HP of ALL the cards in the album
            this.totalHP += cards.get(card).getHP();
        }

        // Updates the static/class variables
        totalCapacity += capacity;
        totalHPOfAllAlbums += this.totalHP;
        totalNumOfCards += cards.size();

        // RETURNS: none (constructors do not return any value)
    }

    // DESCRIPTION: Utilized for Menu #1 - Submenu #2:
    // Displays the number, date, max capacity, # of cards, and total HP of an album
    public void displayInfo() { // PARAMETERS: none
        System.out.printf(
                "Album #: %d\nDate: %s\nMax Capacity: %d\nNumber of Cards: %d\nTotal HP: %d\n\n",
                this.num, this.getDateDisplay(),
                this.capacity,
                this.cards.size(), this.totalHP);
        // RETURNS: none (void method)
    }

    // DESCRIPTION: Utilized for Menu #1 - Submenu #4
    // Updates the static/class variables of the Album class given that the album in
    // the parameter is being removed from the collection
    public static void updateVars(Album a) { // PARAMETERS: an Album intended on being removed from the collection
        totalNumOfCards -= a.cards.size();
        totalCapacity -= a.capacity;
        totalHPOfAllAlbums -= a.totalHP;

        // RETURNS: none (void method)
    }

    // DESCRIPTION: Utilized for Menu #2 - Submenu #1
    // Displays the name and date of ALL the cards in an album
    public void displayAllCards() { // PARAMETERS: none
        // If the album does not contain any cards, inform the user of it and exit out
        // of the method
        if (this.cards.size() == 0) {
            System.out.println("This album contains 0 cards.\n");
        }
        // Otherwise, if the album DOES contain 1+ card(s), display their name and
        // date of purchase/trade
        else {
            for (int card = 0; card < cards.size(); card++) {
                System.out.printf("\nCard Name: %s\nDate of purchase/trade: %s\n", this.getCards().get(card).getName(),
                        this.getCards().get(card).getDateDisplay());
            }
            System.out.println("");
        }
        // RETURNS: none (void method)
    }

    // DESCRIPTION: Utilized for Menu #2 - Submenu #2
    // Displays the name, HP, type, attacks, and date of a particular card in the
    // album
    public void displayCard(Scanner in) { // PARAMETERS: A scanner utilized to acquire user input
        int index;
        Card chosenCard;
        System.out.println();

        // If the album does not contain any cards, inform the user of it and exit out
        // of the method
        if (this.cards.size() == 0) {
            System.out.println("This album contains 0 cards.\n");
        }
        // Otherwise, if the album DOES contain 1+ card(s), prompt the user for which
        // card's information to display, and display its info
        else {

            // Display a numbered list of all the cards in the album
            for (int card = 0; card < this.cards.size(); card++) {
                System.out.printf("%d) %s (%s)\n", card + 1, this.cards.get(card).getName(),
                        this.cards.get(card).getDateDisplay());
            }

            // Continuously prompt the user for a card to display the info from until a
            // valid input is inputted
            do {
                try {
                    System.out.print("Select a card (by #): ");
                    index = Integer.parseInt(in.nextLine().strip()) - 1;

                    if (index < 0 || index >= this.cards.size())
                        throw new NumberFormatException();
                    else { // Once a card is selected, set the chosenCard to the card chosen (chosenCard
                           // will be utilized A LOT following this) and stop prompting the user for a card
                           // to choose from
                        chosenCard = this.cards.get(index);
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. ");
                }
            } while (true);

            // Display the name, HP, and type of the selected card
            System.out.printf("\nCard name: %s\nHP: %d\nType: %s\n", chosenCard.getName(), chosenCard.getHP(),
                    chosenCard.getType());

            // Display the name, description (conditional), and damage of each attack of the
            // card
            for (int attack = 0; attack < chosenCard.getAttacks().size(); attack++) {

                // If the attack does NOT have a description, only display its name and damage
                if (chosenCard.getAttacks().get(attack).getDesc() == "") {
                    System.out.printf("Attack %d name: %s\nAttack %d damage: %s\n",
                            attack + 1,
                            chosenCard.getAttacks().get(attack).getName(), attack + 1,
                            chosenCard.getAttacks().get(attack).getDamage());
                }
                // Otherwise, if the attack DOES have a description, display all of its fields
                // including its description
                else {
                    System.out.printf(
                            "Attack %d name: %s\nAttack %d description: %s\nAttack %d damage: %s\n",
                            attack + 1,
                            chosenCard.getAttacks().get(attack).getName(), attack + 1,
                            chosenCard.getAttacks().get(attack).getDesc(), attack + 1,
                            chosenCard.getAttacks().get(attack).getDamage());
                }
            }

            // Display the card's date of purchase/trade
            System.out.printf("Date of purchase/trade: %s\n\n", chosenCard.getDateDisplay());
        }

        // RETURNS: none (void method)
    }

    // DESCRIPTION: Utilized for Menu #2 - Submenu #3
    // Prompts the user for the name, HP, type, attacks, and date of a new card and
    // adds it into an album
    public void addCard(Scanner in) { // PARAMETERS: A scanner utilized to acquire user input

        // If album is already at maximum capacity (cannot add new card), inform the
        // user of it and exit this method
        if (this.capacity == this.cards.size())
            System.out.printf("Album #%d has already reached maximum capacity!\n\n", this.num);

        // Otherwise, if the album still has room for a new card, prompt the user for
        // the name, HP, type, attacks, and date of the new card
        else {
            String cardName;
            int cardHP;
            String cardType;

            int numOfAttacks;
            ArrayList<Attack> cardAttacks = new ArrayList<>();
            String attackName;
            String attackDesc;
            String attackDamage;

            String inDate;
            Date cardDate;

            // Continuously prompt the user for the card name until a
            // valid name (not empty) is inputted
            do {
                System.out.print("Enter the card name: ");
                cardName = in.nextLine().strip();

                if (cardName != "") // Once a valid card name is inputted, stop prompting for a name
                    break;
                else {
                    System.out.print("Invalid input. ");
                }
            } while (true);

            // Continuously prompt the user for the card HP until a valid HP value
            // (ATLEAST 1) is inputted
            do {
                try {
                    System.out.print("Enter the HP of the card: ");
                    cardHP = Integer.parseInt(in.nextLine().strip());

                    if (cardHP < 1) // HP must ATLEAST be 1
                        throw new NumberFormatException();
                    else // Once a valid HP value is inputted, stop prompting for the HP
                        break;
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. ");
                }
            } while (true);

            // Continuously prompt the user for a card type until a valid type (not empty)
            // is inputted
            do {
                System.out.print("Enter the card type: ");
                cardType = in.nextLine().strip();

                if (cardType != "") // Once a valid card type is inputted, stop prompting for a type
                    break;
                else {
                    System.out.print("Invalid input. ");
                }
            } while (true);

            // Continuously prompt the user for the number of attacks the new card contains
            // until a valid # of attacks (>=0) is inputted
            do {
                try {
                    System.out.print("Enter the # of attacks: ");
                    numOfAttacks = Integer.parseInt(in.nextLine().strip());

                    if (numOfAttacks < 0) // Don't allow for -# of attacks
                        throw new NumberFormatException();
                    else // Once a valid # of attacks for the new card is inputted, stop prompting for it
                        break;
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. ");
                }
            } while (true);

            // For each attack of the card, prompt for its name, description, and damage -
            // then add it, utilizing those respective fields, to the attacks arraylist
            for (int attack = 0; attack < numOfAttacks; attack++) {

                System.out.printf("For attack %d:\n", attack + 1);

                // Continuously prompt the user for an attack name until a
                // valid name (not empty) is inputted
                do {
                    System.out.print("Enter the attack name: ");
                    attackName = in.nextLine().strip();

                    if (attackName != "") // Once a valid attack name is inputted, stop prompting for a name
                        break;
                    else {
                        System.out.print("Invalid input. ");
                    }
                } while (true);

                // Prompt the user for an attack description
                // (may be left blank if the attack does not contain a description)
                do {
                    System.out.print(
                            "Enter the attack description (leave blank if attack does NOT contain a description): ");
                    attackDesc = in.nextLine().strip();

                    break;
                } while (true);

                // Continuously prompt the user for an attack damage until a valid damage (not
                // empty) is inputted
                do {
                    System.out.print("Enter the attack damage: ");
                    attackDamage = in.nextLine().strip();

                    if (attackDamage != "") // Once a valid attack damage is inputted, stop prompting for the damage
                        break;
                    else {
                        System.out.print("Invalid input. ");
                    }
                } while (true);

                // Utilize the inputted attack name, description, and damage to now add the
                // attack into the list of attacks the card contains
                cardAttacks.add(new Attack(attackName, attackDesc, attackDamage));
            }

            // Continuously prompt the user for the date of purchase/trade of the new card
            // until a valid date is inputted
            do {
                System.out.print("Enter the date (MM/DD/YYYY): ");
                inDate = in.nextLine().strip();
                StringTokenizer st = new StringTokenizer(inDate, "/");

                // If the "date" inputted has the correct number of fields (3: month, date,
                // year), check if the fields are all valid (ints) and if so, check if the date
                // inputted is valid or not.
                if (st.countTokens() == 3) {
                    try {
                        // Check to see if the month, date, and year entered are all integer inputs
                        for (int i = 0; i < 3; i++) {
                            Integer.parseInt(st.nextToken());
                        }
                        cardDate = new Date(inDate);
                        if (cardDate.valid()) // If the date of purchase/trade inputted is a valid date, stop prompting
                                              // for it
                            break;
                        else
                            throw new NumberFormatException();
                    } catch (NumberFormatException e) {
                        System.out.print("Invalid input. ");
                    }
                } else {
                    System.out.print("Invalid input. ");
                }
            } while (true);

            // Utilizing the inputted name, HP, type, date, and attacks of the card to now
            // add the card into the album
            this.cards.add(new Card(cardName, cardHP, cardType, cardDate, cardAttacks));

            // Update instance and static/class variables
            this.totalHP += cardHP;
            totalNumOfCards++;
            totalHPOfAllAlbums += cardHP;

            // Let the user know that the card has been successfully added
            System.out.printf("\n%s successfully added!\n\n", cardName);
        }
        // RETURNS: none (void method)
    }

    // DESCRIPTION: Utilized for Menu #2 - Submenu #4
    // Allows the user to remove a card either by name, HP, or remove the first/last
    // listed card in the album (in last sorted order)
    public void removeCard(Scanner in) { // PARAMETERS: A scanner to acquire user input
        int choice;
        int index;

        // If the album doesn't contain ANY cards, inform the user of it and exit this
        // method
        if (this.cards.size() == 0)
            System.out.println("This album contains 0 cards. (No cards removed)\n");

        // Otherwise, if the album contains 1+ cards, prompt the user for the remove by
        // criteria and, if remove by name or HP was selected, prompt for a card to
        // remove. Otherwise, just remove the first or last listed card in the album
        else {

            // Continuously prompt for the remove by criteria until a valid input is
            // inputted
            do {
                try {
                    System.out.print("1. Name\n2. HP\n3. First Listed Card\n4. Last Listed Card\nRemove card by/the: ");
                    choice = Integer.parseInt(in.nextLine().strip());

                    if (choice < 1 || choice > 4)
                        throw new NumberFormatException();
                    else // Once a remove by criteria is selected, stop prompting for one
                        break;
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. ");
                }
            } while (true);

            ArrayList<Card> cardsCopy = new ArrayList<>(this.cards);

            // If the user chooses to remove a card BY NAME, display the names of ALL cards
            // (excluding duplicates) and prompt for which to remove
            // eg. card NATALIEWONG and card nataliewong are duplicates
            if (choice == 1) {
                ArrayList<Card> noDuplicateNames = new ArrayList<>();
                int removeNameChoice;
                String removeName;

                // Store NON-DUPLICATED card names in another ArrayList called noDuplicateNames
                // (eg. cards nataliewong and NATALIEWONG will only be stored once in the
                // ArrayList as they are duplicated cards)
                Collections.sort(cardsCopy);
                for (int i = 0; i < this.cards.size(); i++) {
                    if (Collections.binarySearch(noDuplicateNames,
                            new Card(cardsCopy.get(i).getName(), 0, "", new Date("00/00/0000"), emptyArrList)) < 0) {
                        noDuplicateNames.add(cardsCopy.get(i));
                    }
                }
                System.out.println();

                // Display a list of all the NON-DUPLICATED cards by name
                // (essentially, it displays noDuplicateNames)
                for (int i = 0; i < noDuplicateNames.size(); i++) {
                    System.out.printf("%d. %s\n", i + 1, noDuplicateNames.get(i).getName());
                }

                // Continuously prompt the user for which name to "remove"
                // ("" because it removes the CARD with THAT NAME, not the name itself)
                do {
                    try {
                        System.out.print("Remove Card with Name (Enter LIST #): ");
                        removeNameChoice = Integer.parseInt(in.nextLine().strip());

                        if (removeNameChoice < 1 || removeNameChoice > noDuplicateNames.size())
                            throw new NumberFormatException();
                        else { // Once a name has been selected, set it as the value of removeName as it will
                               // be utilized later on for binary search
                            removeName = noDuplicateNames.get(removeNameChoice - 1).getName();
                            System.out.println();
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.print("Invalid input. ");
                    }
                } while (true);

                // Remove ALL the cards with the selected name from the album
                Collections.sort(cardsCopy);
                while ((index = Collections.binarySearch(cardsCopy,
                        new Card(removeName, 0, "", new Date("00/00/0000"), emptyArrList))) >= 0) { // As long as there
                                                                                                    // are still cards
                                                                                                    // with the selected
                                                                                                    // name in the
                                                                                                    // album, remove
                                                                                                    // them

                    System.out.printf("%s was removed!\n", cardsCopy.get(index).getName());

                    // Update the static/class variables
                    this.totalHP -= cardsCopy.get(index).getHP();
                    totalNumOfCards--;
                    totalHPOfAllAlbums -= cardsCopy.get(index).getHP();

                    // Remove the card from the album
                    this.cards.remove(cardsCopy.get(index));
                    cardsCopy.remove(index);
                }
                System.out.println();

            }

            // If the user chooses to remove a card BY HP, display the HPs of ALL cards
            // (excluding duplicates) and prompt for which to remove
            // eg. two cards with an HP of 59 are duplicates
            else if (choice == 2) {
                ArrayList<Integer> noDuplicateHPs = new ArrayList<>();
                int removeHPChoice;
                int removeHP;

                // Store NON-DUPLICATED card HPs in another ArrayList called noDuplicateHPs
                // (eg. two cards with an HP of 59 will only store ONE 59 in noDuplicateHPs)
                for (int i = 0; i < this.cards.size(); i++) {
                    if (!noDuplicateHPs.contains(this.cards.get(i).getHP())) {
                        noDuplicateHPs.add(this.cards.get(i).getHP());
                    }
                }
                System.out.println();

                // Display a list of all the NON-DUPLICATED cards by HP
                // (essentially, it displays noDuplicateHPs)
                for (int i = 0; i < noDuplicateHPs.size(); i++) {
                    System.out.printf("%d. %d\n", i + 1, noDuplicateHPs.get(i));
                }

                // Continuously prompt the user for which HP to "remove"
                // ("" because it removes the CARD with THAT HP, not the HP itself)
                do {
                    try {
                        System.out.print("Remove Card with HP (Enter LIST #): ");
                        removeHPChoice = Integer.parseInt(in.nextLine().strip());

                        if (removeHPChoice < 1 || removeHPChoice > noDuplicateHPs.size())
                            throw new NumberFormatException();
                        else { // Once an HP has been selected, set it as the value of removeHP as it will
                               // be utilized later on for binary search
                            removeHP = noDuplicateHPs.get(removeHPChoice - 1);
                            System.out.println();
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.print("Invalid input. ");
                    }
                } while (true);

                // Remove ALL the cards with the selected HP from the album
                Collections.sort(cardsCopy, new SortCardsByHP());
                while ((index = Collections.binarySearch(cardsCopy,
                        new Card("", removeHP, "", new Date("00/00/0000"), emptyArrList),
                        new SortCardsByHP())) >= 0) { // As long as there
                                                      // are still cards
                                                      // with the selected
                                                      // HP in the
                                                      // album, remove
                                                      // them

                    System.out.printf("%s was removed!\n", cardsCopy.get(index).getName());

                    // Update the static/class variables
                    this.totalHP -= cardsCopy.get(index).getHP();
                    totalNumOfCards--;
                    totalHPOfAllAlbums -= cardsCopy.get(index).getHP();

                    // Remove the card from the album
                    this.cards.remove(cardsCopy.get(index));
                    cardsCopy.remove(index);
                }
                System.out.println();

            }
            // If the user chooses to remove the first listed card (in the last sorted
            // order), remove it and update the static/class variables
            else if (choice == 3) {
                System.out.printf("%s was removed!\n\n", this.cards.get(0).getName());

                // Update the static/class variables
                this.totalHP -= this.cards.get(0).getHP();
                totalNumOfCards--;
                totalHPOfAllAlbums -= this.cards.get(0).getHP();

                // Remove the first listed card in the album
                this.cards.remove(0);
            }
            // If the user chooses to remove the last listed card (in the last sorted
            // order), remove it and update the static/class variables
            else {
                System.out.printf("%s was removed!\n\n", this.cards.get(this.cards.size() - 1).getName());

                // Update the static/class variables
                this.totalHP -= this.cards.get(this.cards.size() - 1).getHP();
                totalNumOfCards--;
                totalHPOfAllAlbums -= this.cards.get(this.cards.size() - 1).getHP();

                // Remove the last listed card in the album
                this.cards.remove(this.cards.size() - 1);
            }
        }

        // RETURNS: none (void method)
    }

    // DESCRIPTION: Utilized for Menu #2 - Submenu #5
    // Allows the user to choose a card, then an existing attack, and edit its name,
    // description, or damage
    public void editAttack(Scanner in) { // PARAMETERS: A scanner to acquire user input from
        int index;

        // If the current album does not contain any cards, inform the user of it and
        // exit the method
        if (this.cards.size() == 0) {
            System.out.println("This album contains 0 cards.\n");
        }
        // Otherwise, if the current album contains 1+ cards, prompt the user for a card
        // to edit the attack from, and prompt for a new atack name, description, or
        // attack
        else {
            // Display a numbered list of all the cards in the album
            for (int card = 0; card < this.cards.size(); card++) {
                System.out.printf("%d) %s (%s)\n", card + 1, this.cards.get(card).getName(),
                        this.cards.get(card).getDateDisplay());
            }

            // Continuously prompt the user for which card's attack to edit from until a
            // valid input is inputted
            do {
                try {
                    System.out.print("Select a card (by #): ");
                    index = Integer.parseInt(in.nextLine().strip()) - 1;

                    if (index < 0 || index >= this.cards.size())
                        throw new NumberFormatException();
                    else { // Once a card has been selected, stop prompting for it
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. ");
                }
            } while (true);

            // Edit the attack (user will be prompted for which field to edit, and for its
            // new value)
            this.cards.get(index).editAttack(in);
        }

        // RETURNS: none (void method)
    }

    // sortCards method - #2-#6

    // DESCRIPTION: Utilized for Menu #2 - Submenu #6
    // Allows the user to sort cards by name, by HP, or by date.
    public void sortCards(Scanner in) { // PARAMETERS: A scanner to acquire user input from
        int choice;
        System.out.println("1. Sort by NAME\n2. Sort by HP\n3. Sort by DATE");

        // Continuously prompts the user for a sort by criteria given the three (by
        // name, by HP, or by date) until a valid input is inputted
        do {
            try {
                System.out.print("Sort by (Enter #): ");
                choice = Integer.parseInt(in.nextLine());

                if (choice < 1 || choice > 3)
                    throw new NumberFormatException();
                else // Once a sort by criteria has been selected, stop prompting for one
                    break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. ");
            }
        } while (true);

        // If the user selected to sort by name, sort the list of cards by name in
        // alphabetical order, case insensitively. Re-display the list afterwards.
        if (choice == 1) {
            Collections.sort(this.cards);

            System.out.println("Cards sorted by NAME (in alphabetical order)!");
            this.displayAllCards();
        }
        // If the user selected to sort by HP, sort the list of cards by HP in
        // ascending order. Re-display the list afterwards.
        else if (choice == 2) {
            Collections.sort(this.cards, new SortCardsByHP());

            System.out.println("Cards sorted by HP (in ascending order)!");
            this.displayAllCards();

        }
        // If the user selected to sort by date, sort the list of cards by date in the
        // order of oldest to newest. Re-display the list afterwards.
        else {
            Collections.sort(this.cards, new SortCardsByDate());

            System.out.println("Cards sorted by Date (from OLDEST to NEWEST)!");
            this.displayAllCards();
        }

        // RETURNS: none (void method)
    }

    // DESCRIPTION: Getter methods - allows the files utilizing Album objects to
    // access its private attributes (including data encapsulated static/class
    // variables too)
    public int getNum() {
        return this.num;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    public int getTotalHP() {
        return this.totalHP;
    }

    public String getDateDisplay() {
        return this.date.toString();
    }

    public Date getDate() {
        return this.date;
    }

    public static int getTotalNumOfCards() {
        return totalNumOfCards;
    }

    public static int getTotalCapacity() {
        return totalCapacity;
    }

    public static int getTotalHPOfAllAlbums() {
        return totalHPOfAllAlbums;
    }

    // DESCRIPTION: .toString() is called whenever a Album object is to be printed
    // By default, it will print the address location of the Album object in the
    // computer.
    // However, by overriding (writing) the .toString() method like so ourselves,
    // it allows us to change what is to be displayed instead.

    // Likewise, this method will allow us to display the album # of an Album
    // object instead of its address location
    public String toString() { // PARAMETER: none
        return this.num + "";
    }
}
