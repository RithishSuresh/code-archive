package Week6;
public class HWGameDemo {
    public static void main(String[] args) {
        Game g1 = new Game("Generic Game", 2);
        Game g2 = new Game("Generic Game", 2);

        System.out.println("Game Objects:");
        System.out.println(g1);
        System.out.println("g1 equals g2? " + g1.equals(g2));
        System.out.println("g1 hashCode: " + g1.hashCode());
        System.out.println("g2 hashCode: " + g2.hashCode());

        System.out.println("\nCardGame Objects:");
        CardGame cg1 = new CardGame("Poker", 4, 52);
        CardGame cg2 = new CardGame("Poker", 4, 52);
        CardGame cg3 = new CardGame("Uno", 4, 108);

        System.out.println(cg1);
        System.out.println(cg2);
        System.out.println(cg3);

        System.out.println("cg1 equals cg2? " + cg1.equals(cg2));
        System.out.println("cg1 equals cg3? " + cg1.equals(cg3));
        System.out.println("cg1 hashCode: " + cg1.hashCode());
        System.out.println("cg2 hashCode: " + cg2.hashCode());
        System.out.println("cg3 hashCode: " + cg3.hashCode());
    }
}

class Game {
    protected String name;
    protected int numberOfPlayers;

    public Game(String name, int numberOfPlayers) {
        this.name = name;
        this.numberOfPlayers = numberOfPlayers;
    }

    @Override
    public String toString() {
        return "Game Name: " + name + ", Players: " + numberOfPlayers;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Game)) return false;
        Game other = (Game) obj;
        return this.name.equals(other.name) && this.numberOfPlayers == other.numberOfPlayers;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + numberOfPlayers * 31;
    }
}

class CardGame extends Game {
    private int numberOfCards;

    public CardGame(String name, int numberOfPlayers, int numberOfCards) {
        super(name, numberOfPlayers);
        this.numberOfCards = numberOfCards;
    }

    @Override
    public String toString() {
        return super.toString() + ", Cards: " + numberOfCards;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CardGame)) return false;
        CardGame other = (CardGame) obj;
        return super.equals(other) && this.numberOfCards == other.numberOfCards;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + numberOfCards * 17;
    }
}

