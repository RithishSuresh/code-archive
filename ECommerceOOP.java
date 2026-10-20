class Order {
    private double price;

    public Order(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

public class ECommerceOOP {
    public static void main(String[] args) {
        // Create an array of orders with their respective prices
        Order[] orders = {
                new Order(1299.99),
                new Order(1499.50),
                new Order(2000.00),
                new Order(843.80)
        };

        double total = 0;

        // Loop through each order and add its price to the total
        for (Order order : orders) {
            total += order.getPrice();
        }

        // Display the final total price of all orders
        System.out.println("Total price of today's orders: ₹" + total);
    }
}


