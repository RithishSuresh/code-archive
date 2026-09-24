package Week6;
public class HWLightDemo {
    public static void main(String[] args) {
        System.out.println("Creating Light with default constructor:");
        Light light1 = new Light();
        System.out.println();

        System.out.println("Creating Light with parameterized constructor:");
        Light light2 = new Light("White", 60);
        System.out.println();

        System.out.println("Creating LED with default constructor:");
        LED led1 = new LED();
        System.out.println();

        System.out.println("Creating LED with brand only:");
        LED led2 = new LED("Philips");
        System.out.println();

        System.out.println("Creating LED with brand and wattage:");
        LED led3 = new LED("Samsung", 12);
    }
}

class Light {
    protected String color;
    protected int wattage;

    public Light() {
        this("Yellow", 40); // Calls parameterized constructor
        System.out.println("Light default constructor called");
    }

    public Light(String color) {
        this(color, 40); // Calls two-parameter constructor
        System.out.println("Light constructor with color called");
    }

    public Light(String color, int wattage) {
        this.color = color;
        this.wattage = wattage;
        System.out.println("Light parameterized constructor called: Color=" + color + ", Wattage=" + wattage);
    }
}

class LED extends Light {
    private String brand;

    public LED() {
        super(); // Calls Light default constructor
        this.brand = "Generic";
        System.out.println("LED default constructor called");
    }

    public LED(String brand) {
        this(); // Calls LED default constructor
        this.brand = brand;
        System.out.println("LED constructor with brand called: " + brand);
    }

    public LED(String brand, int wattage) {
        super("White", wattage); // Calls Light parameterized constructor
        this.brand = brand;
        System.out.println("LED constructor with brand and wattage called: " + brand + ", Wattage=" + wattage);
    }
}

