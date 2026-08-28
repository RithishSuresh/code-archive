import java.util.*;

public class PasswordAnalyzerGenerator {

    public static int[] analyzePassword(String pwd) {
        int upper = 0, lower = 0, digit = 0, special = 0;
        for (int i = 0; i < pwd.length(); i++) {
            char ch = pwd.charAt(i);
            int ascii = (int) ch;
            if (ascii >= 65 && ascii <= 90) upper++;
            else if (ascii >= 97 && ascii <= 122) lower++;
            else if (ascii >= 48 && ascii <= 57) digit++;
            else if (ascii >= 33 && ascii <= 126) special++;
        }
        return new int[]{upper, lower, digit, special};
    }

    public static int calculateScore(String pwd, int[] counts) {
        int score = 0;
        if (pwd.length() > 8) score += (pwd.length() - 8) * 2;
        if (counts[0] > 0) score += 10;
        if (counts[1] > 0) score += 10;
        if (counts[2] > 0) score += 10;
        if (counts[3] > 0) score += 10;
        String lowerPwd = pwd.toLowerCase();
        if (lowerPwd.contains("123") || lowerPwd.contains("abc") || lowerPwd.contains("qwerty")) score -= 10;
        return score;
    }

    public static String getStrength(int score) {
        if (score <= 20) return "Weak";
        else if (score <= 50) return "Medium";
        else return "Strong";
    }

    public static String generatePassword(int length) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specials = "!@#$%^&*()-_=+[]{};:,.<>?";
        String all = upper + lower + digits + specials;
        Random rand = new Random();
        StringBuilder pwd = new StringBuilder();
        pwd.append(upper.charAt(rand.nextInt(upper.length())));
        pwd.append(lower.charAt(rand.nextInt(lower.length())));
        pwd.append(digits.charAt(rand.nextInt(digits.length())));
        pwd.append(specials.charAt(rand.nextInt(specials.length())));
        for (int i = 4; i < length; i++) {
            pwd.append(all.charAt(rand.nextInt(all.length())));
        }
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < pwd.length(); i++) chars.add(pwd.charAt(i));
        Collections.shuffle(chars);
        StringBuilder shuffled = new StringBuilder();
        for (char c : chars) shuffled.append(c);
        return shuffled.toString();
    }

    public static void displayResults(String pwd, int[] counts, int score, String strength) {
        System.out.printf("%-15s %-8d %-8d %-10d %-12d %-12d %-8d %-10s\n",
                pwd, pwd.length(), counts[0], counts[1], counts[2], counts[3], score, strength);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of passwords to analyze:");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.printf("%-15s %-8s %-8s %-10s %-12s %-12s %-8s %-10s\n",
                "Password", "Length", "Upper", "Lower", "Digits", "Specials", "Score", "Strength");
        System.out.println("----------------------------------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.println("Enter password " + (i + 1) + ":");
            String pwd = sc.nextLine();
            int[] counts = analyzePassword(pwd);
            int score = calculateScore(pwd, counts);
            String strength = getStrength(score);
            displayResults(pwd, counts, score, strength);
        }
        System.out.println("\nGenerate Strong Password");
        System.out.println("Enter desired length:");
        int len = sc.nextInt();
        System.out.println("Generated Password: " + generatePassword(len));
        sc.close();
    }
}

