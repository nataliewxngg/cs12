package u0;

public class L3_Loops {
    public static void main(String[] args) {
        // Logical Operators:
        // < Less than
        // <= Less or equal to
        // > Greater than
        // >= Greater or equal to
        // == Equal to
        // != Inequivalent to

        // Boolean Operators:
        // && And
        // || Or
        // ! Not

        // If statement
        int x = 10;
        int y = 5;

        if (x < y) {
            System.out.println("x is less than y");
        } else if (x == y) {
            System.out.println("x is equal to y");
        } else {
            System.out.println("x is greater than y");
        }

        // Loops
        // 1. For Loops
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        // 2. While Loops
        while (x <= 20) {
            System.out.println("Hello");
            x += 5;
        }

        // 3. Do-while Loops
        do {
            System.out.println(x);
            x += 5;
        } while (x <= 30);
    }
}
