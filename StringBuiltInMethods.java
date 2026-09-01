public class StringBuiltInMethods {

    public static void main(String[] args) {
        String sampleText = " Java Programming is Fun and Challenging! ";

        System.out.println("Original String: \"" + sampleText + "\"");
        System.out.println("1. Original length (with spaces): " + sampleText.length());

        String trimmed = sampleText.trim();
        System.out.println("2. After trimming: \"" + trimmed + "\"");
        System.out.println("   New length: " + trimmed.length());

        System.out.println("3. Character at index 5: " + sampleText.charAt(5));

        String sub = sampleText.substring(sampleText.indexOf("Programming"), sampleText.indexOf("Programming") + "Programming".length());
        System.out.println("4. Substring extracted: " + sub);

        int indexFun = sampleText.indexOf("Fun");
        System.out.println("5. Index of \"Fun\": " + indexFun);

        System.out.println("6. Contains \"Java\"? " + sampleText.contains("Java"));

        System.out.println("7. Starts with \"Java\" after trimming? " + trimmed.startsWith("Java"));

        System.out.println("8. Ends with '!': " + sampleText.trim().endsWith("!"));

        System.out.println("9. Uppercase: " + sampleText.toUpperCase());

        System.out.println("10. Lowercase: " + sampleText.toLowerCase());

        System.out.println("Vowel count: " + countVowels(sampleText));

        System.out.println("Occurrences of 'a': ");
        findAllOccurrences(sampleText, 'a');
    }

    public static int countVowels(String text) {
        int count = 0;
        text = text.toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }

    public static void findAllOccurrences(String text, char target) {
        text = text.toLowerCase();
        target = Character.toLowerCase(target);
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == target) {
                System.out.println("Found '" + target + "' at index: " + i);
            }
        }
    }
}

