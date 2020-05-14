package top.lionxxw.learn.algorithm.lesson.day01;

import java.util.*;

/**
 * 案例
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/13 20:21
 */
public class EvenTimesOddTimes {

    public static void main(String[] args) {
        int[] arr = genArr(1);
        printOddTimesNumOne(arr);
        arr = genArr(2);
        printOddTimesNumTwo(arr);
        int n = 10223;
        int count = bit1Counts(n);
        System.out.println("n=" + n + ",二进制中1的个数:" + count);
    }

    /**
     * 生产数组
     *
     * @param n 出现奇数次的数
     * @return 出现n种树出现奇数次
     */
    public static int[] genArr(int n) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Random random = new Random();
        Set<Integer> set = new HashSet<>(n);
        while (set.size() < n) {
            int i = random.nextInt(10);
            set.add(i);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int r = random.nextInt(10);
            if (set.contains(i)) {
                r = r % 2 == 0 ? r + 1 : r;
            } else {
                r = r % 2 == 0 ? r : r + 1;
            }
            while (r > 0) {
                list.add(nums[i]);
                r--;
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    /**
     * 题目二:
     * 一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这种数
     *
     * @param arr 中,只有一种数出现奇数次
     */
    public static void printOddTimesNumOne(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res ^= arr[i];
        }
        System.out.println("出现奇数次的数:" + res);
    }

    /**
     * 题目三:
     * 怎么把一- 个int类型的数，提取出最右侧的1来
     * n & (~n + 1)
     * 假设:
     * n = 4
     * n 二进制: 0100
     * n取反的二进制: 1011  + 1 = 1100
     * 将上面数进行与操作, 0100 & 1100 = 0100 = 4
     */
    public static int getNumberRightOne(int n) {
        return n & ((~n) + 1);
    }

    /**
     * 题目四:
     * 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么
     * 找到并打印这两种数
     *
     * @param arr arr 中,只有两种树出现奇数次
     */
    public static void printOddTimesNumTwo(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        // 此时eor = a^b 并且 eor != 0 必然有一个位置上是1
        // 提取最右侧的1
        int rightOne = getNumberRightOne(eor);
        System.out.println("最右侧的1:" + rightOne);
        // 另一个奇数次的数
        int onlyOne = 0;
        for (int i = 0; i < arr.length; i++) {
            /**
             * rightOne = 0010
             * arr[i] = 0101
             * arr[i] & rightOne == 0000
             *
             * arr[i] = 0100
             * arr[i] & rightOne == 0000
             *
             * arr[i] = 1010
             * arr[i] & rightOne == 0010
             *
             * 提取所有最右侧为1的数
             */
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];
            }
        }
        System.out.println("2个奇数次的数:a=" + onlyOne + ",b=" + (eor ^ onlyOne));
    }

    /**
     * 统计数字 n 二进制中1的个数
     *
     * @param n 数字
     * @return 二进制中1的个数
     */
    public static int bit1Counts(int n) {
        int count = 0;
        while (n != 0) {
            // 提取最右侧的1
            int rightOne = getNumberRightOne(n);
            count++;
            // 抹掉最右侧的1
            n ^= rightOne;
        }
        return count;
    }
}
