package Week9;
import java.util.HashSet;

class EmployeeRecord {
    private String empCode;
    private String name;

    public EmployeeRecord(String empCode, String name) {
        this.empCode = empCode;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        EmployeeRecord other = (EmployeeRecord) obj;
        return empCode.equals(other.empCode);
    }

    @Override
    public int hashCode() {
        return empCode.hashCode();
    }

    @Override
    public String toString() {
        return "Employee Code: " + empCode + ", Name: " + name;
    }
}

public class EmployeeAuth {
    public static void main(String[] args) {
        EmployeeRecord e1 = new EmployeeRecord("BL001", "Ritika");
        EmployeeRecord e2 = new EmployeeRecord("BL001", "Ritika S.");

        System.out.println("Using == : " + (e1 == e2));
        System.out.println("Using equals(): " + e1.equals(e2));

        HashSet<EmployeeRecord> employees = new HashSet<>();
        employees.add(e1);
        employees.add(e2);

        System.out.println("HashSet: " + employees);
    }
}


