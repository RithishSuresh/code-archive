import java.util.ArrayList;
import java.util.List;

class CloneableBook implements Cloneable {
    String title;
    String author;

    public CloneableBook(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Book[Title=" + title + ", Author=" + author + "]";
    }
}

public class LibraryCloneDemo implements Cloneable {
    List<CloneableBook> books;

    public LibraryCloneDemo() {
        books = new ArrayList<>();
    }

    public void addBook(CloneableBook book) {
        books.add(book);
    }

    protected Object shallowClone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        LibraryCloneDemo clonedLibrary = (LibraryCloneDemo) super.clone();
        clonedLibrary.books = new ArrayList<>();
        for (CloneableBook b : books) {
            clonedLibrary.books.add((CloneableBook) b.clone());
        }
        return clonedLibrary;
    }

    @Override
    public String toString() {
        return books.toString();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        LibraryCloneDemo library1 = new LibraryCloneDemo();
        library1.addBook(new CloneableBook("1984", "George Orwell"));
        library1.addBook(new CloneableBook("Brave New World", "Aldous Huxley"));

        LibraryCloneDemo shallowCopy = (LibraryCloneDemo) library1.shallowClone();
        LibraryCloneDemo deepCopy = (LibraryCloneDemo) library1.clone();

        System.out.println("Before modification:");
        System.out.println("Original: " + library1);
        System.out.println("Shallow Copy: " + shallowCopy);
        System.out.println("Deep Copy: " + deepCopy);

        shallowCopy.books.get(0).title = "Changed by Shallow Copy";
        deepCopy.books.get(1).title = "Changed by Deep Copy";

        System.out.println("\nAfter modification:");
        System.out.println("Original: " + library1);
        System.out.println("Shallow Copy: " + shallowCopy);
        System.out.println("Deep Copy: " + deepCopy);
    }
}
