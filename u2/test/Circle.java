package u2.test;

import java.awt.Color;

public class Circle extends Shape {
    protected int radius;

    public Circle(Color col, int radius) {
        super(col); // Super calls on the superclass' constructor
        this.radius = radius;
        System.out.println(super.color);
    }

    public void changeRadius(int radius) {
        this.radius = radius;
    }

    public void draw() {
        System.out.println("drawing stuff lol");
    }

    public static int blah1() {
        return 1;
    }
}
