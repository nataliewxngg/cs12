package u0;

public class L4_printF {
    public static void main(String[] args) {
        String item = "Almonds";
        double pricePerKg = 12.34;
        double weight = 3.4566;
        double cost = weight * pricePerKg;
        System.out.printf("%-10s: %10f kg @ $%+10.1f per kg will cost $%8.2f%n",
                item, weight, pricePerKg, cost);

        String name = "Natalie";
        // System.out.printf("%0s", name);
        System.out.printf("%.1s", name);
        // System.out.printf("%+s", name);
        // System.out.printf("%,s", name);
    }
}
