package top.lionxxw.learn.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 * <p>
 * 示例:
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 *
 * @author wangxiang
 * created on 2020/6/6 11:19
 */
public class Day41 {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        // 将nums中每个数字都存入HashSet中
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longestStreak = 0;
        for (int num : nums) {
            // 如果当前数的前一个数不存在Set中,开始统计, 为了避免重复计算,只统计连续数的第一个数的情况
            if (!set.contains(num - 1)) {
                int curNum = num;
                int curStreak = 1;
                System.out.print(curNum + " ");
                // 如果下一个数还在set中,进行统计并且将当前替换为下一个数
                while (set.contains(curNum + 1)) {
                    curStreak++;
                    curNum = curNum + 1;
                    System.out.print(curNum + " ");
                }
                longestStreak = Math.max(longestStreak, curStreak);
                System.out.println();
            }
        }
        return longestStreak;
    }
}
