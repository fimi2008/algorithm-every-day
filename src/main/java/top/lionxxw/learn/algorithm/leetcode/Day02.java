package top.lionxxw.learn.algorithm.leetcode;

import java.util.Arrays;

/**
 * 华为面试算法题:
 * 给定一个无序的整数数组,找到其中最长上升子序列的长度.
 * 举例:
 * 输入:[10,9,2,5,3,7,101,18]
 * 输出:4
 * 解释:最长的上升子序列是[2,3,7,101],它的长度是4.
 * <p>
 * 说明:
 * 可能会用多种最长上升子序列的组合,你只需要输出对应的长度即可.
 * 普通:算法的时间复杂度为O(n²)
 * 进阶:算法的时间复杂度降低到O(n log n)
 * <p>
 *
 * @author wangxiang
 * created on 2020/4/27 17:55
 */
public class Day02 {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};

        int result = solving1(nums);
        System.out.println("最长上升子序列长度:" + result);

        int result2 = solving2(nums);
        System.out.println("最长上升子序列长度:" + result2);
    }

    /**
     * 解题思路:
     * 1.动态规划
     * 状态定义:
     * dp[i]的值代表nums前i个数字的最长子序列长度.
     * 初始状态:
     * dp[i]所有元素置1,含义是每个元素都至少可以单独成为子序列,此时长度都为1.
     * 返回值:
     * 返回dp列表最大值,即可得到全局最长上升子序列长度
     */
    private static int solving1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(res, dp[i]);
            }
        }
        System.out.println("结果:" + Arrays.toString(dp));
        return res;
    }

    /**
     * 解题思路:
     * 1.动态规划+二分查找
     * 新建数组cell,用于保存最长上升子序列.'
     * 对原序列进行遍历,将每位元素二分插入cell中.
     * 如果cell中元素都比它小,将它查到最后.
     * 否则,用它覆盖掉比它大的元素中最小的哪个.
     * 总之,思想就是让cell中存储比较小的元素.这样,cell未必是真实的最长上升子序列,但长度是对的.
     */
    private static int solving2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] cell = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) {
                int m = (i + j) / 2;
                if (cell[m] < num) {
                    i = m + 1;
                }else{
                    j = m;
                }
            }
            cell[i] = num;
            if (res == j){
                res++;
            }
        }
        System.out.println("结果:" + Arrays.toString(cell));
        return res;
    }
}
