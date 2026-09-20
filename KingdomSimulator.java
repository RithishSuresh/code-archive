package week4;

import java.util.*;

abstract class MagicalStructure {
    protected String structureName;
    protected int magicPower;
    protected String location;
    protected boolean isActive;

    public MagicalStructure() {
        this("Unknown Structure", 50, "Unknown", true);
    }

    public MagicalStructure(String structureName, int magicPower) {
        this(structureName, magicPower, "Unknown", true);
    }

    public MagicalStructure(String structureName, int magicPower, String location, boolean isActive) {
        this.structureName = structureName;
        this.magicPower = magicPower;
        this.location = location;
        this.isActive = isActive;
    }

    public abstract void castMagicSpell();

    public String getName() {
        return structureName;
    }

    public int getMagicPower() {
        return magicPower;
    }
}

class WizardTower extends MagicalStructure {
    private int spellCapacity;
    private String[] knownSpells;

    public WizardTower() {
        this("Wizard Tower", 100, "Hilltop", true, 3, new String[]{"Fireball"});
    }

    public WizardTower(String[] basicSpells) {
        this("Wizard Tower", 120, "Mountain", true, basicSpells.length, basicSpells);
    }

    public WizardTower(String name, int power, String location, boolean isActive,
                       int spellCapacity, String[] knownSpells) {
        super(name, power, location, isActive);
        this.spellCapacity = spellCapacity;
        this.knownSpells = knownSpells;
    }

    @Override
    public void castMagicSpell() {
        if (knownSpells.length > 0) {
            System.out.println(structureName + " casts " + knownSpells[new Random().nextInt(knownSpells.length)] + "!");
        } else {
            System.out.println(structureName + " has no spells to cast!");
        }
    }

    public int getSpellCapacity() {
        return spellCapacity;
    }

    public void doubleSpellCapacity() {
        this.spellCapacity *= 2;
        System.out.println(structureName + " knowledge boosted! Capacity doubled to " + spellCapacity);
    }
}

class EnchantedCastle extends MagicalStructure {
    private int defenseRating;
    private boolean hasDrawbridge;

    public EnchantedCastle() {
        this("Enchanted Castle", 80, "Valley", true, 200, true);
    }

    public EnchantedCastle(String name, int rating) {
        this(name, 90, "City Center", true, rating, false);
    }

    public EnchantedCastle(String name, int power, String location, boolean isActive,
                           int defenseRating, boolean hasDrawbridge) {
        super(name, power, location, isActive);
        this.defenseRating = defenseRating;
        this.hasDrawbridge = hasDrawbridge;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " emits protective aura! Defense rating: " + defenseRating);
    }

    public void tripleDefense() {
        this.defenseRating *= 3;
        System.out.println(structureName + " is guarded by a dragon! Defense tripled to " + defenseRating);
    }
}

class MysticLibrary extends MagicalStructure {
    private int bookCount;
    private String ancientLanguage;

    public MysticLibrary() {
        this("Mystic Library", 70, "Forest", true, 100, "Latin");
    }

    public MysticLibrary(int bookCount, String lang) {
        this("Mystic Library", 85, "Town", true, bookCount, lang);
    }

    public MysticLibrary(String name, int power, String location, boolean isActive,
                         int bookCount, String lang) {
        super(name, power, location, isActive);
        this.bookCount = bookCount;
        this.ancientLanguage = lang;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " whispers ancient knowledge in " + ancientLanguage + "...");
    }
}

class DragonLair extends MagicalStructure {
    private String dragonType;
    private int treasureValue;

    public DragonLair() {
        this("Dragon Lair", 150, "Cave", true, "Fire Dragon", 1000);
    }

    public DragonLair(String dragonType, int value) {
        this("Dragon Lair", 160, "Volcano", true, dragonType, value);
    }

    public DragonLair(String name, int power, String location, boolean isActive,
                      String dragonType, int treasureValue) {
        super(name, power, location, isActive);
        this.dragonType = dragonType;
        this.treasureValue = treasureValue;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " with " + dragonType + " breathes destruction!");
    }
}

class KingdomManager {
    public static boolean canStructuresInteract(MagicalStructure s1, MagicalStructure s2) {
        return (s1.isActive && s2.isActive);
    }

    public static String performMagicBattle(MagicalStructure attacker, MagicalStructure defender) {
        if (attacker.getMagicPower() > defender.getMagicPower()) {
            return attacker.getName() + " wins the magical battle against " + defender.getName();
        } else if (attacker.getMagicPower() < defender.getMagicPower()) {
            return defender.getName() + " defends successfully against " + attacker.getName();
        } else {
            return "The battle between " + attacker.getName() + " and " + defender.getName() + " ends in a draw!";
        }
    }

    public static int calculateKingdomMagicPower(MagicalStructure[] structures) {
        int total = 0;
        for (MagicalStructure s : structures) {
            total += s.getMagicPower();
        }
        return total;
    }

    public static void applySpecialInteractions(MagicalStructure[] structures) {
        for (MagicalStructure s1 : structures) {
            for (MagicalStructure s2 : structures) {
                if (s1 != s2) {
                    if (s1 instanceof WizardTower && s2 instanceof MysticLibrary) {
                        ((WizardTower) s1).doubleSpellCapacity();
                    }
                    if (s1 instanceof EnchantedCastle && s2 instanceof DragonLair) {
                        ((EnchantedCastle) s1).tripleDefense();
                    }
                }
            }
        }
    }

    public static void categorizeStructures(MagicalStructure[] structures) {
        int towers = 0, castles = 0, libraries = 0, lairs = 0;
        for (MagicalStructure s : structures) {
            if (s instanceof WizardTower) towers++;
            else if (s instanceof EnchantedCastle) castles++;
            else if (s instanceof MysticLibrary) libraries++;
            else if (s instanceof DragonLair) lairs++;
        }
        System.out.println("\n--- Kingdom Structure Report ---");
        System.out.println("Wizard Towers: " + towers);
        System.out.println("Enchanted Castles: " + castles);
        System.out.println("Mystic Libraries: " + libraries);
        System.out.println("Dragon Lairs: " + lairs);
    }
}

public class KingdomSimulator {
    public static void main(String[] args) {
        System.out.println("=== MEDIEVAL KINGDOM BUILDER ===");

        MagicalStructure t1 = new WizardTower(new String[]{"Lightning", "Teleport"});
        MagicalStructure c1 = new EnchantedCastle("Royal Castle", 250);
        MagicalStructure l1 = new MysticLibrary(500, "Greek");
        MagicalStructure d1 = new DragonLair("Ice Dragon", 2000);

        MagicalStructure[] kingdom = {t1, c1, l1, d1};

        for (MagicalStructure s : kingdom) {
            s.castMagicSpell();
        }

        KingdomManager.applySpecialInteractions(kingdom);

        System.out.println("\n" + KingdomManager.performMagicBattle(t1, d1));
        System.out.println("Total Kingdom Magic Power: " + KingdomManager.calculateKingdomMagicPower(kingdom));
        KingdomManager.categorizeStructures(kingdom);
    }
}
