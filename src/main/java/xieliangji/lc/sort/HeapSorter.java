package xieliangji.lc.sort;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * 堆排序
 * - 使用 堆 这种数据结构来完成排序
 * - 时间复杂度 O(n㏒n)
 * 😁
 * 什么是堆？
 *  - 一种特别的<a href="https://zh.wikipedia.org/wiki/%E5%AE%8C%E5%85%A8%E4%BA%8C%E5%8F%89%E6%A0%91">完全二叉树</a>
 *  - 特性
 *      - 给定任意节点A、B，若A是B的父节点，则A节点的值会≤(或≥)B节点的值
 *      - 最大堆 - 父节点的值恒≥子节点的值 ↑
 *      - 最小堆 - 父节点的值恒≤子节点的值 ↓
 *      - 堆中最顶端的是根节点
 */
public interface HeapSorter<T> extends Sorter<T> {

    @Override
    default List<T> sort(List<T> unordered, Comparator<T> comparator) {
        if (Objects.isNull(comparator)) {
            throw new IllegalArgumentException("you should provide the comparator");
        }

        int remainSize = unordered.size() - 1;
        for (int index = (unordered.size() >> 1) - 1; index >= 0; index--) {
            heapify(unordered, index, remainSize, comparator);
        }

        for (int index = remainSize; index > 0; index--) {
            swap(unordered, 0, index);
            heapify(unordered, 0, index - 1, comparator);
        }

        return unordered;
    }

    private void heapify(List<T> els, int index, int remainSize, Comparator<T> comparator) {
        int left = (index << 1) + 1;
        int right = left + 1;
        int maxIndex = left;

        if (left > remainSize) return;

        if (right <= remainSize && comparator.compare(els.get(right), els.get(left)) > 0) {
            maxIndex = right;
        }

        if (comparator.compare(els.get(maxIndex), els.get(index)) > 0) {
            swap(els, maxIndex, index);
            heapify(els, maxIndex, remainSize, comparator);
        }
    }

    private void swap(List<T> els, int eIndex, int anotherEIndex) {
        T e1 = els.get(eIndex);
        T e2 = els.get(anotherEIndex);
        els.set(eIndex, e2);
        els.set(anotherEIndex, e1);
    }
}