package GenericsExercise.CustomList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomList<T extends Comparable<T>> {

    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public List<T> getList() {
        return list;
    }

    public void add(T element) {
        list.add(element);
    }
    public T remove(int index) {
        return list.remove(index);
    }
    public boolean contains(T element) {
        return list.contains(element);
    }
    public void swap(int index1, int index2) {
        T itemAtFirstIndex = list.get(index1);
        T itemAtSecondIndex = list.get(index2);
        list.set(index1, itemAtSecondIndex);
        list.set(index2, itemAtFirstIndex);
    }

    public long countGreaterThan(T element) {
        return list.stream().filter(item -> item.compareTo(element) > 0).count();
    }

    public T getMax() {
        return list.stream().max(Comparator.naturalOrder()).get();
    }

    public T getMin() {
        return list.stream().min(Comparator.naturalOrder()).get();
    }

    public void print() {
        list.forEach(System.out::println);
    }

}
