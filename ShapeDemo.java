package Week8;

abstract class GeometricShape {
    // Abstract methods
    abstract double area();
    abstract double perimeter();

    // Concrete method
    void displayInfo() {
        System.out.println("This is a geometric shape.");
    }
}

// Circle subclass
class MyCircle extends GeometricShape {
    private double radius;

    MyCircle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    double perimeter() {
        return 2 * Math.PI * radius;
    }
}

// Rectangle subclass
class MyRectangle extends GeometricShape {
    private double length;
    private double width;

    MyRectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }

    @Override
    double perimeter() {
        return 2 * (length + width);
    }
}

// Main class
public class ShapeDemo {
    public static void main(String[] args) {
        // Test MyCircle
        MyCircle circle = new MyCircle(5);
        circle.displayInfo();
        System.out.println("Circle Area: " + circle.area());
        System.out.println("Circle Perimeter: " + circle.perimeter());

        System.out.println();

        // Test MyRectangle
        MyRectangle rectangle = new MyRectangle(4, 6);
        rectangle.displayInfo();
        System.out.println("Rectangle Area: " + rectangle.area());
        System.out.println("Rectangle Perimeter: " + rectangle.perimeter());
    }
}
