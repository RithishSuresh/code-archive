package APP.APP5;
// Inheritance Example: Hospital System
class Patient {
    String name;
    int age;

    // Constructor for common details
    Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayDetails() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// InPatient inherits Patient and adds extra feature
class InPatient extends Patient {
    int roomNumber;

    InPatient(String name, int age, int roomNumber) {
        super(name, age);  // Call parent constructor
        this.roomNumber = roomNumber;
    }

    void displayInPatientDetails() {
        displayDetails();  // Reuse common method
        System.out.println("Room Number: " + roomNumber);
    }
}

// OutPatient inherits Patient but no extra features
class OutPatient extends Patient {
    OutPatient(String name, int age) {
        super(name, age);
    }
}

public class HospitalSystem {
    public static void main(String[] args) {
        InPatient ip = new InPatient("Sathish", 40, 202);
        ip.displayInPatientDetails();

        OutPatient op = new OutPatient("Arun", 25);
        op.displayDetails();
    }
}

