package u2.assignment4;

import java.util.*;

// Necessary instance and static variables declared (can ADD more variables later)
// Constructor (can be changed later)

public class Card implements Comparable<Card> {
    public int compareTo(Card c) {
        return this.getName().toLowerCase().compareTo(c.getName().toLowerCase());
    }

    // Variables
    private String name;
    private int HP;
    private String type;
    private Date date;
    private ArrayList<Attack> attacks;

    // Constructor
    public Card(String name, int HP, String type, Date date, ArrayList<Attack> attacks) {
        this.name = name;
        this.HP = HP;
        this.type = type;
        this.date = date;
        this.attacks = attacks;
    }

    // Getters + Setters
    public String getName() {
        return this.name;
    }

    public int getHP() {
        return this.HP;
    }

    public String getType() {
        return this.type;
    }

    public ArrayList<Attack> getAttacks() {
        return this.attacks;
    }

    public String getDateDisplay() {
        return this.date.toString();
    }
}
