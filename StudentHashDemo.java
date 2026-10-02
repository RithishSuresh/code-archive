import java.util.HashSet;
import java.util.Objects;

public class StudentHashDemo {
    private int rollNo;
    private String name;

    public StudentHashDemo(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        StudentHashDemo student = (StudentHashDemo) obj;
        return rollNo == student.rollNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNo);
    }

    @Override
    public String toString() {
        return "Student[RollNo=" + rollNo + ", Name=" + name + "]";
    }

    public static void main(String[] args) {
        HashSet<StudentHashDemo> students = new HashSet<>();
        students.add(new StudentHashDemo(1, "Rithish"));
        students.add(new StudentHashDemo(2, "Santhosh"));
        students.add(new StudentHashDemo(1, "Rithish"));

        for (StudentHashDemo s : students) {
            System.out.println(s);
        }
    }
}
