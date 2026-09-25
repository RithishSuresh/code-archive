package Week6;
public class LabPhoneDemo {
    public static void main(String[] args) {
        System.out.println("Creating SmartPhone with brand and model:");
        SmartPhone sp1 = new SmartPhone("Samsung", "Galaxy S21");
        sp1.display();

        System.out.println("\nCreating SmartPhone with brand, model, and OS:");
        SmartPhone sp2 = new SmartPhone("Apple", "iPhone 13", "iOS 17");
        sp2.display();
    }
}

class Phone {
    protected String brand;
    protected String model;

    public Phone() {
        System.out.println("Phone default constructor called");
    }

    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
        System.out.println("Phone parameterized constructor called");
    }
}

class SmartPhone extends Phone {
    private String operatingSystem;

    public SmartPhone(String brand, String model) {
        super(brand, model);
        this.operatingSystem = "Unknown OS";
        System.out.println("SmartPhone constructor with brand and model called");
    }

    public SmartPhone(String brand, String model, String operatingSystem) {
        super(brand, model);
        this.operatingSystem = operatingSystem;
        System.out.println("SmartPhone constructor with OS called");
    }

    public void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Operating System: " + operatingSystem);
    }
}

