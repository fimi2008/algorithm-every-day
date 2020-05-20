package top.lionxxw.learn.algorithm.lesson.day03;

import java.util.Arrays;

/**
 * 归并排序
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/18 14:56
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 1, 4, 6, 7, 8, 7, 8, 4, 5, 6, 9, 10};
        mergeSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 递归方式实现
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    /**
     * 非递归方式实现
     */
    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int len = arr.length;
        // 当前有序的,左组长度
        int mergeSize = 1;
        while (mergeSize < len) {
            int l = 0;
            while (l < len) {
                // l..M 左组(mergeSize)
                int mid = l + mergeSize - 1;
                // 没有左组,肯定有序
                if (mid > len) {
                    break;
                }
                // L..M M+1..R
                int r = Math.min(mid + mergeSize, len - 1);
                merge(arr, l, mid, r);
                l = r + 1;
            }
            // 防止溢出,不加不会影响程序,但是加了可以防止溢出
            if (mergeSize > (len >> 1)) {
                break;
            }
            mergeSize <<= 1;
        }
    }

    /**
     * arr[L..R]范围上变有序
     * L..R  N  T(N)=2*T(N/2)+O(N)  => a=2,b=2,d=1 logba=d O(N^d*logN) => O(N*logN)
     */
    public static void process(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process(arr, l, mid);
        process(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 要么p1越界,要么p2越界
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }
}
