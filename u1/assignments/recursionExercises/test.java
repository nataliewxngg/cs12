package recursionExercises;

public class test {
    // Program 5: insert()
    public static String insert(String s, char c) {
        // between every 2 characters that are the same
        // checking to the LEFT
        // change to checking to the RIGHT
        if (s.length() == 1)
            return s;

        // remove all the non-letter characters from the string first?

        char currentChar = s.charAt(s.length() - 1);

        if (!((currentChar >= 'a' && currentChar <= 'z') || (currentChar >= 'A' && currentChar <= 'Z'))) {
            return insert(s.substring(0, s.length() - 1), c);
        }

        String previousChar = s.charAt(s.length() - 2) + "";

        if ((currentChar + "").equalsIgnoreCase(previousChar)) {
            return insert(s.substring(0, s.length() - 1), c) + c + currentChar;
        }
        return insert(s.substring(0, s.length() - 1), c) + currentChar;
    }
}
