package org.example;

import java.util.ArrayList;
import java.util.List;

public interface CreateAnimalService {
    default void CreateTenAnimals() {
        int i = 0;
        List<AbstractAnimal> animals = new ArrayList<>();
        while (i < 10) {
            double k = 1 + (int) (Math.random() * (4 - 1 + 1));
            if (k == 1) {
                Lion lion = new Lion();
                lion.createLion(lion);
                animals.add(lion);
                System.out.println(lion.toString());
            } else if (k==2) {
                Lizard lizard = new Lizard();
                lizard.CreateLizard(lizard);
                animals.add(lizard);
                System.out.println(lizard.toString());
            }else if (k==3){
                Wolf wolf = new Wolf();
                wolf.CreateWolf(wolf);
                animals.add(wolf);
                System.out.println(wolf.toString());
            }else {
                Rabbit rabbit = new Rabbit();
                rabbit.CreateRabbit(rabbit);
                animals.add(rabbit);
                System.out.println(rabbit.toString());
            }
            i++;
        }
        System.out.println("Выполнено в интрефейсе!");
    }

}
