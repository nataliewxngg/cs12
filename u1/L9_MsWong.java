package u1;

public class L9_MsWong {
    public static void main(String[] args) {
        MsWong wong1 = new MsWong("J", "CS", 25);
        MsWong wong2 = new MsWong("E");

        System.out.println(wong1.firstName);
        System.out.println(wong1.age);

        wong1.birthday();
        System.out.println(wong1.age);

    }
}
