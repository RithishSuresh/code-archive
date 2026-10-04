package Week9;
import java.util.HashSet;
import java.util.Objects;

public class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student[ID=" + id + ", Name=" + name + "]";
    }

    public static void main(String[] args) {
        HashSet<Student> set = new HashSet<>();
        set.add(new Student(101, "Ravi"));
        set.add(new Student(102, "Anita"));
        set.add(new Student(101, "Ravi"));

        for (Student s : set) {
            System.out.println(s);
        }
    }
}

