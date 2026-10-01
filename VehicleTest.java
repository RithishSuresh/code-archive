package Week8;


// Abstract class Vehicle
abstract class Vehicle {
    public abstract void start();  // Abstract method
    public void stop() {           // Concrete method
        System.out.println("Vehicle stopped.");
    }
}

// Interface Fuel
interface Fuel {
    void refuel();
}

// Renamed Car class to MyCar to avoid duplicate
class MyCar extends Vehicle implements Fuel {
    private String fuelType;

    public MyCar(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public void start() {
        System.out.println("MyCar started using " + fuelType + ".");
    }

    @Override
    public void refuel() {
        System.out.println("Refueling MyCar with " + fuelType + ".");
    }
}

// Main class
public class VehicleTest {
    public static void main(String[] args) {
        MyCar car = new MyCar("Petrol");

        // Call all methods
        car.start();
        car.stop();
        car.refuel();
    }
}

