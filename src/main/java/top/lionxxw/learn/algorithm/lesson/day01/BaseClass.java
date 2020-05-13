package top.lionxxw.learn.algorithm.lesson.day01;

import java.util.Arrays;

/**
 * 基础方法类
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/13 16:28
 */
public class BaseClass {

    /**
     * 交换数组位子
     */
    public static void swap(int[] arr, int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
        // 通过异或运算进行交换
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 对数器
     *
     * @param arr
     */
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }
}