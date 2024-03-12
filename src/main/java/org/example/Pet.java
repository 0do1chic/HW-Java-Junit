package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pet extends AbstractAnimal{
    public Pet(String breed, String name, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }

    public Pet() {
    }
}
