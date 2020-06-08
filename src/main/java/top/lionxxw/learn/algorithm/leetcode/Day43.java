package top.lionxxw.learn.algorithm.leetcode;

import java.util.Arrays;

/**
 * 990. 等式方程的可满足性
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
 * <p>
 * 示例 1：
 * 输入：["a==b","b!=a"]
 * 输出：false
 * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
 * <p>
 * 示例 2：
 * 输出：["b==a","a==b"]
 * 输入：true
 * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
 * <p>
 * 示例 3：
 * 输入：["a==b","b==c","a==c"]
 * 输出：true
 * <p>
 * 示例 4：
 * 输入：["a==b","b!=c","c==a"]
 * <p>
 * 输出：false
 * 示例 5：
 * 输入：["c==c","b==d","x!=z"]
 * 输出：true
 * <p>
 * 提示：
 * 1 <= equations.length <= 500
 * equations[i].length == 4
 * equations[i][0] 和 equations[i][3] 是小写字母
 * equations[i][1] 要么是 '='，要么是 '!'
 * equations[i][2] 是 '=
 * <p>
 *
 * @author wangxiang
 * created on 2020/6/8 13:26
 */
public class Day43 {
    public static void main(String[] args) {
        print(new String[]{"a==b", "b!=a"});
        print(new String[]{"b==a", "a==b"});
        print(new String[]{"a==b", "b==c", "a==c"});
        print(new String[]{"a==b", "b!=c", "c==a"});
        print(new String[]{"c==c", "b==d", "x!=z"});
    }

    private static void print(String[] equations) {
        System.out.println(Arrays.toString(equations) + " 结果:" + equationsPossible(equations));
    }

    // 并查集
    public static boolean equationsPossible(String[] equations) {
        int size = 'z' - 'a' + 1;
        int[] p = new int[size];
        // 先定义每个父节点指向自己本身
        for (int i = 0; i < size; i++) {
            p[i] = i;
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int index1 = equation.charAt(0) - 'a';
                int index2 = equation.charAt(3) - 'a';
                union(p, index1, index2);
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int index1 = equation.charAt(0) - 'a';
                int index2 = equation.charAt(3) - 'a';
                if (find(p, index1) == find(p, index2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void union(int[] p, int index1, int index2) {
        //将第一个变量的根节点的父节点指向第二个变量的根节点；
        p[find(p, index1)] = find(p, index2);
    }

    /**
     * 沿着当前变量的父节点一路向上查找，直到找到根节点
     */
    private static int find(int[] p, int index) {
        while (p[index] != index) {
            p[index] = p[p[index]];
            index = p[index];
        }
        return index;
    }
}
