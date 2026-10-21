// Circle.java
public class Circle {  // Class to represent a circle
    double radius;     // Attribute to store radius

    // Method to calculate area of the circle
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {  // Main method to test the class
        Circle c1 = new Circle();
        c1.radius = 5.0;

        System.out.println("Radius: " + c1.radius);
        System.out.println("Area: " + c1.calculateArea());
    }
}

