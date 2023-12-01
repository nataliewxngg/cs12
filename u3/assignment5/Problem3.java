// Natalie Wong
// Due Sunday, December 3, 2023

// Assignment #5 - Dynamic Data Structures - PROBLEM #3
// This program determines the original order of pokemon cards, given that they all fall under the same sequence until facing upwards.

package u3.assignment5;

import java.awt.*;
import javax.swing.*;

public class Problem3 extends JPanel {

    // Change JPanel Settings
    public Problem3() {
        // JPanel Default Settings
        setPreferredSize(new Dimension(700, 400));
        setBackground(new Color(50, 50, 50));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Clear screen
    }

    public static void main(String[] args) {
        // Create and set up a frame window
        JFrame frame = new JFrame("Problem #3");

        // create and add panels
        Problem3 navBarPanel = new Problem3();
        Problem3 cardsPanel = new Problem3();
        // frame.add(navBarPanel);
        // frame.add(cardsPanel);
        frame.setVisible(true);
        frame.pack();

        // NAV BAR
        JButton jb1 = new JButton("Button 1");
        JButton jb2 = new JButton("Button 2");
        JButton jb3 = new JButton("Button 3");

        navBarPanel.setLayout(new FlowLayout());
        navBarPanel.add(jb1);
        navBarPanel.add(jb2);
        navBarPanel.add(jb3);

        // CARDS
        // JTextField t1 = new JTextField("jalodkfjoaiwejfoiawjef");
        // cardsPanel.add(t1);

        // Set the window to be visible as the default to be false
        frame.add(navBarPanel);
        // frame.add(cardsPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
