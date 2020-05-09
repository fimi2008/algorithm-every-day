package top.lionxxw.learn.algorithm.leetcode;

/**
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/9 15:24
 */
public class Day13 {
    public static void main(String[] args) {
        Day13 demo = new Day13();
        int n = 16;
        int r = demo.mySqrt(n);
        System.out.println(r);
    }

    public int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        // 牛顿迭代
//        double c = x, x0 = x;
//        while (true) {
//            double xi = 0.5 * (x0 + c / x0);
//            if (Math.abs(x0 - xi) < 1e-7) {
//                break;
//            }
//            x0 = xi;
//        }
//        return (int) x0;
        // 袖珍计算器算法
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }
}
