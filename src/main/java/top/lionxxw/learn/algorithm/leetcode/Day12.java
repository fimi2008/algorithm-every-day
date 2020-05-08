package top.lionxxw.learn.algorithm.leetcode;

import java.util.Random;

/**
 * 221. 最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * 输出: 4
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/8 17:55
 */
public class Day12 {

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '1', '1', '0', '0'},
                {'1', '0', '1', '1', '0'},
                {'1', '0', '1', '1', '0'}};
        Day12 demo = new Day12();
        demo.maximalSquare(matrix);
    }

    /**
     * 动态规划
     *
     * 复杂度分析
     *
     * 时间复杂度：O(mn)，其中 m 和 n 是矩阵的行数和列数。需要遍历原始矩阵中的每个元素计算 dp 的值。
     *
     * 空间复杂度：O(mn)，其中 m 和 n 是矩阵的行数和列数。创建了一个和原始矩阵大小相同的矩阵 dp。
     * 由于状态转移方程中的 dp(i, j) 由其上方、左方和左上方的三个相邻位置的 dp 值决定，因此可以使用两个一维数组进行状态转移，
     * 空间复杂度优化至 O(n)。
     *
     */
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return max;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + "\t");
                max = Math.max(max, dp[i][j]);
            }
            System.out.println("");
        }
        return max * max;
    }


}
