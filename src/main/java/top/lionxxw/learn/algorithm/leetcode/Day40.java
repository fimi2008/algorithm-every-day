package top.lionxxw.learn.algorithm.leetcode;

import java.util.Arrays;

/**
 * 面试题29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 限制：
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * <p>
 *
 * @author wangxiang
 * created on 2020/6/5 09:05
 */
public class Day40 {

    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = {{3}, {2}};
        int[] res = spiralOrder(matrix);
        System.out.println(Arrays.toString(res));
    }

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int total = row * column;
        int[] res = new int[total];
        int index = 0;
        // (top,left) -> (top,right)
        // (top+1,right) -> (bottom, right)
        // (bottom, right-1) -> (bottom, left+1)
        // (bottom, left) -> (top +1, left)
        int top = 0;
        int bottom = row - 1;
        int left = 0;
        int right = column - 1;
        while (index < total) {
            // (top,left) -> (top,right)
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[top][i];
            }
            // (top+1,right) -> (bottom, right)
            for (int i = top + 1; i <= bottom; i++) {
                res[index++] = matrix[i][right];
            }
            if (top < bottom && left < right) {
                // (bottom, right-1) -> (bottom, left+1)
                for (int i = right - 1; i >= left + 1; i--) {
                    res[index++] = matrix[bottom][i];
                }
                // (bottom, left) -> (top +1, left)
                for (int i = bottom; i >= top + 1; i--) {
                    res[index++] = matrix[i][left];
                }
            }

            top++;
            left++;
            right--;
            bottom--;
        }
        return res;
    }


}
