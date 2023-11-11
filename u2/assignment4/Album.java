package u2.assignment4;

import java.util.*;

// Necessary instance and static variables declared (can ADD more variables later)
// Constructor (can be cahnged later)

public class Album implements Comparable<Album> {
    // Comparable (Natural Sorting Order) - Sort by Album #, in ascending order
    public int compareTo(Album a) {
        return this.num - a.num;
    }

    // Variables
    private int num;
    private int capacity;
    private ArrayList<Card> cards;
    private Date date;
    private int totalHP;

    private static ArrayList<Attack> emptyArrList = new ArrayList<>();
    private static int totalNumOfCards = 0;
    private static int totalCapacity = 0;
    private static int totalHPOfAllAlbums = 0;

    // Constructor
    public Album(int num, int capacity, ArrayList<Card> cards, Date date) {
        this.num = num;
        this.capacity = capacity;
        totalCapacity += capacity;
        this.cards = cards;
        this.date = date;

        // determines the totalHP of the album
        for (int card = 0; card < cards.size(); card++) {
            this.totalHP += cards.get(card).getHP();
        }
        totalHPOfAllAlbums += this.totalHP;
        totalNumOfCards += cards.size();
    }

    // displayInfo method - for #1-#2
    public void displayInfo() {
        System.out.printf(
                "Album #: %d\nDate: %s\nMaxCapacity: %d\nNumber of Cards: %d\nTotal HP: %d\n\n",
                this.num, this.getDateDisplay(),
                this.capacity,
                this.cards.size(), this.totalHP);
    }

    // displayAllCards method - for #2-#1
    public void displayAllCards() {
        if (this.cards.size() == 0) {
            System.out.println("This album contains 0 cards.\n");
        } else {
            for (int card = 0; card < cards.size(); card++) {
                System.out.printf("\nCard Name: %s\nDate of purchase/trade: %s\n", this.getCards().get(card).getName(),
                        this.getCards().get(card).getDateDisplay());
            }
            System.out.println("");
        }
    }

    // displayCard method - for #2-#2
    public void displayCard(Scanner in) {
        int index;
        Card chosenCard;

        System.out.println();

        if (this.cards.size() == 0) {
            System.out.println("This album contains 0 cards.\n");
        } else {
            for (int card = 0; card < this.cards.size(); card++) {
                System.out.printf("%d) %s (%s)\n", card + 1, this.cards.get(card).getName(),
                        this.cards.get(card).getDateDisplay());
            }

            do {
                try {
                    System.out.print("Select a card (by #): ");
                    index = Integer.parseInt(in.nextLine().strip()) - 1;

                    if (index < 0 || index >= this.cards.size())
                        throw new NumberFormatException();
                    else {
                        chosenCard = this.cards.get(index);
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. ");
                }
            } while (true);

            System.out.printf("\nCard name: %s\nHP: %d\nType: %s\n", chosenCard.getName(), chosenCard.getHP(),
                    chosenCard.getType());
            for (int attack = 0; attack < chosenCard.getAttacks().size(); attack++) {
                if (chosenCard.getAttacks().get(attack).getDesc() == "") {
                    System.out.printf("Attack %d name: %s\nAttack %d damage: %s\n",
                            attack + 1,
                            chosenCard.getAttacks().get(attack).getName(), attack + 1,
                            chosenCard.getAttacks().get(attack).getDamage());
                } else {
                    System.out.printf(
                            "Attack %d name: %s\nAttack %d description: %s\nAttack %d damage: %s\n",
                            attack + 1,
                            chosenCard.getAttacks().get(attack).getName(), attack + 1,
                            chosenCard.getAttacks().get(attack).getDesc(), attack + 1,
                            chosenCard.getAttacks().get(attack).getDamage());
                }
            }
            System.out.printf("Date of purchase/trade: %s\n\n", chosenCard.getDateDisplay());
        }
    }

    // addCard method - for #2-#3
    public void addCard(Scanner in) {
        if (this.capacity == this.cards.size()) // if album is already at maximum capacity - cannot add new card
            System.out.printf("Album #d has already reached maximum capacity - Card not added\n", this.num);
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

            do { // get cardName
                System.out.print("Enter the card name: ");
                cardName = in.nextLine().strip();

                if (cardName != "")
                    break;
                else {
                    System.out.print("Invalid input. ");
                }
            } while (true);

            do { // get cardHP
                try {
                    System.out.print("Enter the HP of the card: ");
                    cardHP = Integer.parseInt(in.nextLine().strip());

                    if (cardHP < 1) // HP must ATLEAST be 1
                        throw new NumberFormatException();
                    else
                        break;
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. ");
                }
            } while (true);

            do { // get cardType
                System.out.print("Enter the card type: ");
                cardType = in.nextLine().strip();

                if (cardType != "")
                    break;
                else {
                    System.out.print("Invalid input. ");
                }
            } while (true);

            do { // get number of attacks
                try {
                    System.out.print("Enter the # of attacks: ");
                    numOfAttacks = Integer.parseInt(in.nextLine().strip());

                    if (numOfAttacks < 0) // don't allow for -# of attacks
                        throw new NumberFormatException();
                    else
                        break;
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. ");
                }
            } while (true);

            for (int attack = 0; attack < numOfAttacks; attack++) {
                // get attack name, description, and damage - then add to attacks arraylist

                System.out.printf("For attack %d:\n", attack + 1);
                do { // get attackName
                    System.out.print("Enter the attack name: ");
                    attackName = in.nextLine().strip();

                    if (attackName != "")
                        break;
                    else {
                        System.out.print("Invalid input. ");
                    }
                } while (true);

                do { // get attackDesc
                    System.out.print("Enter the attack description (leave blank if there is no description): ");
                    attackDesc = in.nextLine().strip();

                    break;
                } while (true);

                do { // get attackDamage
                    System.out.print("Enter the attack damage: ");
                    attackDamage = in.nextLine().strip();

                    if (attackDamage != "")
                        break;
                    else {
                        System.out.print("Invalid input. ");
                    }
                } while (true);

                // all attack info is inputted - add now
                cardAttacks.add(new Attack(attackName, attackDesc, attackDamage));
            }

            // get the date
            do { // get number of attacks
                System.out.print("Enter the date (MM/DD/YYYY): ");
                inDate = in.nextLine().strip();
                StringTokenizer st = new StringTokenizer(inDate, "/");

                if (st.countTokens() == 3) {
                    try {
                        for (int i = 0; i < 3; i++) {
                            Integer.parseInt(st.nextToken());
                        }
                        cardDate = new Date(inDate);
                        if (cardDate.valid())
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

            // create the card
            this.cards.add(new Card(cardName, cardHP, cardType, cardDate, cardAttacks));

            // update variables
            this.totalHP += cardHP;
            totalNumOfCards++;
            totalHPOfAllAlbums += cardHP;

            System.out.printf("\n%s successfully added!\n\n", cardName);
        }
    }

    // removeCard method - for #2-#4
    public void removeCard(Scanner in) {
        int choice; // choice from list of sort by options
        int index;

        if (this.cards.size() == 0) // if album doesn't have ANY cards
            System.out.println("This album contains 0 cards. (No cards removed)\n");
        else {
            // prompt for removeby option
            do {
                try {
                    System.out.print("1. Name\n2. HP\n3. First Listed Card\n4. Last Listed Card\nRemove card by/the: ");
                    choice = Integer.parseInt(in.nextLine().strip());

                    if (choice < 1 || choice > 4)
                        throw new NumberFormatException();
                    else
                        break;
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. ");
                }
            } while (true);

            ArrayList<Card> cardsCopy = new ArrayList<>(this.cards);

            if (choice == 1) { // Remove by NAME

                ArrayList<Card> noDuplicateNames = new ArrayList<>();
                int removeNameChoice;
                String removeName;

                // Store non-duplicate card names in another array
                Collections.sort(cardsCopy);
                for (int i = 0; i < this.cards.size(); i++) {
                    if (Collections.binarySearch(noDuplicateNames,
                            new Card(cardsCopy.get(i).getName(), 0, "", new Date("00/00/0000"), emptyArrList)) < 0) {
                        noDuplicateNames.add(cardsCopy.get(i));
                    }
                }
                System.out.println();

                // Display a list of all the non-duplicated cards by NAME
                for (int i = 0; i < noDuplicateNames.size(); i++) {
                    System.out.printf("%d. %s\n", i + 1, noDuplicateNames.get(i).getName());
                }

                // Prompt for which name
                do {
                    try {
                        System.out.print("Remove Card with Name (Enter LIST #): ");
                        removeNameChoice = Integer.parseInt(in.nextLine().strip());

                        if (removeNameChoice < 1 || removeNameChoice > noDuplicateNames.size())
                            throw new NumberFormatException();
                        else {
                            removeName = noDuplicateNames.get(removeNameChoice - 1).getName();
                            System.out.println();
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.print("Invalid input. ");
                    }
                } while (true);

                // Remove ALL instances of cards with the same name in cards
                // Update variables too!
                Collections.sort(cardsCopy);

                while ((index = Collections.binarySearch(cardsCopy,
                        new Card(removeName, 0, "", new Date("00/00/0000"), emptyArrList))) >= 0) {

                    System.out.printf("%s was removed!\n", cardsCopy.get(index).getName());

                    this.totalHP -= cardsCopy.get(index).getHP();
                    totalNumOfCards--;
                    totalHPOfAllAlbums -= cardsCopy.get(index).getHP();

                    this.cards.remove(cardsCopy.get(index));
                    cardsCopy.remove(index);
                }
                System.out.println();

            } else if (choice == 2) { // Remove by HP

                ArrayList<Integer> noDuplicateHPs = new ArrayList<>();
                int removeHPChoice;
                int removeHP;

                // Store non-duplicate card HPs in another array
                for (int i = 0; i < this.cards.size(); i++) {
                    if (!noDuplicateHPs.contains(this.cards.get(i).getHP())) {
                        noDuplicateHPs.add(this.cards.get(i).getHP());
                    }
                }
                System.out.println();

                // Display a list of all the non-duplicated cards by HP
                for (int i = 0; i < noDuplicateHPs.size(); i++) {
                    System.out.printf("%d. %d\n", i + 1, noDuplicateHPs.get(i));
                }

                // Prompt for which HP
                do {
                    try {
                        System.out.print("Remove Card with HP (Enter LIST #): ");
                        removeHPChoice = Integer.parseInt(in.nextLine().strip());

                        if (removeHPChoice < 1 || removeHPChoice > noDuplicateHPs.size())
                            throw new NumberFormatException();
                        else {
                            removeHP = noDuplicateHPs.get(removeHPChoice - 1);
                            System.out.println();
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.print("Invalid input. ");
                    }
                } while (true);

                // Remove all instances of cards with the same HP in cards
                Collections.sort(cardsCopy, new SortCardsByHP());

                while ((index = Collections.binarySearch(cardsCopy,
                        new Card("", removeHP, "", new Date("00/00/0000"), emptyArrList), new SortCardsByHP())) >= 0) {

                    System.out.printf("%s was removed!\n", cardsCopy.get(index).getName());

                    this.totalHP -= cardsCopy.get(index).getHP();
                    totalNumOfCards--;
                    totalHPOfAllAlbums -= cardsCopy.get(index).getHP();

                    this.cards.remove(cardsCopy.get(index));
                    cardsCopy.remove(index);
                }
                System.out.println();

            } else if (choice == 3) { // Remove the First Listed Card (in last sorted order)
                System.out.printf("%s was removed!\n\n", this.cards.get(0).getName());

                this.totalHP -= this.cards.get(0).getHP();
                totalNumOfCards--;
                totalHPOfAllAlbums -= this.cards.get(0).getHP();

                this.cards.remove(0);
            } else { // Remove Last Listed Card (in Last sorted order)
                System.out.printf("%s was removed!\n\n", this.cards.get(this.cards.size() - 1).getName());

                this.totalHP -= this.cards.get(this.cards.size() - 1).getHP();
                totalNumOfCards--;
                totalHPOfAllAlbums -= this.cards.get(this.cards.size() - 1).getHP();

                this.cards.remove(this.cards.size() - 1);
            }
        }
    }

    // editAttack method - for #2-#5
    public void editAttack(Scanner in) {
        int index;

        if (this.cards.size() == 0) {
            System.out.println("This album contains 0 cards.\n");
        } else {
            // display all cards available to choose from
            for (int card = 0; card < this.cards.size(); card++) {
                System.out.printf("%d) %s (%s)\n", card + 1, this.cards.get(card).getName(),
                        this.cards.get(card).getDateDisplay());
            }

            // prompt for card to edit from
            do {
                try {
                    System.out.print("Select a card (by #): ");
                    index = Integer.parseInt(in.nextLine().strip()) - 1;

                    if (index < 0 || index >= this.cards.size())
                        throw new NumberFormatException();
                    else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. ");
                }
            } while (true);

            // edit attack
            this.cards.get(index).editAttack(in);
        }
    }

    // sortCards method - #2-#6
    public void sortCards(Scanner in) {
        int choice;

        System.out.println("1. Sort by NAME\n2. Sort by HP\n3. Sort by DATE");

        do {
            try {
                System.out.print("Sort by (Enter #): ");
                choice = Integer.parseInt(in.nextLine());

                if (choice < 1 || choice > 3)
                    throw new NumberFormatException();
                else
                    break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. ");
            }
        } while (true);

        if (choice == 1) { // sort by NAME
            Collections.sort(this.cards);

            System.out.println("Cards sorted by NAME (in alphabetical order)!");
            this.displayAllCards();

        } else if (choice == 2) { // sort by HP
            Collections.sort(this.cards, new SortCardsByHP());

            System.out.println("Cards sorted by HP (in ascending order)!");
            this.displayAllCards();

        } else {// sort by DATE
            Collections.sort(this.cards, new SortCardsByDate());

            System.out.println("Cards sorted by Date (from OLDEST to NEWEST)!");
            this.displayAllCards();
        }
    }

    // Getters + Setters
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

    // toString() - for display
    public String toString() {
        return this.num + "";
    }
}
