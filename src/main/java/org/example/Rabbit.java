package org.example;

import java.time.LocalDate;

public class Rabbit extends Pet implements Genarators{
    public Rabbit(String breed, String name, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }

    public Rabbit() {
    }

    public void CreateRabbit(Rabbit rabbit){
        rabbit.breed = generateRandomBreed();
        rabbit.name = generateRandomName();
        rabbit.cost = generateRandomCost();
        rabbit.character = "Not aggressive";
        rabbit.birthDate = generateRandomDate();

    }

    @Override
    public String toString() {
        return "Rabbit{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public String generateRandomBreed() {
        String[] names = {"Blanc de Hotot", "American", "Blue Holicer", "Britannia Petite", "Californian"};
        int randomIndex = (int) (Math.random() * names.length);
        return names[randomIndex];
    }

    @Override
    public double generateRandomCost() {
        return 20 + Math.random() * (200 - 20 + 1);
    }
}