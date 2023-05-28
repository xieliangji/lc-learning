package xieliangji.lc.sort;

import java.util.Comparator;
import java.util.List;

public interface Sorter<T> {

    default List<T> sort(List<T> unordered, Comparator<T> comparator) {
        throw new UnsupportedOperationException("no implementation yet.");
    }
}
