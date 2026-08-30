import java.util.*;

public class TextFormatter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter text to format:");
        String text = sc.nextLine();
        System.out.print("Enter line width: ");
        int width = sc.nextInt();
        sc.nextLine(); // consume newline


        String[] words = splitWords(text);


        List<String> justifiedLines = justifyText(words, width);


        List<String> centeredLines = centerAlign(words, width);


        comparePerformance(words, width);

        // Display results
        System.out.println("\n=== ORIGINAL TEXT ===");
        System.out.println(text);

        System.out.println("\n=== JUSTIFIED TEXT ===");
        displayFormatted(justifiedLines);

        System.out.println("\n=== CENTER-ALIGNED TEXT ===");
        displayFormatted(centeredLines);

        sc.close();
    }


    public static String[] splitWords(String text) {
        List<String> words = new ArrayList<>();
        int start = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                if (i > start) {
                    words.add(text.substring(start, i));
                }
                start = i + 1;
            }
        }
        if (start < text.length()) {
            words.add(text.substring(start));
        }
        return words.toArray(new String[0]);
    }


    public static List<String> justifyText(String[] words, int width) {
        List<String> lines = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        List<String> currentWords = new ArrayList<>();
        int currentLength = 0;

        for (String word : words) {
            if (currentLength + word.length() + currentWords.size() <= width) {
                currentWords.add(word);
                currentLength += word.length();
            } else {
                lines.add(justifyLine(currentWords, currentLength, width));
                currentWords.clear();
                currentWords.add(word);
                currentLength = word.length();
            }
        }


        StringBuilder lastLine = new StringBuilder();
        for (int i = 0; i < currentWords.size(); i++) {
            lastLine.append(currentWords.get(i));
            if (i < currentWords.size() - 1) lastLine.append(" ");
        }
        lines.add(lastLine.toString());

        return lines;
    }

    private static String justifyLine(List<String> words, int length, int width) {
        if (words.size() == 1) return words.get(0); // single word
        int spaces = width - length;
        int gaps = words.size() - 1;
        int spaceEach = spaces / gaps;
        int extra = spaces % gaps;

        StringBuilder line = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            line.append(words.get(i));
            if (i < gaps) {
                for (int s = 0; s < spaceEach; s++) line.append(" ");
                if (i < extra) line.append(" ");
            }
        }
        return line.toString();
    }


    public static List<String> centerAlign(String[] words, int width) {
        List<String> lines = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        int currentLength = 0;

        for (String word : words) {
            if (currentLength + word.length() + (line.length() > 0 ? 1 : 0) <= width) {
                if (line.length() > 0) {
                    line.append(" ");
                    currentLength++;
                }
                line.append(word);
                currentLength += word.length();
            } else {
                lines.add(centerLine(line.toString(), width));
                line = new StringBuilder(word);
                currentLength = word.length();
            }
        }
        if (line.length() > 0) {
            lines.add(centerLine(line.toString(), width));
        }

        return lines;
    }

    private static String centerLine(String text, int width) {
        int padding = (width - text.length()) / 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < padding; i++) sb.append(" ");
        sb.append(text);
        return sb.toString();
    }


    public static void comparePerformance(String[] words, int width) {
        long start, end;


        start = System.nanoTime();
        justifyText(words, width);
        end = System.nanoTime();
        long sbTime = end - start;


        start = System.nanoTime();
        justifyTextConcat(words, width);
        end = System.nanoTime();
        long concatTime = end - start;

        System.out.println("\n=== PERFORMANCE COMPARISON ===");
        System.out.println("StringBuilder time : " + sbTime + " ns");
        System.out.println("String concat time : " + concatTime + " ns");
    }


    public static List<String> justifyTextConcat(String[] words, int width) {
        List<String> lines = new ArrayList<>();
        List<String> currentWords = new ArrayList<>();
        int currentLength = 0;

        for (String word : words) {
            if (currentLength + word.length() + currentWords.size() <= width) {
                currentWords.add(word);
                currentLength += word.length();
            } else {
                lines.add(justifyLineConcat(currentWords, currentLength, width));
                currentWords.clear();
                currentWords.add(word);
                currentLength = word.length();
            }
        }

        String lastLine = "";
        for (int i = 0; i < currentWords.size(); i++) {
            lastLine += currentWords.get(i);
            if (i < currentWords.size() - 1) lastLine += " ";
        }
        lines.add(lastLine);

        return lines;
    }

    private static String justifyLineConcat(List<String> words, int length, int width) {
        if (words.size() == 1) return words.get(0);
        int spaces = width - length;
        int gaps = words.size() - 1;
        int spaceEach = spaces / gaps;
        int extra = spaces % gaps;

        String line = "";
        for (int i = 0; i < words.size(); i++) {
            line += words.get(i);
            if (i < gaps) {
                for (int s = 0; s < spaceEach; s++) line += " ";
                if (i < extra) line += " ";
            }
        }
        return line;
    }


    public static void displayFormatted(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            System.out.printf("%2d | %-30s | %d chars%n", i + 1, line, line.length());
        }
    }
}
