import java.util.Scanner;

public class BankSystemProcedure {
    public static void main(String[] args) {
        int total = 0;
        Scanner input = new Scanner(System.in);

        // Get the number of savings accounts from the user
        System.out.print("Enter the number of accounts: ");
        int n = input.nextInt();
        input.nextLine(); // For newline

        int[] balances = new int[n];

        // Input the balance for each account
        for (int i = 0; i < n; i++) {
            System.out.print("Enter balance for account " + (i + 1) + ": ₹");
            balances[i] = input.nextInt();
            input.nextLine(); // For newline
        }

        // Calculate the total balance
        for (int i = 0; i < balances.length; i++) {
            total += balances[i];
        }

        // Display the total balance
        System.out.println("Total balance of all savings account: ₹" + total);
    }
}




