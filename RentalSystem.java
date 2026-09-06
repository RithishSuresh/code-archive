package week3;
class RentalVehicle {
    private String vehicleId;
    private String brand;
    private String model;
    private double rentPerDay;
    private boolean isAvailable;
    private int totalRentalDays;

    private static int totalVehicles = 0;
    private static double totalRevenue = 0.0;
    private static String companyName = "Default Rentals";
    private static int rentalDays = 0;
    private static int vehicleCounter = 0;

    public RentalVehicle(String brand, String model, double rentPerDay) {
        this.vehicleId = generateVehicleId();
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.isAvailable = true;
        this.totalRentalDays = 0;
        totalVehicles++;
    }

    public double rentVehicle(int days) {
        if (!isAvailable) {
            System.out.println("Vehicle " + vehicleId + " is not available.");
            return 0.0;
        }
        double amount = calculateRent(days);
        isAvailable = false;
        totalRentalDays += days;
        System.out.println(vehicleId + " rented for " + days + " days. Rent: " + amount);
        return amount;
    }

    public void returnVehicle() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println(vehicleId + " returned and is now available.");
        } else {
            System.out.println(vehicleId + " was already available.");
        }
    }

    public double calculateRent(int days) {
        double amount = rentPerDay * days;
        totalRevenue += amount;
        rentalDays += days;
        return amount;
    }

    public void displayVehicleInfo() {
        System.out.println("--------------- Vehicle Info ---------------");
        System.out.println("Vehicle ID    : " + vehicleId);
        System.out.println("Brand         : " + brand);
        System.out.println("Model         : " + model);
        System.out.println("Rent Per Day  : " + rentPerDay);
        System.out.println("Available     : " + (isAvailable ? "Yes" : "No"));
        System.out.println("Rental Days   : " + totalRentalDays);
        System.out.println("--------------------------------------------");
    }

    private static String generateVehicleId() {
        vehicleCounter++;
        return String.format("V%03d", vehicleCounter);
    }

    public static void setCompanyName(String name) {
        companyName = name;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public static double getAverageRentPerDay() {
        if (rentalDays == 0) return 0.0;
        return totalRevenue / rentalDays;
    }

    public static void displayCompanyStats() {
        System.out.println("=============== Company Stats ===============");
        System.out.println("Company Name    : " + companyName);
        System.out.println("Total Vehicles  : " + totalVehicles);
        System.out.println("Total Revenue   : " + totalRevenue);
        System.out.println("Total Rental Days: " + rentalDays);
        System.out.println("Avg Rent/Day    : " + getAverageRentPerDay());
        System.out.println("=============================================");
    }
}

public class RentalSystem {
    public static void main(String[] args) {
        RentalVehicle.setCompanyName("ZoomCars Pvt Ltd");

        RentalVehicle v1 = new RentalVehicle("Toyota", "Corolla", 2000);
        RentalVehicle v2 = new RentalVehicle("Honda", "Civic", 2500);
        RentalVehicle v3 = new RentalVehicle("Suzuki", "Swift", 1500);

        v1.displayVehicleInfo();
        v2.displayVehicleInfo();
        v3.displayVehicleInfo();

        v1.rentVehicle(3);
        v2.rentVehicle(5);
        v1.rentVehicle(2);
        v1.returnVehicle();
        v1.rentVehicle(2);

        System.out.println("\nFinal Vehicle Info:");
        v1.displayVehicleInfo();
        v2.displayVehicleInfo();
        v3.displayVehicleInfo();

        RentalVehicle.displayCompanyStats();
    }
}


