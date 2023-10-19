package IteratorsAndComparatorsExercise.StrategyPattern;

import IteratorsAndComparatorsExercise.StrategyPattern.Person;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        if (p1.getName().length() > p2.getName().length()) {
            return 1;
        } else if (p1.getName().length() < p2.getName().length()) {
            return -1;
        } else {
            String name1 = p1.getName().toLowerCase();
            String name2 = p2.getName().toLowerCase();
            if (name1.charAt(0) > name2.charAt(0)) {
                return 1;
            } else if (name1.charAt(0) < name2.charAt(0)) {
                return -1;
            }
        }
        return 0;
    }
}
