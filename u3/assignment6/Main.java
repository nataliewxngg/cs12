// Natalie Wong
// Due Monday, December 18, 2023

// Assignment #6 - Word Frequency Assignment
// This program determines the frequency of all words in a textfile.

package u3.assignment6;

import java.awt.*;
import javax.swing.*;

// must use maps or other collection methods

public class Main {

    public Main() {
        JFrame frame = new JFrame("Word Frequency Assignment");
        frame.setPreferredSize(new Dimension(200, 200));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel l1 = new JLabel("Hello World");

        panel.add(l1);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
