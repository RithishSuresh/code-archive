import java.util.*;

public class TextProcessor {

    public static String cleanInput(String input) {
        String trimmed = input.trim().replaceAll("\\s+", " ");
        String[] words = trimmed.toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            if (w.isEmpty()) continue;
            sb.append(Character.toUpperCase(w.charAt(0)));
            if (w.length() > 1) sb.append(w.substring(1));
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static void analyzeText(String text) {
        String noSpaces = text.replace(" ", "");
        int characters = noSpaces.length();
        String[] sentences = text.trim().isEmpty() ? new String[0] : text.split("[.!?]+\\s*");
        int sentenceCount = text.trim().isEmpty() ? 0 : sentences.length;
        List<String> words = new ArrayList<>();
        var m = java.util.regex.Pattern.compile("\\b[\\p{L}\\p{N}']+\\b").matcher(text);
        while (m.find()) words.add(m.group());
        int wordCount = words.size();
        String longest = "";
        for (String w : words) if (w.length() > longest.length()) longest = w;
        Map<Character,Integer> freq = new HashMap<>();
        for (char c : text.toLowerCase().toCharArray()) {
            if (Character.isWhitespace(c)) continue;
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        char mostCommonChar = 0;
        int best = -1;
        for (var e : freq.entrySet()) {
            if (e.getValue() > best || (e.getValue() == best && e.getKey() < mostCommonChar)) {
                mostCommonChar = e.getKey();
                best = e.getValue();
            }
        }
        System.out.println("\n--- Analysis ---");
        System.out.println("Words: " + wordCount);
        System.out.println("Sentences: " + sentenceCount);
        System.out.println("Characters (no spaces): " + characters);
        System.out.println("Longest word: " + (longest.isEmpty() ? "-" : longest));
        System.out.println("Most common character: " + (best <= 0 ? "-" : mostCommonChar) + (best <= 0 ? "" : " (" + best + ")"));
    }

    public static String[] getWordsSorted(String text) {
        List<String> words = new ArrayList<>();
        var m = java.util.regex.Pattern.compile("\\b[\\p{L}\\p{N}']+\\b").matcher(text);
        while (m.find()) words.add(m.group());
        words.replaceAll(String::toLowerCase);
        Collections.sort(words);
        return words.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== TEXT PROCESSOR ===");
        System.out.print("Enter a paragraph: ");
        String input = scanner.nextLine();
        while (input.trim().isEmpty()) {
            System.out.print("Please enter non-empty text: ");
            input = scanner.nextLine();
        }
        String cleaned = cleanInput(input);
        System.out.println("\nCleaned text: " + cleaned);
        analyzeText(cleaned);
        String[] sorted = getWordsSorted(cleaned);
        System.out.println("\n--- Words (alphabetical) ---");
        for (String w : sorted) System.out.println(w);
        System.out.print("\nSearch a word: ");
        String query = scanner.nextLine().trim().toLowerCase();
        int occurrences = 0;
        for (String w : sorted) if (w.equals(query)) occurrences++;
        System.out.println("Occurrences of \"" + query + "\": " + occurrences);
        scanner.close();
    }
}
