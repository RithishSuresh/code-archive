import java.util.Scanner;

public class CaesarCipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter text to encrypt: ");
        String text = scanner.nextLine();
        System.out.print("Enter shift value: ");
        int shift = scanner.nextInt();


        String encrypted = encrypt(text, shift);

        String decrypted = decrypt(encrypted, shift);


        System.out.println("\n=== CAESAR CIPHER IMPLEMENTATION ===");
        System.out.println("Original Text:   " + text);
        displayAscii(text);

        System.out.println("\nEncrypted Text:  " + encrypted);
        displayAscii(encrypted);

        System.out.println("\nDecrypted Text:  " + decrypted);
        displayAscii(decrypted);

        if (text.equals(decrypted)) {
            System.out.println("\n✅ Decryption successful: Original text restored.");
        } else {
            System.out.println("\n❌ Decryption failed!");
        }

        scanner.close();
    }


    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                result.append((char) ((c - 'A' + shift) % 26 + 'A'));
            } else if (c >= 'a' && c <= 'z') {
                result.append((char) ((c - 'a' + shift) % 26 + 'a'));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }


    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - (shift % 26)); // Reverse shift
    }


    public static void displayAscii(String text) {
        System.out.print("Characters: ");
        for (char c : text.toCharArray()) {
            System.out.print(c + " ");
        }
        System.out.println();
        System.out.print("ASCII:      ");
        for (char c : text.toCharArray()) {
            System.out.print((int) c + " ");
        }
        System.out.println();
    }
}
