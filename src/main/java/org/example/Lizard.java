package org.example;

import java.time.LocalDate;

public class Lizard extends Pet implements Genarators{


    public Lizard(String breed, String name, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }

    public Lizard() {
    }

    public void CreateLizard(Lizard lizard){
        lizard.breed = generateRandomBreed();
        lizard.name = generateRandomName();
        lizard.cost = generateRandomCost();
        lizard.character = "Not aggressive";
        lizard.birthDate= generateRandomDate();


    }
    @Override
    public String toString() {
        return "Lizard{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
    @Override
    public String generateRandomBreed() {
        String[] names = {"Algyroides", "Lacerta", "Podarcis", "Timon", "Zootoca"};
        int randomIndex = (int) (Math.random() * names.length);
        return names[randomIndex];
    }

    @Override
    public double generateRandomCost() {
        return 20 + Math.random() * (300 - 20 + 1);
    }
}

