import java.util.Scanner;

public class Question0104 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        final double PRICE_OF_BURGER = 5.69;
        final double PRICE_OF_FRIES = 3.49;
        final double PRICE_OF_DRINK = 1.99;
        final double PST = 0.08;
        final double GST = 0.05;

        System.out.print("How many burgers, fries, and drinks would you like to purchase?: ");

        double burger = reader.nextDouble();
        double fries = reader.nextDouble();
        double drink = reader.nextDouble();

        double subtotal = PRICE_OF_BURGER * burger + PRICE_OF_FRIES * fries + PRICE_OF_DRINK * drink ;
        double totalPST = subtotal * PST;
        double totalGST = subtotal * GST;
        double total = subtotal + totalGST + totalPST;

        System.out.println("Subtotal: " + subtotal + "\nPST: " + totalPST + "\nGST: " + totalGST + "\nTotal: " + total);
        System.out.print("Amount tendeered: ");

        double amountTendered = reader.nextDouble();

        System.out.println("Change due: " + (amountTendered - total));
    
        reader.close();
    }

}
