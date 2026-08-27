import java.util.Scanner;

public class BMI {

    // Method to calculate BMI and return status
    public static String[] calculateBMIStatus(double weight, double heightCm) {
        double heightM = heightCm / 100.0;
        double bmi = weight / (heightM * heightM);
        String status;

        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 25) {
            status = "Normal";
        } else if (bmi < 30) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        return new String[] {
                String.format("%.2f", heightCm),
                String.format("%.2f", weight),
                String.format("%.2f", bmi),
                status
        };
    }

    // Method to compute BMI and status for each person
    public static String[][] processBMIData(double[][] personData) {
        String[][] result = new String[10][4];

        for (int i = 0; i < 10; i++) {
            double weight = personData[i][0];
            double height = personData[i][1];
            result[i] = calculateBMIStatus(weight, height);
        }

        return result;
    }

    // Method to display the results
    public static void displayResults(String[][] data) {
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Height(cm)", "Weight(kg)", "BMI", "Status");
        System.out.println("-----------------------------------------------------");

        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-10s %-10s %-10s %-15s\n",
                    data[i][0], data[i][1], data[i][2], data[i][3]);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] personData = new double[10][2];

        System.out.println("Enter weight (kg) and height (cm) for 10 persons:");

        for (int i = 0; i < 10; i++) {
            System.out.printf("Person %d:\n", i + 1);
            System.out.print("  Weight (kg): ");
            personData[i][0] = scanner.nextDouble();
            System.out.print("  Height (cm): ");
            personData[i][1] = scanner.nextDouble();
        }

        String[][] bmiResults = processBMIData(personData);
        System.out.println("\nBMI Results:");
        displayResults(bmiResults);
    }
}


