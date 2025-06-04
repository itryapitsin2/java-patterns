package ru.yandex.practicum.s3.final_tasks;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Объяснение решения сделано в файле README_B.md.
 * Ссылка на отчёт https://contest.yandex.ru/contest/23815/run-report/115979949/
 */
public class A {

    /**
     * Модифицированный алгоритм бинарного поиска
     * @param arr Массив, в котором происходит поиск
     * @param left индекс начала поиска
     * @param right индекс конца поиска
     * @param value значение для поиска
     * @return индекс искомого элемента или -1 если элемент отсутствует
     */
    public static int binarySearch(int[] arr, int left, int right, int value) {
        if (arr.length == 1 && arr[0] == value) {
            return 0;
        } else if ((left >= right) || (arr.length == 1)) {
            return -1;
        }

        int mid = left + ((right - left) / 2);
        int firstV = arr[left];
        int lastV = arr[right - 1];
        int midV = arr[mid];

        if (arr[mid] == value) {
            return mid;
        } else if ((firstV <= value && value <= midV)
                || (firstV >= midV && value > lastV && midV <= lastV)
                || (firstV >= midV && value <= midV && midV <= lastV)
        ) {
            return binarySearch(arr, left, mid, value);
        } else {
            return binarySearch(arr, mid + 1, right, value);
        }
    }

    public static int brokenSearch(int[] arr, int k) {
        return binarySearch(arr, 0, arr.length, k);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            scanner.nextLine();
            int k = Integer.parseInt(scanner.nextLine());
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int result = brokenSearch(arr, k);
            System.out.println(result);
        }
    }
}
