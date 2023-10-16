package GenericsExercise.Box;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {

    private List<T> list;
    private T element;

    public List<T> getList() {
        return list;
    }


    public Box(List<T> list, T element) {
        this.list = list;
        this.element = element;
    }

    public boolean compare(T elementToCheck, T element) {
        return elementToCheck.compareTo(element) > 0;

    }

    public void add(T element) {
        list.add(element);
    }

    public void swap(List<T> list, int index1, int index2) {
        T itemAtFirstIndex = list.get(index1);
        T itemAtSecondIndex = list.get(index2);
        list.set(index1, itemAtSecondIndex);
        list.set(index2, itemAtFirstIndex);
    }

}
