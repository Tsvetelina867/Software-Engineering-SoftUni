package GenericsExercise.CustomList;

import GenericsExercise.CustomList.CustomList;

import java.util.Collections;

public class Sorter {
    public static <T extends Comparable<T>> void sort(CustomList<T> list){
        Collections.sort(list.getList());

    }
}
