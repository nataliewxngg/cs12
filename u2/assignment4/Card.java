package u2.assignment4;

import java.util.*;

// Necessary instance and static variables declared (can ADD more variables later)
// Constructor (can be cahnged later)

public class Card {
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
    public int getHP() {
        return this.HP;
    }
}
