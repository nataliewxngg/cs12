package u3;

import java.util.*;

public class study {
    public static void main(String[] args) {
        // 1120 Dynamic Data Structures, ArrayLists

        // ListIterator
        ArrayList<String> names = new ArrayList<>();
        names.add("rilakkuma");
        names.add("stitch");
        names.add("totoro");

        ListIterator<String> iter = names.listIterator();
        System.out.println(iter.next()); // rilakkuma
        iter.set("i love poop");
        System.out.println(iter.next()); // stitch
        iter.add("ayoooo");
        System.out.println(iter.nextIndex()); // 3
        System.out.println(iter.next()); // totoro

        System.out.println(names);

        // subList
        names = new ArrayList<>(Arrays.asList("rilakkuma", "stitch", "totoro"));
        List<String> fav = names.subList(1, 2);

        fav.add(0, "hellooo");
        System.out.println(fav); // {hellooo, stitch}
        names.add("what");
        System.out.println(names); // {rilakkuma, stitch, totoro, stitch}
        // System.out.println(fav); // now invalid because names is different

        // ----------------------------------------------------------------------------------------

        // 1121 LinkedLists
        LinkedList<String> schools = new LinkedList<>();
        schools.add("mss");
        schools.add("ups");
        schools.add("uhs");
        schools.add("umps");
        schools.add("peths");
        System.out.println(schools);

        List<String> ew = schools.subList(3, 4);
        System.out.println(ew);

        ListIterator<String> iter1 = schools.listIterator();
        System.out.println(iter1.next()); // mss
        iter1.next();
        System.out.println(iter1.previous()); // ups

        // ----------------------------------------------------------------------------------------

        // 1122 LinkedList - Stacks and Queues

        // LinkedList can be made purely as a queue or dequeue
        Queue<String> q1 = new LinkedList<>();
        Deque<String> d1 = new LinkedList<>();

        // Queues
        LinkedList<String> l1 = new LinkedList<>(Arrays.asList("hi", "hello", "hey"));
        l1.addLast("bonjour");
        l1.addLast("salut");
        l1.removeFirst();
        System.out.println(l1.getFirst()); // hello

        // Stacks
        l1 = new LinkedList<>(Arrays.asList("hi", "hello", "hey"));

        // ----------------------------------------------------------------------------------------

        // 1123 Stack, Queue, Deque
        Stack<String> s1 = new Stack<>();
        s1.push("yo");
        s1.push("poo");
        s1.push("ooh");
        System.out.println(s1); // {yo, poo, ooh}
        s1.pop();
        System.out.println(s1); // {yo, poo}

        LinkedList<String> listL = new LinkedList<>();
        listL.addLast("hi");
        listL.addLast("hello");
        listL.addLast("hey");
        System.out.println((listL.getFirst())); // hi
        listL.removeFirst();
        System.out.println(listL); // {hello, hey}

        Queue<String> listQ = new LinkedList<>();
        listQ.add("hi");
        listQ.add("hello");
        listQ.add("hey");
        listQ.remove();
        System.out.println(listQ); // {hello, hey}
        System.out.println(listQ.element()); // hello
        listQ.remove();
        listQ.remove();
        System.out.println(listQ.peek()); // returns null

        Deque<String> listD = new LinkedList<>();
        listD.offerLast("hi");
        listD.offerFirst("hello");
        listD.addLast("hey");
        System.out.println(listD); // {hello, hi, hey}
        System.out.println(listD.peekLast()); // hey
        listD.removeLast();
        listD.removeLast();
        listD.removeFirst();
        listD.pollFirst(); // won't throw error even tho deque is empty!
        System.out.println(listD.peekLast()); // null

        // ----------------------------------------------------------------------------------------

        // 1123 TreeSet
        TreeSet<String> tree1 = new TreeSet<>();
        tree1.add("dad");
        tree1.add("mom");
        tree1.add("sis");
        tree1.add("bro");
        System.out.println(tree1); // {bro, dad, mom, sis}

        // ----------------------------------------------------------------------------------------

        // 1124 HashSet
        HashSet<String> hash1 = new HashSet<>();
        String s = "ur bro";
        hash1.add("ur dad");
        hash1.add("ur mom");
        hash1.add("ur sis");
        hash1.add("s");
        System.out.println("ur bro".hashCode());
        System.out.println(s.hashCode());

        // ----------------------------------------------------------------------------------------

        // 1128 Iterator, HashCode, and equals

        // ----------------------------------------------------------------------------------------

        ArrayList<String> names1 = new ArrayList<>();
        names1.add("rilakkuma");
        names1.add("stitch");
        names1.add("totoro");

        System.out.println(names); // {rilakkuma, hellooo, stitch, totoro, what}
        names1.addAll(2, names1);
        System.out.println(names1); // {rilakkuma, stitch, rilakkuma, hellooo, stitch, totoro, what, totoro}

        // ----------------------------------------------------------------------------------------

        names.removeAll(names);
        names.add("rilakkuma");
        names.add("stitch");
        names.add("totoro");

        List<String> sub = names.subList(1, 3);
        sub.set(1, "oiajweoifjaosdijf");

        System.out.println(names);
        System.out.println(sub);
    }
}
