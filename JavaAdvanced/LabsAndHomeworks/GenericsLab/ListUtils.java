package GenericsLab;

import java.util.Collections;
import java.util.List;

public class ListUtils<T> {
    public static <T extends Comparable<? super T>> T getMin(List<T> list) {
        ensureListIsNotEmpty(list);
        return Collections.min(list);
    }

    public static <T extends Comparable<? super T>> T getMax(List<T> list) {
        ensureListIsNotEmpty(list);
        return Collections.max(list);
    }
    private static <T extends Comparable<? super T>> void ensureListIsNotEmpty(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Doesn't accept empty lists");
        }
    }

}
