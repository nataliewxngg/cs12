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
