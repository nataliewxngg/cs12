package u1;

public class U1_Review {
    // Method heading - MODIFIER RETURN_TYPE METHOD_NAME(PARAMETERS)
    public static String methodName(String parameter) {
        return "";
    }

    public static void main(String[] args) {
        // 1. Basics from GR11 CS

        // Declaring variables
        // Primitive types
        int age = 9;
        double time = 8.23;
        char pee = 'p';
        boolean iwillget100tomorrow = true;

        // Non-primitive types
        String name = "Natalie";
        double[] birthdays = { 5.9, 1.11, 5.31, 3.4 };
        int[] numOfEars = new int[2];

        // Arithmetics
        System.out.println(age + time); // 9+8.23 = 17.23
        System.out.println(age - time); // 9-8.23 = 0.77
        System.out.println(birthdays[0] * birthdays[1]); // 5.9*1.11 = 6.549
        System.out.println(birthdays[2] / birthdays[3]); // 5.31/3.4 = 1.561764706
        System.out.println(age % time); // 9%8.23 = 0.77

        // BEDMAS
        System.out.println(5 + 2 * 6); // 5+12 = 17
        System.out.println(5 * 2 + 6 / 3); // 10 + 2 = 12

        // a++/a--: POSTFIX - will operate after utilization
        // ++a/--a: PREFIX - will operate beforehand

        // type conversions are only allowed when no data/info gets lost
        // eg
        double age1 = age; // 9.0
        System.out.println(age1);

        // double -> int will NOT be applicable (data from decimal places lost)
        // int time1 = time;
        // System.out.println(time1);

        // Rounding
        // DUMB ROUNDING: int/int, casting
        // SMART ROUNDING: Math.round(), printf()

        // Strings - objects (saves by address), immutable (CANNOT be changed)
        System.out.println(name.equals("natalie")); // Natalie!=natalie --> false
        System.out.println(name.equalsIgnoreCase("natalie")); // Natalie==natalie without considering capitalization -->
                                                              // true
        System.out.println(name.compareTo("noooo")); // -32
        System.out.println(name.compareTo("")); // name has 7 more characters --> 7

        System.out.println(name.length()); // 7
        System.out.println(name.charAt(1)); // a
        System.out.println(name.substring(1, name.length() - 1)); // atali

        System.out.println(name.toUpperCase()); // NATALIE
        System.out.println(name.toLowerCase()); // natalie

        System.out.println("       poo   poo    ".trim()); // poo^^^poo
        System.out.println(name.indexOf('t')); // 2
        System.out.println(name.indexOf('a', 3)); // 3
        System.out.println(name.indexOf("poo")); // -1
        System.out.println(name.indexOf("lie", 4)); // 4

        System.out.println(name.lastIndexOf("lie", 4)); // 4
        System.out.println(name.lastIndexOf('a')); // 3

        // Methods
        // MODIFIER RETURN_TYPE METHOD_NAME(PARAMETERS) { <-- Method heading
        // return; <-- NOT APPLICABLE for void methods
        // }

        // *** METHOD OVERLOADING - Creating a method with the same name or/and return
        // type, but with different parameters

        System.out.println(
                "------------------------------------------------------------------------------------------------");

        // 2. Input from keyboaard and file using Scanner/BufferedReader
        // Output using .println() or PrintWriter

    }
}
