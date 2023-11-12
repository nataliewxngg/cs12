package u2.assignment4;

public class Attack {

    // Instance Variables + Data Encapsulation
    private String name;
    private String desc;
    private String damage;

    // DESCRIPTION: The CONSTRUCTOR method - utilized to create new Attack objects
    // and to initialize each object's instance variables
    public Attack(String name, String desc, String damage) { // PARAMETERS:
                                                             // 1. Attack name
                                                             // 2. Attack description
                                                             // 3. Attack damage

        // Initializes the instance variables of the new Attack object!
        this.name = name;
        this.desc = desc;
        this.damage = damage;

        // RETURNS: none (constructors do not return any value)
    }

    // DESCRIPTION: Getter methods - allows the files utilizing Attack objects to
    // access its private attributes
    // PARAMETERS: none
    // RETURNS: dependent on each attribute's data type
    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getDamage() {
        return this.damage;
    }

    // DESCRIPTION: Setter methods - allows the files utilizing Attack objects to
    // change its private attributes
    // PARAMETERS: New value that is to be assigned to the corresponding
    // attribute
    // RETURNS: none (void method)
    public void changeName(String newName) {
        this.name = newName;
    }

    public void changeDesc(String newDesc) {
        this.desc = newDesc;
    }

    public void changeDamage(String newDamage) {
        this.damage = newDamage;
    }
}
