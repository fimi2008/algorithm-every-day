package top.lionxxw.learn.algorithm.lesson.day01;

import java.util.Arrays;

/**
 * 冒泡排序
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/13 16:31
 */
public class BubbleSort extends BaseClass {

    public static void main(String[] args) {
        int[] arr1 = {4, 3, 2, 1};
        int[] arr2 = {4, 3, 2, 1};
        bubbleSort(arr1);
        System.out.println(Arrays.toString(arr1));
        comparator(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        /**
         * 0 ~ N-1
         * 0 ~ N-2
         * 0 ~ N-3
         * ...
         * 时间复杂度也是:O(N^2)
         */
        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                int minIndex = arr[e] < arr[i] ? e : i;
                if (minIndex != i) {
                    swap(arr, i, minIndex);
                }
            }
        }
    }
}
