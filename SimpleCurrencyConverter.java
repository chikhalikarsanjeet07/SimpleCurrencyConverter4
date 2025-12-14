import java.util.*;

public class SimpleCurrencyConverter{

    static String[] names = {"INR", "USD", "EUR", "GBP", "AED", "JPY", "AUD", "CAD"};
    static double[] rates = {1.0, 83.2, 90.1, 104.5, 22.6, 0.55, 54.3, 61.4};

    static int size = names.length;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            menu();
            System.out.print("Enter choice (Example: 1): ");
            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 5) {
                System.out.println("Exiting...");
                break;
            }

            switch (ch) {
                case 1: inrToCurrency(sc); break;
                case 2: currencyToInr(sc); break;
                case 3: currencyToCurrency(sc); break;
                case 4: showTable(); break;
                default: System.out.println("Invalid choice!");
            }

            System.out.println("----------------------------------------");
        }
    }

    static void menu() {
        System.out.println("\n==== CURRENCY CONVERTER ====");
        System.out.println("1. INR → Currency");
        System.out.println("2. Currency → INR");
        System.out.println("3. Currency → Currency");
        System.out.println("4. Show Rate Table");
        System.out.println("5. Exit");
        System.out.println("=============================");
    }

    static int find(String n) {
        for (int i = 0; i < size; i++) {
            if (names[i].equalsIgnoreCase(n))
                return i;
        }
        return -1;
    }

    static void inrToCurrency(Scanner sc) {
        System.out.print("Enter INR amount: ");
        double amt = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter target currency ");
        System.out.println("(Options: INR, USD, EUR, GBP, AED, JPY, AUD, CAD)");
        String name = sc.nextLine();

        int i = find(name);
        if (i == -1) {
            System.out.println("Currency not found!");
            return;
        }

        double result = amt / rates[i];
        System.out.println(amt + " INR = " + result + " " + names[i]);
    }

    static void currencyToInr(Scanner sc) {
        System.out.print("Enter currency ");
        System.out.println("(Options: INR, USD, EUR, GBP, AED, JPY, AUD, CAD)");
        String name = sc.nextLine();

        System.out.print("Enter amount: ");
        double amt = sc.nextDouble();
        sc.nextLine();

        int i = find(name);
        if (i == -1) {
            System.out.println("Currency not found!");
            return;
        }

        double result = amt * rates[i];
        System.out.println(amt + " " + names[i] + " = " + result + " INR");
    }

    static void currencyToCurrency(Scanner sc) {
        System.out.print("From currency ");
        System.out.println("(Options: INR, USD, EUR, GBP, AED, JPY, AUD, CAD)");
        String from = sc.nextLine();

        System.out.print("To currency ");
        System.out.println("(Options: INR, USD, EUR, GBP, AED, JPY, AUD, CAD)");
        String to = sc.nextLine();

        System.out.print("Enter amount: ");
        double amt = sc.nextDouble();
        sc.nextLine();

        int i1 = find(from);
        int i2 = find(to);

        if (i1 == -1 || i2 == -1) {
            System.out.println("Currency not found!");
            return;
        }

        double inr = amt * rates[i1];
        double result = inr / rates[i2];

        System.out.println(amt + " " + from + " = " + result + " " + to);
    }

    static void showTable() {
        System.out.println("\n--- RATE TABLE (1 UNIT = INR) ---");
        for (int i = 0; i < size; i++) {
            System.out.println(names[i] + " = " + rates[i]);
        }
    }
}
