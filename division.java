import java.util.Scanner;
public class division {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter any integer: \n");
        int num = input.nextInt();
        if (num % 3 == 0) { // Check if the number is divisible by 3
            System.out.print("The number is divisible by 3");
        } else {
            System.out.print("The number is not divisible by 3");
        }

    }
}

