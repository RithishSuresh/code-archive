import java.util.*;

public class EmailAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter number of email addresses: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String[] emails = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter email " + (i + 1) + ": ");
            emails[i] = scanner.nextLine().trim();
        }


        int validCount = 0, invalidCount = 0, totalUsernameLength = 0;
        Map<String, Integer> domainCount = new HashMap<>();


        System.out.println("\n=== EMAIL ANALYSIS REPORT ===");
        System.out.printf("%-25s %-15s %-20s %-15s %-10s %-10s%n",
                "Email", "Username", "Domain", "Domain Name", "Extension", "Valid?");


        for (String email : emails) {
            boolean isValid = validateEmail(email);

            if (isValid) {
                validCount++;


                String username = getUsername(email);
                String domain = getDomain(email);
                String domainName = getDomainName(domain);
                String extension = getExtension(domain);


                totalUsernameLength += username.length();
                domainCount.put(domainName, domainCount.getOrDefault(domainName, 0) + 1);


                System.out.printf("%-25s %-15s %-20s %-15s %-10s %-10s%n",
                        email, username, domain, domainName, extension, "Valid");

            } else {
                invalidCount++;

                System.out.printf("%-25s %-15s %-20s %-15s %-10s %-10s%n",
                        email, "-", "-", "-", "-", "Invalid");
            }
        }


        String mostCommonDomain = "-";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : domainCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommonDomain = entry.getKey();
            }
        }


        double avgUsernameLength = (validCount > 0) ?
                (double) totalUsernameLength / validCount : 0.0;


        System.out.println("\n=== STATISTICS ===");
        System.out.println("Total Valid Emails   : " + validCount);
        System.out.println("Total Invalid Emails : " + invalidCount);
        System.out.println("Most Common Domain   : " + mostCommonDomain);
        System.out.printf("Average Username Length: %.2f%n", avgUsernameLength);

        scanner.close();
    }


    public static boolean validateEmail(String email) {
        int atIndex = email.indexOf('@');
        int lastAtIndex = email.lastIndexOf('@');

        if (atIndex == -1 || atIndex != lastAtIndex) return false; // must have exactly 1 '@'
        if (atIndex == 0) return false; // no username
        if (atIndex == email.length() - 1) return false; // no domain

        String domain = email.substring(atIndex + 1);
        int dotIndex = domain.indexOf('.');
        if (dotIndex == -1 || dotIndex == 0 || dotIndex == domain.length() - 1) return false;

        return true;
    }


    public static String getUsername(String email) {
        return email.substring(0, email.indexOf('@'));
    }

    public static String getDomain(String email) {
        return email.substring(email.indexOf('@') + 1);
    }

    public static String getDomainName(String domain) {
        return domain.substring(0, domain.indexOf('.'));
    }

    public static String getExtension(String domain) {
        return domain.substring(domain.lastIndexOf('.') + 1);
    }
}
