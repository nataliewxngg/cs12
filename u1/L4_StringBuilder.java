package u1;

public class L4_StringBuilder {
    public static void main(String[] args) {
        // String:
        // - Not immutable
        // - NOT memory efficient when changed

        // StringBuilder: (AUTOMATICALLY CREATED WHEN STRING IS)
        // - Mutable
        // - Faster
        // - Non-threaded safe

        // StringBuffer
        // - Mutable
        // - Slower
        // - Thread Safe

        // Creating a StringBuilder
        StringBuilder sb = new StringBuilder(); // default capacity of 16
        StringBuilder sb1 = new StringBuilder(10); // capacity of 10
        StringBuilder sb2 = new StringBuilder("hello"); // capacity = 16 + "hello".length() = 16+5 = 21

        // If a StringBuilder exceeds maximum capcity:
        // A new StringBuilder with a capacity of
        // 2 * (old capacity + 1) will be created

        // Change capcity:
        // sb.ensureCapacity(int); <-- the minimum size of the new capacity is
        // 2 * (old capacity + 1)

        sb.ensureCapacity(21);
        // 2*(16+1) = 2*17 = 34
        // Because 21 < minimum new capacity, the new capacity will be forced to 34

        sb1.ensureCapacity(40);
        // 2*(10+1) = 2*11 = 22
        // New capacity of sb1 will now be 40

        // StringBuilder methods
        // .append(any type)
        sb.append("This will be added to the end of sb.");
        System.out.println(sb);

        // .insert(int index, any type)
        sb2.insert(2, "poo");
        System.out.println(sb2);

        // .setCharAt(int index, char ch)
        sb.setCharAt(14, 'i');
        System.out.println(sb);

        // .deleteCharAt(int index)
        sb2.deleteCharAt(0);
        System.out.println(sb2);

        // .delete(int start, int end)
        // deletes characters from start to end, where end is exclusive
        sb.delete(18, sb.length());
        System.out.println(sb);

        // Exercises
        StringBuilder strBuild = new StringBuilder(10);
        System.out.println("1: " + strBuild.length() + " " + strBuild.capacity());

        strBuild.append("Do you");
        System.out.println("2: " + strBuild.length() + " " + strBuild.capacity());

        strBuild.append(" get this?");
        System.out.println("3: " + strBuild.length() + " " + strBuild.capacity());
    }
}