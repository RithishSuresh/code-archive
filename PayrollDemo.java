package Week8;

// Abstract class Employee
abstract class Employee {
    protected String name;
    protected double salary;

    // Constructor to initialize fields
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Abstract method for bonus calculation
    public abstract void calculateBonus();
}

// Interface Payable
interface Payable {
    void generatePaySlip();
}

// Manager class extends Employee and implements Payable
class Manager extends Employee implements Payable {
    private double bonus;

    public Manager(String name, double salary) {
        super(name, salary);
    }

    // Implement calculateBonus()
    @Override
    public void calculateBonus() {
        bonus = salary * 0.10; // 10% of salary as bonus
        System.out.println("Bonus for " + name + ": ₹" + bonus);
    }

    // Implement generatePaySlip()
    @Override
    public void generatePaySlip() {
        System.out.println("---- Pay Slip ----");
        System.out.println("Name: " + name);
        System.out.println("Salary: ₹" + salary);
        System.out.println("Bonus: ₹" + bonus);
        System.out.println("Total Pay: ₹" + (salary + bonus));
        System.out.println("-----------------");
    }
}

// Main class
public class PayrollDemo {
    public static void main(String[] args) {
        // Create Manager object
        Manager mgr = new Manager("Rithish", 80000);

        // Calculate bonus and generate pay slip
        mgr.calculateBonus();
        mgr.generatePaySlip();
    }
}

