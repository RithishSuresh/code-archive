package week3;
import java.util.Scanner;
public class Car {
    String brand;
    String model;
    int year;
    String color;
    boolean isRunning;
    public Car(String brand, String model, int year, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.isRunning = false;
    }
    public void startEngine() {
        isRunning = true;
        System.out.println(brand + " " + model + " engine started.");
    }
    public void stopEngine() {
        isRunning = false;
        System.out.println(brand + " " + model + " engine stopped.");
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("Is Running: " + isRunning);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter details for Car 1:");
        System.out.print("Brand: ");
        String brand1 = sc.nextLine();
        System.out.print("Model: ");
        String model1 = sc.nextLine();
        System.out.print("Year: ");
        int year1 = sc.nextInt();
        sc.nextLine();
        System.out.print("Color: ");
        String color1 = sc.nextLine();
        Car car1 = new Car(brand1, model1, year1, color1);

        System.out.println("\nEnter details for Car 2:");
        System.out.print("Brand: ");
        String brand2 = sc.nextLine();
        System.out.print("Model: ");
        String model2 = sc.nextLine();
        System.out.print("Year: ");
        int year2 = sc.nextInt();
        sc.nextLine();
        System.out.print("Color: ");
        String color2 = sc.nextLine();
        Car car2 = new Car(brand2, model2, year2, color2);

        System.out.println("\nEnter details for Car 3:");
        System.out.print("Brand: ");
        String brand3 = sc.nextLine();
        System.out.print("Model: ");
        String model3 = sc.nextLine();
        System.out.print("Year: ");
        int year3 = sc.nextInt();
        sc.nextLine();
        System.out.print("Color: ");
        String color3 = sc.nextLine();
        Car car3 = new Car(brand3, model3, year3, color3);
        System.out.println("\n Car 1 Info ");
        car1.startEngine();
        car1.displayInfo();
        car1.stopEngine();
        System.out.println("\n Car 2 Info ");
        car2.startEngine();
        car2.displayInfo();
        car2.stopEngine();
        System.out.println("\n Car 3 Info ");
        car3.startEngine();
        car3.displayInfo();
        car3.stopEngine();

        sc.close();
    }
}


