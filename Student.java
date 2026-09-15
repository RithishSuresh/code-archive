package week3;

import java.util.Scanner;

public class Student {
    private String studentId;
    private String name;
    private double grade;
    private String course;

    public Student() {
        this.studentId = "";
        this.name = "";
        this.grade = 0.0;
        this.course = "";
    }

    public Student(String studentId, String name, double grade, String course) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
        this.course = course;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String calculateLetterGrade() {
        if (grade >= 90) return "A";
        else if (grade >= 80) return "B";
        else if (grade >= 70) return "C";
        else if (grade >= 60) return "D";
        else return "F";
    }
    public void displayStudent() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
        System.out.println("Course: " + course);
        System.out.println("Letter Grade: " + calculateLetterGrade());
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student s1 = new Student();
        System.out.println("Enter details for Student 1:");
        System.out.print("Student ID: ");
        s1.setStudentId(sc.nextLine());
        System.out.print("Name: ");
        s1.setName(sc.nextLine());
        System.out.print("Grade: ");
        s1.setGrade(sc.nextDouble());
        sc.nextLine();
        System.out.print("Course: ");
        s1.setCourse(sc.nextLine());
        Student s2 = new Student("102", "Santhosh", 85.5, "Computer Science");
        System.out.println("\n Student 1 Info ");
        s1.displayStudent();
        System.out.println(" Student 2 Info ");
        s2.displayStudent();
        System.out.println(" Testing Getters and Setters ");
        System.out.println("Student 2 Name before update: " + s2.getName());
        s2.setName("Santhosh S");
        System.out.println("Student 2 Name after update: " + s2.getName());

        sc.close();
    }
}

