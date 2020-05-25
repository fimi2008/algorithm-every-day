package top.lionxxw.learn.algorithm.leetcode;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/23 22:31
 */
public class Day27 {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }


    public static String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen == 0 || tLen == 0 || sLen < tLen) {
            return "";
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int[] winFreq = new int[128];
        int[] tFreq = new int[128];
        for (char c : tChars) {
            tFreq[c]++;
        }
        int distance = 0;
        int minLen = sLen + 1;
        int begin = 0;
        int left = 0;
        int right = 0;
        while (right < sLen) {
            if (tFreq[sChars[right]] == 0) {
                right++;
                continue;
            }
            if (winFreq[sChars[right]] < tFreq[sChars[right]]) {
                distance++;
            }
            winFreq[sChars[right]]++;
            right++;

            while (distance == tLen) {

                if (right - left < minLen) {
                    minLen = right - left;
                    begin = left;
                }

                if (tFreq[sChars[left]] == 0) {
                    left++;
                    continue;
                }
                if (winFreq[sChars[left]] == tFreq[sChars[left]]) {
                    distance--;
                }
                winFreq[sChars[left]]--;
                left++;
            }
        }
        if (minLen == sLen + 1) {
            return "";
        }
        return s.substring(begin, begin + minLen);
    }
}
