package u2.review;

import java.util.*;

public class L3_Comparables {
    public static void main(String[] args) {
        // SORTING INTS
        // Arrays:
        int[] intArr = { 1, 5, 3, 9, 5, 7, 2, 65, 35 };
        Arrays.sort(intArr);

        for (int i = 0; i < intArr.length; i++) {
            System.out.print(intArr[i] + " ");
        } // { 1, 2, 3, 5, 5, 7, 9, 35, 65 }
        System.out.println();

        // ArrayList:
        ArrayList<Integer> intArrList = new ArrayList<>(Arrays.asList(1, 5, 3, 9, 5, 7, 2, 65, 35));
        Collections.sort(intArrList); // { 1, 2, 3, 5, 5, 7, 9, 35, 65 }
        System.out.println(intArrList);

        // TO SORT AN ARRAYLIST OF OBJECTS BY A SPECIFIC CRITERIA (eg. name, age),
        // IMPLEMENT THE COMPARABLE INTERFACE
        Client jeff = new Client("Jeff", 54);
        Client nat = new Client("Natalie", 17);
        Client amanda = new Client("Amanda", 3);
        Client megan = new Client("Megan", 7);

        ArrayList<Client> clients = new ArrayList<>();
        clients.add(jeff);
        clients.add(nat);
        clients.add(amanda);
        clients.add(megan);

        // Only with comparable implemented will this work
        Collections.sort(clients);
        System.out.println(clients);

        // *********************************************** KEYTERMS
        // ****************************************************

        // Interface
        // - A special type of class
        // - Does NOOOOOTTTT include any instance variables
        // - Only allowed to have static/constant variables
        // - Has empty methods

        // Implementing an interface = filling in ALL empty methods of an interface with
        // bodies

        // ********************************************* BINARY SEARCH
        // *****************************************************
        // Finding based on criteria of the natural sorting order
        System.out.println(Arrays.binarySearch(intArr, 7)); // 5
        System.out.println(Collections.binarySearch(clients, new Client("Gurt", 54)));
        System.out.println(Collections.binarySearch(clients, new Client("Amanda", 83)));
    }
}