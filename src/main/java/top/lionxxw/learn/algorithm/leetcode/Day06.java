package top.lionxxw.learn.algorithm.leetcode;

import java.util.Arrays;

/**
 * 53. 最大子序和
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/3 19:04
 */
public class Day06 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = {-2, -1};
        Day06 demo = new Day06();
        System.out.println("其最大和:" + demo.maxSubArray3(nums));
    }

    /**
     * 贪心-复杂度
     * <p>
     * 时间复杂度：O(n)，其中 n 为 nums 数组的长度。我们只需要遍历一遍数组即可求得答案。
     * 空间复杂度：O(1)。我们只需要常数空间存放若干变量。
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int num : nums) {
            // 若当前指针所指元素之前的和小于0,则丢弃当前元素之前的数列
            pre = Math.max(pre + num, num);
            // 将当前值与最大值比较,取最大值
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    /**
     * 动态规划
     * 时间复杂度：O(n)，其中 n 为 nums 数组的长度。我们只需要遍历一遍数组即可求得答案。
     * 空间复杂度：O(1)。我们只需要常数空间存放若干变量。
     *
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            // 若前一个元素大于0,则将其加到当前元素上
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
        }
        System.out.println(Arrays.toString(nums));
        return Arrays.stream(nums).max().getAsInt();
    }

    /**
     * 分治
     * 这个分治方法类似于「线段树求解 LCIS 问题」的 pushUp 操作.
     *
     * 复杂度分析
     * 时间复杂度：假设我们把递归的过程看作是一颗二叉树的先序遍历，那么这颗二叉树的深度的渐进上界为 O(logn)，
     * 这里的总时间相当于遍历这颗二叉树的所有节点，故总时间的渐进上界是 O(\sum_{i = 1}^{\log n} 2^{i - 1}) =O(n)，故渐进时间复杂度为 O(n)。
     * 空间复杂度：递归会使用 O(logn) 的栈空间，故渐进空间复杂度为 O(logn)。
     *
     * @param nums
     * @return
     */
    public int maxSubArray3(int[] nums) {
        Status info = getInfo(nums, 0, nums.length - 1);
        return info.mSum;
    }

    private Status pushUp(Status lSub, Status rSub) {
        int iSum = lSub.iSum + rSub.iSum;
        int lSum = Math.max(lSub.lSum, lSub.iSum + rSub.lSum);
        int rSum = Math.max(rSub.rSum, rSub.iSum + lSub.rSum);
        int mSum = Math.max(Math.max(rSub.mSum, lSub.mSum), lSub.rSum + rSub.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }

    private Status getInfo(int[] nums, int l, int r) {
        if (l == r) {
            return new Status(nums[l], nums[l], nums[l], nums[l]);
        }
        int m = (l + r) / 2;
        Status lSub = getInfo(nums, l, m);
        Status rSub = getInfo(nums, m + 1, r);
        return pushUp(lSub, rSub);
    }

    /**
     * lSum 表示 [l, r] 内以 ll 为左端点的最大子段和
     * rSum 表示 [l, r] 内以 rr 为右端点的最大子段和
     * mSum 表示 [l, r] 内的最大子段和
     * iSum 表示 [l, r] 的区间和
     */
    class Status {
        int lSum;
        int rSum;
        int mSum;
        int iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }
}
