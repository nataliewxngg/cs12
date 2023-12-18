// Natalie Wong
// Due Monday, December 18, 2023

// Assignment #6 - Word Frequency Assignment
// This program determines the frequency of all words in a textfile.

// Assumptions:
// Contractions (eg. don't, isn't) are separated into TWO words
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

        // Create a new map containing all the contractions, where the key is the
        // contraction itself, and the respective value contains the split-up
        // contraction (eg. key = she's, value = she is)
        Map<String, String> contractions = new HashMap<>();
        contractions.put("should've", "should have");
        contractions.put("shouldn't", "should not");
        contractions.put("could've", "could have");
        contractions.put("there'll", "there will");
        contractions.put("would've", "would have");
        contractions.put("couldn't", "could not");
        contractions.put("there're", "there are");
        contractions.put("these're", "these are");
        contractions.put("those're", "those are");
        contractions.put("wouldn't", "would not");
        contractions.put("that'll", "that will");
        contractions.put("they'll", "they will");
        contractions.put("they've", "they have");
        contractions.put("doesn't", "does not");
        contractions.put("haven't", "have not");
        contractions.put("there's", "there is");
        contractions.put("they're", "they are");
        contractions.put("weren't", "were not");
        contractions.put("she'll", "she will");
        contractions.put("you'll", "you will");
        contractions.put("aren't", "are not");
        contractions.put("didn't", "did not");
        contractions.put("hadn't", "had not");
        contractions.put("hasn't", "has not");
        contractions.put("wasn't", "was not");
        contractions.put("you're", "you are");
        contractions.put("you've", "you have");
        contractions.put("won't", "will not");
        contractions.put("he'll", "he will");
        contractions.put("it'll", "it will");
        contractions.put("we'll", "we will");
        contractions.put("we've", "we have");
        contractions.put("can't", "cannot");
        contractions.put("don't", "do not");
        contractions.put("isn't", "is not");
        contractions.put("she's", "she is");
        contractions.put("we're", "we are");
        contractions.put("i'll", "i will");
        contractions.put("i've", "i have");
        contractions.put("he's", "he is");
        contractions.put("it's", "it is");
        contractions.put("i'm", "i am");

        // Removes all leading apostrophes from the word
        while (s.charAt(0) == '\'') {
            s = s.substring(1);
            if (s.length() == 0)
                return s; // RETURNS: If the word becomes empty (original was all apostrophes), then
                          // return the empty string
        }

        // Removes all trailing apostrophes from the word
        while (s.charAt(s.length() - 1) == '\'') {
            s = s.substring(0, s.length() - 1);
        }

        // Splits the word (according to 'contractions''s key and value) and returns it
        // if it's a contraction
        if (contractions.containsKey(s)) {
            s = contractions.get(s);
            return (s); // RETURNS: the contraction split up
        }

        // Removes all 's from the end of the word
        while (s.length() >= 2) {
            if (s.substring(s.length() - 2, s.length()).equals("'s")) {
                s = s.substring(0, s.length() - 2);

                // If removing a 's leads to trailing apostrophes, remove them
                while (s.charAt(s.length() - 1) == '\'') {
                    s = s.substring(0, s.length() - 1);
                    if (s.length() == 0)
                        return s; // RETURNS: the word if its length becomes 0 (indicating that its empty)
                }

            } else { // If the length of the word is incompatible for containing a 's (less than 2),
                     // then stop looking for 's break;
            }
        }
        return s;
    }

    public Main() {
        frame = new JFrame("Word Frequency Assignment");
        frame.setPreferredSize(new Dimension(820, 570));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // for all panels
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Add file button, drop-down menu for recent files, exit button
        inputPanel = new JPanel();
        inputPanel.setBackground(NAVIGATOR_COLOR);
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
        // inputPanel.setPreferredSize(new Dimension(500, 20));

        // Add file button, drop-down menu for recent files
        input1Panel = new JPanel();
        input1Panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        input1Panel.setBackground(NAVIGATOR_COLOR);

        addFile = new JButton("Add File");
        addFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = JOptionPane.showInputDialog(frame, "Enter the file name (Exclude .txt):", null);

                try {
                    BufferedReader inFile = new BufferedReader(new FileReader(fileName.strip() + ".txt"));

                    // add to array
                    files = addFile(fileName.strip());

                    DefaultComboBoxModel<String> recentFilesModel = new DefaultComboBoxModel<>(files);
                    recentFiles.setModel(recentFilesModel);

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

                // stats panel
                Map<Word, Integer> words = new HashMap<>(); // uses .hashcode() and .equals()
                ArrayList<Word> sortedWords;

                try {
                    Long startTime = System.currentTimeMillis();
                    BufferedReader inFile = new BufferedReader(new FileReader(recentFiles.getSelectedItem() + ".txt"));

                    viewFile.setText("");
                    viewFile.read(inFile, null);

                    // redraw file panel to update the file content
                    filePanel.repaint();

                    inFile = new BufferedReader(new FileReader(recentFiles.getSelectedItem() + ".txt"));

                    String s;
                    String w;
                    Word word;
                    StringTokenizer st;
                    StringTokenizer wordSt;
                    int freq;

                    while ((s = inFile.readLine()) != null) {
                        st = new StringTokenizer(s, " !@#$%^&*()_-+=[]{}\\|\";:,./<>?~`");

                        while (st.hasMoreTokens()) {
                            w = correct(st.nextToken().toLowerCase());
                            wordSt = new StringTokenizer(w);

                            while (wordSt.hasMoreTokens()) {
                                w = wordSt.nextToken();

                                if (words.containsKey(new Word(w))) {
                                    freq = words.get(new Word(w));

                                    word = new Word(w, freq);
                                    word.addFreq();

                                    words.remove(new Word(w));
                                } else
                                    word = new Word(w, 1);
                                words.put(word, word.getFrequency());
                            }
                        }
                    }

                    sortedWords = new ArrayList<>(words.keySet());
                    Collections.sort(sortedWords); // sorts by comparable (.compareTo)

                    System.out.println(System.currentTimeMillis() - startTime + "ms");
                    String statsInfo = "Total Time: " + (System.currentTimeMillis() - startTime)
                            + " milliseconds\n\n20 Most Frequent Words\n\n";
                    statsInfo += String.format("%-10s%-25s%-10s\n\n", "", "Words", "Frequency");

                    if (sortedWords.size() > 0) {
                        for (int i = 0; i < 20; i++) {
                            statsInfo += String.format("%-10s%-25s%-10d\n",
                                    i + 1 + ")", sortedWords.get(i),
                                    sortedWords.get(i).getFrequency());
                            if (i + 1 == sortedWords.size())
                                i = 20;
                        }
                    }

                    System.out.println(statsInfo);
                    stats.setText(statsInfo);
                    statsPanel.repaint();

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
        input2Panel.setBackground(NAVIGATOR_COLOR);

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
        viewPanel.setBackground(BODY_COLOR);

        filePanel = new JPanel();
        fileScroller = new JScrollPane(filePanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        filePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        filePanel.setBackground(BODY_COLOR);
        viewFile = new JTextArea("");
        viewFile.setBackground(BODY_COLOR);
        viewFile.setEditable(false);
        filePanel.add(viewFile);

        statsPanel = new JPanel();
        statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.PAGE_AXIS));
        statsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        statsPanel.setBackground(BODY_COLOR);
        statsScroller = new JScrollPane(statsPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
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
    }

    // DESCRIPTION: The main method operates the overall program by calling and
    // initializing the graphics
    public static void main(String[] args) { // PARAMETERS: args not used
        new Main();

        // RETURNS: none (void method)
    }
}
