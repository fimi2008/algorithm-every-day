package top.lionxxw.learn.algorithm.lesson.day05;

import top.lionxxw.learn.algorithm.lesson.day01.BaseClass;

import java.util.Arrays;

/**
 * 基数排序
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/28 17:57
 */
public class RadixSort extends BaseClass {

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100000;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            radixSort(arr1);
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
        radixSort(arr);
        printArray(arr);
    }

    /**
     * 基数排序的原理:
     * 以10为基,对数的个位,十位,百位...依次排序
     * 第一步:
     * count[0..9] 数组,记录arr[]数组个位数为[0..9]的个数
     * 第二步:
     * count[]转换成前缀和count2[]即,每一项为前一项数组总和
     * 第三步:
     * 从右向左进行遍历,将数放入arr[]中
     * 依次进行十位,百位操作...
     *
     * @param arr
     * @return
     */
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    /**
     * 基数排序
     *
     * @param arr   数组
     * @param left  左边界
     * @param right 右边界
     * @param digit 最大位数
     */
    private static void radixSort(int[] arr, int left, int right, int digit) {
        final int radix = 10;
        int i = 0, j = 0;
        // 有多少个数准备多少个辅助空间
        int[] help = new int[right - left + 1];
        for (int d = 1; d <= digit; d++) {
            int[] count = new int[radix];
            for (i = left; i <= right; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
            for (i = right; i >= left; i--) {
                j = getDigit(arr[i], d);
                help[--count[j]] = arr[i];
            }
            System.out.println("arr="+ Arrays.toString(arr));
            System.out.println("help="+ Arrays.toString(help));
            for (i = left, j = 0; i <= right; i++, j++) {
                arr[i] = help[j];
            }
        }
    }

    private static int getDigit(int x, int d) {
        return (x / (int) Math.pow(10, d - 1)) % 10;
    }

    public static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }
}
