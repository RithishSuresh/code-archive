package week4;

class FoodOrder {
    private String customerName;
    private String foodItem;
    private int quantity;
    private double price;
    private static final double FIXED_RATE = 150.0;

    public FoodOrder() {
        this("Unknown", "Unknown", 0, 0.0);
    }

    public FoodOrder(String foodItem) {
        this("Unknown", foodItem, 1, FIXED_RATE);
    }

    public FoodOrder(String foodItem, int quantity) {
        this("Unknown", foodItem, quantity, quantity * FIXED_RATE);
    }

    public FoodOrder(String customerName, String foodItem, int quantity, double price) {
        this.customerName = customerName;
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.price = price;
    }

    public void printBill() {
        System.out.println("Customer: " + customerName +
                ", Food: " + foodItem +
                ", Quantity: " + quantity +
                ", Total Price: " + price);
    }
}

public class FoodDeliverySystem {
    public static void main(String[] args) {
        FoodOrder o1 = new FoodOrder();
        FoodOrder o2 = new FoodOrder("Burger");
        FoodOrder o3 = new FoodOrder("Pizza", 3);
        FoodOrder o4 = new FoodOrder("Alice", "Pasta", 2, 400.0);

        o1.printBill();
        o2.printBill();
        o3.printBill();
        o4.printBill();
    }
}
