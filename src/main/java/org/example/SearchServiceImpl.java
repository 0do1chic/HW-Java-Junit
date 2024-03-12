package org.example;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class SearchServiceImpl implements SearchService{

    @Override
    public List<String> findLeapYearNames(List<AbstractAnimal> AnimalsList) {
        return AnimalsList.stream().filter(x -> x.birthDate.getYear()%4 == 0).map(AbstractAnimal::getName).toList();

    }

    @Override
    public List<AbstractAnimal> findOlderAnimal(List<AbstractAnimal> AnimalsList, int N) {
        return AnimalsList.stream().filter(x -> ((LocalDate.now().getYear() - x.birthDate.getYear() > N+1) |
                (LocalDate.now().getYear() - x.birthDate.getYear() > N) &
                        (x.birthDate.getMonthValue()<LocalDate.now().getMonthValue()) |
                                ((LocalDate.now().getYear() - x.birthDate.getYear() > N) &
                                        (x.birthDate.getMonthValue() == LocalDate.now().getMonthValue()) &
                                        (x.birthDate.getDayOfMonth()<=LocalDate.now().getDayOfMonth())))).toList();
    }

    @Override
    public List<AbstractAnimal> findDuplicate(List<AbstractAnimal> AnimalsList) {
        List<AbstractAnimal> duplicates = AnimalsList;
        return AnimalsList.stream()
                .filter(e -> AnimalsList.indexOf(e) != AnimalsList.lastIndexOf(e) & e != AnimalsList.get(AnimalsList.indexOf(e)))
                .toList();
        /*List<AbstractAnimal> duplicates1 = AnimalsList
            .stream()
            .collect(Collectors.groupingBy(n -> n, Collectors.counting())
            .stream()
            .collect(Collectors.groupingBy(n -> n, Collectors.counting())
            .entrySet()
            .stream()
            .filter(e -> e.getValue() > 1)
            .map(e -> e.getKey())
            .collect(Collectors.toList());*/
        //return duplicates1;
    }
    public void printFindDuplicate(List<AbstractAnimal> AnimalsList){
        System.out.println(findDuplicate(AnimalsList));
    }
}
