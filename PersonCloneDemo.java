package Week9;
class Address implements Cloneable {
    String city;
    String state;

    public Address(String city, String state) {
        this.city = city;
        this.state = state;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return city + ", " + state;
    }
}

public class PersonCloneDemo implements Cloneable {
    String name;
    Address address;

    public PersonCloneDemo(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        PersonCloneDemo cloned = (PersonCloneDemo) super.clone();
        cloned.address = new Address(address.city, address.state);
        return cloned;
    }

    @Override
    public String toString() {
        return "Person[Name=" + name + ", Address=" + address + "]";
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Address addr = new Address("Chennai", "Tamil Nadu");
        PersonCloneDemo p1 = new PersonCloneDemo("Rithish", addr);
        PersonCloneDemo p2 = (PersonCloneDemo) p1.clone();

        System.out.println("Before change:");
        System.out.println("Original: " + p1);
        System.out.println("Cloned: " + p2);

        p2.address.city = "Coimbatore";

        System.out.println("After change:");
        System.out.println("Original: " + p1);
        System.out.println("Cloned: " + p2);
    }
}

