import java.util.*;

public class TextCompression {

    public static Object[] countFrequency(String text) {
        char[] chars = new char[text.length()];
        int[] freq = new int[text.length()];
        int uniqueCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            boolean found = false;
            for (int j = 0; j < uniqueCount; j++) {
                if (chars[j] == ch) {
                    freq[j]++;
                    found = true;
                    break;
                }
            }
            if (!found) {
                chars[uniqueCount] = ch;
                freq[uniqueCount] = 1;
                uniqueCount++;
            }
        }
        char[] finalChars = Arrays.copyOf(chars, uniqueCount);
        int[] finalFreq = Arrays.copyOf(freq, uniqueCount);
        return new Object[]{finalChars, finalFreq};
    }

    public static String[][] createCodes(char[] chars, int[] freq) {
        int n = chars.length;
        String[][] mapping = new String[n][2];
        Character[] indices = new Character[n];
        for (int i = 0; i < n; i++) indices[i] = (char) i;
        Integer[] freqIndex = new Integer[n];
        for (int i = 0; i < n; i++) freqIndex[i] = i;
        Arrays.sort(freqIndex, (a, b) -> freq[b] - freq[a]);
        for (int i = 0; i < n; i++) {
            mapping[i][0] = String.valueOf(chars[freqIndex[i]]);
            mapping[i][1] = Integer.toString(i, 36);
        }
        return mapping;
    }

    public static String compressText(String text, String[][] mapping) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            for (String[] map : mapping) {
                if (map[0].charAt(0) == ch) {
                    sb.append(map[1]);
                    break;
                }
            }
        }
        return sb.toString();
    }

    public static String decompressText(String compressed, String[][] mapping) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < compressed.length(); i++) {
            String code = String.valueOf(compressed.charAt(i));
            for (String[] map : mapping) {
                if (map[1].equals(code)) {
                    sb.append(map[0]);
                    break;
                }
            }
        }
        return sb.toString();
    }

    public static void displayAnalysis(String text, char[] chars, int[] freq, String[][] mapping, String compressed, String decompressed) {
        System.out.println("\nCharacter Frequency Table:");
        System.out.printf("%-10s %-10s\n", "Char", "Freq");
        for (int i = 0; i < chars.length; i++) {
            System.out.printf("%-10s %-10d\n", chars[i], freq[i]);
        }

        System.out.println("\nCompression Mapping:");
        System.out.printf("%-10s %-10s\n", "Char", "Code");
        for (String[] map : mapping) {
            System.out.printf("%-10s %-10s\n", map[0], map[1]);
        }

        System.out.println("\nOriginal Text: " + text);
        System.out.println("Compressed Text: " + compressed);
        System.out.println("Decompressed Text: " + decompressed);

        double ratio = ((double) compressed.length() / text.length()) * 100;
        System.out.printf("Compression Efficiency: %.2f%%\n", 100 - ratio);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text to compress:");
        String text = sc.nextLine();

        Object[] result = countFrequency(text);
        char[] chars = (char[]) result[0];
        int[] freq = (int[]) result[1];

        String[][] mapping = createCodes(chars, freq);
        String compressed = compressText(text, mapping);
        String decompressed = decompressText(compressed, mapping);

        displayAnalysis(text, chars, freq, mapping, compressed, decompressed);
        sc.close();
    }
}

