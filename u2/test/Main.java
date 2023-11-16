package u2.test;

import java.util.*;
import java.awt.Color;

public class Main {
    public static void main(String[] args) {
        // ArrayList
        MsWong wong1 = new MsWong("J", "CS", 25);
        ArrayList<MsWong> list = new ArrayList<>();

        list.add(wong1);
        list.add(new MsWong("E"));

        // Find # of elements
        System.out.println(list.size());

        // Get obj from list
        MsWong wong3 = list.get(1);
        wong3.setSubject("poop");
        System.out.println(list.get(1));
        System.out.println(wong3);

        // System.out.println(list.contains(new MsWong("E"))); // true with new
        // overriden .equals() method

        // For question #2
        ArrayList<MsWong> newList = list;
        newList.remove(0);

        System.out.println(list.get(0));
        System.out.println(newList.get(0));

        // Calling classes with inheritance
        Shape s1 = new Circle(Color.red, 10);
        s1.noOfShapes++;
        Shape.noOfShapes++;
        System.out.println(Shape.noOfShapes);
    }
}
