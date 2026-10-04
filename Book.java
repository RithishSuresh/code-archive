package Week9;
public class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return title.equals(book.title) && author.equals(book.author);
    }

    public static void main(String[] args) {
        Book b1 = new Book("1984", "George Orwell");
        Book b2 = new Book("1984", "George Orwell");
        Book b3 = b1;

        System.out.println(b1 == b2);
        System.out.println(b1.equals(b2));
        System.out.println(b1 == b3);
        System.out.println(b1.equals(b3));
    }
}

