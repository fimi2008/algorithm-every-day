package top.lionxxw.learn.algorithm.leetcode;

import java.sql.SQLOutput;

/**
 * 680. 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 * <p>
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/19 22:09
 */
public class Day23 {
    public static void main(String[] args) {
        Day23 demo = new Day23();
        String str = "abca";
        System.out.println(demo.validPalindrome(str));
    }

    public boolean validPalindrome(String s, int i, int j) {
        while (i <= j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        if ("".equals(s) || s.length() == 1) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return validPalindrome(s, i + 1, j) || validPalindrome(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }
}
