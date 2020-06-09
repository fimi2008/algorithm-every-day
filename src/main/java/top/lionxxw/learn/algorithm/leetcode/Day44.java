package top.lionxxw.learn.algorithm.leetcode;

/**
 * 面试题46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * 示例 1:
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * <p>
 *
 * @author wangxiang
 * created on 2020/6/9 13:42
 */
public class Day44 {

    public static void main(String[] args) {
        int num = 1225521415;
        int i = translateNum(num);
        System.out.println(i);
        int i2 = translateNum2(num);
        System.out.println(i2);
    }

    public static int translateNum(int num) {
        String src = String.valueOf(num);
        int p, q = 0, r = 1;
        for (int i = 0; i < src.length(); i++) {
            p = q;
            q = r;
            r = 0;
            r += q;
            if (i == 0) {
                continue;
            }
            String pre = src.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
//                System.out.println(pre);
                r += p;
            }
        }

        return r;
    }

    public static int translateNum2(int num) {
        String src = String.valueOf(num);
        int[] dp = new int[src.length()];
        dp[0] = 1;
        for (int i = 0; i < src.length(); i++) {
            if (i == 0) {
                continue;
            }
            String pre = src.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                if (i == 1) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
//                System.out.println(pre);
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[src.length() - 1];
    }
}
