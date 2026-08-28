import java.util.*;

public class FileOrganizer {

    static class FileInfo {
        String originalName;
        String name;
        String extension;
        String category;
        String newName;
        String subCategory;
        int priority;
    }

    static FileInfo extractFileInfo(String filename) {
        FileInfo f = new FileInfo();
        f.originalName = filename;
        int dot = filename.lastIndexOf('.');
        if (dot == -1 || dot == filename.length() - 1) {
            f.name = filename;
            f.extension = "";
        } else {
            f.name = filename.substring(0, dot);
            f.extension = filename.substring(dot + 1).toLowerCase();
        }
        return f;
    }

    static String categorizeFile(String ext) {
        if (ext.equals("txt") || ext.equals("doc")) return "Document";
        if (ext.equals("jpg") || ext.equals("png")) return "Image";
        if (ext.equals("mp3") || ext.equals("wav")) return "Audio";
        if (ext.equals("mp4") || ext.equals("avi")) return "Video";
        if (ext.equals("java") || ext.equals("cpp") || ext.equals("py")) return "Code";
        return "Unknown";
    }

    static String generateNewName(FileInfo f, int count) {
        StringBuilder sb = new StringBuilder();
        sb.append(f.category).append("_").append(System.currentTimeMillis());
        if (count > 0) sb.append("_").append(count);
        if (!f.extension.isEmpty()) sb.append(".").append(f.extension);
        return sb.toString();
    }

    static void analyzeContent(FileInfo f) {
        if (f.extension.equals("txt")) {
            String content = f.name.toLowerCase();
            if (content.contains("resume")) f.subCategory = "Resume";
            else if (content.contains("report")) f.subCategory = "Report";
            else if (content.contains("code")) f.subCategory = "Code";
            else f.subCategory = "General";
        } else f.subCategory = "N/A";
        f.priority = f.name.length();
    }

    static void displayReport(List<FileInfo> files) {
        System.out.printf("%-20s %-12s %-25s %-15s %-10s\n", "Original", "Category", "New Name", "SubCategory", "Priority");
        for (FileInfo f : files) {
            System.out.printf("%-20s %-12s %-25s %-15s %-10d\n", f.originalName, f.category, f.newName, f.subCategory, f.priority);
        }
    }

    static void categoryStats(List<FileInfo> files) {
        Map<String, Integer> map = new HashMap<>();
        for (FileInfo f : files) map.put(f.category, map.getOrDefault(f.category, 0) + 1);
        System.out.println("\nCategory Counts:");
        for (String cat : map.keySet()) {
            System.out.println(cat + ": " + map.get(cat));
        }
    }

    static void batchCommands(List<FileInfo> files) {
        System.out.println("\nBatch Rename Commands:");
        for (FileInfo f : files) {
            System.out.println("rename " + f.originalName + " " + f.newName);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<FileInfo> files = new ArrayList<>();
        System.out.println("Enter file names (comma separated):");
        String[] input = sc.nextLine().split(",");
        Map<String, Integer> duplicateCount = new HashMap<>();

        for (String s : input) {
            FileInfo f = extractFileInfo(s.trim());
            f.category = categorizeFile(f.extension);
            analyzeContent(f);
            int count = duplicateCount.getOrDefault(f.name, 0);
            f.newName = generateNewName(f, count);
            duplicateCount.put(f.name, count + 1);
            files.add(f);
        }

        displayReport(files);
        categoryStats(files);
        batchCommands(files);
    }
}

