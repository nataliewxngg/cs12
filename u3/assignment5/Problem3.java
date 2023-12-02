// Natalie Wong
// Due Sunday, December 3, 2023

// Assignment #5 - Dynamic Data Structures - PROBLEM #3
// This program determines the original order of pokemon cards, given that they all fall under the same sequence until facing upwards.

package u3.assignment5;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.border.*;

public class Problem3 {

    // Global variables
    public static int numCards = 0;
    public static Stack<Integer> stack = new Stack<>(); // For the FINAL ORDER (cards in ascending order)
    public static Deque<Integer> original = new ArrayDeque<>(); // For the ORIGINAL ORDER

    // DESCRIPTION: Utilized to draw the 3 panels - 1 for the # of cards selection
    // (textfield and Go button),
    // 1 for the exit button,
    // and the last for displaying the original order of cards.

    // Called each time a new # of cards is selected
    public void draw(JFrame frame) { // PARAMETERS: the JFrame to attach the panels to

        frame.getContentPane().removeAll(); // remove all the existing panels from the frame

        // JPanel for each menu elements (panel1 - for selecting # of cards, panel2 -
        // for exit button, panel3 - for displaying the cards)
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        panel1.setMaximumSize(new Dimension(500, 30));
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
        panel3.setMaximumSize(new Dimension(500, 30));
        JScrollPane scroller = new JScrollPane(panel3, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Elements for PANEL1 - selection of # of cards
        JLabel text = new JLabel("Enter the number of cards: ");
        JTextField numCardsMenu = new JTextField(20);
        JButton goButton = new JButton("Go");

        // If the go button is selected, determine the original order of cards and call
        // the draw() method to display it on panel3
        goButton.addActionListener(new ActionListener() {
            // DESCRIPTION: actionPerformed is a method in the interface ActionListener and
            // is executed each time an action is performed

            // In this case, each time the go button is pressed, it will input the # of
            // cards from the textfield, determine the original order according to it, and
            // call draw() to display the new original order on the JFrame
            public void actionPerformed(ActionEvent e) { // PARAMETERS: ActionEvent e not used

                // Determine the original order of the cards depending on the # of cards
                try {

                    // If the number of cards entered is empty, set number of cards to 0
                    // Otherwise, set number of cards to the # inputted
                    if (numCardsMenu.getText().strip() != null)
                        numCards = Integer.parseInt(numCardsMenu.getText());
                    else
                        numCards = 0;

                    // If the number of cards entered is invalid (not between the range of 0-25
                    // inclusive), throw a NumberFormatException to set the # of cards to -1 instead
                    // and call draw().
                    // Otherwise, if the # of cards entered is 0, call draw() already to redraw the
                    // jframe
                    if (numCards < 0 || numCards > 25) {
                        throw new NumberFormatException();
                    } else if (numCards == 0) {
                        draw(frame);
                        return;
                    }

                    // If the # of cards entered is between 1-25 inclusive, initialize the final
                    // order (cards in ascending order) of the cards into a stack first
                    // NOTE: a stack is utilized as elements added last (greatest #s) will be
                    // removed first (LIFO)
                    for (int i = 1; i <= numCards; i++) {
                        stack.add(i);
                    }

                    // After the final order is initialized, go through the sequence to determine
                    // the original order of the cards
                    // Store the original order into a deque, as elements will have to be removed
                    // and added from both ends (only removed from last index, and added from first
                    // index in this while loop, BUT will be added/removed from opposing ends later
                    // on)
                    // Plus, deque is faster!
                    while (stack.size() > 1) {
                        original.addFirst(stack.pop());
                        original.addFirst(original.removeLast());
                    }
                    original.addFirst(stack.pop());

                    draw(frame); // call draw to display the new original order on to the jframe

                } catch (NumberFormatException x) { // If the # of cards inputted is a non-int input, or is invalid
                                                    // (less than 0 or greater than 25), then set the # of cards to -1
                                                    // and call draw()
                    numCards = -1;
                    draw(frame);
                }

                // RETURNS: none (void method)
            }
        });

        // Add all panel1 elements to its panel
        panel1.add(text);
        panel1.add(numCardsMenu);
        panel1.add(goButton);

        // Panel 2 elements - exit button
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            // DESCRIPTION: actionPerformed is a method in the interface ActionListener and
            // is executed each time an action is performed

            // When the exit button is pressed, the jframe will close and the program will
            // be terminated
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        // Add all panel2 elements to its panel
        panel2.add(exitButton);

        // If the number of cards is -1, indicating the # of cards inputted is invalid,
        // display "Invalid input!" in panel3 instead of cards
        if (numCards == -1) {
            panel3.setLayout(new FlowLayout());
            JLabel text1 = new JLabel("Invalid input!");
            panel3.add(text1);

            // Attach all the necessary panels to the jframe
            frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
            frame.add(panel1);
            frame.add(panel2);
            frame.add(panel3);
            frame.pack();
            frame.setVisible(true);

        }
        // If the number of cards is greater than 0, display the original order of cards
        else if (numCards > 0) {
            try {
                // Add the original order of the cards on to panel3 one by one, ensuring they
                // are all displayed in their respective order
                while (original.size() > 0) {
                    BufferedImage img = ImageIO
                            .read(new File("u3/assignment5/assets/card" + original.getFirst() + ".png"));
                    JLabel imgLabel = new JLabel(new ImageIcon(img.getScaledInstance(150, 90, Image.SCALE_FAST)));
                    imgLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
                    original.removeFirst();

                    panel3.add(imgLabel);
                }

                // Attach all the necessary panels to the jframe
                frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
                frame.add(panel1);
                frame.add(panel2);
                frame.add(scroller);
                frame.pack();
                frame.setVisible(true);
            } catch (IOException e) { // If the images cannot be found in the directory, inform the user of it and
                                      // don't display anything
                System.out.println("Images not found!");
            }
        } else if (numCards == 0) { // If the number of cards is 0, don't display any cards

            // Attach all the necessary panels to the jframe
            frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
            frame.add(panel1);
            frame.add(panel2);
            frame.add(panel3);
            frame.pack();
            frame.setVisible(true);
            return;
        }
    }

    // DESCRPTION: The CONSTRUCTOR method - utilized to create the jframe and adjust
    // its settings - Also calls draw() to draw the panels on to the jframe
    public Problem3() { // PARAMETERS: none
        JFrame frame = new JFrame("Assignment 5 - Problem #3");
        frame.setPreferredSize(new Dimension(500, 280));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        draw(frame);

        // RETURNS: none (constructors do not return any value)
    }

    // DESCRIPTION: The main method calls Problem3(), which creates the JFrame and
    // attaches jpanels on to it
    public static void main(String[] args) { // PARAMETERS: args not used
        new Problem3();
        // RETURNS: none (void method)
    }
}
