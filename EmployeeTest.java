// Non-public Employee class
class Employee {
    String name;
    int id;
    double salary;

    // Constructor
    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display details
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
        System.out.println("-------------------------");
    }
}

// Public main class
public class EmployeeTest {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Suresh", 100, 50000.0);
        Employee emp2 = new Employee("Atulya", 101, 40000.0);

        System.out.println("Employee 1 Details:");
        emp1.displayDetails();

        System.out.println("Employee 2 Details:");
        emp2.displayDetails();
    }
}

