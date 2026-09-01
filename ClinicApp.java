package week3;
import java.util.*;

class Client {
    String id;
    String name;
    int age;
    String gender;
    String contact;
    List<String> history = new ArrayList<>();
    List<String> treatments = new ArrayList<>();

    public Client(String id, String name, int age, String gender, String contact) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
    }

    public void addTreatment(String treatment) {
        treatments.add(treatment);
        System.out.println("Treatment added for " + name + ": " + treatment);
    }

    public void release() {
        treatments.clear();
        System.out.println("Client " + name + " has been discharged.");
    }
}

class Medic {
    String id;
    String name;
    String field;
    List<String> slots = new ArrayList<>();
    int handled = 0;
    double fee;

    public Medic(String id, String name, String field, double fee) {
        this.id = id;
        this.name = name;
        this.field = field;
        this.fee = fee;
    }
}

class Visit {
    String id;
    Client client;
    Medic medic;
    String date;
    String time;
    String status;
    String type;

    public Visit(String id, Client client, Medic medic, String date, String time, String type) {
        this.id = id;
        this.client = client;
        this.medic = medic;
        this.date = date;
        this.time = time;
        this.type = type;
        this.status = "Scheduled";
    }
}

class Clinic {
    static int clientCount = 0;
    static int visitCount = 0;
    static String clinicName = "CityCare Clinic";
    static double revenue = 0.0;

    List<Client> clients = new ArrayList<>();
    List<Medic> medics = new ArrayList<>();
    List<Visit> visits = new ArrayList<>();

    static Map<String, Double> rates = new HashMap<>();
    static {
        rates.put("Consultation", 500.0);
        rates.put("Follow-up", 300.0);
        rates.put("Emergency", 1000.0);
    }

    public void addClient(Client c) {
        clients.add(c);
        clientCount++;
    }

    public void addMedic(Medic m) {
        medics.add(m);
    }

    public Visit bookVisit(String id, Client c, Medic m, String date, String time, String type) {
        Visit v = new Visit(id, c, m, date, time, type);
        visits.add(v);
        visitCount++;
        m.handled++;
        System.out.println("Visit booked for " + c.name + " with " + m.name);
        return v;
    }

    public void cancelVisit(Visit v) {
        v.status = "Cancelled";
        System.out.println("Visit " + v.id + " cancelled.");
    }

    public double bill(Visit v) {
        double amt = rates.getOrDefault(v.type, 500.0) + v.medic.fee;
        revenue += amt;
        System.out.println("Bill for visit " + v.id + ": Rs." + amt);
        return amt;
    }

    public static void report() {
        System.out.println("\n--- " + clinicName + " Report ---");
        System.out.println("Total Clients: " + clientCount);
        System.out.println("Total Visits: " + visitCount);
        System.out.println("Revenue: Rs." + revenue);
    }

    public void medicStats() {
        System.out.println("\n--- Medic Utilization ---");
        for (Medic m : medics) {
            System.out.println(m.name + " (" + m.field + ") handled " + m.handled + " clients.");
        }
    }

    public void clientStats() {
        System.out.println("\n--- Client Statistics ---");
        for (Client c : clients) {
            System.out.println("Client: " + c.name + ", Treatments: " + c.treatments);
        }
    }
}

public class ClinicApp {
    public static void main(String[] args) {
        Clinic cl = new Clinic();

        Medic m1 = new Medic("M1", "Dr. Sharma", "Cardiologist", 700);
        Medic m2 = new Medic("M2", "Dr. Mehta", "Dermatologist", 500);
        cl.addMedic(m1);
        cl.addMedic(m2);

        Client c1 = new Client("C1", "Amit Kumar", 35, "Male", "9876543210");
        Client c2 = new Client("C2", "Neha Singh", 28, "Female", "9123456780");
        cl.addClient(c1);
        cl.addClient(c2);

        Visit v1 = cl.bookVisit("V1", c1, m1, "2025-09-05", "10:00 AM", "Consultation");
        Visit v2 = cl.bookVisit("V2", c2, m2, "2025-09-05", "11:00 AM", "Emergency");

        c1.addTreatment("Blood Pressure Checkup");
        c2.addTreatment("Skin Allergy Treatment");

        cl.bill(v1);
        cl.bill(v2);

        cl.cancelVisit(v1);

        Clinic.report();
        cl.medicStats();
        cl.clientStats();
    }
}

