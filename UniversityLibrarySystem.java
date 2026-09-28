package Week7;
class LibraryUser {
    String name;
    LibraryUser(String name) { this.name = name; }
    void accessLibrary() { System.out.println(name + " is accessing the library."); }
}

class LibraryStudent extends LibraryUser {
    LibraryStudent(String name) { super(name); }
    void accessLibrary() { System.out.println(name + " (Student) borrows books and uses computers."); }
}

class LibraryFaculty extends LibraryUser {
    LibraryFaculty(String name) { super(name); }
    void accessLibrary() { System.out.println(name + " (Faculty) reserves books and accesses research databases."); }
}

class LibraryGuest extends LibraryUser {
    LibraryGuest(String name) { super(name); }
    void accessLibrary() { System.out.println(name + " (Guest) can only browse books."); }
}

public class UniversityLibrarySystem {
    public static void main(String[] args) {
        LibraryUser[] users = {
                new LibraryStudent("Alice"),
                new LibraryFaculty("Dr. Bob"),
                new LibraryGuest("Charlie")
        };

        for (LibraryUser user : users) {
            user.accessLibrary();
        }
    }
}

