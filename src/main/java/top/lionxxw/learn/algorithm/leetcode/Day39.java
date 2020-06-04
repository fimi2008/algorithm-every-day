package top.lionxxw.learn.algorithm.leetcode;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 * 示例:
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * <p>
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 *
 * @author wangxiang
 * created on 2020/6/4 21:37
 */
public class Day39 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] res = productExceptSelf(nums);
        System.out.println(Arrays.toString(res));
        res = productExceptSelf2(nums);
        System.out.println(Arrays.toString(res));
    }


    /**
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     */
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] L = new int[len];
        int[] R = new int[len];
        L[0] = 1;
        int i;
        // 计算左侧的乘积
        for (i = 1; i < len; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }
        R[len - 1] = 1;
        // 计算右侧的乘积
        for (i = len - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }

        // 合并左右乘积
        int[] res = new int[len];
        for (i = 0; i < len; i++) {
            res[i] = L[i] * R[i];
        }

        return res;
    }

    /**
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     */
    public static int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int R = 1;
        for (int i = len - 1; i >= 0; i--) {
            res[i] = res[i] * R;
            R *= nums[i];
        }
        return res;
    }
}