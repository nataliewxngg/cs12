// Natalie Wong
// Due Monday, December 18, 2023

// Assignment #6 - Word Frequency Assignment
// This program determines the frequency of all valid words in a textfile.

// Assumptions****:
// Contractions (eg. don't, isn't) are kept as ONE word
// Words connected by dashes are separated (eg. "ice-cream" --> "ice", "cream")
// Numbers are INCLUDED

package u3.assignment6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {

    // Global Variables
    public static Color NAVIGATOR_COLOR = new Color(29, 45, 68);
    public static Color BODY_COLOR = new Color(244, 243, 238);

    public static JFrame frame;
    public static JPanel mainPanel, inputPanel, input1Panel, input2Panel, viewPanel, filePanel, statsPanel;
    public static JComboBox<String> recentFiles;
    public static JLabel space = new JLabel(" | ");
    public static JButton addFile, selectFile, exit;
    public static JTextArea viewFile, stats;
    public static JScrollPane fileScroller, statsScroller;

    public static String[] files = { "ALICE", "MOBY" };

    // DESCRIPTION: The addFile method takes in a new file (by name) and adds it
    // into the array of available files ONLY IF IT IS NOT ALREADY ADDED
    public static String[] addFile(String fileName) { // PARAMETERS: name of new file (excluding .txt)
        String[] out = new String[files.length + 1];

        // Copy each file from the array of available files into a new array (that is
        // larger by 1 index)
        //
        // However, if the current available file has the same name (case insensitive)
        // as the NEW file, indicating that the new file is already added, then inform
        // the user of it and return the array of available files WITHOUT the new file
        // added
        for (int i = 0; i < files.length; i++) {
            out[i] = files[i];

            if (files[i].toLowerCase().equals(fileName.toLowerCase())) {
                JOptionPane.showMessageDialog(frame, fileName + ".txt is already added!");
                return files; // RETURNS: the original list of available files (if new file is already
                              // added)
            }
        }

        // If the new file does not already exist in the list of available files, then
        // add it into the array, inform the user of it, and return it
        JOptionPane.showMessageDialog(frame, fileName + ".txt has been added!");
        out[out.length - 1] = fileName.strip();
        return out; // RETURNS: the new list of available files (with new file added!)
    }

    // DESCRIPTION: The correct method takes in a word and removes its
    // leading/trailing apostrophes and contractions
    public static String correct(String s) { // PARAMETERS: a WORD in String format

        String symbols = "!@#$%^&*()_-+=[]{}\\|\"';:,./<>?~`";

        // Removes all leading symbols from the word
        while (symbols.indexOf(s.charAt(0)) != -1) {
            s = s.substring(1);
            if (s.length() == 0)
                return s; // RETURNS: If the word becomes empty (original was all symbols), then
                          // return the empty string
        }

        // Removes all trailing symbols from the word
        while (symbols.indexOf(s.charAt(s.length() - 1)) != -1) {
            s = s.substring(0, s.length() - 1);
        }

        // Removes all 's from the end of the word
        while (s.length() >= 2) {
            if (s.substring(s.length() - 2, s.length()).equals("'s")) {
                s = s.substring(0, s.length() - 2);

                // If removing 's leads to trailing symbol(s), remove it
                while (s.length() > 0) {
                    if (symbols.indexOf(s.charAt(s.length() - 1)) != -1) {
                        s = s.substring(0, s.length() - 1);
                        if (s.length() == 0)
                            return s; // RETURNS: the word if its length becomes 0 (indicating that its empty)
                    } else
                        break;
                }
            } else { // If the length of the word is incompatible for containing a 's (less than 2),
                break; // then stop looking for 's
            }
        }
        return s; // RETURNS: the word with leading and trailing symbols removed, as well as
                  // 's
    }

    // DESCRPTION: The CONSTRUCTOR method - utilized to create and append all
    // graphics components, as well as manage the full operation of the program
    public Main() { // PARAMETERS: none

        // Initialize the JFrame for the graphics window
        frame = new JFrame("Word Frequency Assignment");
        frame.setPreferredSize(new Dimension(820, 570));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize the JPanel utilized to group all other panels
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Initialize the input JPanel - utilized for the navigation bar
        inputPanel = new JPanel();
        inputPanel.setBackground(NAVIGATOR_COLOR);
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));

        // Initialize the JPanel that contains
        // 1. The add file button
        // 2. The drop-down menu for available files
        // in the navigation bar (inputPanel)
        input1Panel = new JPanel();
        input1Panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        input1Panel.setBackground(NAVIGATOR_COLOR);

        // Initialize the add file button
        addFile = new JButton("Add File");

        // If the add file button is selected, allow the user to input a new file (by
        // name) through a pop-up window and append it into the array of available files
        // if it's not already added
        addFile.addActionListener(new ActionListener() {

            // DESCRIPTION: actionPerformed is a method in the interface ActionListener and
            // is executed each time an action is performed

            // IN this case, each time the add file button is pressed, a pop-up window will
            // appear, input a new file (by name) from the user, and append it into the
            // array of available files (if not already added)
            public void actionPerformed(ActionEvent e) { // PARAMETERS: ActionEvent e not used
                // Prompt the user for a new file (by name) and append it into the array of
                // available files (if not already added)
                // If the file inputted does not exist, inform the user of it and do not modify
                // the array of available files
                String fileName = JOptionPane.showInputDialog(frame, "Enter the file name (Exclude .txt):", null);

                if (fileName != null) { // If 'cancel' button was selected, the following try-catch statement won't be
                                        // executed
                    try {
                        BufferedReader inFile = new BufferedReader(new FileReader(fileName.strip() + ".txt"));

                        // Add the file into the array 'files'
                        files = addFile(fileName.strip());

                        // Update the drop-down menu (recentFiles JComboBox)
                        DefaultComboBoxModel<String> recentFilesModel = new DefaultComboBoxModel<>(files);
                        recentFiles.setModel(recentFilesModel);

                        inFile.close();
                    } catch (IOException x) { // If the file name inputted does not exist in the directory, inform the
                                              // user
                                              // of it and do not modify the array of available files
                        JOptionPane.showMessageDialog(frame, fileName + ".txt does not exist!");
                    }
                }

                // RETURNS: none (void method)
            }
        });

        input1Panel.add(addFile);
        input1Panel.add(space);

        // Initialize the drop-down menu for all available files
        recentFiles = new JComboBox<String>(files);
        input1Panel.add(recentFiles);

        // Initialize the select button located on the navigation bar
        selectFile = new JButton("Select");

        // If the select button is selected, determine and display the frequencies of
        // every word in the current file selected (in the drop-down menu)
        selectFile.addActionListener(new ActionListener() {

            // DESCRIPTION: actionPerformed is a method in the interface ActionListener and
            // is executed each time an action is performed

            // In this case, each time the select button is pressed, determine the display
            // the frequencies of every word in the selected file (in the drop-down menu)
            public void actionPerformed(ActionEvent e) { // PARAMETERS: ActionEvent e not used

                // Initalize the map utilized to keep track of each word and its frequency
                // Moreover, initialize an arraylist later utilized to display the words and
                // frequencies in order (greatest-least frequencies)

                Map<Word, Integer> words = new HashMap<>(); // uses .hashcode() and .equals()
                ArrayList<Word> sortedWords;

                // Read through the selected file, display it on the file viewer, and determine
                // and display the frequencies of each word in the stats panel
                try {
                    // Update the new file content onto the file viewer
                    BufferedReader inFile = new BufferedReader(new FileReader(recentFiles.getSelectedItem() + ".txt"));

                    viewFile.setText("");
                    viewFile.read(inFile, null);

                    filePanel.repaint();

                    // Start the timer and re-initialize the bufferedreader
                    Long startTime = System.currentTimeMillis();
                    inFile = new BufferedReader(new FileReader(recentFiles.getSelectedItem() + ".txt"));

                    String s;
                    String w;
                    Word word;
                    StringTokenizer st;
                    int freq;

                    // Tokenize the words in each line of the selected file and add each into the
                    // map. If the word already exists in the map, accumulate its frequency!
                    while ((s = inFile.readLine()) != null) {
                        // StringTokenizer initialized to separate by space and by '-' (separates words
                        // connected by dashes --> eg. ice-cream)
                        st = new StringTokenizer(s, " -");

                        // Correct each token (word) in the current line and add them into the map
                        // (accumulate to frequency if already added)
                        while (st.hasMoreTokens()) {
                            w = correct(st.nextToken().toLowerCase());

                            // If word is already in map, remove it, add to its frequency, and add it into
                            // the map
                            if (words.containsKey(new Word(w))) {
                                freq = words.get(new Word(w));

                                word = new Word(w, freq);
                                word.addFreq();

                                words.remove(new Word(w));
                            }
                            // If the word is not already in the map, create a new word object
                            // with it (with frequency at 1) and add it into the map
                            else
                                word = new Word(w, 1);
                            words.put(word, word.getFrequency());
                        }
                    }

                    // Initialize the arraylist containing the keys (Word objects) of the map.
                    // This arraylist will be utilized to display the stats in sorted order
                    sortedWords = new ArrayList<>(words.keySet());
                    Collections.sort(sortedWords); // sorts by natural sorting order (comparable interface)

                    // End the timer and store the stats into a string called statsInfo.
                    // This string will then be attached to the statsInfo panel and displayed in the
                    // window
                    System.out.println(System.currentTimeMillis() - startTime + "ms");
                    String statsInfo = "Total Time: " + (System.currentTimeMillis() - startTime)
                            + " milliseconds\n\n20 Most Frequent Words\n\n";
                    statsInfo += String.format("%-10s%-25s%-10s\n\n", "", "Words", "Frequency");

                    // Store the top 20 words with the highest frequencies into the string statsInfo
                    // If there are less than 20 unique words, then display all of the words'
                    // frequencies
                    if (sortedWords.size() > 0) {
                        for (int i = 0; i < 20; i++) {
                            statsInfo += String.format("%-10s%-25s%-10d\n",
                                    i + 1 + ")", sortedWords.get(i),
                                    sortedWords.get(i).getFrequency());
                            if (i + 1 == sortedWords.size()) // If the current word is the last unique word
                                                             // available, end the for loop
                                i = 20;
                        }
                    } else {
                        statsInfo = recentFiles.getSelectedItem() + ".txt does not contain any valid words...";
                    }

                    // Update the stats panel with the new stats
                    stats.setText(statsInfo);
                    statsPanel.repaint();

                    inFile.close();

                }
                // If the file is missing from the directory, inform the user of it
                catch (IOException x) {
                    JOptionPane.showMessageDialog(frame, "Reading error!");
                }

                // RETURNS: none (void method)
            }
        });

        input1Panel.add(selectFile);

        // Initialize the JPanel that contains only the exit button
        input2Panel = new JPanel();
        input2Panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        input2Panel.setBackground(NAVIGATOR_COLOR);

        // Initialize the exit button
        exit = new JButton("Exit");

        // If the exit button is selected, the program terminates
        exit.addActionListener(new ActionListener() {

            // DESCRIPTION: actionPerformed is a method in the interface ActionListener and
            // is executed each time an action is performed

            // In this case, when the exit button is pressed, the JFrame and program
            // altogether terminates
            public void actionPerformed(ActionEvent e) { // PARAMETERS: Action e not used
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                // RETURNS: none (void method)
            }

        });
        input2Panel.add(exit);

        inputPanel.add(input1Panel);
        inputPanel.add(input2Panel);

        // Initialize the JPanel that contains:
        // 1. A panel that contains the file viewer
        // 2. A panel that contains the stats display
        viewPanel = new JPanel();
        viewPanel.setLayout(new GridLayout(1, 2));
        viewPanel.setBackground(BODY_COLOR);

        // Initialize the JPanel that contains the file viewer (includes a scrollbar!)
        filePanel = new JPanel();
        fileScroller = new JScrollPane(filePanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        filePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        filePanel.setBackground(BODY_COLOR);

        // Initialize the JTextArea for the file viewer
        viewFile = new JTextArea("");
        viewFile.setBackground(BODY_COLOR);
        viewFile.setEditable(false);
        filePanel.add(viewFile);

        // Initialize the panel that contains the stats display (includes a scrollbar!)
        statsPanel = new JPanel();
        statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.PAGE_AXIS));
        statsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        statsPanel.setBackground(BODY_COLOR);
        statsScroller = new JScrollPane(statsPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Initialize the JTextArea for the stats
        stats = new JTextArea("");
        stats.setFont(new Font("monospaced", Font.PLAIN, 12));
        stats.setBackground(BODY_COLOR);
        viewFile.setEditable(false);
        statsPanel.add(stats);

        viewPanel.add(fileScroller);
        viewPanel.add(statsScroller);

        mainPanel.add(inputPanel, BorderLayout.PAGE_START);
        mainPanel.add(viewPanel, BorderLayout.CENTER);
        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);

        // RETURNS: none (constructors do not return any value)
    }

    // DESCRIPTION: The main method operates the overall program by calling and
    // initializing the graphics
    public static void main(String[] args) { // PARAMETERS: args not used
        try {
            BufferedReader in = new BufferedReader(new FileReader("alice.txt"));
            in.close();
            in = new BufferedReader(new FileReader("MOBY.txt"));
            in.close();

            new Main();
        } catch (IOException e) {
            System.out.println("ALICE.txt and/or MOBY.txt is missing");
        }
        // RETURNS: none (void method)
    }
}
