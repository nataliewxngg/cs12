// Natalie Wong
// Due Monday, December 18, 2023

// Assignment #6 - Word Frequency Assignment
// This program determines the frequency of all words in a textfile.

package u3.assignment6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

// must use maps or other collection methods

public class Main {

    public static JFrame frame;
    public static JPanel mainPanel, inputPanel, input1Panel, input2Panel, viewPanel, filePanel, statsPanel;
    public static JComboBox<String> recentFiles;
    public static JLabel space = new JLabel(" | ");
    public static JButton addFile, selectFile, exit;
    public static JTextArea viewFile, stats;
    public static JScrollPane fileScroller, statsScroller;

    public static String[] files = { "ALICE", "MOBY" };

    public static String[] addFile(String fileName) {
        String[] out = new String[files.length + 1];
        for (int i = 0; i < files.length; i++) {
            out[i] = files[i];

            if (files[i].toLowerCase() == fileName.toLowerCase()) {
                out = new String[0];
                return files;
            }
        }
        out[out.length - 1] = fileName.strip();
        return out;
    }

    public Main() {
        frame = new JFrame("Word Frequency Assignment");
        frame.setPreferredSize(new Dimension(800, 550));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // for all panels
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Add file button, drop-down menu for recent files, exit button
        inputPanel = new JPanel();
        inputPanel.setBackground(new Color(2, 17, 27));
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
        // inputPanel.setPreferredSize(new Dimension(500, 20));

        // Add file button, drop-down menu for recent files
        input1Panel = new JPanel();
        input1Panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        input1Panel.setBackground(new Color(2, 17, 27));

        addFile = new JButton("Add File");
        addFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = JOptionPane.showInputDialog(frame, "Enter the file name (Exclude .txt):", null);

                try {
                    BufferedReader inFile = new BufferedReader(new FileReader(fileName.strip() + ".txt"));

                    // add to array
                    int orrLength = files.length;
                    files = addFile(fileName);

                    if (files.length == orrLength) {
                        JOptionPane.showMessageDialog(frame, fileName + ".txt has already been added!");
                    } else {
                        DefaultComboBoxModel<String> recentFilesModel = new DefaultComboBoxModel<>(files);
                        recentFiles.setModel(recentFilesModel);

                        JOptionPane.showMessageDialog(frame, fileName + ".txt has been added!");
                    }

                    // close the bufferedreader
                    inFile.close();
                } catch (IOException x) {
                    JOptionPane.showMessageDialog(frame, fileName + ".txt does not exist!");
                }
            }
        });

        input1Panel.add(addFile);
        input1Panel.add(space);

        recentFiles = new JComboBox<String>(files);
        input1Panel.add(recentFiles);

        selectFile = new JButton("Select");
        selectFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    BufferedReader inFile = new BufferedReader(
                            new FileReader(recentFiles.getSelectedItem() + ".txt"));

                    viewFile.setText("");
                    viewFile.read(inFile, null);

                    // redraw file panel to update the file content
                    filePanel.repaint();

                    // stats panel
                    long startTimer = System.currentTimeMillis();

                    // key - FREQUENCY; value - WORD
                    Map<Word, Integer> words = new TreeMap<>();

                    inFile = new BufferedReader(new FileReader(recentFiles.getSelectedItem() + ".txt"));
                    String s;
                    StringTokenizer st;
                    Word w;

                    // // collect frequencies of all the words
                    // while ((s = inFile.readLine()) != null) {
                    // st = new StringTokenizer(s, " -");

                    // while (st.hasMoreTokens()) {
                    // w = new Word(st.nextToken().toLowerCase(), 1);
                    // // System.out.println(w.getWord());

                    // if (words.containsKey(w)) {
                    // words.remove(w);
                    // w.addFreq();
                    // }

                    // words.put(w, w.getFrequency());
                    // }
                    // }

                    long timer = System.currentTimeMillis() - startTimer;
                    System.out.println(timer + "ms");

                    System.out.println(words);

                    inFile.close();
                } catch (IOException x) {
                    JOptionPane.showMessageDialog(frame, "Reading error!");
                }
            }
        });
        input1Panel.add(selectFile);

        // Exit button
        input2Panel = new JPanel();
        input2Panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        input2Panel.setBackground(new Color(2, 17, 27));

        exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        input2Panel.add(exit);

        inputPanel.add(input1Panel);
        inputPanel.add(input2Panel);

        // File Viewer and Frequency Stats
        viewPanel = new JPanel();
        viewPanel.setLayout(new GridLayout(1, 2));

        filePanel = new JPanel();
        fileScroller = new JScrollPane(filePanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        filePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        filePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        viewFile = new JTextArea("");
        viewFile.setEditable(false);
        filePanel.add(viewFile);

        statsPanel = new JPanel();
        statsScroller = new JScrollPane(statsPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        statsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        stats = new JTextArea("");
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
