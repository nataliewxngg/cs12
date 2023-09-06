package u0;

public class L5_2DArrays {

    // a
    public static void a(int[][] numsArr) {
        for (int i = 0; i < numsArr.length; i++) {
            for (int n = 0; n < numsArr[i].length; n++) {
                System.out.print(numsArr[i][n]);
            }
            System.out.println("");
        }
    }

    // b
    public static void b(int[][] numsArr) {
        for (int i = 0; i < numsArr.length; i++) {
            for (int n = 0; n < numsArr[i].length; n++) {
                if (n != 0)
                    System.out.print(",");
                System.out.print(numsArr[i][n]);
            }
            System.out.println("");
        }
    }

    // c
    public static void c(int[][] numsArr) {
        for (int i = numsArr.length - 1; i >= 0; i--) {
            for (int n = 0; n < numsArr[i].length; n++) {
                if (n != 0)
                    System.out.print(",");
                System.out.print(numsArr[i][n]);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        // a) Write a method that takes in a 2D array and prints it out
        // nicely in rows and columns

        // b) Add commas between each element in each row
        // eg. 1,2,3,4
        // 5,6
        // 7,8,9

        // c) Turn the table upside down (print the rows in reverse)
        // eg. 7,8,9
        // 5,6
        // 1,2,3,4

        // a
        int[][] numsArr1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        a(numsArr1);

        // b
        int[][] numsArr2 = { { 1, 2, 3, 4 }, { 5, 6 }, { 7, 8, 9 } };
        b(numsArr2);

        // c
        c(numsArr2);
    }
}
