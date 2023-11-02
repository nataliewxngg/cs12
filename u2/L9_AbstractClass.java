package u2;

abstract class L9_AbstractClass {
    // Abstract class
    // **** CANNOT "INSTANTIATE" AN OBJECT OF AN ABSTRACT CLASS (can't make an
    // object out of this class)
    // - is a special type of class:

    // Interface
    // - can only have static and final variables (no instance)
    // - only empty methods are allowed
    // - implements ________
    // - must fill in bodies of empty methods (when implemented)

    // Abstract Class
    // - can have ALL types of variables
    // - can have empty (abstract) or fully defined methods
    // - extends _______
    // - must fill in bodies of empty methods (when extended)
    // this is a way to control what your subclasses must have

    // eg.
    protected Color color;
    protected static int numShapes = 0;

    public Shape(Color c) {
        color = c;
    }

    public int bla1() {
        ...
    }

    abstract public void draw();
}
