package Week7;
abstract class Character {
    String name;
    Character(String name) {
        this.name = name;
    }
    abstract void attack();
}

class Warrior extends Character {
    Warrior(String name) {
        super(name);
    }
    void attack() {
        System.out.println(name + " attacks with a sword and has high defense!");
    }
}

class Mage extends Character {
    Mage(String name) {
        super(name);
    }
    void attack() {
        System.out.println(name + " casts a powerful spell using mana!");
    }
}

class Archer extends Character {
    Archer(String name) {
        super(name);
    }
    void attack() {
        System.out.println(name + " shoots an arrow with long-range precision!");
    }
}

public class GamingCharacterSystem {
    public static void main(String[] args) {
        Character[] army = {
                new Warrior("Thor"),
                new Mage("Merlin"),
                new Archer("Robin")
        };

        for (Character c : army) {
            c.attack();
        }
    }
}
