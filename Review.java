public class Review {

    // a
    public static void a(int[][] numsArr) {
        for (int i = 0; i < numsArr.length; i++) {
            for (int n = 0; n < numsArr[i].length; n++) {
                System.out.print(numsArr[i][n]);
            }
            System.out.println("");
        }
    }

    public static void b(int[][] numsArr) {

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
    }
}
