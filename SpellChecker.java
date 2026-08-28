import java.util.Scanner;

public class SpellChecker {

    public static String[] splitWords(String text) {
        StringBuilder word = new StringBuilder();
        StringBuilder allWords = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                word.append(ch);
            } else {
                if (word.length() > 0) {
                    allWords.append(word.toString()).append(" ");
                    word.setLength(0);
                }
            }
        }
        if (word.length() > 0) {
            allWords.append(word.toString());
        }
        return allWords.toString().split(" ");
    }

    public static int stringDistance(String w1, String w2) {
        int len1 = w1.length();
        int len2 = w2.length();
        int distance = Math.abs(len1 - len2);
        int minLen = Math.min(len1, len2);
        for (int i = 0; i < minLen; i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }

    public static String getSuggestion(String word, String[] dict) {
        String suggestion = word;
        int minDist = Integer.MAX_VALUE;
        for (String d : dict) {
            int dist = stringDistance(word.toLowerCase(), d.toLowerCase());
            if (dist < minDist) {
                minDist = dist;
                suggestion = d;
            }
        }
        if (minDist <= 2) {
            return suggestion;
        }
        return word;
    }

    public static void spellCheck(String[] words, String[] dict) {
        System.out.printf("%-15s %-15s %-10s %-15s\n", "Word", "Suggestion", "Distance", "Status");
        System.out.println("-------------------------------------------------------------");
        for (String w : words) {
            String suggestion = getSuggestion(w, dict);
            int dist = stringDistance(w.toLowerCase(), suggestion.toLowerCase());
            String status = (dist == 0) ? "Correct" : "Misspelled";
            System.out.printf("%-15s %-15s %-10d %-15s\n", w, suggestion, dist, status);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] dictionary = {"hello", "world", "java", "programming", "chatgpt", "spell", "checker"};
        System.out.println("Enter a sentence:");
        String sentence = sc.nextLine();
        String[] words = splitWords(sentence);
        spellCheck(words, dictionary);
        sc.close();
    }
}

