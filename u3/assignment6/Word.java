package u3.assignment6;

public class Word {
    // Instance Variables + Data Encapsulation
    private String word;
    private int frequency;

    // DESCRPTION: The CONSTRUCTOR method - utilized to create new Word objects
    public Word(String word) { // PARAMETERS: A word

        // Initializes the instance variables of the new Wordobject!
        this.word = word;
        this.frequency++;

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
}
