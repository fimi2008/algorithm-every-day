package top.lionxxw.learn.algorithm.lesson.day05;

import top.lionxxw.learn.algorithm.lesson.day01.BaseClass;

/**
 * 计数排序
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/28 17:42
 */
public class CountSort extends BaseClass {

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 150;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            countSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        countSort(arr);
        printArray(arr);
    }

    /**
     * 基数排序实现原理:
     * 假设arr数组中的最大值为200,
     * 创建一个bucket桶,容量为200,[0,200]
     * 遍历arr数组,在对应的下标为arr[i]的桶位置上进行+1操作,得出该数的个数
     * 然后遍历bucket桶,将所有桶中非0的数都放入对应的arr数组的中,
     * 假设,bucket[10] = 3 表示10这个数有3个,对应的arr[i],arr[i+1],arr[i+2]都为10
     * @param arr
     */
    public static void countSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }
        int[] bucket = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0) {
                arr[i++] = j;
            }
        }
    }
}
