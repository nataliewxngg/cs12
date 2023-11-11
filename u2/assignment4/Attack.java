package u2.assignment4;

// Necessary instance and static variables declared (can ADD more variables later)
// Constructor (can be cahnged later)

public class Attack {
    // Variables
    private String name;
    private String desc;
    private String damage;

    // Constructor
    public Attack(String name, String desc, String damage) {
        this.name = name;
        this.desc = desc;
        this.damage = damage;
    }

    // Getters + Setters
    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getDamage() {
        return this.damage;
    }

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
