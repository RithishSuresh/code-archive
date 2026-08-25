import java.util.Scanner;

public class StringSplit {

    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
        }
        return count;
    }

    public static String[] manualSplit(String str) {
        int len = findLength(str);
        String[] words = new String[len];
        int wordCount = 0;
        String current = "";
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                if (!current.equals("")) {
                    words[wordCount++] = current;
                    current = "";
                }
            } else {
                current += c;
            }
        }
        if (!current.equals("")) {
            words[wordCount++] = current;
        }
        String[] result = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            result[i] = words[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();
        String[] manual = manualSplit(input);
        String[] builtin = input.split(" ");
        System.out.println("Manual Split:");
        for (String w : manual) System.out.println(w);
        System.out.println("Built-in Split:");
        for (String w : builtin) System.out.println(w);
        sc.close();
    }
}

