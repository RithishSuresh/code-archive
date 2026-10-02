public class University {
    private String universityName;

    public University(String universityName) {
        this.universityName = universityName;
    }

    class Department {
        private String deptName;

        public Department(String deptName) {
            this.deptName = deptName;
        }

        public void showInfo() {
            System.out.println("University: " + universityName + ", Department: " + deptName);
        }
    }

    static class ExamCell {
        public void conductExam() {
            System.out.println("Exam is being conducted by the Exam Cell.");
        }
    }

    public static void main(String[] args) {
        University uni = new University("SRM University");

        University.Department dept = uni.new Department("Computer Science");
        dept.showInfo();

        University.ExamCell exam = new University.ExamCell();
        exam.conductExam();
    }
}

