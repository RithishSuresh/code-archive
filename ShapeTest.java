package Week8;


abstract class AbstractShape {  // Renamed from Shape
    // Abstract methods
    public abstract double area();
    public abstract double perimeter();

    // Concrete method
    public void displayInfo() {
        System.out.println("Area: " + area());
        System.out.println("Perimeter: " + perimeter());
    }
}

// Circle class
class CircleShape extends AbstractShape {
    private double radius;

    public CircleShape(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

// Rectangle class
class RectangleShape extends AbstractShape {
    private double length, width;

    public RectangleShape(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}

// Main class
public class ShapeTest {
    public static void main(String[] args) {
        CircleShape circle = new CircleShape(5);
        System.out.println("Circle:");
        circle.displayInfo();

        System.out.println();

        RectangleShape rectangle = new RectangleShape(4, 6);
        System.out.println("Rectangle:");
        rectangle.displayInfo();
    }
}
