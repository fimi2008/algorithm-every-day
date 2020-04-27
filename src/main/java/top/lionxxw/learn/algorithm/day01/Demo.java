package top.lionxxw.learn.algorithm.day01;

import java.util.Arrays;

/**
 * 字节跳动面试题
 * 给定一个数组nums,编写一个方法将所有0移动到数组的末尾
 * 要求:
 * 1.保持非零元素的相对顺序
 * 2.空间复杂度O(1)
 * <p>
 * 举例:
 * 输入:nums=[0,1,2,0,3,7,0,12]
 * 输出:[1,2,3,7,12,0,0,0]
 * <p>
 *
 * @author wangxiang
 * created on 2020/4/27 17:07
 */
public class Demo {

    /**
     * 思路:
     * 双指针,一个标记指针,一个循环指针
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 0, 3, 7, 0, 12};
        int flag = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[flag];
                nums[flag++] = temp;
            }
        }
        System.out.println("结果:" + Arrays.toString(nums));
    }
}
