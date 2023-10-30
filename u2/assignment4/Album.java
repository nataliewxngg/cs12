package u2.assignment4;

import java.util.*;

// Necessary instance and static variables declared (can ADD more variables later)
// Constructor (can be cahnged later)

public class Album {
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
        for (int i = 0; i < cards.size(); i++) {
            totalHP += cards.get(i).getHP();
        }
    }
}
