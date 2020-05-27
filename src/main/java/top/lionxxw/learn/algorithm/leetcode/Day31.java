package top.lionxxw.learn.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 974. 和可被 K 整除的子数组
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 * <p>
 * 示例：
 * <p>
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/27 09:36
 */
public class Day31 {

    public static void main(String[] args) {
        int[] arr = {4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println(subarraysDivByK(arr, k));
    }

    /**
     * P[i] = A[0]+ A[1]+ A[2]+...+ A[i]
     * sum[i,j] = P[j] - P[i-1]
     * 根据同余定理:
     * (P[j] - P[i-1])%K == 0
     * ==> 可以推导出 P[j] %K == P[i-1] %K
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(min(N,K))，
     */
    public static int subarraysDivByK(int[] A, int K) {
        // key为前缀和取模, value为次数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int pre = 0, count = 0;
        for (int i : A) {
            pre += i;
            // 过滤去取为负数的情况
            int m = (pre % K + K) % K;
            int same = map.getOrDefault(m, 0);
            if (same > 0) {
                System.out.println("same = " + same + ", i=" + i + ",pre = " + pre + ",m=" + m);
            }
            count += same;
            map.put(m, same + 1);
        }
        return count;
    }
}
