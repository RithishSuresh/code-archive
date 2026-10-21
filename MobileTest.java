// Mobile class
class Mobile {
    String brand;
    String model;
    double price;

    // Constructor
    Mobile(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Method to display mobile details
    void showDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: ₹" + price);
        System.out.println("------------------------");
    }
}

// Main class
public class MobileTest {
    public static void main(String[] args) {
        // Creating three mobile objects with different values
        Mobile mobile1 = new Mobile("Samsung", "Galaxy S21", 69999.0);
        Mobile mobile2 = new Mobile("Apple", "iPhone 14", 79999.0);
        Mobile mobile3 = new Mobile("OnePlus", "Nord CE 3", 24999.0);

        // Displaying mobile details
        System.out.println("Mobile 1:");
        mobile1.showDetails();

        System.out.println("Mobile 2:");
        mobile2.showDetails();

        System.out.println("Mobile 3:");
        mobile3.showDetails();
    }
}

