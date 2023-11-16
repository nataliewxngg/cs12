package u2.test;

import java.awt.Color;
import java.util.*;

abstract class Shape {
    protected static int noOfShapes = 0;
    private int shapeID;
    protected Color color;
    protected double area;

    public Shape(Color c) {
        shapeID = ++noOfShapes;
        this.color = c;
        area = 0;
    }

    public static int blah1() {
        return 0;
    }

    abstract public void draw();
}
