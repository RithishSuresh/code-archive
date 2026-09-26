class Course {
    String title;
    String instructor;
    String enrollmentDate;

    Course(String title, String instructor, String enrollmentDate) {
        this.title = title;
        this.instructor = instructor;
        this.enrollmentDate = enrollmentDate;
    }

    void showProgress() {
        System.out.println("Course: " + title + ", Instructor: " + instructor + ", Enrolled on: " + enrollmentDate);
    }
}

class VideoCourse extends Course {
    int completionPercentage;
    int watchTime;

    VideoCourse(String title, String instructor, String enrollmentDate, int completionPercentage, int watchTime) {
        super(title, instructor, enrollmentDate);
        this.completionPercentage = completionPercentage;
        this.watchTime = watchTime;
    }

    void showProgress() {
        System.out.println("Video Course: " + title + ", Completion: " + completionPercentage + "%, Watch Time: " + watchTime + " mins");
    }
}

class InteractiveCourse extends Course {
    int quizScore;
    int projectsCompleted;

    InteractiveCourse(String title, String instructor, String enrollmentDate, int quizScore, int projectsCompleted) {
        super(title, instructor, enrollmentDate);
        this.quizScore = quizScore;
        this.projectsCompleted = projectsCompleted;
    }

    void showProgress() {
        System.out.println("Interactive Course: " + title + ", Quiz Score: " + quizScore + ", Projects Completed: " + projectsCompleted);
    }
}

class ReadingCourse extends Course {
    int pagesRead;
    int notesTaken;

    ReadingCourse(String title, String instructor, String enrollmentDate, int pagesRead, int notesTaken) {
        super(title, instructor, enrollmentDate);
        this.pagesRead = pagesRead;
        this.notesTaken = notesTaken;
    }

    void showProgress() {
        System.out.println("Reading Course: " + title + ", Pages Read: " + pagesRead + ", Notes Taken: " + notesTaken);
    }
}

class CertificationCourse extends Course {
    int examAttempts;
    boolean certified;

    CertificationCourse(String title, String instructor, String enrollmentDate, int examAttempts, boolean certified) {
        super(title, instructor, enrollmentDate);
        this.examAttempts = examAttempts;
        this.certified = certified;
    }

    void showProgress() {
        System.out.println("Certification Course: " + title + ", Exam Attempts: " + examAttempts + ", Certified: " + (certified ? "Yes" : "No"));
    }
}

public class OnlineLearningPlatform {
    public static void main(String[] args) {
        Course[] courses = {
                new VideoCourse("Java Basics", "Alice", "2025-09-26", 75, 120),
                new InteractiveCourse("Python Projects", "Bob", "2025-09-20", 85, 3),
                new ReadingCourse("Data Structures", "Charlie", "2025-09-15", 150, 10),
                new CertificationCourse("AWS Cloud", "Diana", "2025-09-10", 2, true)
        };

        for (Course c : courses) {
            c.showProgress();
        }
    }
}

