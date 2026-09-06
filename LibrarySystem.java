package week3;
class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    private static int totalBooks = 0;
    private static int availableBooks = 0;
    private static int bookCounter = 0;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.bookId = generateBookId();
        this.isAvailable = true;
        totalBooks++;
        availableBooks++;
    }

    public boolean issueBook() {
        if (isAvailable) {
            isAvailable = false;
            availableBooks--;
            return true;
        } else {
            System.out.println("Book " + bookId + " is not available.");
            return false;
        }
    }

    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            availableBooks++;
        }
    }

    public void displayBookInfo() {
        System.out.println("--------------- Book Info ---------------");
        System.out.println("Book ID     : " + bookId);
        System.out.println("Title       : " + title);
        System.out.println("Author      : " + author);
        System.out.println("Available   : " + (isAvailable ? "Yes" : "No"));
        System.out.println("-----------------------------------------");
    }

    public String getBookId() {
        return bookId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    private static String generateBookId() {
        bookCounter++;
        return String.format("B%03d", bookCounter);
    }

    public static int getTotalBooks() {
        return totalBooks;
    }

    public static int getAvailableBooks() {
        return availableBooks;
    }
}

class Member {
    private String memberId;
    private String memberName;
    private String[] booksIssued;
    private int bookCount;

    private static int memberCounter = 0;

    public Member(String memberName, int maxBooks) {
        this.memberName = memberName;
        this.memberId = generateMemberId();
        this.booksIssued = new String[maxBooks];
        this.bookCount = 0;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            if (bookCount < booksIssued.length) {
                if (book.issueBook()) {
                    booksIssued[bookCount++] = book.getBookId();
                    System.out.println(memberName + " borrowed " + book.getBookId());
                }
            } else {
                System.out.println(memberName + " cannot borrow more books (limit reached).");
            }
        } else {
            System.out.println("Book " + book.getBookId() + " is not available.");
        }
    }

    public void returnBook(String bookId, Book[] books) {
        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            if (booksIssued[i].equals(bookId)) {
                for (Book b : books) {
                    if (b.getBookId().equals(bookId)) {
                        b.returnBook();
                        System.out.println(memberName + " returned " + bookId);
                        found = true;
                        for (int j = i; j < bookCount - 1; j++) {
                            booksIssued[j] = booksIssued[j + 1];
                        }
                        booksIssued[--bookCount] = null;
                        break;
                    }
                }
                break;
            }
        }
        if (!found) {
            System.out.println(memberName + " did not issue " + bookId);
        }
    }

    public void displayMemberInfo() {
        System.out.println("--------------- Member Info ---------------");
        System.out.println("Member ID   : " + memberId);
        System.out.println("Name        : " + memberName);
        System.out.print("Books Issued: ");
        if (bookCount == 0) {
            System.out.println("None");
        } else {
            for (int i = 0; i < bookCount; i++) {
                System.out.print(booksIssued[i] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------");
    }

    private static String generateMemberId() {
        memberCounter++;
        return String.format("M%03d", memberCounter);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Book[] books = new Book[3];
        books[0] = new Book("The Hobbit", "J.R.R. Tolkien");
        books[1] = new Book("1984", "George Orwell");
        books[2] = new Book("Clean Code", "Robert C. Martin");

        Member[] members = new Member[2];
        members[0] = new Member("Alice", 2);
        members[1] = new Member("Bob", 3);

        for (Book b : books) {
            b.displayBookInfo();
        }
        for (Member m : members) {
            m.displayMemberInfo();
        }

        members[0].borrowBook(books[0]);
        members[1].borrowBook(books[1]);
        members[0].borrowBook(books[1]);

        members[0].returnBook("B001", books);
        members[1].returnBook("B002", books);

        System.out.println("\nFinal State:");
        for (Book b : books) {
            b.displayBookInfo();
        }
        for (Member m : members) {
            m.displayMemberInfo();
        }

        System.out.println("Total Books    : " + Book.getTotalBooks());
        System.out.println("Available Books: " + Book.getAvailableBooks());
    }
}

