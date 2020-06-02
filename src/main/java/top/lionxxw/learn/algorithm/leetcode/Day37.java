package top.lionxxw.learn.algorithm.leetcode;

/**
 * 面试题64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 * 示例 1：
 * 输入: n = 3
 * 输出: 6
 * <p>
 * 示例 2：
 * 输入: n = 9
 * 输出: 45
 * <p>
 *
 * @author wangxiang
 * created on 2020/6/2 09:13
 */
public class Day37 {

    public static void main(String[] args) {
        int n = 39;
        System.out.println(sumNums(n));
        System.out.println(sumNums2(n));
        System.out.println(sumNums3(n));
    }

    public static int sumNums(int n) {
        return n == 0 ? 0 : n + sumNums(n - 1);
    }

    /**
     * 俄罗斯农民乘法 https://www.iteye.com/blog/masterkey-326386
     */
    public static int sumNums2(int n) {
        // 1+2+...+n = n*(n+1)/2
        int res = 0;
        int a = n, b = n + 1;
        while (b != 1) {
            if (b % 2 != 0) {
                res += a;
            }
            a <<= 1;
            b >>= 1;
        }
        res += a;
        return res >> 1;
    }

    public static int sumNums3(int n) {
        int res = 0;
        int a = n, b = n + 1;
        boolean flag;
        // 通过&操作判断奇偶性,只有b为奇数时,才累加a的值
        flag = ((b & 1) > 0) && (res += a) > 0;
        a <<= 1;
        b >>= 1;

        //因为题目数据范围 n 为 [1,10000],所以 n 二进制展开最多不会超过 14 位,我们手动展开 14 层代替循环即可，
        flag = ((b & 1) > 0) && (res += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) > 0) && (res += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) > 0) && (res += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) > 0) && (res += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) > 0) && (res += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) > 0) && (res += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) > 0) && (res += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) > 0) && (res += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) > 0) && (res += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) > 0) && (res += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) > 0) && (res += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) > 0) && (res += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) > 0) && (res += a) > 0;
        a <<= 1;
        b >>= 1;

        flag = ((b & 1) > 0) && (res += a) > 0;
        a <<= 1;
        b >>= 1;

        return res >> 1;
    }
}
