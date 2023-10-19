package IteratorsAndComparatorsExercise.Froggy;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer>{
    private List<Integer> numbers;

    public Lake(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }
    private class Frog implements Iterator<Integer> {
        private int evenIndex = 0;
        private int oddIndex = 1;
        @Override
        public boolean hasNext() {
            return evenIndex < numbers.size() || oddIndex < numbers.size();
        }

        @Override
        public Integer next() {
            if (evenIndex < numbers.size()) {
                int evenNum = numbers.get(evenIndex);
                evenIndex += 2;
                return evenNum;
            }
            else {
                int oddNum = numbers.get(oddIndex);
                oddIndex += 2;
                return oddNum;
            }

        }
    }
}
