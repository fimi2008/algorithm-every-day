package top.lionxxw.learn.algorithm.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 739. 每日温度
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数
 * <p>
 *
 * @author wangxiang
 * created on 2020/6/11 13:37
 */
public class Day46 {
    public static void main(String[] args) {

//        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
//        int[] temperatures = {89, 62, 70, 58, 47, 47, 46, 76, 100, 70};
        int[] temperatures = {55, 38, 53, 81, 61, 93, 97, 32, 43, 78};
        int[] res = dailyTemperatures(temperatures);
        //[8,1,5,4,3,2,1,1,0,0]
        // [3,1,1,2,1,1,0,1,1,0]
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(dailyTemperatures2(temperatures)));
    }

    /**
     * 暴力解法
     *
     * @param T
     * @return
     */
    public static int[] dailyTemperatures(int[] T) {
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[T.length];
        int len = T.length;
        for (int i = 0; i < len - 1; i++) {
            stack.push(T[i]);
            int day = 0;
            for (int j = i + 1; j < len; j++) {
                if (T[j] <= T[i]) {
                    stack.push(T[j]);
                } else {
                    while (!stack.isEmpty()) {
                        day++;
                        stack.pop();
                    }
                    break;
                }
            }
            stack.clear();
            res[i] = day;
        }
        return res;
    }


    /**
     * 单调栈解法
     *
     * @param T
     * @return
     */
    public static int[] dailyTemperatures2(int[] T) {
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[T.length];
        int len = T.length;
        for (int i = 0; i < len; i++) {
            // 比较栈顶下标元素的值是否小于当前值
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                Integer preIndex = stack.pop();
                // preIndex的值在第i处找到大于的温度
                res[preIndex] = i - preIndex;
            }
            // 将新的温度压入栈顶
            stack.push(i);
        }
        return res;
    }
}
