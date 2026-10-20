public class ECommerceProcedural {
    public static void main(String[] args) {
        // Array to store the prices of today's orders
        double[] orderPrices = {499.99, 299.50, 1000.00, 750.25};
        double total = 0;

        // Loop through the prices and calculate the total
        for (int i = 0; i < orderPrices.length; i++) {
            total += orderPrices[i];
        }

        // Display the total price
        System.out.println("Total price of today's order: ₹" + total);
    }
}

