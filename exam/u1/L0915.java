package exam.u1;

class L0915 {
    public static void main(String[] args) {

        // initialization of stringbuilders
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.capacity()); // default - 16

        sb = new StringBuilder(10);
        System.out.println(sb.capacity()); // 10

        sb = new StringBuilder("hello");
        System.out.println(sb.capacity()); // 16 + 5 = 21

        // changing capacities
        sb = new StringBuilder();
        sb.ensureCapacity(20);
        System.out.println(sb.capacity()); // 34

        // methods
        System.out.println(sb.append("hellobro")); // hellobro
        System.out.println(sb.insert(5, "yo")); // helloyobro
        sb.setCharAt(0, 'j'); // returns void
        System.out.println(sb.deleteCharAt(sb.length() - 2)); // jelloyobo
        System.out.println(sb.delete(0, 5)); // yobo

        // methods same as strings:
        System.out.println(sb.length()); // 4
        System.out.println(sb.charAt(2)); // o
        System.out.println(sb.substring(2)); // bo
        System.out.println(sb.indexOf("2")); // -1

        // methods it does not have -
        // - .equals()
        // - .compareTo()
        StringBuilder sb1 = new StringBuilder("hihi");
        StringBuilder sb2 = new StringBuilder("HIHI");

        System.out.println(sb1.toString().equalsIgnoreCase(sb2.toString())); // true
        // .toString() automatically called when sb printed

    }
}