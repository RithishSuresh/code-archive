import java.util.Scanner;

public class ShortestLongestWord {

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

    public static String[][] wordWithLength(String[] words) {
        int n = words.length;
        String[][] result = new String[n][2];
        for (int i = 0; i < n; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }

    public static int[] findShortestLongest(String[][] table) {
        int shortestIndex = 0;
        int longestIndex = 0;
        int minLen = Integer.valueOf(table[0][1]);
        int maxLen = Integer.valueOf(table[0][1]);
        for (int i = 1; i < table.length; i++) {
            int len = Integer.valueOf(table[i][1]);
            if (len < minLen) {
                minLen = len;
                shortestIndex = i;
            }
            if (len > maxLen) {
                maxLen = len;
                longestIndex = i;
            }
        }
        return new int[]{shortestIndex, longestIndex};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();
        String[] words = manualSplit(input);
        String[][] table = wordWithLength(words);
        System.out.println("Word\tLength");
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t" + Integer.valueOf(table[i][1]));
        }
        int[] result = findShortestLongest(table);
        System.out.println("Shortest word: " + table[result[0]][0] + " (" + table[result[0]][1] + ")");
        System.out.println("Longest word: " + table[result[1]][0] + " (" + table[result[1]][1] + ")");
        sc.close();
    }
}

