package u1;

public class L4_StringBuilderExercises {
    public static void main(String[] args) {
        String original = "software";
        StringBuilder result = new StringBuilder("hi");
        int index = original.indexOf('a');

        result.setCharAt(0, original.charAt(0));
        System.out.println(result);

        result.setCharAt(1, original.charAt(original.length() - 1));
        System.out.println(result);

        result.insert(1, original.charAt(4));
        System.out.println(result);

        result.append(original.substring(1, 4));
        System.out.println(result);

        result.insert(3, (original.substring(index, index + 2) + " "));
        System.out.println(result);
    }
}
