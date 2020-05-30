package top.lionxxw.learn.algorithm.leetcode;

import java.util.*;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * 示例:
 * <p>
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/28 10:21
 */
public class Day32 {

    public static void main(String[] args) {
        String str = "13[a]2[bc]";
//        String str = "3[a2[c]]";
        System.out.println("result=" + decodeString2(str));
    }


    public static String decodeString(String s) {
        if (s == null) {
            return s;
        }
        Deque<Object> stack = new ArrayDeque<>();
        int index = 0;
        int num = 0;
        while (index < s.length()) {
            char cur = s.charAt(index);
            if (Character.isDigit(cur)) {
                // 数字
                num = num * 10 + cur - '0';
                index++;
            } else if (cur == '[') {
                stack.push(num);
                num = 0;
                index++;
            } else if (Character.isLetter(cur)) {
                // 字符
                stack.push(String.valueOf(cur));
                index++;
            } else {
                ++index;
                // ] 出栈
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() instanceof String) {
                    sb.append(stack.pop());
                }
                int times = (int) stack.pop();
                String temp = "";
                for (int i = 0; i < times; i++) {
                    temp += sb.toString();
                }
                stack.push(temp);
            }
        }

        System.out.println(stack);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty() && stack.peek() instanceof String) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    static int ptr;

    public static String decodeString2(String s) {
        LinkedList<String> stk = new LinkedList<String>();
        ptr = 0;

        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                // 获取一个数字并进栈
                String digits = getDigits(s);
                stk.addLast(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                // 获取一个字母并进栈
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                ++ptr;
                LinkedList<String> sub = new LinkedList<String>();
                while (!"[".equals(stk.peekLast())) {
                    sub.addLast(stk.removeLast());
                }
                Collections.reverse(sub);
                // 左括号出栈
                stk.removeLast();
                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                // 构造字符串
                while (repTime-- > 0) {
                    t.append(o);
                }
                // 将构造好的字符串入栈
                stk.addLast(t.toString());
            }
        }

        return getString(stk);
    }

    public static String getDigits(String s) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    public static String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }
}
