package org.example;

import org.junit.jupiter.api.*;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AbstractAnimalTest {

    @Nested
    @DisplayName("Проверка переопределенного метода equals")
    class EqualsMethodTest {
        LocalDate date = LocalDate.now();
        Lion animal1 = new Lion("Panthera leo leo", "Bruno", 3332.5686972272742, "Aggressive", date);
        Lion animal2 = new Lion("Panthera leo leo", "Bruno", 3332.5686972272742, "Aggressive", date);
        Lion animal3 = new Lion("Panthera leo", "Bruno", 3332.5686972272741, "Aggressive", date);

        @Test
        @DisplayName("Сравнение с равным объектом")
        void testEquals1() {
            assertTrue(animal1.equals(animal2));
            assertTrue(animal2.equals(animal1));
        }

        @Test
        @DisplayName("Сравнение с не равным объектом")
        void testEquals2() {
            assertFalse(animal1.equals(animal3));
        }

        @Test
        @DisplayName("Сравнение с null")
        void testEquals3() {
            assertFalse(animal1.equals(null));
        }

        }


    }
