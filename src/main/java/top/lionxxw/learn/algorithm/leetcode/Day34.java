package top.lionxxw.learn.algorithm.leetcode;

/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/30 10:53
 */
public class Day34 {

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
        System.out.println(largestRectangleArea2(heights));
    }

    /**
     * 暴力解法 (枚举「高」)
     * S[i,j] = (j - i + 1) * Min(heights[i],heights[j])
     */
    public static int largestRectangleArea(int[] heights) {
        if (heights == null) {
            return 0;
        }
        int start, end, len = heights.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            int h = heights[i];
            start = i;
            end = i;
            // 先固定每一列的高,在遍历数组得出这个高的最大宽
            while (start - 1 >= 0 && heights[start - 1] >= h) {
                start--;
            }
            while (end + 1 < len && heights[end + 1] >= h) {
                end++;
            }
            res = Math.max(res, h * (end - start + 1));
        }
        return res;
    }

    /**
     * 暴力解法 (枚举「宽」)
     * S[i,j] = (j - i + 1) * Min(heights[i],heights[j])
     */
    public static int largestRectangleArea2(int[] heights) {
        if (heights == null) {
            return 0;
        }
        int len = heights.length;
        int minHeight;
        int res = 0;
        for (int i = 0; i < len; i++) {
            minHeight = heights[i];
            for (int j = i; j < len; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                res = Math.max(res, (j - i + 1) * minHeight);
            }
        }
        return res;
    }
}
