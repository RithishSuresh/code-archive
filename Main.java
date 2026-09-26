package Week6;

public class Main {
    public static void main(String[] args) {
        System.out.println("Creating car with default constructor:");
        Car car1 = new Car();
        car1.displaySpecs();
        car1.start();
        System.out.println(car1.getVehicleInfo());
        car1.openTrunk();
        car1.playRadio();
        car1.stop();

        System.out.println("\n============================\n");

        System.out.println("Creating car with parameterized constructor:");
        Car car2 = new Car("Toyota", "Camry", 2023, "Hybrid", 4, "Hybrid", "Automatic");
        car2.displaySpecs();
        car2.start();
        System.out.println(car2.getVehicleInfo());
        car2.openTrunk();
        car2.playRadio();
        car2.stop();

        System.out.println("\n============================\n");

        System.out.println("Accessing protected fields from subclass:");
        System.out.println("Brand: " + car2.brand);
        System.out.println("Model: " + car2.model);

        System.out.println("\nDemonstrating overridden method calling super:");
        car2.start();

        System.out.println("\nPolymorphism demonstration:");
        Vehicle vehicle = new Car("Honda", "Civic", 2022, "Petrol", 4, "Petrol", "Manual");
        vehicle.displaySpecs();
        vehicle.start();
    }
}

class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected String engineType;
    private String registrationNumber;
    private boolean isRunning;

    public Vehicle() {
        this.brand = "DefaultBrand";
        this.model = "DefaultModel";
        this.year = 2020;
        this.engineType = "Petrol";
        this.registrationNumber = generateRandomRegistration();
        this.isRunning = false;
        System.out.println("Vehicle default constructor called");
    }

    public Vehicle(String brand, String model, int year, String engineType) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engineType = engineType;
        this.registrationNumber = generateRandomRegistration();
        this.isRunning = false;
        System.out.println("Vehicle parameterized constructor called");
    }

    private String generateRandomRegistration() {
        return "REG" + (int)(Math.random() * 10000);
    }

    public void start() {
        isRunning = true;
        System.out.println("Vehicle started");
    }

    public void stop() {
        isRunning = false;
        System.out.println("Vehicle stopped");
    }

    public String getVehicleInfo() {
        return "Brand: " + brand + ", Model: " + model + ", Year: " + year +
                ", Engine: " + engineType + ", Registration: " + registrationNumber +
                ", Running: " + isRunning;
    }

    public void displaySpecs() {
        System.out.println("Vehicle Specs -> Brand: " + brand + ", Model: " + model +
                ", Year: " + year + ", Engine Type: " + engineType);
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public boolean isRunning() {
        return isRunning;
    }
}

class Car extends Vehicle {
    private int numberOfDoors;
    private String fuelType;
    private String transmissionType;

    public Car() {
        super();
        this.numberOfDoors = 4;
        this.fuelType = "Petrol";
        this.transmissionType = "Automatic";
        System.out.println("Car default constructor called");
    }

    public Car(String brand, String model, int year, String engineType,
               int numberOfDoors, String fuelType, String transmissionType) {
        super(brand, model, year, engineType);
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        System.out.println("Car parameterized constructor called");
    }

    @Override
    public void start() {
        super.start();
        System.out.println("Car-specific startup sequence initiated");
    }

    @Override
    public void displaySpecs() {
        super.displaySpecs();
        System.out.println("Car Specs -> Doors: " + numberOfDoors +
                ", Fuel Type: " + fuelType +
                ", Transmission: " + transmissionType);
    }

    public void openTrunk() {
        System.out.println("Trunk opened");
    }

    public void playRadio() {
        System.out.println("Radio playing music");
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getTransmissionType() {
        return transmissionType;
    }
}

