
package Week8;

// Base interface
interface Animal {
    void eat();
}

// Interface extending Animal
interface Pet extends Animal {
    void play();
}

// Class implementing the Pet interface
class Dog implements Pet {
    private String name;

    Dog(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println(name + " is eating dog food.");
    }

    @Override
    public void play() {
        System.out.println(name + " is playing fetch.");
    }
}

// Main class to test
public class InterfaceDemo {
    public static void main(String[] args) {
        Dog myDog = new Dog("Buddy");

        // Call methods
        myDog.eat();   // From Animal interface
        myDog.play();  // From Pet interface
    }
}
