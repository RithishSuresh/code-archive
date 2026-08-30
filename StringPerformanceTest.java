import java.util.Scanner;

public class StringPerformanceTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter number of iterations (e.g., 1000, 10000, 100000): ");
        int iterations = scanner.nextInt();


        Result stringResult = testStringConcat(iterations);
        Result builderResult = testStringBuilder(iterations);
        Result bufferResult = testStringBuffer(iterations);


        System.out.println("\n=== STRING PERFORMANCE ANALYSIS ===");
        System.out.printf("%-15s %-20s %-20s\n", "Method", "Time Taken (ms)", "Final String Length");
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-15s %-20d %-20d\n", "String (+)", stringResult.timeTaken, stringResult.length);
        System.out.printf("%-15s %-20d %-20d\n", "StringBuilder", builderResult.timeTaken, builderResult.length);
        System.out.printf("%-15s %-20d %-20d\n", "StringBuffer", bufferResult.timeTaken, bufferResult.length);

        scanner.close();
    }


    static class Result {
        long timeTaken;
        int length;
        Result(long timeTaken, int length) {
            this.timeTaken = timeTaken;
            this.length = length;
        }
    }


    public static Result testStringConcat(int iterations) {
        String str = "";
        long start = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            str += "a";  // new object each time
        }
        long end = System.currentTimeMillis();
        return new Result(end - start, str.length());
    }


    public static Result testStringBuilder(int iterations) {
        StringBuilder sb = new StringBuilder();
        long start = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        long end = System.currentTimeMillis();
        return new Result(end - start, sb.length());
    }


    public static Result testStringBuffer(int iterations) {
        StringBuffer sb = new StringBuffer();
        long start = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        long end = System.currentTimeMillis();
        return new Result(end - start, sb.length());
    }
}
