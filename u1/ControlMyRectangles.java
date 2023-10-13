package u1;

import java.util.Scanner;

import u2.MyRectangle;

import java.util.ArrayList;

public class ControlMyRectangles {
    public static void main(String[] args) {
        // Variables
        int numOfSquares;
        int maxSideLength;

        // Main Code
        Scanner in = new Scanner(System.in);

        System.out.print("Enter # of squares: ");
        numOfSquares = Integer.parseInt(in.nextLine());

        System.out.print("Enter max side length of squares: ");
        maxSideLength = Integer.parseInt(in.nextLine());

        ArrayList<MyRectangle> list = new ArrayList<>();

        in.close();
    }
}
