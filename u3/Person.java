package u3;

import java.util.*;

public class Person implements Comparable<Person> {
    public int compareTo(Person p) {
        return this.name.toLowerCase().compareTo(p.name.toLowerCase());
    }

    public int age;
    public String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return this.age + "";
    }
}
