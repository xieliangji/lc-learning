package xieliangji.lc.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
import java.util.List;

public class TestHeapSorter {


    @DisplayName("测试堆排序")
    @ParameterizedTest
    @MethodSource("xieliangji.lc.ajunit.DataCenter#forTestHeapSort")
    void testHeapSort(List<Integer> unordered) {
        List<Integer> ordered = new HeapSorter<Integer>() {
        }.sort(unordered, Comparator.reverseOrder());
        System.out.println("sorted: " + ordered);
    }
}
