import java.util.Scanner;

public class UniqueCharacters {

    // Method to find the length of a string without using length()
    public static int getLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count); // Throws exception when out of bounds
                count++;
            }
        } catch (Exception e) {
            // Reached end of string
        }
        return count;
    }

    // Method to find unique characters in the string
    public static char[] findUniqueCharacters(String text) {
        int len = getLength(text);
        char[] uniqueTemp = new char[len];
        int uniqueCount = 0;

        for (int i = 0; i < len; i++) {
            char currentChar = text.charAt(i);
            boolean isUnique = true;

            // Check if currentChar appeared before
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == currentChar) {
                    isUnique = false;
                    break;
                }
            }

            // If it's unique, store it
            if (isUnique) {
                uniqueTemp[uniqueCount++] = currentChar;
            }
        }

        // Create new array of correct size
        char[] uniqueChars = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueChars[i] = uniqueTemp[i];
        }

        return uniqueChars;
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        char[] unique = findUniqueCharacters(input);

        System.out.println("\nUnique characters:");
        for (char c : unique) {
            System.out.print(c + " ");
        }
    }
}

