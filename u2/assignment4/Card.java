package u2.assignment4;

import java.util.*;

public class Card implements Comparable<Card> {

    // DESCRIPTION:
    // Used to compare between the names of two Card objects lexicographically and
    // case insensitively
    // (CARD1.compareTo(CARD2))

    // It is moreover a method utilized for the Comparable Interface - NATURAL
    // SORTING ORDER
    // When called (Collections.sort(ARRAYLIST)), it allows the comparable interface
    // to sort an ArrayList of Card objects in alphabetical order of their names,
    // lexicographically and case insensitively
    public int compareTo(Card c) { // PARAMETER: A Card object to compare to
        return this.getName().toLowerCase().compareTo(c.getName().toLowerCase());

        // RETURNS:
        // let the variables be c1 and c2 in c1.compareTo(c2)
        // IF c1 < c2 --> RETURN A NEGATIVE #
        // IF c1 == c2 --> RETURN 0
        // IF c1 > c2 --> RETURN A POSITIVE #
    }

    // Instance Variables + Data Encapsulation
    private String name;
    private int HP;
    private String type;
    private Date date;
    private ArrayList<Attack> attacks;

    // DESCRIPTION: The CONSTRUCTOR method - utilized to create new Card objects
    // and to initialize each object's instance variables
    public Card(String name, int HP, String type, Date date, ArrayList<Attack> attacks) { // PARAMETERS:
                                                                                          // 1. Card name
                                                                                          // 2. Card HP
                                                                                          // 3. Card type
                                                                                          // 4. Card's date of
                                                                                          // purchase/trade
                                                                                          // 5. Card's list of attacks

        // Initializes the instance variables of the new Card object!
        this.name = name;
        this.HP = HP;
        this.type = type;
        this.date = date;
        this.attacks = attacks;

        // RETURNS: none (constructors do not return any value)
    }

    // DESCRIPTION: Utilized for Menu #2 - Submenu #5
    // Allows the user to edit the attack name, description, or damage of a card
    public void editAttack(Scanner in) { // PARAMETERS: A scanner to acquire user input from

        // If the card does NOT contain any attacks, inform the user of it and exit the
        // method
        if (this.attacks.size() == 0) {
            System.out.println("This card contains 0 attacks. No attack fields changed.\n");
        }
        // Otherwise, if the card contains 1+ attacks, prompt for which attack to edit
        // from, and what to assign its name, description, or damage
        else {
            int index;
            int editOption;

            // Displays a numbered list of all the attacks the card contains
            for (int attack = 0; attack < this.attacks.size(); attack++) {
                System.out.printf("%d) %s (%s Damage)\n", attack + 1, this.attacks.get(attack).getName(),
                        this.attacks.get(attack).getDamage());
            }

            // Continuously prompts the user for which attack to edit until a valid input is
            // inputted
            do {
                try {
                    System.out.print("Select an attack (by #): ");
                    index = Integer.parseInt(in.nextLine().strip()) - 1;

                    if (index < 0 || index >= this.attacks.size())
                        throw new NumberFormatException();
                    else { // Once an attack is selected to edit from, stop prompting for one
                        System.out.printf("You selected the Attack %s.\n", this.attacks.get(index).getName());
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. ");
                }
            } while (true);

            // Continuously prompts the user for whether they would like to edit the chosen
            // attack's name, description, or damage until a valid input is inputted
            System.out.println("1. Name\n2. Description\n3. Damage");
            do {
                try {
                    System.out.print("Select a Field to Edit (by #): ");
                    editOption = Integer.parseInt(in.nextLine().strip());

                    if (editOption < 1 || editOption > 3)
                        throw new NumberFormatException();
                    else { // Once a field is chosen to edit from, stop prompting the user for it
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. ");
                }
            } while (true);

            // If the user selected to edit the ATTACK NAME, prompt the user for a new
            // attack name and reassign it to its new value
            if (editOption == 1) {
                String newName;

                // Continuously prompt the user for the new attack name until a non-empty input
                // is inputted
                do {
                    System.out.print("Enter the new attack name (CANNOT BE EMPTY!): ");
                    newName = in.nextLine().strip();

                    if (newName != "")
                        break;
                    else
                        System.out.print("Invalid input. ");

                } while (true);

                // Set the attack name to the new attack name inputted by the user
                System.out.printf("Attack %s has been renamed to %s!\n\n", this.attacks.get(index).getName(), newName);
                this.attacks.get(index).changeName(newName);
            }
            // If the user selected to edit the ATTACK DESCRIPTION, prompt the user for a
            // new attack description and reassign it to its new value
            else if (editOption == 2) {
                String newDesc;

                // Prompt the user for the new attack description
                System.out.print("Enter the new attack description (Can be EMPTY!): ");
                newDesc = in.nextLine().strip();

                // Set the attack description to the new attack description inputted by the user
                System.out.printf("Attack %s's description is now \"%s\"!\n\n", this.attacks.get(index).getName(),
                        newDesc);
                this.attacks.get(index).changeDesc(newDesc);
            }
            // Otherwise, if the user selected to edit the ATTACK DAMAGE, prompt the user
            // for a new attack damage and reassign it to its new value
            else {
                String newDamage;

                // Continuously prompt the user for the new attack damage until a non-empty
                // input is inputted
                do {
                    System.out.print("Enter the new attack name (CANNOT BE EMPTY!): ");
                    newDamage = in.nextLine().strip();

                    if (newDamage != "")
                        break;
                    else
                        System.out.print("Invalid input. ");

                } while (true);

                // Set the attack damage to the new attack damage inputted by the user
                System.out.printf("Attack %s's damage is now %s!\n\n", this.attacks.get(index).getName(), newDamage);
                this.attacks.get(index).changeDamage(newDamage);
            }
        }
        // RETURNS: none (void method)
    }

    // DESCRIPTION: Getter methods - allows the files utilizing Card objects to
    // access its private attributes
    // PARAMETERS: none
    // RETURNS: dependent on each attribute's data type
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

    public String getDateDisplay() { // A little special version of a getter as it returns the date of the Card
                                     // object as String format instead
        return this.date.toString();
    }
}
