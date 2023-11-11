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
        for (int card = 0; card < cards.size(); card++) {
            System.out.printf("\nCard Name: %s\nDate of purchase/trade: %s\n", this.getCards().get(card).getName(),
                    this.getCards().get(card).getDateDisplay());
        }
        System.out.println("");
    }

    // displayCard method - for #2-#2
    public void displayCard(Scanner in) {
        int index;
        Card chosenCard;

        System.out.println();
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

    // removeCard method - for #2-#4 - NOT DONE
    public void removeCard(Scanner in) {

        int choice; // choice from list of sort by options

        do { // get number of attacks
            try {
                System.out.print("1. Name\n2. HP\n3. First Listed Card\n4. Last Listed Card\nRemove card by/the: ");
                choice = Integer.parseInt(in.nextLine().strip());

                if (choice < 1 || choice > 4) // don't allow for -# of attacks
                    throw new NumberFormatException();
                else
                    break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. ");
            }
        } while (true);

        if (choice == 1) { // Remove by NAME - case insensitively!

            Collections.sort(this.cards);
            ArrayList<Card> cardsCopy = new ArrayList<>(this.cards);
            ArrayList<String> cardNamesNoDuplicates = new ArrayList<>();

            // Store non-duplicate card names in another array
            for (int card = 0; card < this.cards.size(); card++) {
                if (!cardNamesNoDuplicates.contains(cards.get(card).getName())) {
                    cardNamesNoDuplicates.add(this.cards.get(card).getName());
                }
            }
            System.out.println(cardNamesNoDuplicates); // NOT DONEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE and not
                                                       // working lol

            // Display a list of all the non-duplicated cards by NAME

            // Prompt for which name

            // Remove ALL instances of cards with the same name in cards
            // Update variables too!

        } else if (choice == 2) { // Remove by HP

            // Store non-duplicate card HPs in another array

            // Display a list of all the non-duplicated cards by HP

            // Prompt for which HP

            // Remove all instances of cards with the same HP in cards
            // Update variables too!

        } else if (choice == 3) { // Remove the First Listed Card (in last sorted order)
            System.out.printf("%s was removed!\n\n", this.cards.get(0).getName());
            this.cards.remove(0);
        } else { // Remove Last Listed Card (in Last sorted order)
            System.out.printf("%s was removed!\n\n", this.cards.get(this.cards.size() - 1).getName());
            this.cards.remove(this.cards.size() - 1);
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
