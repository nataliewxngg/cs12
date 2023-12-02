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

    public static int numCards = 0;
    public static Stack<Integer> stack = new Stack<>();
    public static Deque<Integer> original = new ArrayDeque<>();

    public void draw(JFrame frame) {
        frame.getContentPane().removeAll();

        // JPanel for each menu buttons
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        panel1.setMaximumSize(new Dimension(500, 30));

        // Select # of cards
        JLabel text = new JLabel("Enter the number of cards: ");
        JButton goButton = new JButton("Go");
        JTextField numCardsMenu = new JTextField(20);

        goButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (numCardsMenu.getText().strip() != null)
                        numCards = Integer.parseInt(numCardsMenu.getText());
                    else
                        numCards = 0;

                    if (numCards < 0) {
                        throw new NumberFormatException();
                    } else if (numCards == 0) {
                        draw(frame);
                        return;
                    }

                    // Initialize stack (in order) first
                    for (int i = 1; i <= numCards; i++) {
                        stack.add(i);
                    }

                    // Go through sequence to make Deque
                    while (stack.size() > 1) {
                        // take
                        original.addFirst(stack.pop());
                        // on top
                        original.addFirst(original.removeLast());
                    }
                    original.addFirst(stack.pop());

                    draw(frame);
                } catch (NumberFormatException x) {
                    numCards = -1;
                    draw(frame);
                }
            }
        });

        panel1.add(text);
        panel1.add(numCardsMenu);
        panel1.add(goButton);

        // Exit button
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        panel2.add(exitButton);

        // JPanel for displaying the cards
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
        panel3.setMaximumSize(new Dimension(500, 30));
        JScrollPane scroller = new JScrollPane(panel3, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        if (numCards == -1) {
            JLabel text1 = new JLabel("Invalid input!");
            panel3.add(text1);

            frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
            frame.add(panel1);
            frame.add(panel2);
            frame.add(panel3);
            frame.pack();
            frame.setVisible(true);

        } else if (numCards > 0) {
            try {
                while (original.size() > 0) {
                    BufferedImage img = ImageIO
                            .read(new File("u3/assignment5/assets/card" + original.getFirst() + ".png"));
                    JLabel imgLabel = new JLabel(new ImageIcon(img.getScaledInstance(150, 90, Image.SCALE_FAST)));
                    imgLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
                    original.removeFirst();

                    panel3.add(imgLabel);
                }

                frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
                frame.add(panel1);
                frame.add(panel2);
                frame.add(scroller);
                frame.pack();
                frame.setVisible(true);
            } catch (IOException e) {
                System.out.println("Images not found!");
            }
        } else if (numCards == 0) { // = 0
            frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
            frame.add(panel1);
            frame.add(panel2);
            frame.add(panel3);
            frame.pack();
            frame.setVisible(true);
            return;
        }
    }

    // Change JPanel Settings
    public Problem3() {
        JFrame frame = new JFrame("Assignment 5 - Problem #3");
        frame.setPreferredSize(new Dimension(500, 280));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        draw(frame);
    }

    public static void main(String[] args) {
        new Problem3();
    }
}
