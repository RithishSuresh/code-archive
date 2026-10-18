import java.util.Scanner;

public class math {
    public static void main(String[] args) {
        int num;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer:");
        num = input.nextInt();

        if (num % 2 == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }

        int[] Odd = new int[50];
        int[] Even = new int[50];
        int gen = 1;
        int Oddnum = 0, EvenNum = 0;

        while (gen <= 100) {
            if (gen % 2 == 0 && EvenNum < 50) {
                Even[EvenNum] = gen;
                EvenNum++;
            } else if (Oddnum < 50) {
                Odd[Oddnum] = gen;
                Oddnum++;
            }
            gen++;
        }

        System.out.println("Odd numbers:");
        for (int i = 0; i < Odd.length; i++) {
            System.out.print(Odd[i] + " ");
        }

        System.out.println();

        System.out.println("Even numbers:");
        for (int j = 0; j < Even.length; j++) {
            System.out.print(Even[j] + " ");
        }
        
    }
}