package top.lionxxw.learn.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 * <p>
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/15 14:52
 */
public class Day19 {

    public static void main(String[] args) {
        Day19 demo = new Day19();
        int[] nums = {3, 4, 7, 2, -3, 1, 4, 2};
        System.out.println(demo.subarraySum2(nums, 7));
    }

    /**
     * 暴力破解法
     * 时间复杂度O(N^2)
     */
    public int subarraySum(int[] nums, int k) {
        int total = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int j = i;
            int sum = 0;
            while (j < len) {
                sum += nums[j];
                if (sum == k) {
                    total++;
                }
                j++;
            }
        }
        return total;
    }

    /**
     * 前缀和 + 哈希表优化
     * 时间复杂度O(N)
     */
    public int subarraySum2(int[] nums, int k) {
        // key为前缀和,value为出现次数
        Map<Integer, Integer> mp = new HashMap<>();
        int pre = 0, count = 0;
        // 记录下标0之前的数
        mp.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
