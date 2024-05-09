package DataStructures.algorithms.sort;

import DataStructures.types.Comparable;

public interface Sort<T extends Comparable<T>> {
    T[] sort(T[] items, long count);
}
