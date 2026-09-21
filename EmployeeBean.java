import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.Objects;

public class EmployeeBean implements Serializable {
    private String employeeId;
    private String firstName;
    private String lastName;
    private double salary;
    private String department;
    private Date hireDate;
    private boolean isActive;

    // Default no-argument constructor
    public EmployeeBean() {
    }

    // Parameterized constructor
    public EmployeeBean(String employeeId, String firstName, String lastName, double salary,
                        String department, Date hireDate, boolean isActive) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary > 0 ? salary : 0;
        this.department = department;
        this.hireDate = hireDate;
        this.isActive = isActive;
    }

    // Standard Getters
    public String getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public boolean isActive() {
        return isActive;
    }

    // Standard Setters
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Salary must be positive.");
        }
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    // Computed Properties
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getYearsOfService() {
        if (hireDate == null) return 0;
        Calendar hireCal = Calendar.getInstance();
        hireCal.setTime(hireDate);
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.YEAR) - hireCal.get(Calendar.YEAR);
    }

    public String getFormattedSalary() {
        return NumberFormat.getCurrencyInstance().format(salary);
    }

    // Derived property
    public void setFullName(String fullName) {
        String[] parts = fullName.split(" ", 2);
        if (parts.length >= 2) {
            this.firstName = parts[0];
            this.lastName = parts[1];
        } else {
            this.firstName = fullName;
            this.lastName = "";
        }
    }

    @Override
    public String toString() {
        return "EmployeeBean{" +
                "employeeId='" + employeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + getFormattedSalary() +
                ", department='" + department + '\'' +
                ", hireDate=" + hireDate +
                ", isActive=" + isActive +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeBean)) return false;
        EmployeeBean that = (EmployeeBean) o;
        return Objects.equals(employeeId, that.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }

    // Main method to demonstrate usage
    public static void main(String[] args) {
        EmployeeBean emp1 = new EmployeeBean();
        emp1.setEmployeeId("E001");
        emp1.setFullName("John Doe");
        emp1.setSalary(50000);
        emp1.setDepartment("IT");
        emp1.setHireDate(new Date());
        emp1.setActive(true);

        EmployeeBean emp2 = new EmployeeBean("E002", "Jane", "Smith", 60000,
                "HR", new Date(), true);

        System.out.println(emp1.getFullName());
        System.out.println(emp2.getFormattedSalary());
        System.out.println(emp1.getYearsOfService());

        EmployeeBean[] employees = {emp1, emp2};
        for (EmployeeBean e : employees) {
            System.out.println(e);
        }
    }
}

class JavaBeanProcessor {
    public static void printAllProperties(EmployeeBean emp) {
        System.out.println("EmployeeId: " + emp.getEmployeeId());
        System.out.println("FullName: " + emp.getFullName());
        System.out.println("Salary: " + emp.getFormattedSalary());
        System.out.println("Department: " + emp.getDepartment());
        System.out.println("HireDate: " + emp.getHireDate());
        System.out.println("Active: " + emp.isActive());
    }

    public static void copyProperties(EmployeeBean source, EmployeeBean target) {
        target.setEmployeeId(source.getEmployeeId());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setSalary(source.getSalary());
        target.setDepartment(source.getDepartment());
        target.setHireDate(source.getHireDate());
        target.setActive(source.isActive());
    }
}
