package u3.assignment6;

import java.util.*;

public class Word implements Comparable<Word> {
    // Instance Variables + Data Encapsulation
    private String word;
    private int frequency;

    // DESCRPTION: The CONSTRUCTOR method - utilized to create new Word objects
    public Word(String word, int frequency) { // PARAMETERS: A word

        // Initializes the instance variables of the new Word object!
        this.word = word;
        this.frequency = frequency;

        // RETURNS: none (constructors do not return any value)
    }

    public Word(String word) {
        this.word = word;
    }

    // DESCRIPTION: Getter methods - allows the files utilizing Word objects
    // to access its private attributes
    // PARAMETERS: none
    // RETURNS: dependent on each attribute's data type
    public String getWord() {
        return this.word;
    }

    public int getFrequency() {
        return this.frequency;
    }

    // DESCRIPTION: Setter methods - allows the files utilizing Word objects
    // to access/edit its private attributes
    // PARAMETERS: none
    // RETURNS: none (void methods)
    public void addFreq() {
        this.frequency++;
    }

    // uncommented
    public String toString() {
        return this.word;
    }

    // FOR HASHMAP
    public int hashCode() {
        return word.hashCode();
    }

    public boolean equals(Object o) {
        Word w = (Word) o;
        return (this.word.equals(w.word));
    }

    // FOR TREEMAP
    public int compareTo(Word w) {
        if (w.frequency == this.frequency)
            return this.word.compareTo(w.word);
        return w.frequency - this.frequency;
    }
}
