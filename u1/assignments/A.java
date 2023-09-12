// Natalie Wong
// Due September 14, 2023

// This program is designated to utilize input from WONG "R" Us' customers
// to create their receipts in a txt file respectively

// Questions:
// 1. Do we have to consider cases for when customers enter an input that doesnt match the datatype 
//    eg. inputted a word for cost YES

package u1.assignments;

import java.util.Scanner;
import java.io.*;

public class A {
    public static String[][] addItemToBag(String[][] bag, String toy, int amount, double cost) {
        String[][] newBag = new String[bag.length + 1][3];

        for (int row = 0; row < bag.length; row++) {
            for (int col = 0; col < bag[row].length; col++) {
                newBag[row][col] = bag[row][col];
            }
        }
        newBag[bag.length][0] = toy;
        newBag[bag.length][1] = Integer.toString(amount);
        newBag[bag.length][2] = Double.toString(cost);
        // name, quantity, cost

        return newBag;
    }

    public static int getMostExpensive(String[][] bag) {
        int mostExpensiveIndex = 0;
        double mostExpensiveCost = 0;

        for (int row = 0; row < bag.length; row++) {
            if (Integer.parseInt(bag[row][1]) * Double.parseDouble(bag[row][2]) > mostExpensiveCost) {
                mostExpensiveCost = Integer.parseInt(bag[row][1]) * Double.parseDouble(bag[row][2]);
                mostExpensiveIndex = row;
            }
        }
        return mostExpensiveIndex;
    }

    public static void main(String[] args) {
        // Variables
        Scanner in = new Scanner(System.in);

        String buyingInput;
        boolean buying = true;
        int toyNum = 0;
        String toy;
        int amount;
        double cost;

        double totalCost = 0;
        int totalAmount = 0;

        String[][] bag = new String[0][0];

        // Main Code
        System.out.println("WONG \"R\" US\n");

        while (buying) {
            toyNum++;

            System.out.printf("Please enter the name of toy #%d: ", toyNum);
            toy = in.nextLine();
            while (toy.length() < 1 || toy.length() > 20) {
                System.out.printf("Invalid input. Please enter the name of toy #%d: ", toyNum);
                toy = in.nextLine();
            }

            System.out.print("How many of this toy are you buying?: ");
            amount = Integer.parseInt(in.nextLine());
            while (amount < 1 || amount >= 99999) {
                System.out.print("Invalid input. How many of this toy are you buying?: ");
                amount = Integer.parseInt(in.nextLine());
            }

            System.out.print("Please enter the cost of this toy: $");
            cost = Double.parseDouble(in.nextLine());
            while (cost <= 0 || cost >= 99999) {
                System.out.print("Invalid input. Please enter the cost of this toy: $");
                cost = Double.parseDouble(in.nextLine());
            }

            System.out.printf("The cost for %s @ %.2f each is %.2f%n", toy, cost, amount * cost);

            System.out.print("Are you buying anymore toys? (y/n): ");
            buyingInput = in.nextLine();
            while (!buyingInput.equalsIgnoreCase("n") && !buyingInput.equalsIgnoreCase("y")) {
                System.out.print("Invalid input. Are you buying anymore toys? (y/n): ");
                buyingInput = in.nextLine();
            }
            if (buyingInput.equalsIgnoreCase("n")) {
                buying = false;

                System.out.println("\nThank you for shopping at Wong \"R\" Us!");
                System.out.println("(Your receipt is saved in receipt.txt.)");
            }
            System.out.println("");
            bag = addItemToBag(bag, toy, amount, cost);
            totalAmount += amount;
        }

        try {
            PrintWriter outputFile = new PrintWriter(new FileWriter("receipt.txt"));

            outputFile.println("Here is a summary of your purchases at Wong \"R\" Us:\n");
            outputFile.printf("%-36s%-12s%-12s%-12s%n", "ITEM", "UNIT COST", "QUANTITY", "TOTAL COST");
            outputFile.printf("%-36s%-12s%-12s%-12s%n", "----", "---------", "---------", "----------");

            for (int row = 0; row < bag.length; row++) {
                outputFile.printf("%-36s$%-11.2f%-13d$%-11.2f%n", bag[row][0], Double.parseDouble(bag[row][2]),
                        Integer.parseInt(bag[row][1]), Double.parseDouble(bag[row][2]) * Integer.parseInt(bag[row][1]));
                totalCost += Double.parseDouble(bag[row][2]) * Integer.parseInt(bag[row][1]);
            }

            for (int i = 0; i < 70; i++) {
                outputFile.print("-");
            }

            outputFile.printf("%n%-61s$%.2f", "Total Cost", totalCost);
            outputFile.printf("%n%-61s$%.2f%n", "Tax", totalCost * 0.13);

            for (int i = 0; i < 70; i++) {
                outputFile.print("-");
            }

            outputFile.printf("%n%-61s$%.2f%n%n", "FINAL COST", totalCost * 1.13);
            outputFile.printf("Total # of items bought: %d%n", totalAmount);
            outputFile.printf("Most expensive item: %d %s for $%.2f",
                    Integer.parseInt(bag[getMostExpensive(bag)][1]),
                    bag[getMostExpensive(bag)][0],
                    Double.parseDouble(bag[getMostExpensive(bag)][2])
                            * Integer.parseInt(bag[getMostExpensive(bag)][1]));

            outputFile.close();
        } catch (IOException e) {
            System.out.println("Writing Error!");
        }

        // Terminating variables
        in.close();
    }
}
