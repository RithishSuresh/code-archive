package week3;
import java.util.*;

class BookInfo {
    String bookId, title, author, isbn, category;
    boolean isIssued;
    String issueDate, dueDate;

    static int totalBooks = 0;

    BookInfo(String bookId, String title, String author, String isbn, String category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.category = category;
        this.isIssued = false;
        this.issueDate = null;
        this.dueDate = null;
        totalBooks++;
    }

    public void displayBook() {
        System.out.println(bookId + " | " + title + " | " + author + " | " + category + " | Issued: " + isIssued);
    }
}

class User {
    String userId, userName, userType, joinDate;
    BookInfo[] issuedBooks;
    int issuedCount;
    double totalFines;

    static int totalUsers = 0;
    static String libraryName = "Central Library";
    static double finePerDay = 5.0;
    static int maxBooksAllowed = 3;

    User(String userId, String userName, String userType, String joinDate) {
        this.userId = userId;
        this.userName = userName;
        this.userType = userType;
        this.joinDate = joinDate;
        this.issuedBooks = new BookInfo[maxBooksAllowed];
        this.issuedCount = 0;
        this.totalFines = 0;
        totalUsers++;
    }

    public void issueBook(BookInfo b, String issueDate, String dueDate) {
        if (issuedCount < maxBooksAllowed && !b.isIssued) {
            issuedBooks[issuedCount++] = b;
            b.isIssued = true;
            b.issueDate = issueDate;
            b.dueDate = dueDate;
            System.out.println("Book " + b.title + " issued to " + userName);
        } else {
            System.out.println("Cannot issue book. Limit reached or book already issued.");
        }
    }

    public void returnBook(BookInfo b, String returnDate) {
        for (int i = 0; i < issuedCount; i++) {
            if (issuedBooks[i] != null && issuedBooks[i].bookId.equals(b.bookId)) {
                double fine = calculateFine(b.dueDate, returnDate);
                totalFines += fine;
                System.out.println("Book returned: " + b.title + ". Fine: ₹" + fine);

                issuedBooks[i] = null;
                b.isIssued = false;
                b.issueDate = null;
                b.dueDate = null;
                issuedCount--;
                return;
            }
        }
        System.out.println("Book not found in issued list.");
    }

    private double calculateFine(String dueDate, String returnDate) {
        try {
            String[] d1 = dueDate.split("-");
            String[] d2 = returnDate.split("-");
            int dueDay = Integer.parseInt(d1[0]);
            int returnDay = Integer.parseInt(d2[0]);
            int overdueDays = returnDay - dueDay;
            if (overdueDays > 0) return overdueDays * finePerDay;
        } catch (Exception e) {
            System.out.println("Invalid date format. Expected dd-mm.");
        }
        return 0;
    }

    public void renewBook(BookInfo b, String newDueDate) {
        if (b.isIssued) {
            b.dueDate = newDueDate;
            System.out.println("Book " + b.title + " renewed. New due date: " + newDueDate);
        } else {
            System.out.println("Book not issued.");
        }
    }

    public void displayIssuedBooks() {
        System.out.println("Books issued to " + userName + ":");
        for (BookInfo b : issuedBooks) {
            if (b != null) {
                System.out.println(" - " + b.title + " (Due: " + b.dueDate + ")");
            }
        }
    }

    public static void generateLibraryReport(List<User> users, List<BookInfo> books) {
        System.out.println("\n===== LIBRARY REPORT =====");
        System.out.println("Library: " + libraryName);
        System.out.println("Total Books: " + BookInfo.totalBooks);
        System.out.println("Total Users: " + totalUsers);

        double totalFine = 0;
        for (User u : users) {
            totalFine += u.totalFines;
        }
        System.out.println("Total Fines Collected: ₹" + totalFine);
    }

    public static void getOverdueBooks(List<User> users, String currentDate) {
        System.out.println("\n===== OVERDUE BOOKS =====");
        for (User u : users) {
            for (BookInfo b : u.issuedBooks) {
                if (b != null) {
                    try {
                        int due = Integer.parseInt(b.dueDate.split("-")[0]);
                        int today = Integer.parseInt(currentDate.split("-")[0]);
                        if (today > due) {
                            System.out.println("Overdue: " + b.title + " (User: " + u.userName + ")");
                        }
                    } catch (Exception e) {
                        continue;
                    }
                }
            }
        }
    }

    public static void getMostPopularBooks(List<User> users) {
        System.out.println("\n===== POPULAR BOOKS =====");
        Map<String, Integer> bookCount = new HashMap<>();
        for (User u : users) {
            for (BookInfo b : u.issuedBooks) {
                if (b != null) {
                    bookCount.put(b.title, bookCount.getOrDefault(b.title, 0) + 1);
                }
            }
        }
        bookCount.forEach((book, count) -> {
            if (count > 0) {
                System.out.println(book + " borrowed " + count + " times.");
            }
        });
    }
}

public class LibraryApp {
    public static void main(String[] args) {
        List<BookInfo> books = new ArrayList<>();
        List<User> users = new ArrayList<>();

        books.add(new BookInfo("B101", "Java Programming", "James Gosling", "ISBN001", "Programming"));
        books.add(new BookInfo("B102", "Database Systems", "Elmasri", "ISBN002", "Database"));
        books.add(new BookInfo("B103", "Operating System", "Silberschatz", "ISBN003", "Systems"));

        User u1 = new User("U101", "Alice", "Student", "01-01");
        User u2 = new User("U102", "Bob", "Faculty", "05-01");

        users.add(u1);
        users.add(u2);

        u1.issueBook(books.get(0), "01-09", "05-09");
        u2.issueBook(books.get(1), "02-09", "06-09");

        u1.displayIssuedBooks();
        u2.displayIssuedBooks();

        u1.returnBook(books.get(0), "08-09");
        u2.renewBook(books.get(1), "12-09");

        User.generateLibraryReport(users, books);
        User.getOverdueBooks(users, "10-09");
        User.getMostPopularBooks(users);
    }
}

