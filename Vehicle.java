package week3;
public class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    protected double fuelLevel;

    public Vehicle(String make, String model, int year, double fuelLevel) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelLevel = fuelLevel;
    }

    public void startVehicle() {
        System.out.println(make + " " + model + " started.");
    }

    public void stopVehicle() {
        System.out.println(make + " " + model + " stopped.");
    }

    public void refuel(double amount) {
        fuelLevel += amount;
        System.out.println(make + " " + model + " refueled. Current fuel: " + fuelLevel);
    }

    public void displayVehicleInfo() {
        System.out.println("Make: " + make + ", Model: " + model + ", Year: " + year + ", Fuel Level: " + fuelLevel);
    }

    public static void main(String[] args) {
        Vehicle car = new Cars("Toyota", "Camry", 2022, 40, 4);
        Vehicle truck = new Truck("Ford", "F-150", 2020, 60, 1000);
        Vehicle bike = new Motorcycle("Yamaha", "R15", 2021, 15, true);

        Vehicle[] vehicles = {car, truck, bike};

        for (Vehicle v : vehicles) {
            v.startVehicle();
            v.displayVehicleInfo();
            v.refuel(10);
            v.stopVehicle();
            System.out.println();
        }
    }
}

class Cars extends Vehicle {
    private int doors;

    public Cars(String make, String model, int year, double fuelLevel, int doors) {
        super(make, model, year, fuelLevel);
        this.doors = doors;
    }

    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo();
        System.out.println("Doors: " + doors);
    }
}

class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String make, String model, int year, double fuelLevel, double loadCapacity) {
        super(make, model, year, fuelLevel);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo();
        System.out.println("Load Capacity: " + loadCapacity + " kg");
    }
}

class Motorcycle extends Vehicle {
    private boolean hasGear;

    public Motorcycle(String make, String model, int year, double fuelLevel, boolean hasGear) {
        super(make, model, year, fuelLevel);
        this.hasGear = hasGear;
    }

    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo();
        System.out.println("Has Gear: " + (hasGear ? "Yes" : "No"));
    }
}
