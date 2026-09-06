package week3;
class Employee {
    private String empId;
    private String empName;
    private String department;
    private double baseSalary;
    private String empType;

    private static int totalEmployees = 0;
    private static int empCounter = 0;

    public Employee(String empName, String department, double baseSalary, double bonus) {
        this.empId = generateEmpId();
        this.empName = empName;
        this.department = department;
        this.baseSalary = baseSalary + bonus;
        this.empType = "Full-time";
        totalEmployees++;
    }

    public Employee(String empName, String department, double hourlyRate, int hoursWorked) {
        this.empId = generateEmpId();
        this.empName = empName;
        this.department = department;
        this.baseSalary = hourlyRate * hoursWorked;
        this.empType = "Part-time";
        totalEmployees++;
    }

    public Employee(String empName, String department, double fixedAmount) {
        this.empId = generateEmpId();
        this.empName = empName;
        this.department = department;
        this.baseSalary = fixedAmount;
        this.empType = "Contract";
        totalEmployees++;
    }

    public double calculateSalary(double bonus) {
        if (empType.equals("Full-time")) {
            return baseSalary + bonus;
        }
        return baseSalary;
    }

    public double calculateSalary(int hoursWorked, double hourlyRate) {
        if (empType.equals("Part-time")) {
            return hoursWorked * hourlyRate;
        }
        return baseSalary;
    }

    public double calculateSalary() {
        return baseSalary;
    }

    public double calculateTax(double salary, double taxRate) {
        return salary * taxRate / 100;
    }

    public double calculateTax(double salary) {
        if (empType.equals("Full-time")) {
            return salary * 0.20;
        } else if (empType.equals("Part-time")) {
            return salary * 0.10;
        } else {
            return salary * 0.15;
        }
    }

    public void generatePaySlip() {
        double salary;
        if (empType.equals("Full-time")) {
            salary = calculateSalary(0);
        } else if (empType.equals("Part-time")) {
            salary = baseSalary;
        } else {
            salary = calculateSalary();
        }

        double tax = calculateTax(salary);
        double netPay = salary - tax;

        System.out.println("--------------- Pay Slip ---------------");
        System.out.println("Employee ID   : " + empId);
        System.out.println("Name          : " + empName);
        System.out.println("Department    : " + department);
        System.out.println("Type          : " + empType);
        System.out.println("Gross Salary  : " + salary);
        System.out.println("Tax Deducted  : " + tax);
        System.out.println("Net Pay       : " + netPay);
        System.out.println("----------------------------------------");
    }

    public void displayEmployeeInfo() {
        System.out.println(empId + " | " + empName + " | " + department + " | " + empType);
    }

    private static String generateEmpId() {
        empCounter++;
        return String.format("E%03d", empCounter);
    }

    public static int getTotalEmployees() {
        return totalEmployees;
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Employee e1 = new Employee("Alice", "HR", 40000, 5000);
        Employee e2 = new Employee("Bob", "IT", 200, 80);
        Employee e3 = new Employee("Charlie", "Finance", 60000);

        System.out.println("Employee List:");
        e1.displayEmployeeInfo();
        e2.displayEmployeeInfo();
        e3.displayEmployeeInfo();

        System.out.println("\nGenerating Pay Slips:\n");
        e1.generatePaySlip();
        e2.generatePaySlip();
        e3.generatePaySlip();

        System.out.println("Demonstrating Method Overloading:");
        System.out.println("Alice Salary (with extra bonus 2000): " + e1.calculateSalary(2000));
        System.out.println("Bob Salary (recalculated hourly): " + e2.calculateSalary(80, 200));
        System.out.println("Charlie Salary (contract): " + e3.calculateSalary());

        System.out.println("\nTotal Employees: " + Employee.getTotalEmployees());
    }
}

