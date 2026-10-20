import java.util.Scanner;

public class BankSystemOOP {
    public static void main(String[] var0) {
        Scanner var1 = new Scanner(System.in);

        // Get the number of savings accounts from the user
        System.out.print("Enter the number of accounts: ");
        int var2 = var1.nextInt();
        Account[] var3 = new Account[var2];

        // Input the balance for each account and create Account objects
        for (int var4 = 0; var4 < var2; ++var4) {
            System.out.print("Enter balance for account " + (var4 + 1) + ": ");
            int var5 = var1.nextInt();
            var3[var4] = new Account(var5);
        }

        // Calculate total balance using a method
        int var6 = calculateTotalBalance(var3);

        // Display the total balance
        System.out.println("Total balance in all accounts: " + var6);
    }

    public static int calculateTotalBalance(Account[] var0) {
        int var1 = 0;

        for (int var2 = 0; var2 < var0.length; ++var2) {
            var1 += var0[var2].getBalance();
        }

        return var1;
    }
}

// Account class representing each savings account
class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return this.balance;
    }
}
