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

    private static int totalNumOfCards = 0;

    // Constructor
    public Album(int num, int capacity, ArrayList<Card> cards, Date date) {
        this.num = num;
        this.capacity = capacity;
        this.cards = cards;
        this.date = date;

        // determines the totalHP of the album
        for (int card = 0; card < cards.size(); card++) {
            this.totalHP += cards.get(card).getHP();
        }
    }

    // displayInfo method - for #1-#2
    public void displayInfo() {
        System.out.printf(
                "\nAlbum #: %d\nDate: %s\nMaxCapacity: %d\nNumber of Cards: %d\nTotal HP: %d\n\n",
                this.num, this.getDate(),
                this.capacity,
                this.cards.size(), this.totalHP);
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

    public String getDate() {
        return this.date.toString();
    }
}
