package DataStructures.algorithms.search;


import DataStructures.types.Comparable;
import DataStructures.types.OrderedArray;

public class BinarySearch<T extends Comparable<T>> implements Search<OrderedArray<T>, T> {

    @Override
    public int has(OrderedArray<T> list, T element) {
        int firstIndex = 0;
        int lastIndex = list.getCount() - 1;

        Comparable<T>[] items = list.getItems();

        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;

            if (items[middleIndex].equals(element)) {
                return middleIndex;
            } else if (items[middleIndex].left(element)) {
                firstIndex = middleIndex + 1;
            } else if (items[middleIndex].right(element)) {
                lastIndex = middleIndex - 1;
            }
        }

        return -1;
    }
}
