package top.lionxxw.learn.algorithm.lesson.day01;

import java.util.Arrays;

/**
 * 插入排序
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/13 17:11
 */
public class InsertionSort extends BaseClass {
    public static void main(String[] args) {
        int[] arr1 = {4, 3, 2, 1};
        int[] arr2 = {4, 3, 2, 1};
        insertionSort(arr1);
        System.out.println(Arrays.toString(arr1));
        comparator(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    /**
     * 时间复杂度:O(N)
     */
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 最外层循环规定 0 ~ i 做到有序
        for (int i = 1; i < arr.length; i++) {
            // j+1 就相当于i
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }
}
