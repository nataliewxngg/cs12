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

    public static String correct(String s) {
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

        // starting or ending with an apostrophe
        while (s.charAt(0) == '\'') {
            s = s.substring(1);
            if (s.length() == 0)
                return s;
        }
        while (s.charAt(s.length() - 1) == '\'') {
            s = s.substring(0, s.length() - 1);
            if (s.length() == 0)
                return s;
        }

        // contractions
        if (contractions.containsKey(s)) {
            s = contractions.get(s);
            return (s);
        }

        // 's
        while (s.length() >= 2) {
            if (s.substring(s.length() - 2, s.length()).equals("'s")) {
                s = s.substring(0, s.length() - 2);

                while (s.charAt(s.length() - 1) == '\'') {
                    s = s.substring(0, s.length() - 1);
                    if (s.length() == 0)
                        return s;
                }

            } else {
                break;
            }
        }
        return s;
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

                // stats panel
                Map<Word, Integer> words = new HashMap<>(); // uses .equals()
                Map<Word, Integer> sortedWords = new TreeMap<>(); // uses .compareTo()

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
                    StringTokenizer st1;
                    int freq;

                    while ((s = inFile.readLine()) != null) {
                        st = new StringTokenizer(s, " !@#$%^&*()_-+=[]{}\\|\";:,./<>?~`0123456789");

                        while (st.hasMoreTokens()) {
                            w = correct(st.nextToken().toLowerCase());
                            st1 = new StringTokenizer(w);

                            while (st1.hasMoreTokens()) {
                                w = st1.nextToken();
                                // System.out.println(w + ".");

                                if (words.containsKey(new Word(w))) {
                                    // System.out.println(true);
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

                    sortedWords = new TreeMap<>(words);
                    System.out.println(System.currentTimeMillis() - startTime + "ms");

                    Set<Word> setOfSortedWords = sortedWords.keySet();
                    Iterator<Word> iter = setOfSortedWords.iterator();

                    String statsInfo = "Total Time: " + (System.currentTimeMillis() - startTime)
                            + "milliseconds\n\n20 Most Frequent Words\n\n";
                    statsInfo += String.format("%5s%10s\n", "Words", "Frequency");

                    for (int i = 0; i < 20; i++) {
                        if (iter.hasNext()) {
                            Word iterWord = iter.next();
                            statsInfo += String.format("%d) %s - %d\n", i + 1, iterWord.getWord(),
                                    iterWord.getFrequency());
                        } else
                            i = 20;
                    }

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
        filePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        viewFile = new JTextArea("");
        viewFile.setEditable(false);
        filePanel.add(viewFile);

        statsPanel = new JPanel();
        statsScroller = new JScrollPane(statsPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
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
