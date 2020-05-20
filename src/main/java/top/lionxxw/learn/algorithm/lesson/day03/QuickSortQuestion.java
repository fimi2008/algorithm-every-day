package top.lionxxw.learn.algorithm.lesson.day03;

import java.util.Arrays;

/**
 * 基于快速排序做的案例
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/20 15:09
 */
public class QuickSortQuestion {

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 2, 4, 6, 7, 0, 3, 2};
        int num = 3;
        int left = quickSort(arr, num);
        System.out.println("left=" + left);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 给定一个数组arr，和一个整数num。请把小于等于num的数放在数组的左边,
     * 大于num的数放在数组的右边。
     * 要求额外空间复杂度0(1)，时间复杂度O(N)
     *
     * @param arr
     * @param num
     * @return
     */
    public static int quickSort(int[] arr, int num) {
        int left = -1;
        for (int i = 0; i < arr.length; i++) {
            // arr[i]与小于区的右一个交换,小于区右扩,i++
            if (arr[i] <= num) {
                swap(arr, ++left, i);
            }
            // i++
        }
        return left;
    }

    /**
     * 荷兰国旗问题
     * 给定一个数组arr，和一个整数num。请把小于num的数放在数组的左边,等于num放中间
     * 大于num的数放在数组的右边。
     *
     * @param arr
     * @param num
     */
    public static void quickSort2(int[] arr, int num) {
        int left = -1;
        int right = arr.length;
        int i = 0;
        while (i < right) {
            if (arr[i] < num) {
                // arr[i]与小于区的右一个交换,小于区右扩,i++
                swap(arr, ++left, i++);
            } else if (arr[i] > num) {
                // arr[i]与大于区的左一个交换,小于区左扩,i不变
                swap(arr, --right, i);
            } else {
                // arr[i] == num i++
                i++;
            }
        }
        System.out.println("left=" + left + ",right=" + right);
    }

    public static void swap(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        arr[left] = arr[left] ^ arr[right];
        arr[right] = arr[left] ^ arr[right];
        arr[left] = arr[left] ^ arr[right];
    }
}
