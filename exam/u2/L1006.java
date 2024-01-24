package exam.u2;

import java.util.*;

public class L1006 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(2);

        list.remove(0);

        System.out.println(list.get(0)); // 2
    }
}
