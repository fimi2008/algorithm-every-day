package top.lionxxw.learn.algorithm.lesson.day03;

import java.util.Arrays;

/**
 * 快速排序
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/20 15:09
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = genRandomArray(5000,1000);
        int[] arr2 = copyArray(arr);
        int[] arr3 = copyArray(arr);
        quickSort(arr);
        quickSort2(arr2);
        quickSort3(arr3);
        System.out.println(isEqual(arr, arr2));
        System.out.println(isEqual(arr2, arr3));
    }

    /**
     * 快速排序1.0版
     * 时间复杂度O(N^2)
     * 在arr[L.. R]范围上，进行快速排序的过程:
     * 1)用arr[R]对 该范围做partition，<= arr[R]的数在左部分并且保证arr[R]最后来
     * 到左部分的最后一个位置，记为M; <= arr[R]的数在右部分(arr[M+1..R])
     * 2)对arr[L.M-1]进 行快速排序(递归)
     * 3)对arr[M+ ..R]进行快速排序(递归)
     * 因为每一次partition都会搞定一-个数的位置且不会再变动，所以排序能完成
     */
    public static void quickSort(int[] arr) {
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = partition(arr, l, r);
        process(arr, l, m - 1);
        process(arr, m + 1, r);
    }

    /**
     * 快速排序1.0版
     */
    public static int partition(int[] arr, int l, int r) {
        int i = l;
        int left = l - 1;
        while (i <= r) {
            if (arr[i] < arr[r]) {
                swap(arr, ++left, i++);
            } else {
                i++;
            }
        }
        swap(arr, ++left, r);
        return left;
    }

    /**
     * 快速排序2.0版
     * 基于荷兰国旗划分
     * 时间复杂度O(N^2)
     */
    public static void quickSort2(int[] arr) {
        process2(arr, 0, arr.length - 1);
    }

    public static void process2(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int[] m = netherlandsFlag(arr, l, r);
        process2(arr, l, m[0] - 1);
        process2(arr, m[1] + 1, r);
    }

    /**
     * arr[l..r] 荷兰国旗问题的划分,已arr[r]做划分值
     * 分为三个区域 {小于arr[r]|等于arr[r]|大于arr[r]}
     */
    public static int[] netherlandsFlag(int[] arr, int l, int r) {
        if (l > r) {
            return new int[]{-1, -1};
        }
        if (l == r) {
            return new int[]{l, r};
        }
        int i = l;
        int left = l - 1;
        int right = r;
        while (i < right) {
            if (arr[i] < arr[r]) {
                swap(arr, ++left, i++);
            } else if (arr[i] == arr[r]) {
                i++;
            } else {
                swap(arr, i, --right);
            }
        }
        swap(arr, right, r);
        return new int[]{left + 1, right};
    }

    /**
     * 快速排序3.0版
     * 时间复杂度O(N*logN)
     * 随机快排的时间复杂度分析
     * 1)通过分析知道，划分值越靠近中间，性能越好;越靠近两边，性能越差
     * 2)随机选一个数进行划分的目的就是让好情况和差情况都变成概率事件
     * 3)把每一种情况都列出来，会有每种情况下的时间复杂度，但概率都是1/N
     * 4)那么所有情况都考虑，时间复杂度就是这种概率模型下的长期期望!
     * 时间复杂度O(N+logN)，额外空间复杂度O(logN)都是这么来的。
     */
    public static void quickSort3(int[] arr) {
        process3(arr, 0, arr.length - 1);
    }

    public static void process3(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
        int[] m = netherlandsFlag(arr, l, r);
        process3(arr, l, m[0] - 1);
        process3(arr, m[1] + 1, r);
    }

    public static void swap(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        arr[left] = arr[left] ^ arr[right];
        arr[right] = arr[left] ^ arr[right];
        arr[left] = arr[left] ^ arr[right];
    }

    public static int[] genRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return arr;
        }
        if (arr.length < 2) {
            return new int[]{arr[0]};
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;

    }
}
