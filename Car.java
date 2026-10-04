package Week9;
public class Car {
    private String brand;
    private String model;
    private double price;

    public Car(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car[Brand=" + brand + ", Model=" + model + ", Price=" + price + "]";
    }

    public static void main(String[] args) {
        Car c1 = new Car("Toyota", "Camry", 30000);
        System.out.println(c1);
        System.out.println(c1.getClass().getName());
    }
}

