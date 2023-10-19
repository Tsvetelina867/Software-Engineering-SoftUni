package IteratorsAndComparatorsExercise.ListyIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    List<String> list;
    private int currentIndex;

    public ListyIterator(String... strings) {
        this.list = Arrays.asList(strings);
        this.currentIndex = 0;
    }

    public boolean move() {
        if (hasNext()) {
            currentIndex++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return this.currentIndex < list.size() - 1;
    }

    public void print() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
        System.out.println(list.get(currentIndex));
    }

    @Override
    public Iterator<String> iterator() {
        return new ListIterator();
        }
        private  class ListIterator implements Iterator<String> {
        int index = 0;
                @Override
                public boolean hasNext() {
                    return index < list.size();
                }

                @Override
                public String next() {
                    return list.get(index++);
                }
            };
        }


