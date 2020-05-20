package top.lionxxw.learn.algorithm.leetcode;

import java.util.*;

/**
 * 1371. 每个元音包含偶数次的最长子字符串
 * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
 * <p>
 * 示例 1：
 * 输入：s = "eleetminicoworoep"
 * 输出：13
 * 解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
 * <p>
 * 示例 2：
 * 输入：s = "leetcodeisgreat"
 * 输出：5
 * 解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
 * <p>
 * 示例 3：
 * 输入：s = "bcbcbc"
 * 输出：6
 * 解释：这个示例中，字符串 "bcbcbc" 本身就是最长的，因为所有的元音 a，e，i，o，u 都出现了 0 次。
 * <p>
 * 提示：
 * 1 <= s.length <= 5 x 10^5
 * s 只包含小写英文字母。
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/20 09:17
 */
public class Day24 {

    private static char[] VOWEL = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) {
        String s = "eleetminicoworoep";
//        String s = "leetcodeisgreat";
//        String s = "bcbcbc";
        Day24 demo = new Day24();
        System.out.println(demo.findTheLongestSubstring(s));
        int status = 0;
        status ^= (1 << 4);
        System.out.println(status);
    }

    // 奇数-奇数=偶数, 偶数-偶数=偶数
    public int findTheLongestSubstring(String s) {
        int len = s.length();
        // 因为二进制(00000)-(11111)的十进制范围0~31,可以使用长度32的数组来存储对应的状态
        int[] pos = new int[1 << VOWEL.length];
        Arrays.fill(pos, -1);
        int ans = 0, status = 0;
        pos[0] = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            for (int j = 0; j < VOWEL.length; j++) {
                // 将每个元音的奇偶性记录在一个二进制中,0-偶数,1-奇数
                if (c == VOWEL[j]) {
                    status ^= (1 << j);
                }
            }
            if (pos[status] >= 0) {
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
        }
        return ans;
    }
}
