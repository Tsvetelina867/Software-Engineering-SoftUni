package IteratorsAndComparatorsExercise.StrategyPattern;

import IteratorsAndComparatorsExercise.StrategyPattern.Person;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        if (p1.getAge() > p2.getAge()) {
            return 1;
        } else if (p1.getAge() < p2.getAge()) {
            return -1;
        }
        return 0;
    }
}
