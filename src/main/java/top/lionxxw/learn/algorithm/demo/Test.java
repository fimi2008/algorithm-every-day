package top.lionxxw.learn.algorithm.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 01.02. 判定是否互为字符重排
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 * <p>
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 * <p>
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/29 16:46
 */
public class Test {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int len = s1.length();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = chars1[i];
            Integer count = map.get(c);
            if (count != null) {
                if (count + 1 == 0) {
                    map.remove(c);
                } else {
                    map.put(c, count + 1);
                }
            } else {
                map.put(c, 1);
            }

            c = chars2[i];
            count = map.get(c);
            if (count != null) {
                if (count - 1 == 0) {
                    map.remove(c);
                } else {
                    map.put(c, count - 1);
                }
            } else {
                map.put(c, -1);
            }
        }
        return map.size() == 0;
    }
}
