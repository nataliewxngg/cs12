// Natalie Wong
// DUE September 14, 2023

// Description:

// This program is designated to take input from WONG "R" Us' customers
// and create their receipts in a txt file respectively (called receipt.txt)

// The receipt will display each item's quantity and price, as well as the total cost (without tax), tax, and the final cost (with tax).
// On top of that, the receipt will provide a summary of the total number of toys bought and the most expensive toy purchased!

package u1.assignments;

import java.util.Scanner;
import java.io.*;

public class A {

    // This method takes a 2D array, bag, and appends a new item into it (item as in
    // a toy's name, quantity, and cost)
    // In essence, it appends an extra row into the array each time it is called
    public static String[][] addItemToBag(String[][] bag, String toy, int amount, double cost) { // Parameters include:
                                                                                                 // 1. the 2D array bag,
                                                                                                 // which includes all
                                                                                                 // the items
                                                                                                 // 2. the toy name
                                                                                                 // 3. the quantity of
                                                                                                 // the toy purchased
                                                                                                 // 4. the unit cost
                                                                                                 // (cost per toy) of
                                                                                                 // the toy
        String[][] newBag = new String[bag.length + 1][3];

        // Copies all the original values of bag into the new array
        for (int row = 0; row < bag.length; row++) {
            for (int col = 0; col < bag[row].length; col++) {
                newBag[row][col] = bag[row][col];
            }
        }

        // Appends the new item given the parameters
        newBag[bag.length][0] = toy;
        newBag[bag.length][1] = Integer.toString(amount);
        newBag[bag.length][2] = Double.toString(cost);

        return newBag; // The 2D array bag with the new item appended
    }

    // This method takes the 2D array, bag, and goes through the total costs
    // (cost*quantity) of each item to determine the most expensive one
    // If there are two items with the same total costs, the first item will remain
    // most expensive
    public static int getMostExpensive(String[][] bag) { // The 2D array, bag, that includes all the items
                                                         // name, quantity, cost)
        int mostExpensiveIndex = 0;
        double mostExpensiveCost = 0;

        // Goes through all items of bag row by row to determine the most expensive
        // item's cost and index in the array
        for (int row = 0; row < bag.length; row++) {
            if (Integer.parseInt(bag[row][1]) * Double.parseDouble(bag[row][2]) > mostExpensiveCost) {
                mostExpensiveCost = Integer.parseInt(bag[row][1]) * Double.parseDouble(bag[row][2]);
                mostExpensiveIndex = row;
            }
        }
        return mostExpensiveIndex; // The index of the row in the 2D array bag that stores the most expensive item
    }

    // This method creates the dash lines in the receipt textfile
    public static void addDashLine(PrintWriter outputFile) { // The text file to display the dash lines in
        // Prints 70 dash lines in ONE LINE (.out.PRINT) in the textfile
        for (int i = 0; i < 70; i++) {
            outputFile.print("-");
        }
    }

    public static void main(String[] args) {
        // Variables
        Scanner in = new Scanner(System.in);

        String buyingInput;
        boolean buying = true;
        int toyNum = 0;
        String toy;
        int amount = 0;
        double cost = 0;

        double totalCost = 0;
        int totalAmount = 0;

        String[][] bag = new String[0][0];

        // Main Code
        System.out.println("WONG \"R\" US\n");

        // Collects input for toy name, quantity, and price from user UNTIL user inputs
        // "n"/"N" when prompted whether or not they are purchasing anymore toys
        while (buying) {
            toyNum++;

            // inputs the toy name from user
            // (between 0-20 characters exclusive)
            // user will be continuously prompted until a valid input is entered
            System.out.printf("Please enter the name of toy #%d: ", toyNum);
            toy = in.nextLine();
            while (toy.length() < 1 || toy.length() > 19) {
                System.out.printf("Invalid input. Please enter the name of toy #%d: ", toyNum);
                toy = in.nextLine();
            }

            // inputs the quantity of the toy from user
            // (between 0-99999 toys exclusive)
            // user will be continuously prompted until a valid input is entered
            System.out.print("How many of this toy are you buying?: ");

            while (amount < 1 || amount >= 99999) {
                try {
                    amount = Integer.parseInt(in.nextLine().trim());
                    if (amount < 1 || amount >= 99999) {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Invalid. How many of this toy are you buying?: ");
                }
            }

            // inputs the cost of the toy from user
            // (between $0-99999 exclusive)
            // user will be continuously prompted until a valid input is entered
            System.out.print("Please enter the cost of this toy: $");

            while (cost <= 0 || cost >= 99999) {
                try {
                    cost = Double.parseDouble(in.nextLine().trim());
                    if (cost <= 0 || cost >= 99999) {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Invalid. Please enter the cost of this toy: $");
                }
            }

            System.out.printf("The cost for %d %s @ $%.2f each is %.2f%n", amount, toy, cost, amount * cost);

            // asks user if they are buying anymore toys
            // if NOT, buying will become FALSE, meaning that the user will not be prompted
            // and inputted anymore
            System.out.print("Are you buying anymore toys? (y/n): ");
            buyingInput = in.nextLine();
            while (!buyingInput.equalsIgnoreCase("n") && !buyingInput.equalsIgnoreCase("y")) {
                System.out.print("Invalid input. Are you buying anymore toys? (y/n): ");
                buyingInput = in.nextLine();
            }
            if (buyingInput.equalsIgnoreCase("n")) {
                buying = false;

                System.out
                        .println(
                                "\nThank you for shopping at Wong \"R\" Us!\n(Your receipt is saved in receipt.txt.)");
            }
            System.out.println("");

            bag = addItemToBag(bag, toy, amount, cost); // appends the new information of the toy (toy name, quantity,
                                                        // cost) into the
                                                        // 2D-array bag which will become extremely useful later on for
                                                        // the receipt

            totalAmount += amount; // accumulates the toy's cost*quantity (toy's total cost) into totalAmount,
                                   // which will be accessed later on for the receipt

            amount = 0;
            cost = 0;
        }

        // creates receipt.txt
        try {
            PrintWriter outputFile = new PrintWriter(new FileWriter("receipt.txt"));

            outputFile.println("Here is a summary of your purchases at Wong \"R\" Us:\n");
            outputFile.printf("%-36s%-12s%-12s%-12s%n", "ITEM", "UNIT COST", "QUANTITY", "TOTAL COST");
            outputFile.printf("%-36s%-12s%-12s%-12s%n", "----", "---------", "---------", "----------");

            // takes every toy from the bag and display their names, quantities, unit costs,
            // and total costs in the receipt
            for (int row = 0; row < bag.length; row++) {
                outputFile.printf("%-36s$%-11.2f%-13d$%-11.2f%n", bag[row][0], Double.parseDouble(bag[row][2]),
                        Integer.parseInt(bag[row][1]), Double.parseDouble(bag[row][2]) * Integer.parseInt(bag[row][1]));
                totalCost += Double.parseDouble(bag[row][2]) * Integer.parseInt(bag[row][1]);
            }
            addDashLine(outputFile);

            // calculates and displays the total cost and tax into the receipt
            outputFile.printf("%n%-61s$%.2f", "Total Cost", totalCost);
            outputFile.printf("%n%-61s$%.2f%n", "Tax", totalCost * 0.13);
            addDashLine(outputFile);

            // calculates and displays the final cost (tax included) as well as the summary
            // of the total # of toys bought as well as the most expensive item purchased
            outputFile.printf("%n%-61s$%.2f%n%n", "FINAL COST", totalCost * 1.13);
            outputFile.printf("Total # of items bought: %d%n", totalAmount);
            outputFile.printf("Most expensive item: %d %s for $%.2f",
                    Integer.parseInt(bag[getMostExpensive(bag)][1]),
                    bag[getMostExpensive(bag)][0],
                    Double.parseDouble(bag[getMostExpensive(bag)][2])
                            * Integer.parseInt(bag[getMostExpensive(bag)][1]));
            outputFile.close();
        } catch (IOException e) { // prints a "Writing Error!" message in the console if an input output exception
                                  // occurs
            System.out.println("Writing Error!");
        }

        // Terminating variables
        in.close();
    }
}
