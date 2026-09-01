package week3;
import java.util.*;

abstract class Staff {
    String staffId, staffName, dept, role, joinDate;
    double baseSalary;
    boolean[] attendance = new boolean[30];

    static int totalStaff = 0;
    static String orgName = "TechNova Ltd";
    static double totalExpense = 0;
    static int workingDays = 22;

    Staff(String id, String name, String dept, String role, double salary, String joinDate) {
        this.staffId = id;
        this.staffName = name;
        this.dept = dept;
        this.role = role;
        this.baseSalary = salary;
        this.joinDate = joinDate;
        totalStaff++;
    }

    void markAttendance(int day, boolean present) {
        if (day >= 1 && day <= 30) attendance[day - 1] = present;
    }

    int getPresentDays() {
        int c = 0;
        for (boolean p : attendance) if (p) c++;
        return c;
    }

    abstract double calculateSalary();

    double calculateBonus() {
        double rate = (double) getPresentDays() / workingDays;
        if (rate >= 0.9) return baseSalary * 0.1;
        else if (rate >= 0.75) return baseSalary * 0.05;
        else return 0;
    }

    void takeLeave(int day) {
        if (day >= 1 && day <= 30) {
            attendance[day - 1] = false;
            System.out.println(staffName + " has taken leave on day " + day);
        }
    }

    void showPaySlip() {
        double salary = calculateSalary();
        double bonus = calculateBonus();
        double total = salary + bonus;
        totalExpense += total;

        System.out.println("\n--- Pay Slip ---");
        System.out.println("Staff: " + staffName + " (" + role + ")");
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Attendance Days: " + getPresentDays());
        System.out.println("Bonus: " + bonus);
        System.out.println("Total Salary: " + total);
        System.out.println("-------------------");
    }
}

class FullTime extends Staff {
    FullTime(String id, String name, String dept, String role, double salary, String joinDate) {
        super(id, name, dept, role, salary, joinDate);
    }
    @Override double calculateSalary() { return baseSalary; }
}

class PartTime extends Staff {
    int hours;
    PartTime(String id, String name, String dept, String role, double rate, String joinDate) {
        super(id, name, dept, role, rate, joinDate);
    }
    void addHours(int h) { this.hours += h; }
    @Override double calculateSalary() { return baseSalary * hours; }
}

class Contract extends Staff {
    Contract(String id, String name, String dept, String role, double contractAmt, String joinDate) {
        super(id, name, dept, role, contractAmt, joinDate);
    }
    @Override double calculateSalary() { return baseSalary / 12; }
}

class Division {
    String divId, divName;
    Staff manager;
    ArrayList<Staff> team = new ArrayList<>();
    double budget;

    Division(String id, String name, Staff mgr, double budget) {
        this.divId = id;
        this.divName = name;
        this.manager = mgr;
        this.budget = budget;
    }

    void addStaff(Staff s) { team.add(s); }

    double getExpense() {
        double total = 0;
        for (Staff s : team) total += s.calculateSalary() + s.calculateBonus();
        return total;
    }
}

class OrgReports {
    static void payroll(ArrayList<Staff> staff) {
        double total = 0;
        for (Staff s : staff) total += s.calculateSalary() + s.calculateBonus();
        System.out.println("\nTotal Org Payroll: " + total);
    }

    static void divisionExpenses(ArrayList<Division> divs) {
        System.out.println("\n--- Division Expenses ---");
        for (Division d : divs) System.out.println(d.divName + ": " + d.getExpense());
    }

    static void attendance(ArrayList<Staff> staff) {
        System.out.println("\n--- Attendance Report ---");
        for (Staff s : staff) System.out.println(s.staffName + " (" + s.dept + "): " + s.getPresentDays() + " days present");
    }
}

public class PayrollApp {
    public static void main(String[] args) {
        ArrayList<Staff> staff = new ArrayList<>();

        FullTime s1 = new FullTime("S101", "Alice", "IT", "Developer", 50000, "2022-05-01");
        PartTime s2 = new PartTime("S102", "Bob", "HR", "Assistant", 500, "2023-01-15");
        Contract s3 = new Contract("S103", "Charlie", "Finance", "Consultant", 1200000, "2021-03-10");

        staff.add(s1);
        staff.add(s2);
        staff.add(s3);

        Division d1 = new Division("D01", "IT", s1, 2000000); d1.addStaff(s1);
        Division d2 = new Division("D02", "HR", s2, 1000000); d2.addStaff(s2);
        Division d3 = new Division("D03", "Finance", s3, 1500000); d3.addStaff(s3);

        ArrayList<Division> divs = new ArrayList<>();
        divs.add(d1); divs.add(d2); divs.add(d3);

        for (int i = 1; i <= 20; i++) s1.markAttendance(i, true);
        for (int i = 1; i <= 15; i++) s2.markAttendance(i, true);
        for (int i = 1; i <= 18; i++) s3.markAttendance(i, true);

        s2.addHours(80);

        s1.showPaySlip();
        s2.showPaySlip();
        s3.showPaySlip();

        OrgReports.payroll(staff);
        OrgReports.divisionExpenses(divs);
        OrgReports.attendance(staff);
    }
}

