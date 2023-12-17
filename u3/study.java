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
        System.out.println(iter.next()); // "rilakkuma"
        iter.set("i love poop"); // {"i love poop", "stitch", "totoro"}
        System.out.println(iter.previous()); // "i love poop"
        System.out.println(iter.next()); // "i love poop"
        iter.add("ayoooo"); // {"i love poop", "ayoooo", "stitch", "totoro"}
        System.out.println(iter.nextIndex()); // 2
        System.out.println(iter.next()); // "stitch"
        iter.remove(); // {"i love poop", "ayoooo", "totoro"}

        System.out.println(names);

        // subList
        names = new ArrayList<>(Arrays.asList("rilakkuma", "stitch", "totoro"));
        List<String> fav = names.subList(1, 2);

        fav.add(0, "hellooo");
        fav.add("poopoo");
        System.out.println(fav); // {hellooo, stitch, poopoo}
        names.add("what");
        System.out.println(names); // {rilakkuma, hellooo, stitch, poopoo, totoro, what}
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
        l1.addLast("bonjour");
        l1.addLast("salut");
        System.out.println(l1.getLast());
        l1.removeLast();
        System.out.println(l1); // {hi, hello, hey, bonjour}

        // ----------------------------------------------------------------------------------------

        // 1123 Stack, Queue, Deque
        Stack<String> s1 = new Stack<>();
        s1.push("yo");
        s1.push("poo");
        s1.push("ooh");
        System.out.println(s1); // {yo, poo, ooh}
        System.out.println(s1.peek()); // ooh
        s1.pop();
        System.out.println(s1); // {yo, poo}
        System.out.println(s1.empty()); // false
        System.out.println(s1.search("poo")); // 1
        System.out.println(s1.search("asldkjfaslkdjfasd")); // -1

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
        listQ.offer("hey");
        listQ.remove();
        System.out.println(listQ); // {hello, hey}
        System.out.println(listQ.element()); // hello
        listQ.remove();
        listQ.remove();
        System.out.println(listQ.size()); // 0
        System.out.println(listQ.peek()); // returns null

        Deque<String> listD = new LinkedList<>();
        listD.offerLast("hi");
        listD.offerFirst("hello");
        listD.addLast("hey");
        System.out.println(listD); // {hello, hi, hey}
        System.out.println(listD.getLast()); // hey
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

        // Iterator
        // - can be used on LISTS, SETS, MAPS
        // - can only traverse forwards
        // - cannot add elements
        // - cannot set/modify elements
        // - can remove elements
        // - cannot get index

        // TreeSet - uses the compareTo() to determine sorting order
        // HashSet - uses the equals() method to determine duplicates

        // Rules of the .hashCode method
        // 1. two "equal" objects (according to equals() method) MUST produce the SAME
        // hashcode
        // 2. two "unequal" objects can, but do not HAVE to, have different hashcodes
        // However, this should always be avoided to prevent collision

        // ----------------------------------------------------------------------------------------

        // 1205 Maps

        Map<String, String> aniMap = new HashMap<>();

        aniMap.put("dog", "mammal");
        System.out.println(aniMap.put("cat", "mammal")); // null
        System.out.println(aniMap.put("dog", "reptile")); // mammal - and replaces dog's value with reptile

        System.out.println(aniMap); // {cat=mammal, dog=reptile}

        System.out.println(aniMap.get("cat")); // mammal
        System.out.println(aniMap.containsKey("Dog")); // false
        System.out.println(aniMap.containsValue("reptile")); // true

        System.out.println(aniMap.remove("dog")); // reptile
        aniMap.put("lorraine", "skunk");
        System.out.println(aniMap.size()); // 2

        Set<String> keys = aniMap.keySet();
        System.out.println(keys); // {cat, lorraine}

        aniMap.put("natalie", "skunk");
        Collection<String> vals = aniMap.values();
        System.out.println(vals);

        // ----------------------------------------------------------------------------------------

        // 1206 Reverse Order

        ArrayList<Integer> ages = new ArrayList<>();
        ages.add(42);
        ages.add(84);
        ages.add(64);
        ages.add(25);
        ages.add(2);
        ages.add(17);
        ages.add(8);

        Collections.sort(ages);
        System.out.println(ages); // {2,8,17,25,42,64,84}
        Collections.sort(ages, Collections.reverseOrder());
        System.out.println(ages); // {84,64,42,25,17,8,2}

        Collections.sort(ages);
        System.out.println(Collections.binarySearch(ages, 42)); // 4

        Collections.sort(ages, Collections.reverseOrder());
        System.out.println(Collections.binarySearch(ages, 42, Collections.reverseOrder())); // 2

        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Lorraine", 18));
        people.add(new Person("Natalie", 17));
        people.add(new Person("Ryan", 12));
        people.add(new Person("Charlotte", 8));
        people.add(new Person("Granny", 64));

        Comparator reverse = Collections.reverseOrder(new SortByAge());

        Collections.sort(people, new SortByAge());
        System.out.println(people); // {8,12,17,18,64}
        Collections.sort(people, reverse);
        System.out.println(people); // {64,18,17,12,8}

        Collections.sort(people, new SortByAge());
        System.out.println(Collections.binarySearch(people, new Person("lkjasdlfkjasdlkfj", 12), new SortByAge())); // 1

        Collections.sort(people, reverse);
        System.out.println(Collections.binarySearch(people, new Person("ldskfjaksjdha", 12), reverse));// 3

        System.out.println("\n\n\n\n\n\n\n");

        // ----------------------------------------------------------------------------------------

        // 1206 PriorityQueue

        Queue<String> q = new PriorityQueue<>();
        q.add("C");
        q.add("A");
        q.add("D");
        q.add("B");
        System.out.println(q); // {A,B,D,C}
        while (!q.isEmpty()) {
            System.out.println(q.remove());
            System.out.println(q);

            // A
            // {B,D,C}
            // B
            // {C,D}
            // C
            // {D}
            // D
            // {}
        }

        q = new PriorityQueue<>(10, Collections.reverseOrder());
        q.add("C");
        q.add("A");
        q.add("D");
        q.add("B");
        System.out.println(q); // {D,B,C,A}
        while (!q.isEmpty()) {
            System.out.println(q.remove());
            System.out.println(q);

            // D
            // {C,B,A}
            // C
            // {B,A}
            // B
            // {A}
            // A
            // {}
        }

        // ----------------------------------------------------------------------------------------

        // 1208 Sorting - Stable vs. Unstable

        // ----------------------------------------------------------------------------------------

        // 1211 Heaps

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
