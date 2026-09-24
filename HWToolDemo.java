package Week6;
public class HWToolDemo {
    public static void main(String[] args) {
        Hammer hammer = new Hammer("Steel", "Claw Hammer", 500);

        System.out.println("Accessing fields in Hammer class:");

        // Accessing protected field from parent
        System.out.println("Type (protected): " + hammer.type);

        // Accessing public field from parent
        System.out.println("Weight (public): " + hammer.weight);

        // Accessing private field using getter
        System.out.println("Material (private, via getter): " + hammer.getMaterial());

        hammer.displayInfo();
    }
}

class Tool {
    private String material;    // Only accessible via getter/setter
    protected String type;      // Accessible in child class
    public int weight;          // Accessible anywhere

    public Tool(String material, String type, int weight) {
        this.material = material;
        this.type = type;
        this.weight = weight;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}

class Hammer extends Tool {
    public Hammer(String material, String type, int weight) {
        super(material, type, weight);
    }

    public void displayInfo() {
        System.out.println("\nInside Hammer class method:");
        // Private field: Cannot access directly
        // System.out.println(material); // ❌ Not accessible

        // Protected field: Accessible
        System.out.println("Type (protected): " + type);

        // Public field: Accessible
        System.out.println("Weight (public): " + weight);

        // Private field: Access via getter
        System.out.println("Material (private via getter): " + getMaterial());
    }
}

