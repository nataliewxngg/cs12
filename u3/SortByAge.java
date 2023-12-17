package u3;

import java.util.*;

public class SortByAge implements Comparator<Person> {
    public int compare(Person p1, Person p2) {
        return p1.age - p2.age;
    }
}
