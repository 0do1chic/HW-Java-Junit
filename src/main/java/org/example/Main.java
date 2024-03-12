package org.example;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        CreateAnimalServiceImpl ten1 = new CreateAnimalServiceImpl();
        CreateAnimalService ten2 = new CreateAnimalServiceImpl();

        ten2.CreateTenAnimals();
        System.out.println("/////////////////////////////////////////////////////////////////////////");

        SearchServiceImpl foundation = new SearchServiceImpl();
        List<AbstractAnimal> animals = ten1.CreateTenAnimals(20);
        System.out.println("======================================================================================");
        System.out.println(foundation.findLeapYearNames(animals));
        System.out.println("======================================================================================");
        System.out.println(foundation.findOlderAnimal(animals, 4));
        System.out.println("======================================================================================");
        foundation.printFindDuplicate(animals);

    }

}