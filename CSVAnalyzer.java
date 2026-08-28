import java.util.*;

public class CSVAnalyzer {

    // Parse CSV into 2D ArrayList
    static List<List<String>> parseCSV(String input) {
        List<List<String>> data = new ArrayList<>();
        List<String> row = new ArrayList<>();
        StringBuilder field = new StringBuilder();
        boolean inQuotes = false;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '\"') {
                inQuotes = !inQuotes; // toggle
            } else if (c == ',' && !inQuotes) {
                row.add(field.toString());
                field.setLength(0);
            } else if ((c == '\n' || c == '\r') && !inQuotes) {
                if (field.length() > 0 || !row.isEmpty()) {
                    row.add(field.toString());
                    data.add(new ArrayList<>(row));
                }
                row.clear();
                field.setLength(0);
            } else {
                field.append(c);
            }
        }
        if (field.length() > 0 || !row.isEmpty()) {
            row.add(field.toString());
            data.add(row);
        }
        return data;
    }

    // Clean and validate fields
    static void cleanData(List<List<String>> data) {
        for (List<String> row : data) {
            for (int i = 0; i < row.size(); i++) {
                String val = row.get(i).trim();
                if (val.isEmpty()) {
                    row.set(i, "MISSING");
                } else {
                    row.set(i, val);
                }
            }
        }
    }

    // Check if numeric
    static boolean isNumeric(String s) {
        if (s.equals("MISSING")) return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(c >= '0' && c <= '9')) return false;
        }
        return true;
    }

    // Data analysis
    static void analyze(List<List<String>> data) {
        if (data.isEmpty()) return;
        int cols = data.get(0).size();
        System.out.println("\n--- Data Analysis Report ---");

        for (int c = 0; c < cols; c++) {
            List<String> colData = new ArrayList<>();
            for (int r = 1; r < data.size(); r++) colData.add(data.get(r).get(c));

            boolean numeric = colData.stream().allMatch(CSVAnalyzer::isNumeric);
            System.out.println("\nColumn: " + data.get(0).get(c));

            if (numeric) {
                int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, sum = 0, count = 0;
                for (String v : colData) {
                    if (isNumeric(v)) {
                        int num = Integer.parseInt(v);
                        min = Math.min(min, num);
                        max = Math.max(max, num);
                        sum += num;
                        count++;
                    }
                }
                double avg = (count > 0) ? (sum * 1.0 / count) : 0;
                System.out.println("Type: Numeric");
                System.out.println("Min: " + min + " Max: " + max + " Avg: " + String.format("%.2f", avg));
            } else {
                Set<String> unique = new HashSet<>(colData);
                System.out.println("Type: Categorical");
                System.out.println("Unique Values: " + unique);
            }

            long missingCount = colData.stream().filter(x -> x.equals("MISSING")).count();
            if (missingCount > 0) {
                System.out.println("⚠ Missing values: " + missingCount);
            }
        }
    }

    // Format output as table
    static void displayTable(List<List<String>> data) {
        System.out.println("\n--- Formatted Table ---");
        int cols = data.get(0).size();
        int[] widths = new int[cols];

        // Find max width per column
        for (List<String> row : data) {
            for (int i = 0; i < cols; i++) {
                widths[i] = Math.max(widths[i], row.get(i).length());
            }
        }

        // Print table
        for (List<String> row : data) {
            StringBuilder sb = new StringBuilder("| ");
            for (int i = 0; i < cols; i++) {
                sb.append(String.format("%-" + widths[i] + "s | ", row.get(i)));
            }
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter CSV-like data (end with an empty line):");

        StringBuilder input = new StringBuilder();
        while (true) {
            String line = sc.nextLine();
            if (line.isEmpty()) break;
            input.append(line).append("\n");
        }

        List<List<String>> data = parseCSV(input.toString());
        cleanData(data);
        displayTable(data);
        analyze(data);

        System.out.println("\n--- Summary Report ---");
        System.out.println("Total Records (excluding header): " + (data.size() - 1));
        System.out.println("Columns: " + data.get(0).size());
    }
}

