// Student class
class Student {
    int rollNo;
    String name;
    double marks;

    // Constructor
    Student(int rollNo, String name, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    // Method to display student details
    void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("---------------------------");
    }
}

// Main class
public class StudentTest {
    public static void main(String[] args) {
        // Creating two student objects
        Student student1 = new Student(101, "Rithish", 92.5);
        Student student2 = new Student(102, "Santhosh", 88.0);

        // Displaying student details
        System.out.println("Student 1 Details:");
        student1.display();

        System.out.println("Student 2 Details:");
        student2.display();
    }
}

