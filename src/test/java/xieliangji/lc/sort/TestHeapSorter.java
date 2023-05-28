package xieliangji.lc.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestHeapSorter {

    @Test
    @DisplayName("测试堆排序")
    void testSort() {
        List<Integer> unordered = new ArrayList<>(List.of(
                3, 5, 3, 0, 8, 6, 1, 5,
                8, 6, 2, 4, 9, 4, 7, 0, 1, 8, 9,
                7, 3, 1, 2, 5, 9, 7, 4, 0, 2, 6
        ));

        List<Integer> ordered = new HeapSorter<Integer>(){}.sort(unordered, Comparator.naturalOrder());
        System.out.println("sorted: " + ordered);
    }
}
