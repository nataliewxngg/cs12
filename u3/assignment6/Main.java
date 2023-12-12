// Natalie Wong
// Due Monday, December 18, 2023

// Assignment #6 - Word Frequency Assignment
// This program determines the frequency of all words in a textfile.

package u3.assignment6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// must use maps or other collection methods

public class Main {

    public Main() {
        String[] files = { "ALICE", "MOBY" };

        JFrame frame = new JFrame("Word Frequency Assignment");
        frame.setPreferredSize(new Dimension(600, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // for all panels
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Add file button, drop-down menu for recent files, exit button
        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(Color.GRAY);
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
        // inputPanel.setPreferredSize(new Dimension(500, 20));

        // Add file button, drop-down menu for recent files
        JPanel input1Panel = new JPanel();
        input1Panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        input1Panel.setBackground(Color.GRAY);

        JButton addFile = new JButton("Add File");
        addFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("developing...");
            }
        });

        input1Panel.add(addFile);
        JLabel space = new JLabel(" | ");
        input1Panel.add(space);

        JComboBox<String> recentFiles = new JComboBox<String>(files);
        input1Panel.add(recentFiles);

        JButton selectFile = new JButton("Select");
        selectFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("developing..."); // *********************
            }
        });
        input1Panel.add(selectFile);

        // Exit button
        JPanel input2Panel = new JPanel();
        input2Panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        input2Panel.setBackground(Color.GRAY);

        JButton exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        input2Panel.add(exit);

        inputPanel.add(input1Panel);
        inputPanel.add(input2Panel);

        // File Viewer and Frequency Stats
        JPanel viewPanel = new JPanel();
        viewPanel.setLayout(new GridLayout(1, 2));

        JPanel filePanel = new JPanel();
        JScrollPane fileScroller = new JScrollPane(filePanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        filePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JTextArea viewFile = new JTextArea(
                "VIEW PANEL");
        viewFile.setEditable(false);
        filePanel.add(viewFile);

        JPanel statsPanel = new JPanel();
        JScrollPane statsScroller = new JScrollPane(statsPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        statsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JTextArea stats = new JTextArea("STATS PANEL");
        viewFile.setEditable(false);
        statsPanel.add(stats);

        viewPanel.add(fileScroller);
        viewPanel.add(statsScroller);

        mainPanel.add(inputPanel, BorderLayout.PAGE_START);
        mainPanel.add(viewPanel, BorderLayout.CENTER);
        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
