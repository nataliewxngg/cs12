package u2.review;

public class Client implements Comparable<Client> {
    // Comparable Interface - Natural Sorting Order

    public int compareTo(Client g) {
        return this.getAge() - g.getAge(); // Age in ascending order
        // return g.getAge() - this.getAge(); // Age in descending order

        // return this.getName().toLowerCase().compareTo(g.getName().toLowerCase());
        // Name in ascending order
        // return g.getName().toLowerCase().compareTo(this.getName().toLowerCase());
        // Name in descending order
    }

    private String name;
    private int age;

    public Client(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String toString() {
        return "\nName: " + this.getName() + "\nAge: " + this.getAge();
    }

}
