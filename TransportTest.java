package Week8;

// Abstract class renamed to avoid conflict
abstract class TransportVehicle {
    protected int speed;
    protected String fuelType;

    public TransportVehicle(int speed, String fuelType) {
        this.speed = speed;
        this.fuelType = fuelType;
    }

    public abstract void startEngine();
}

// Interface Maintainable
interface Maintainable {
    void serviceInfo();
}

// Subclass renamed to Bus to avoid duplicate Car
class Bus extends TransportVehicle implements Maintainable {

    public Bus(int speed, String fuelType) {
        super(speed, fuelType);
    }

    @Override
    public void startEngine() {
        System.out.println("Bus engine started using " + fuelType + " at speed " + speed + " km/h");
    }

    @Override
    public void serviceInfo() {
        System.out.println("Service every 10000 km or annually, whichever comes first.");
    }
}

// Main class renamed to avoid duplicate VehicleTest
public class TransportTest {
    public static void main(String[] args) {
        Bus bus = new Bus(80, "Diesel");
        bus.startEngine();
        bus.serviceInfo();
    }
}



