import java.util.Scanner;

public class ASCIIProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        for (char ch : input.toCharArray()) {
            System.out.println("Character: " + ch + " | ASCII: " + (int) ch);
            System.out.println("Type: " + classifyCharacter(ch));
            if (Character.isLetter(ch)) {
                char upper = Character.toUpperCase(ch);
                char lower = Character.toLowerCase(ch);
                System.out.println("Upper: " + upper + " (" + (int) upper + ")");
                System.out.println("Lower: " + lower + " (" + (int) lower + ")");
                System.out.println("Difference: " + Math.abs((int) upper - (int) lower));
            }
            System.out.println();
        }

        System.out.println("Caesar Cipher (shift 3): " + caesarCipher(input, 3));
        System.out.println("ASCII Table (65 to 70):");
        displayASCIITable(65, 70);

        int[] asciiArray = stringToASCII(input);
        System.out.print("ASCII Array: ");
        for (int val : asciiArray) {
            System.out.print(val + " ");
        }
        System.out.println();
        System.out.println("Back to String: " + asciiToString(asciiArray));

        scanner.close();
    }

    public static String classifyCharacter(char ch) {
        if (Character.isUpperCase(ch)) return "Uppercase Letter";
        else if (Character.isLowerCase(ch)) return "Lowercase Letter";
        else if (Character.isDigit(ch)) return "Digit";
        else return "Special Character";
    }

    public static char toggleCase(char ch) {
        if (Character.isUpperCase(ch)) return (char) (ch + 32);
        else if (Character.isLowerCase(ch)) return (char) (ch - 32);
        else return ch;
    }

    public static String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                result.append((char) ((ch - base + shift) % 26 + base));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void displayASCIITable(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(i + " -> " + (char) i);
        }
    }

    public static int[] stringToASCII(String text) {
        int[] ascii = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            ascii[i] = (int) text.charAt(i);
        }
        return ascii;
    }

    public static String asciiToString(int[] asciiValues) {
        StringBuilder result = new StringBuilder();
        for (int val : asciiValues) {
            result.append((char) val);
        }
        return result.toString();
    }
}

