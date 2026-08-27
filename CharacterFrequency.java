import java.util.Scanner;

public class CharacterFrequency {

    // Method to compute frequency of characters using charAt()
    public static String[][] getCharFrequencies(String text) {
        int[] freq = new int[256];  // ASCII size
        int length = 0;

        // Step 1: Count character frequencies using charAt()
        try {
            while (true) {
                char ch = text.charAt(length);
                freq[ch]++;
                length++;
            }
        } catch (Exception e) {
            // End of string
        }

        // Step 2: Prepare a 2D array to store character-frequency pairs
        String[][] resultTemp = new String[256][2];
        int count = 0;

        // Step 3: Store unique characters and their frequencies
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            if (freq[ch] != 0) {
                resultTemp[count][0] = String.valueOf(ch);
                resultTemp[count][1] = String.valueOf(freq[ch]);
                freq[ch] = 0;  // Mark as stored to avoid duplicates
                count++;
            }
        }

        // Step 4: Trim the 2D array to actual size
        String[][] result = new String[count][2];
        for (int i = 0; i < count; i++) {
            result[i][0] = resultTemp[i][0];
            result[i][1] = resultTemp[i][1];
        }

        return result;
    }

    // Method to display frequency table
    public static void displayFrequencies(String[][] freqData) {
        System.out.printf("%-10s %-10s\n", "Character", "Frequency");
        System.out.println("-----------------------");
        for (String[] pair : freqData) {
            System.out.printf("%-10s %-10s\n", pair[0], pair[1]);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String[][] frequencies = getCharFrequencies(input);
        System.out.println("\nCharacter Frequencies:");
        displayFrequencies(frequencies);
    }
}


