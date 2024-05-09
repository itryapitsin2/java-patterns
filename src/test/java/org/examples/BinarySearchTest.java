package org.examples;

import DataStructures.algorithms.search.BinarySearch;
import DataStructures.algorithms.search.LinearSearch;
import DataStructures.algorithms.sort.BubbleSort;
import DataStructures.algorithms.sort.CombSort;
import DataStructures.algorithms.sort.InsertionSort;
import DataStructures.algorithms.sort.MixSort;
import DataStructures.algorithms.sort.SelectionSort;
import DataStructures.types.Array;
import DataStructures.types.Comparable;
import DataStructures.types.OrderedArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class BinarySearchTest {

    static class Element implements Comparable<Element> {

        private final int value;

        public int getValue() {
            return value;
        }

        public Element(int value) {
            this.value = value;
        }

        @Override
        public boolean right(Element element) {
            return element.value > value;
        }

        @Override
        public boolean left(Element element) {
            return element.value < value;
        }

        @Override
        public boolean equals(Object element) {
            if (element instanceof Element) {
                return ((Element) element).value == value;
            }

            return false;
        }
    }

    @Test
    public void searchInBubbleOrderedArray() {
        int maxCount = 25;
        OrderedArray<Element> array = new OrderedArray<>(Element.class, maxCount, new BubbleSort<>());
        Random rand = new Random();

        for (int i = 0; i < maxCount; i++) {
            array.insert(i, new Element(rand.nextInt(100)));
        }

        Element i = array.getItem(5);
        BinarySearch<Element> linearSearch = new BinarySearch<>();
        Assertions.assertEquals(linearSearch.has(array, i), 5);

        i = array.getItem(9);
        Assertions.assertEquals(linearSearch.has(array, i), 9);

        Assertions.assertNotEquals(linearSearch.has(array, new Element(i.getValue() + 1000)), 9);
    }

    @Test
    public void searchInInsertionOrderedArray() {
        int maxCount = 25;
        OrderedArray<Element> array = new OrderedArray<>(Element.class, maxCount, new InsertionSort<>());
        Random rand = new Random();

        for (int i = 0; i < maxCount; i++) {
            array.insert(i, new Element(rand.nextInt(100)));
        }

        Element i = array.getItem(5);
        BinarySearch<Element> linearSearch = new BinarySearch<>();
        Assertions.assertEquals(linearSearch.has(array, i), 5);

        i = array.getItem(9);
        Assertions.assertEquals(linearSearch.has(array, i), 9);

        Assertions.assertNotEquals(linearSearch.has(array, new Element(i.getValue() + 1000)), 9);
    }

    @Test
    public void searchInSelectionOrderedArray() {
        int maxCount = 25;
        OrderedArray<Element> array = new OrderedArray<>(Element.class, maxCount, new SelectionSort<>());
        Random rand = new Random();

        for (int i = 0; i < maxCount; i++) {
            array.insert(i, new Element(rand.nextInt(100)));
        }

        Element i = array.getItem(5);
        BinarySearch<Element> linearSearch = new BinarySearch<>();
        Assertions.assertEquals(linearSearch.has(array, i), 5);

        i = array.getItem(9);
        Assertions.assertEquals(linearSearch.has(array, i), 9);

        Assertions.assertNotEquals(linearSearch.has(array, new Element(i.getValue() + 1000)), 9);
    }

    @Test
    public void searchInMixSortOrderedArray() {
        int maxCount = 25;
        OrderedArray<Element> array = new OrderedArray<>(Element.class, maxCount, new MixSort<>());
        Random rand = new Random();

        for (int i = 0; i < maxCount; i++) {
            array.insert(i, new Element(rand.nextInt(100)));
        }

        Element i = array.getItem(5);
        BinarySearch<Element> linearSearch = new BinarySearch<>();
        Assertions.assertEquals(linearSearch.has(array, i), 5);

        i = array.getItem(9);
        Assertions.assertEquals(linearSearch.has(array, i), 9);

        Assertions.assertNotEquals(linearSearch.has(array, new Element(i.getValue() + 1000)), 9);
    }

    @Test
    public void searchInCombSortOrderedArray() {
        int maxCount = 25;
        OrderedArray<Element> array = new OrderedArray<>(Element.class, maxCount, new CombSort<>());
        Random rand = new Random();

        for (int i = 0; i < maxCount; i++) {
            array.insert(i, new Element(rand.nextInt(100)));
        }

        Element i = array.getItem(5);
        BinarySearch<Element> linearSearch = new BinarySearch<>();
        Assertions.assertEquals(linearSearch.has(array, i), 5);

        i = array.getItem(9);
        Assertions.assertEquals(linearSearch.has(array, i), 9);

        Assertions.assertNotEquals(linearSearch.has(array, new Element(i.getValue() + 1000)), 9);
    }
}
