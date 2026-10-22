class StudentRecord {
    String name;
    int[] marks;

    StudentRecord(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double getAverage() {
        int sum = 0;
        for (int m : marks) sum += m;
        return sum / marks.length;
    }
}

public class StudentMarksTracker {
    public static void main(String[] args) {
        // Create array of 3 StudentRecord objects with their marks
        StudentRecord[] students = {
                new StudentRecord("Santhosh", new int[]{85, 90, 88}),
                new StudentRecord("Lalith", new int[]{78, 82, 80}),
                new StudentRecord("Srijai", new int[]{92, 88, 95})
        };

        // Assume first student has the highest average initially
        StudentRecord topStudent = students[0];

        // Compare averages of all students to find the highest
        for (StudentRecord s : students) {
            if (s.getAverage() > topStudent.getAverage()) {
                topStudent = s;
            }
        }

        // Display the name and average marks of the top student
        System.out.println("Top Student: " + topStudent.name);
        System.out.println("Average Marks: " + topStudent.getAverage());
    }
}
