package ru.yandex.practicum.s3;

import java.util.Arrays;

public class K {
    public static int[] merge(int[] arr, int left, int mid, int right) {
        int[] result = new int[arr.length];
        int k = 0;
        int i = mid;

        while (left < mid && i < right) {
            if (arr[left] <= arr[i]) {
                result[k] = arr[left];
                left++;
            } else {
                result[k] = arr[i];
                i++;
            }
            k++;
        }
        while (left < mid) {
            result[k] = arr[left];
            left++;
            k++;
        }
        while (i < right) {
            result[k] = arr[i];
            i++;
            k++;
        }

        return result;
    }

    public static int middle(int left, int right) {
        return (left + right) / 2;
    }

    public static int[] sort(int[] arr, int left, int right) {
        if (arr.length == 1) {
            return arr;
        }
        int middle = middle(left, right);

        int[] leftArr = sort(Arrays.copyOfRange(arr, left, middle), left, middle);
        int[] rightArr = sort(Arrays.copyOfRange(arr, middle, right), 0, right - middle);

        int[] result = new int[leftArr.length + rightArr.length];
        System.arraycopy(leftArr, 0, result, 0, leftArr.length);
        System.arraycopy(rightArr, 0, result, leftArr.length, rightArr.length);

        result = merge(result, 0, middle(0, result.length), result.length);
        return result;
    }

    public static void merge_sort(int[] arr, int left, int right) {
        var result = sort(arr, left, right);
        System.arraycopy(result, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 9, 2, 10, 11};
        int[] b = merge(a, 0, 3, 6);
        int[] expected = {1, 2, 4, 9, 10, 11};
        assert Arrays.equals(b, expected);
        int[] c = {1, 4, 2, 10, 1, 2};
        merge_sort(c, 0, 6);
        int[] expected2 = {1, 1, 2, 2, 4, 10};
        assert Arrays.equals(c, expected2);
    }
}
