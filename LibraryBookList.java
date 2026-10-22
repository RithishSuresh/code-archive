class LibraryBook {
    String title;
    String author;

    LibraryBook(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

public class LibraryBookList {
    // Method to print books by a specific author
    static void printBooksByAuthor(LibraryBook[] books, String authorName) {
        for (LibraryBook b : books) {
            if (b.author.equalsIgnoreCase(authorName)) {
                System.out.println(b.title + " by " + b.author);
            }
        }
    }

    public static void main(String[] args) {
        // Create array of 5 LibraryBook objects
        LibraryBook[] books = {
                new LibraryBook("C Programming", "Robert White"),
                new LibraryBook("Python Essentials", "Emma Clark"),
                new LibraryBook("OOP in Java", "Robert White"),
                new LibraryBook("Data Science Basics", "Liam Harris"),
                new LibraryBook("Machine Learning", "Robert White")
        };

        // Print all books written by the given author
        printBooksByAuthor(books, "Robert White");
    }
}

