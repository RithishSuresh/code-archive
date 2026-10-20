import java.util.Scanner;

public class BankSystemProcedural {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask the user how many accounts to process
        System.out.print("Enter the number of accounts: ");
        int n = input.nextInt();

        double[] balances = new double[n];
        double total = 0;

        // Read and store each account balance
        for (int i = 0; i < n; i++) {
            System.out.print("Enter balance for account " + (i + 1) + ": ₹");
            balances[i] = input.nextDouble();
            total += balances[i];  // Add to total while reading
        }

        // Display the total balance of all savings accounts
        System.out.println("Total balance of all savings account: ₹" + total);
    }
}


