package org.example;

import java.time.LocalDate;

public interface Genarators { // создан для случайного генерирования полей

    String generateRandomBreed();

    default String generateRandomName(){
        String[] names = {"Archie", "Alto", "Bruno", "Charlie", "James", "Monroe", "Alice", "Maybelle", "Maggie", "Florence"};
        int randomIndex = (int) (Math.random() * names.length);
        return names[randomIndex];
    }

    double generateRandomCost();
    default LocalDate generateRandomDate(){
        int day = 1+(int) ( Math.random() * (365 - 1 + 1));
        int year = 2015+(int) ( Math.random() * (LocalDate.now().getYear() - 2015));
        return LocalDate.ofYearDay(year, day);
    }


}
