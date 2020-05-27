package top.lionxxw.learn.algorithm.leetcode;

/**
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 * <p>
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/26 15:18
 */
public class Day30 {

    public static void main(String[] args) {
        int[] nums = {1, 1};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        int left = 1, right = n - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int cnt = 0;
            // [1,4] mid=2 cnt= 3
            // cnt > mid [1,2]
            // [1,2] mid=1 cnt=1
            // cnt = mid left = 1+1 =2
            for (int i = 0; i < n; i++) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = mid;
            }
        }

        return ans;
    }
}
