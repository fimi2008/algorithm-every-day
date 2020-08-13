package top.lionxxw.learn.algorithm.leetcode;

/**
 * TODO
 * <p>
 *
 * @author wangxiang
 * created on 2020/6/23 09:32
 */
public class Day53 {

    public static void main(String[] args) {
        String a = "10001011";
        String b = "11";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }


}
