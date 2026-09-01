package week3;
import java.util.*;

abstract class Transport {
    String id, brand, model, fuel, status;
    int year;
    double mileage;

    static int total = 0;
    static double value = 0;
    static String org = "TransLogistics Pvt Ltd";
    static double fuelUsed = 0;

    Operator driver;
    double maintenance = 0;

    public Transport(String id, String brand, String model, int year,
                     double mileage, String fuel, String status, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.fuel = fuel;
        this.status = status;
        total++;
        value += price;
    }

    public void assignOperator(Operator op) {
        this.driver = op;
        op.vehicle = this;
        System.out.println("Operator " + op.name + " assigned to " + this.id);
    }

    public void maintain(double cost) {
        this.maintenance += cost;
        System.out.println("Maintenance of " + id + " scheduled. Cost: " + cost);
    }

    public void run(double km, double fuel) {
        this.mileage += km;
        fuelUsed += fuel;
        if (driver != null) driver.trips++;
    }

    public boolean serviceDue() {
        return mileage % 10000 < 500;
    }

    public abstract double cost();
}

class Sedan extends Transport {
    boolean luxury;
    public Sedan(String id, String brand, String model, int year, double mileage,
                 String fuel, String status, double price, boolean luxury) {
        super(id, brand, model, year, mileage, fuel, status, price);
        this.luxury = luxury;
    }
    @Override
    public double cost() { return mileage * (luxury ? 12 : 8); }
}

class Coach extends Transport {
    int seats;
    public Coach(String id, String brand, String model, int year, double mileage,
                 String fuel, String status, double price, int seats) {
        super(id, brand, model, year, mileage, fuel, status, price);
        this.seats = seats;
    }
    @Override
    public double cost() { return mileage * 15 + (seats * 0.1); }
}

class Lorry extends Transport {
    double load;
    public Lorry(String id, String brand, String model, int year, double mileage,
                 String fuel, String status, double price, double load) {
        super(id, brand, model, year, mileage, fuel, status, price);
        this.load = load;
    }
    @Override
    public double cost() { return mileage * 20 + load * 0.5; }
}

class Operator {
    String id, name, license;
    Transport vehicle;
    int trips = 0;
    public Operator(String id, String name, String license) {
        this.id = id;
        this.name = name;
        this.license = license;
    }
}

class FleetOps {
    public static double utilization(Transport[] list) {
        int active = 0;
        for (Transport t : list) if (t.status.equalsIgnoreCase("Active")) active++;
        return (active * 100.0) / list.length;
    }
    public static double maintenance(Transport[] list) {
        double total = 0;
        for (Transport t : list) total += t.maintenance;
        return total;
    }
    public static void showType(Transport[] list, String type) {
        System.out.println("Listing " + type + "s:");
        for (Transport t : list) {
            if (type.equalsIgnoreCase("Sedan") && t instanceof Sedan) System.out.println(t.id + " - " + t.model);
            if (type.equalsIgnoreCase("Coach") && t instanceof Coach) System.out.println(t.id + " - " + t.model);
            if (type.equalsIgnoreCase("Lorry") && t instanceof Lorry) System.out.println(t.id + " - " + t.model);
        }
    }
}

public class FleetApp {
    public static void main(String[] args) {
        Transport[] list = new Transport[3];

        list[0] = new Sedan("C101", "Toyota", "Camry", 2020, 25000, "Petrol", "Active", 30000, true);
        list[1] = new Coach("B201", "Volvo", "9400", 2018, 120000, "Diesel", "Active", 90000, 50);
        list[2] = new Lorry("T301", "Tata", "LPT", 2019, 80000, "Diesel", "Inactive", 70000, 15);

        Operator o1 = new Operator("O01", "Ramesh", "LMV");
        Operator o2 = new Operator("O02", "Suresh", "HMV");

        list[0].assignOperator(o1);
        list[1].assignOperator(o2);

        list[0].run(500, 50);
        list[1].run(1200, 150);

        list[1].maintain(5000);

        System.out.println("\n--- Fleet Report ---");
        System.out.println("Total: " + Transport.total);
        System.out.println("Fleet Value: " + Transport.value);
        System.out.println("Fuel Used: " + Transport.fuelUsed);
        System.out.println("Utilization: " + FleetOps.utilization(list) + "%");
        System.out.println("Maintenance Cost: " + FleetOps.maintenance(list));

        FleetOps.showType(list, "Coach");
    }
}
