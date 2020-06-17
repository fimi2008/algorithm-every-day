package top.lionxxw.learn.algorithm.leetcode;

/**
 * 1014. 最佳观光组合
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 * <p>
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 * <p>
 * 返回一对观光景点能取得的最高分。
 * <p>
 * 示例：
 * <p>
 * 输入：[8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 * <p>
 *
 * @author wangxiang
 * created on 2020/6/17 10:16
 */
public class Day49 {

    public static void main(String[] args) {
        int[] A = {1,3,5};
        System.out.println(maxScoreSightseeingPair(A));
    }

    public static int maxScoreSightseeingPair(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        int[] dp = new int[A.length];
        int max = A[0];
        dp[0] = max;
        for (int i = 1; i < A.length; i++) {
            // dp中记录最大观看值
            dp[i] =  Math.max(dp[i-1], A[i] + i);
            // 前面所有中最大的观看值+当前的观光值
            max = Math.max(dp[i-1] + A[i] - i, max);
        }
        return max;
    }
}
