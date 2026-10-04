package week9;
class ContactInfo implements Cloneable {
    String email;
    String phone;

    public ContactInfo(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Email: " + email + ", Phone: " + phone;
    }
}

class Student implements Cloneable {
    String id;
    String name;
    ContactInfo contact;

    public Student(String id, String name, ContactInfo contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    protected Object shallowClone() throws CloneNotSupportedException {
        return super.clone();
    }

    protected Object deepClone() throws CloneNotSupportedException {
        Student cloned = (Student) super.clone();
        cloned.contact = (ContactInfo) contact.clone();
        return cloned;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", " + contact;
    }
}

public class Registration {
    public static void main(String[] args) throws CloneNotSupportedException {
        ContactInfo contact = new ContactInfo("student@mail.com", "9876543210");
        Student original = new Student("S101", "Rithish", contact);

        Student shallowCopy = (Student) original.shallowClone();
        Student deepCopy = (Student) original.deepClone();

        System.out.println("Before change:");
        System.out.println("Original: " + original);
        System.out.println("Shallow: " + shallowCopy);
        System.out.println("Deep: " + deepCopy);

        original.contact.email = "updated@mail.com";

        System.out.println("\nAfter changing original contact email:");
        System.out.println("Original: " + original);
        System.out.println("Shallow: " + shallowCopy);
        System.out.println("Deep: " + deepCopy);
    }
}

