abstract class Vehicle {
    String name;
    Vehicle(String name) { this.name = name; }
    abstract void operate();
}

class Bus extends Vehicle {
    int capacity;
    Bus(String name, int capacity) {
        super(name);
        this.capacity = capacity;
    }
    void operate() {
        System.out.println(name + " (Bus) follows fixed routes with capacity " + capacity + " passengers.");
    }
}

class Taxi extends Vehicle {
    double farePerKm;
    Taxi(String name, double farePerKm) {
        super(name);
        this.farePerKm = farePerKm;
    }
    void operate() {
        System.out.println(name + " (Taxi) provides door-to-door service, fare per km: " + farePerKm);
    }
}

class Train extends Vehicle {
    int cars;
    Train(String name, int cars) {
        super(name);
        this.cars = cars;
    }
    void operate() {
        System.out.println(name + " (Train) operates on schedule with " + cars + " cars.");
    }
}

class Bike extends Vehicle {
    Bike(String name) { super(name); }
    void operate() {
        System.out.println(name + " (Bike) available for short-distance eco-friendly trips.");
    }
}

public class TransportationFleetManagement {
    public static void main(String[] args) {
        Vehicle[] fleet = {
                new Bus("City Bus", 50),
                new Taxi("Yellow Cab", 25.0),
                new Train("Express Train", 10),
                new Bike("Eco Bike")
        };

        for (Vehicle v : fleet) {
            v.operate();
        }
    }
}

