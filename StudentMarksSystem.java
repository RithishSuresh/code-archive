package APP.APP5;
// Encapsulation Example: Student Marks System
class Student {
    private int marks;   // marks are private (not directly accessible)

    // Getter method - students can only view marks
    public int getMarks() {
        return marks;
    }

    // Setter method - only teachers can update marks
    public void setMarks(int marks) {
        this.marks = marks;
    }
}

public class StudentMarksSystem {
    public static void main(String[] args) {
        Student s1 = new Student();

        // Teacher updates marks
        s1.setMarks(85);

        // Student views marks
        System.out.println("Student's Marks: " + s1.getMarks());
    }
}

