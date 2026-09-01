package week3;
import java.util.*;

class Subject {
    String subjectCode;
    String subjectName;
    int credits;
    String instructor;

    public Subject(String subjectCode, String subjectName, int credits, String instructor) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.credits = credits;
        this.instructor = instructor;
    }
}

class Pupil {
    private String studentId;
    private String studentName;
    private String className;
    private String[] subjects;
    private double[][] marks;
    private double gpa;

    static int totalStudents = 0;
    static String schoolName = "Global International School";
    static String[] gradingScale = {"A", "B", "C", "D", "F"};
    static double passPercentage = 40.0;

    public Pupil(String studentId, String studentName, String className, String[] subjects, int exams) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.className = className;
        this.subjects = subjects;
        this.marks = new double[subjects.length][exams];
        totalStudents++;
    }

    public void addMarks(String subject, double mark, int examIndex) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i].equalsIgnoreCase(subject)) {
                marks[i][examIndex] = mark;
                return;
            }
        }
        System.out.println("Subject not found for pupil: " + studentName);
    }

    public void calculateGPA() {
        double total = 0;
        int count = 0;
        for (int i = 0; i < subjects.length; i++) {
            for (int j = 0; j < marks[i].length; j++) {
                total += marks[i][j];
                count++;
            }
        }
        double avg = total / count;
        gpa = avg / 20;
    }

    private String getGrade(double percentage) {
        if (percentage >= 90) return "A";
        else if (percentage >= 75) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 40) return "D";
        else return "F";
    }

    public void generateReportCard() {
        System.out.println("\n===== Report Card for " + studentName + " =====");
        double total = 0;
        for (int i = 0; i < subjects.length; i++) {
            double subjectTotal = 0;
            for (int j = 0; j < marks[i].length; j++) {
                subjectTotal += marks[i][j];
            }
            double avg = subjectTotal / marks[i].length;
            total += avg;
            System.out.println(subjects[i] + ": " + avg + "% → Grade: " + getGrade(avg));
        }
        double overall = total / subjects.length;
        System.out.println("Overall Percentage: " + overall + "%");
        System.out.println("GPA: " + String.format("%.2f", gpa));
        System.out.println("Promotion Eligibility: " + (checkPromotionEligibility() ? "YES" : "NO"));
    }

    public boolean checkPromotionEligibility() {
        double total = 0;
        int count = 0;
        for (int i = 0; i < subjects.length; i++) {
            for (int j = 0; j < marks[i].length; j++) {
                total += marks[i][j];
                count++;
            }
        }
        double percentage = total / count;
        return percentage >= passPercentage;
    }

    public static void setGradingScale(String[] scale) {
        gradingScale = scale;
    }

    public static double calculateClassAverage(Pupil[] pupils) {
        double total = 0;
        int count = 0;
        for (Pupil s : pupils) {
            for (int i = 0; i < s.subjects.length; i++) {
                for (int j = 0; j < s.marks[i].length; j++) {
                    total += s.marks[i][j];
                    count++;
                }
            }
        }
        return total / count;
    }

    public static Pupil[] getTopPerformers(Pupil[] pupils, int count) {
        Arrays.sort(pupils, (a, b) -> Double.compare(b.gpa, a.gpa));
        return Arrays.copyOfRange(pupils, 0, count);
    }

    public static void generateSchoolReport(Pupil[] pupils) {
        System.out.println("\n===== " + schoolName + " - School Report =====");
        System.out.println("Total Pupils: " + totalStudents);
        System.out.println("Average Percentage Across School: " + calculateClassAverage(pupils) + "%");

        Pupil[] top = getTopPerformers(pupils, 3);
        System.out.println("\nTop Performers:");
        for (Pupil s : top) {
            System.out.println(s.studentName + " | GPA: " + String.format("%.2f", s.gpa));
        }
    }
}

public class StudentGradeSystem {
    public static void main(String[] args) {
        String[] subjects = {"Math", "Science", "English"};

        Pupil s1 = new Pupil("S101", "Alice", "10A", subjects, 2);
        Pupil s2 = new Pupil("S102", "Bob", "10A", subjects, 2);
        Pupil s3 = new Pupil("S103", "Charlie", "10A", subjects, 2);

        s1.addMarks("Math", 85, 0);
        s1.addMarks("Science", 90, 0);
        s1.addMarks("English", 78, 0);
        s1.addMarks("Math", 88, 1);
        s1.addMarks("Science", 92, 1);
        s1.addMarks("English", 80, 1);

        s2.addMarks("Math", 70, 0);
        s2.addMarks("Science", 65, 0);
        s2.addMarks("English", 72, 0);
        s2.addMarks("Math", 75, 1);
        s2.addMarks("Science", 68, 1);
        s2.addMarks("English", 74, 1);

        s3.addMarks("Math", 95, 0);
        s3.addMarks("Science", 98, 0);
        s3.addMarks("English", 94, 0);
        s3.addMarks("Math", 92, 1);
        s3.addMarks("Science", 97, 1);
        s3.addMarks("English", 96, 1);

        s1.calculateGPA();
        s2.calculateGPA();
        s3.calculateGPA();

        s1.generateReportCard();
        s2.generateReportCard();
        s3.generateReportCard();

        Pupil[] allPupils = {s1, s2, s3};
        Pupil.generateSchoolReport(allPupils);
    }
}
