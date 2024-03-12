package org.example;

import java.util.List;

public interface SearchService {
    List<String> findLeapYearNames(List<AbstractAnimal> list);
    List<AbstractAnimal> findOlderAnimal(List<AbstractAnimal> list, int N);
    List<AbstractAnimal> findDuplicate(List<AbstractAnimal> list);
}
