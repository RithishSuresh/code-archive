import java.util.Scanner;

public class TextCaseConversion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter your text:");
        String text = scanner.nextLine();

        String manualUpper = toUpperCaseManual(text);
        String manualLower = toLowerCaseManual(text);
        String manualTitle = toTitleCaseManual(text);


        String builtinUpper = text.toUpperCase();
        String builtinLower = text.toLowerCase();


        System.out.println("\n=== CASE CONVERSION RESULTS ===");
        System.out.printf("%-20s %-30s %-30s\n", "Conversion", "Manual Result", "Built-in Result");
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("%-20s %-30s %-30s\n", "Uppercase", manualUpper, builtinUpper);
        System.out.printf("%-20s %-30s %-30s\n", "Lowercase", manualLower, builtinLower);
        System.out.printf("%-20s %-30s %-30s\n", "Title Case", manualTitle, "(no built-in direct)");

        scanner.close();
    }


    public static String toUpperCaseManual(String text) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                result.append((char)(ch - 32));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }


    public static String toLowerCaseManual(String text) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                result.append((char)(ch + 32));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }


    public static String toTitleCaseManual(String text) {
        StringBuilder result = new StringBuilder();
        boolean startOfWord = true;

        for (char ch : text.toCharArray()) {
            if (ch == ' ') {
                result.append(ch);
                startOfWord = true;
            } else {
                if (startOfWord) {

                    if (ch >= 'a' && ch <= 'z') {
                        result.append((char)(ch - 32));
                    } else {
                        result.append(ch);
                    }
                    startOfWord = false;
                } else {

                    if (ch >= 'A' && ch <= 'Z') {
                        result.append((char)(ch + 32));
                    } else {
                        result.append(ch);
                    }
                }
            }
        }
        return result.toString();
    }
}

