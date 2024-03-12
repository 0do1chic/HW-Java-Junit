package org.example;

import java.time.LocalDate;

public class Lion extends Predator implements Genarators {

    public Lion(String breed, String name, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }

    public Lion() {
    }

    public void createLion(Lion lion) {
        lion.breed = generateRandomBreed();
        lion.name = generateRandomName();
        lion.cost = generateRandomCost();
        lion.character = "Aggressive";
        lion.birthDate =generateRandomDate();

    }

    @Override
    public String toString() {
        return "Lion{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public String generateRandomBreed() {
        String[] names = {"Panthera leo leo", "Panthera leo persica", "Panthera leo senegalensis", "Panthera leo azandica", "Panthera leo nubica"};
        int randomIndex = (int) (Math.random() * (names.length));
        return names[randomIndex];
    }

    @Override
    public double generateRandomCost() {
        return 2500 + Math.random() * (5000 - 2500 + 1);
    }
}



