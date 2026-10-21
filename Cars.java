// Car.java
class Car {  // Class to represent a car
    String brand;   // Attribute for car brand
    String model;   // Attribute for car model
    int year;       // Attribute for manufacturing year

    // Method to start the car
    void start() {
        System.out.println("Car is starting...");
    }
}

public class Cars {  // Main class to test Car
    public static void main(String[] args) {
        Car myCar = new Car();  // Create a Car object
        myCar.brand = "Toyota";
        myCar.model = "Camry";
        myCar.year = 2022;

        System.out.println("Brand: " + myCar.brand);
        System.out.println("Model: " + myCar.model);
        System.out.println("Year: " + myCar.year);

        myCar.start();  // Call start method
    }
}
