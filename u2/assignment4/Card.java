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

    // editAttack method - for #2-#5
    public void editAttack(Scanner in) {

        if (this.attacks.size() == 0) {
            System.out.println("This card contains 0 attacks. No attack fields changed.\n");
        } else {
            int index;
            int editOption;

            // display all attacks
            for (int attack = 0; attack < this.attacks.size(); attack++) {
                System.out.printf("%d) %s (%s Damage)\n", attack + 1, this.attacks.get(attack).getName(),
                        this.attacks.get(attack).getDamage());
            }

            // prompt for which attack
            do {
                try {
                    System.out.print("Select an attack (by #): ");
                    index = Integer.parseInt(in.nextLine().strip()) - 1;

                    if (index < 0 || index >= this.attacks.size())
                        throw new NumberFormatException();
                    else {
                        System.out.printf("You selected the Attack %s.\n", this.attacks.get(index).getName());
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. ");
                }
            } while (true);

            // prompt for remove name, description, or damage
            System.out.println("1. Name\n2. Description\n3. Damage");

            do {
                try {
                    System.out.print("Select a Field to Edit (by #): ");
                    editOption = Integer.parseInt(in.nextLine().strip());

                    if (editOption < 1 || editOption > 3)
                        throw new NumberFormatException();
                    else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. ");
                }
            } while (true);

            if (editOption == 1) { // edit ATTACK NAME
                String newName;

                do {
                    System.out.print("Enter the new attack name (CANNOT BE EMPTY!): ");
                    newName = in.nextLine().strip();

                    if (newName != "")
                        break;
                    else
                        System.out.print("Invalid input. ");

                } while (true);

                System.out.printf("Attack %s has been renamed to %s!\n\n", this.attacks.get(index).getName(), newName);
                this.attacks.get(index).changeName(newName);

            } else if (editOption == 2) { // edit ATTACK DESCRIPTION
                String newDesc;

                System.out.print("Enter the new attack description (Can be EMPTY!): ");
                newDesc = in.nextLine().strip();

                System.out.printf("Attack %s's description is now \"%s\"!\n\n", this.attacks.get(index).getName(),
                        newDesc);
                this.attacks.get(index).changeDesc(newDesc);

            } else { // EDIT ATTACK DAMAGE
                String newDamage;

                do {
                    System.out.print("Enter the new attack name (CANNOT BE EMPTY!): ");
                    newDamage = in.nextLine().strip();

                    if (newDamage != "")
                        break;
                    else
                        System.out.print("Invalid input. ");

                } while (true);

                System.out.printf("Attack %s's damage is now %s!\n\n", this.attacks.get(index).getName(), newDamage);
                this.attacks.get(index).changeDamage(newDamage);
            }

        }
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

    public Date getDate() {
        return this.date;
    }

    public ArrayList<Attack> getAttacks() {
        return this.attacks;
    }

    public String getDateDisplay() {
        return this.date.toString();
    }
}
