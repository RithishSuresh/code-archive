package Week6;
public class HWMathDemo {
    public static void main(String[] args) {
        BasicMath bm = new BasicMath();
        AdvancedMath am = new AdvancedMath();

        System.out.println("BasicMath Operations:");
        System.out.println("Sum (int, int): " + bm.calculate(5, 10));
        System.out.println("Sum (double, double): " + bm.calculate(3.5, 2.5));

        System.out.println("\nAdvancedMath Operations:");
        System.out.println("Sum (int, int): " + am.calculate(7, 8));           // inherited
        System.out.println("Sum (double, double): " + am.calculate(4.5, 5.5)); // inherited
        System.out.println("Sum (int, int, int): " + am.calculate(1, 2, 3));    // new
        System.out.println("Product (int, int): " + am.calculateProduct(2, 3)); // new
    }
}

class BasicMath {
    public int calculate(int a, int b) {
        return a + b;
    }

    public double calculate(double a, double b) {
        return a + b;
    }
}

class AdvancedMath extends BasicMath {
    // New overloaded calculate method
    public int calculate(int a, int b, int c) {
        return a + b + c;
    }

    // Additional method for demonstration
    public int calculateProduct(int a, int b) {
        return a * b;
    }

    // You can also overload with different types if needed
    public double calculate(double a, double b, double c) {
        return a + b + c;
    }
}

