package APP.APP5;

// Inheritance Example: Vehicle Rental System
class Vehicle {
    int speed;
    int fuelCapacity;

    // Common method for all vehicles
    void start() {
        System.out.println("Vehicle is starting...");
    }
}

// Car inherits Vehicle and adds its own feature
class Car extends Vehicle {
    void airConditioning() {
        System.out.println("Car has Air Conditioning");
    }
}

// Bike inherits Vehicle and adds its own feature
class Bike extends Vehicle {
    void helmetStorage() {
        System.out.println("Bike has Helmet Storage");
    }
}

// Truck inherits Vehicle and adds its own feature
class Truck extends Vehicle {
    void loadCapacity() {
        System.out.println("Truck has Heavy Load Capacity");
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();              // Common method
        car.airConditioning();    // Car-specific feature

        Bike bike = new Bike();
        bike.start();
        bike.helmetStorage();

        Truck truck = new Truck();
        truck.start();
        truck.loadCapacity();
    }
}
