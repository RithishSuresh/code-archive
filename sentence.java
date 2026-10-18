import java.util.Scanner;
public class sentence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence:\n");
        String sentence = sc.nextLine();
        String[] words = sentence.split(" "); //Spliting the sentence
        for (String w : words) {   //Print each word on its own line
            System.out.println(w);
        }


    }
}


