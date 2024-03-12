package org.example;

import java.time.LocalDate;

public class Wolf extends Predator implements Genarators{

    public Wolf(String breed, String name, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }

    public Wolf() {
    }

    public void CreateWolf(Wolf wolf) {
        wolf.breed = generateRandomBreed();
        wolf.name = generateRandomName();
        wolf.cost = generateRandomCost();
        wolf.character = "Aggressive";
        wolf.birthDate = generateRandomDate();

    }

    @Override
    public String toString() {
        return "Wolf{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public String generateRandomBreed() {
        String[] names = {"Baffin Island", "Steppe", "Tundra", "Mexican", "Red"};
        int randomIndex = (int) (Math.random() * names.length);
        return names[randomIndex];
    }

    @Override
    public double generateRandomCost() {
        return 2500 + Math.random() * (5000 - 2500 + 1);
    }
}
