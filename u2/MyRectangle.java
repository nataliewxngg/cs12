package u2;

public class MyRectangle {
    private int left;
    private int bottom;
    private int width;
    private int height;

    private static int numRectangles;

    public int removeNegs(int val) {
        if (val < 0)
            return 0;
        return val;
    }

    // constructor method
    public MyRectangle(int left, int bottom, int width, int height) {
        this.left = removeNegs(left);
        this.bottom = removeNegs(bottom);
        this.width = removeNegs(width);
        this.height = removeNegs(height);
        numRectangles++;
    }

    // getter and setter
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    // toString method
    public String toString() {
        return "base: (" + left + "," + bottom + ")" + " w:" + width + " h:" + height;
    }

    // get area
    public int area() {
        return width * height;
    }

    // get num of rectangles
    public static int getNumOfRectangles() {
        return numRectangles;
    }

    // compareTo method
    public int compareTo(MyRectangle rect1) {
        if (width * height == rect1.getWidth() * rect1.getHeight())
            return 0;
        else if (width * height < rect1.getWidth() * rect1.getHeight())
            return -1;
        else
            return 1;
    }
}
