package week4;

import java.util.Random;
import java.util.UUID;

public class VirtualPet {
    private final String petId;
    private String petName;
    private String species;
    private int age;
    private int happiness;
    private int health;
    private String stage;

    private static final String[] EVOLUTION_STAGES = {"Egg", "Baby", "Child", "Teen", "Adult", "Elder"};
    private static int totalPetsCreated = 0;


    public VirtualPet() {
        this("Unknown", getRandomSpecies(), 0, 50, 50, EVOLUTION_STAGES[0]);
    }

    public VirtualPet(String petName) {
        this(petName, getRandomSpecies(), 1, 60, 60, EVOLUTION_STAGES[1]);
    }


    public VirtualPet(String petName, String species) {
        this(petName, species, 2, 70, 70, EVOLUTION_STAGES[2]);
    }


    public VirtualPet(String petName, String species, int age, int happiness, int health, String stage) {
        this.petId = generatePetId();
        this.petName = petName;
        this.species = species;
        this.age = age;
        this.happiness = happiness;
        this.health = health;
        this.stage = stage;
        totalPetsCreated++;
        System.out.println("Pet Created: " + petName + " (" + petId + ")");
    }


    public static String generatePetId() {
        return UUID.randomUUID().toString();
    }

    private static String getRandomSpecies() {
        String[] speciesList = {"Dragon", "Cat", "Dog", "Phoenix", "Slime"};
        Random rand = new Random();
        return speciesList[rand.nextInt(speciesList.length)];
    }


    public void evolvePet() {
        if (stage.equals("Ghost")) return;
        int stageIndex = getStageIndex(stage);
        if (stageIndex < EVOLUTION_STAGES.length - 1 && age >= stageIndex + 2 && health > 0) {
            stage = EVOLUTION_STAGES[stageIndex + 1];
            System.out.println(petName + " evolved into " + stage + "!");
        }
    }

    private int getStageIndex(String currentStage) {
        for (int i = 0; i < EVOLUTION_STAGES.length; i++) {
            if (EVOLUTION_STAGES[i].equals(currentStage)) {
                return i;
            }
        }
        return 0;
    }

    // Interaction methods
    public void feedPet() {
        if (!stage.equals("Ghost")) {
            happiness += 5;
            health += 5;
            System.out.println(petName + " enjoyed a meal!");
        }
    }

    public void playWithPet() {
        if (!stage.equals("Ghost")) {
            happiness += 10;
            health -= 2;
            System.out.println(petName + " had fun playing!");
        }
    }

    public void healPet() {
        if (!stage.equals("Ghost")) {
            health += 15;
            System.out.println(petName + " feels better now!");
        }
    }

    // Simulation of a day passing
    public void simulateDay() {
        if (stage.equals("Ghost")) return;

        age++;
        Random rand = new Random();
        happiness -= rand.nextInt(6); // lose 0-5 happiness
        health -= rand.nextInt(6);    // lose 0-5 health

        if (health <= 0) {
            stage = "Ghost";
            health = 0;
            System.out.println(petName + " has died and become a Ghost...");
        } else {
            evolvePet();
        }
    }

    public String getPetStatus() {
        return "Pet [" + petName + "] | Species: " + species + " | Age: " + age +
                " | Happiness: " + happiness + " | Health: " + health +
                " | Stage: " + stage;
    }

    public static int getTotalPetsCreated() {
        return totalPetsCreated;
    }

    public static void main(String[] args) {
        System.out.println("=== VIRTUAL PET DAYCARE ===");

        VirtualPet pet1 = new VirtualPet();
        VirtualPet pet2 = new VirtualPet("Luna");
        VirtualPet pet3 = new VirtualPet("Blaze", "Dragon");
        VirtualPet pet4 = new VirtualPet("Max", "Dog", 3, 80, 90, "Teen");

        VirtualPet[] daycare = {pet1, pet2, pet3, pet4};

        for (int day = 1; day <= 5; day++) {
            System.out.println("\n--- Day " + day + " ---");
            for (VirtualPet pet : daycare) {
                pet.simulateDay();
                pet.feedPet();
                pet.playWithPet();
                pet.displayStatus();
            }
        }

        System.out.println("\nTotal Pets Created: " + VirtualPet.getTotalPetsCreated());
    }

    public void displayStatus() {
        System.out.println(getPetStatus());
    }
}
