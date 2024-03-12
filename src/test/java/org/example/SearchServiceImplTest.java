package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

import java.util.ArrayList;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SearchServiceImplTest {

    List<AbstractAnimal> animals = new ArrayList<>();
    SearchServiceImpl foundation = new SearchServiceImpl();
    LocalDate date = LocalDate.now();
    @Nested
    @DisplayName("Проверка метода findLeapYearNames")
    class findLeapYearNamesTest {
        List<String> namesList = List.of("Archie", "Alto", "Bruno", "Charlie", "James");

        @DisplayName("Выполнение в обычных условиях")
        @Test
        void findLeapYearNamesTest1() {
            for (int i = 0; i < 5; i++){
                Lion lion = new Lion("Panthera leo leo", namesList.get(i), 3332.5686972272742, "Aggressive", date.minusYears(i));
                animals.add(lion);
            }
            assertEquals(foundation.findLeapYearNames(animals), List.of("Archie", "James"));
        }

        @DisplayName("Выполнение при отсутствии верных")
        @Test
        void findLeapYearNamesTest2() {
            for (int i = 1; i < 4; i++){
                Lion lion = new Lion("Panthera leo leo", namesList.get(i), 3332.5686972272742, "Aggressive", date.minusYears(i));
                animals.add(lion);
            }
            assertEquals(foundation.findLeapYearNames(animals), List.of());
        }

        @DisplayName("Выполнения при пустом входном массиве")
        @Test
        void findLeapYearNamesTest3() {
            assertEquals(foundation.findLeapYearNames(animals), List.of());
        }
    }

    @Nested
    @DisplayName("Проверка метода findOlderAnimal")
    class findOlderAnimalTest {

        @DisplayName("Года в этот же день")
        @ParameterizedTest(name = "{0} - верное определение")
        @ValueSource(ints = { 2024, 2023, 2022, 2021, 2020, 2019,2018,2017,2016})
        void findOlderAnimalTest1(int year) {
            Lion lion = new Lion("Panthera leo leo", "Leo", 3332.5686972272742, "Aggressive",
                    LocalDate.of(year, LocalDate.now().getMonthValue(),LocalDate.now().getDayOfMonth()));
            animals.add(lion);
            if (year < LocalDate.now().minusYears(2).getYear()){assertFalse(foundation.findOlderAnimal(animals,2).isEmpty());}
            else {assertTrue(foundation.findOlderAnimal(animals,2).isEmpty());}
        }
        @DisplayName("Года в завтрашнем дне")
        @ParameterizedTest(name = "{0} - верное определение")
        @ValueSource(ints = { 2024, 2023, 2022, 2021, 2020, 2019,2018,2017,2016})
        void findOlderAnimalTest2(int year) {
            Lion lion = new Lion("Panthera leo leo", "Leo", 3332.5686972272742, "Aggressive",
                    LocalDate.of(year, LocalDate.now().getMonthValue(),LocalDate.now().getDayOfMonth()+1));
            animals.add(lion);
            if (year < LocalDate.now().minusYears(3).getYear()){assertFalse(foundation.findOlderAnimal(animals,2).isEmpty());}
            else {assertTrue(foundation.findOlderAnimal(animals,2).isEmpty());}
        }

        @DisplayName("Месяца в этом году")
        @ParameterizedTest(name = "{0} - верное определение")
        @ValueSource(ints = { 1, 2, 3, 4, 5, 10, 12})
        void findOlderAnimalTest3(int month) {
            Lion lion = new Lion("Panthera leo leo", "Leo", 3332.5686972272742, "Aggressive",
                    LocalDate.of(LocalDate.now().minusYears(3).getYear(), month,LocalDate.now().getDayOfMonth()));
            animals.add(lion);
            if (month <= LocalDate.now().getMonthValue()){assertFalse(foundation.findOlderAnimal(animals,2).isEmpty());}
            else {assertTrue(foundation.findOlderAnimal(animals,2).isEmpty());}
        }

        @DisplayName("Дни в этот месяц")
        @ParameterizedTest(name = "{0} - верное определение")
        @ValueSource(ints = { 1, 2, 10, 11,12,14,17,19, 20, 28})
        void findOlderAnimalTest4(int day) {
            Lion lion = new Lion("Panthera leo leo", "Leo", 3332.5686972272742, "Aggressive",
                    LocalDate.of(LocalDate.now().minusYears(3).getYear(), LocalDate.now().getMonthValue(), day));
            animals.add(lion);
            if (day <= LocalDate.now().getDayOfMonth()){assertFalse(foundation.findOlderAnimal(animals,2).isEmpty());}
            else {assertTrue(foundation.findOlderAnimal(animals,2).isEmpty());}
        }


    }
    @Nested
    @DisplayName("Проверка метода findDuplicate")
    class findDuiplicateTest {
        List<AbstractAnimal> animals = new ArrayList<>();
        Lion lion1 = new Lion("Panthera leo leo", "Leo", 3332.5686972272742, "Aggressive", date);
        Lion lion2 = new Lion("Panthera leo leo", "Leo", 3332.5686972272742, "Aggressive", date);
        Lion lion3 = new Lion("Panthera leo leo", "Leo", 3332.5686972272742, "Aggressive", date);
        Lion lion4 = new Lion("Panthera leo leo", "Dima", 3332.5686972272742, "Aggressive", date);
        Lion lion5 = new Lion("Panthera leo leo", "Dima", 3332.5686972272742, "Aggressive", date);


        @DisplayName("Выполнение с 2-мя дубликатами")
        @Test
        void findDuplicateTest1() {
            animals.add(lion1);
            animals.add(lion2);
            animals.add(lion3);
            assertEquals(foundation.findDuplicate(animals), List.of(lion2,lion3));
        }
        @DisplayName("Выполнение без дубликатов")
        @Test
        void findDuplicateTest2() {
            animals.add(lion1);
            animals.add(lion4);
            assertEquals(foundation.findDuplicate(animals), List.of());
        }
        @DisplayName("Выполнение при пустом входном массиве")
        @Test
        void findDuplicateTest3() {
            assertEquals(foundation.findDuplicate(animals), List.of());
        }
        @DisplayName("Выполнение с разными дубликатами")
        @Test
        void findDuplicateTest4() {
            animals.add(lion1);
            animals.add(lion4);
            animals.add(lion3);
            animals.add(lion5);
            assertEquals(foundation.findDuplicate(animals), List.of(lion3,lion5));
        }
    }

}