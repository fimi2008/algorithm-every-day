package top.lionxxw.learn.algorithm.leetcode;

import java.util.Arrays;

/**
 * 钢管切割问题
 * 长度:{1,2,3,4,5,6,7,8,9,10}
 * 价格:{1,5,8,9,10,17,17,20,24,30}
 * 一条长度n的钢管如何切割最优收益
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/7 14:04
 */
public class Day10 {

    // 收益
    private int[] priceArr = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

    public static void main(String[] args) {
        int n = 100;
        Day10 demo = new Day10();
        System.out.println(demo.cut(n));
    }

    /**
     * 1 --> 1,0 = 1
     * 2 --> 2,0 = 5
     * 3 --> 3,0 = 8
     * 4 --> 2,2 = 10
     * 5 --> 3,2 = 13
     * 6 --> 6,0 = 17
     * 7 --> 3,2,2 = 18
     * 8 --> 6,2 = 22
     * 9 --> 6,3 = 25
     * 10 --> 10,0 = 30
     * @param n 钢管的长度
     */
    public int cut(int n) {
        int[] memo = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int maxPrice = -1;
            for (int j = 1; j <= i; j++) {
                if (j <= 10) {
                    maxPrice = Math.max(maxPrice, priceArr[j] + memo[i - j]);
                } else {
                    maxPrice = Math.max(maxPrice, j / 10 * priceArr[10] + priceArr[j % 10] + memo[i - j]);
                }

            }
            memo[i] = maxPrice;
        }
        System.out.println(Arrays.toString(memo));
        return memo[n];
    }

}
