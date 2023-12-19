package u3.assignment6;

import java.util.*;

public class Word implements Comparable<Word> {
    // Instance Variables + Data Encapsulation
    private String word;
    private int frequency;

    // DESCRIPTION: The CONSTRUCTOR method - utilized to create new Word objects and
    // initialize each's word and frequency attributes
    public Word(String word, int frequency) { // PARAMETERS:
                                              // 1. A word in String format
                                              // 2. The frequency of the word

        // Initializes the instance variables of the new Word object!
        this.word = word;
        this.frequency = frequency;

        // RETURNS: none (constructors do not return any value)
    }

    // DESCRIPTION: The CONSTRUCTOR method (overloaded) - utilized to create a new
    // Word object without frequency - primarily utilized to check for whether or
    // not a word already exists in the map
    public Word(String word) { // PARAMETERS: a word in String format

        this.word = word;
        // RETURNS: none (constructors do not return any value)
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

    // DESCRIPTION: .toString() is called whenever a Word object is to be
    // outputted
    // By default, it will ouput the address location of the Word object in the
    // computer.
    // However, by overriding (writing) the .toString() method like so ourselves,
    // it allows us to change what is to be displayed instead.

    // Likewise, this method will allow us to display the word of the Word object as
    // a String in proper format instead
    public String toString() { // PARAMETERS: none
        return this.word;
        // RETURNS: The word attribute of the Word object
    }

    // DESCRIPTION: determines the hashcode of a Word object - utilized to decide on
    // which bucket Word objects are added into
    // (Utilized for hashMap as keys are hashed)
    public int hashCode() { // PARAMETERS: none
        return word.hashCode();
        // RETURNS: the hashcode of the Word's word (will need reference to the Strings
        // class to determine the hashcode)
    }

    // DESCRIPTION: Defines "equivalent" objects - identifies duplicates in a
    // hashtable
    // (Utilized for hashMap as keys are hashed)
    public boolean equals(Object o) { // PARAMETERS: Object o to compare to
        Word w = (Word) o;
        return (this.word.equals(w.word)); // RETURNS: True if the two words being compared are identical
    }

    // DESCRIPTION:
    // Used to compare between the frequencies of two Word objects
    // However, if the frequencies aree equivalent, then the Word object's words are
    // compared lexicographically

    // It is moreover a method utilized for the Comparable Interface - NATURAL
    // SORTING ORDER
    // When called (Collections.sort(LIST)), it allows the comparable interface
    // to sort a list of Word objects in descending order of their frequencies.
    // However, if the frequencies of the Word objects are the same, this method
    // will sort the objects alphabetically instead.
    public int compareTo(Word w) { // PARAMETER: A Word object to compare to
        if (w.frequency == this.frequency)
            return this.word.compareTo(w.word); // RETURNS: If the frequencies of the two words being compared are
                                                // equivalent:
                                                // let the words of the Word objects be w1 and w2 where w1.compareTo(w2)
                                                // IF w1 < w2 --> RETURN A NEGATIVE #
                                                // IF w1 == w2 --> RETURN 0
                                                // IF w1 > w2 --> RETURN A POSITIVE #

        return w.frequency - this.frequency; // RETURNS: If the frequencies of the two words are different, return the
                                             // difference between the current and the compared-to object's frequency
    }
}
