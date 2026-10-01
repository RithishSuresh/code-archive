

// Abstract class Fruit
abstract class Fruit {
    protected String color;
    protected String taste;

    // Constructor to initialize color and taste
    public Fruit(String color, String taste) {
        this.color = color;
        this.taste = taste;
    }

    // Abstract method to show details
    public abstract void showDetails();
}

// Interface Edible
interface Edible {
    // Method declaration
    void nutrientsInfo();
}

// Class Apple extends Fruit and implements Edible
class Apple extends Fruit implements Edible {
    private String variety;

    // Constructor to initialize color, taste, and variety
    public Apple(String color, String taste, String variety) {
        super(color, taste);
        this.variety = variety;
    }

    // Implement abstract method from Fruit
    @Override
    public void showDetails() {
        System.out.println("Fruit: Apple");
        System.out.println("Color: " + color);
        System.out.println("Taste: " + taste);
        System.out.println("Variety: " + variety);
    }

    // Implement interface method from Edible
    @Override
    public void nutrientsInfo() {
        System.out.println("Nutrients: Rich in fiber, vitamin C, and antioxidants.");
    }
}

// Main class for testing
public class FruitTest {
    public static void main(String[] args) {
        // Create Apple object
        Apple apple = new Apple("Red", "Sweet", "Kashmiri");

        // Call methods
        apple.showDetails();
        apple.nutrientsInfo();
    }
}

