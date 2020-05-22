package top.lionxxw.learn.algorithm.leetcode;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/21 09:32
 */
public class Day25 {

    public static void main(String[] args) {
        Day25 demo = new Day25();
        String str = "cbbd";
//        String str = "babad";
        System.out.println(demo.longestPalindrome(str));
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int startIndex = 0;
        int maxLen = 0;
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    startIndex = i;
                    System.out.println("i=" + i + "j=" + j);
                }
            }
        }
        return s.substring(startIndex, startIndex + maxLen);
    }
}
