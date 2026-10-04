package week9;

class Vehicle {
    private String registrationNo;
    private String type;
    private double ratePerDay;


    public Vehicle(String registrationNo, String type, double ratePerDay) {
        this.registrationNo = registrationNo;
        this.type = type;
        this.ratePerDay = ratePerDay;
    }


    public String getRegistrationNo() {
        return registrationNo;
    }

    public String getType() {
        return type;
    }

    public double getRatePerDay() {
        return ratePerDay;
    }


    @Override
    public String toString() {
        return "Vehicle: " + registrationNo +
                ", Type: " + type +
                ", Rate: $" + ratePerDay + "/day";
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Vehicle other = (Vehicle) obj;
        return registrationNo.equals(other.registrationNo);
    }


    @Override
    public int hashCode() {
        return registrationNo.hashCode();
    }
}

public class VehicleRental {
    public static void main(String[] args) {

        Vehicle v1 = new Vehicle("TN12AB1234", "Sedan", 1500);

        System.out.println(v1);

        Vehicle v2 = new Vehicle("TN12AB1234", "SUV", 2000);

        System.out.println(v2);

        if (v1.equals(v2)) {
            System.out.println("Both vehicles are the same (same registration number).");
        } else {
            System.out.println("Vehicles are different.");
        }
    }
}

