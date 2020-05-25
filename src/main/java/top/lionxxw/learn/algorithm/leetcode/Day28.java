package top.lionxxw.learn.algorithm.leetcode;

import java.util.Arrays;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/24 11:51
 */
public class Day28 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println(findMedianSortedArrays2(nums1, nums2));
    }

    /**
     * 合并两个有序数组,求中位数
     * 本方法时间复杂度:O(m+n),空间复杂度O(1)
     * 不满足题目要求的log(m+n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int[] nums = new int[len];
        int p1 = 0;
        int p2 = 0;
        int index = 0;
        while (p1 < len1 && p2 < len2) {
            if (nums1[p1] < nums2[p2]) {
                nums[index++] = nums1[p1++];
            } else {
                nums[index++] = nums2[p2++];
            }
        }
        while (p1 < len1) {
            nums[index++] = nums1[p1++];
        }
        while (p2 < len2) {
            nums[index++] = nums2[p2++];
        }
        System.out.println(Arrays.toString(nums));
        if (len % 2 == 0) {
            int mid = len / 2;
            return (nums[mid] + nums[mid - 1]) / 2.0;
        } else {
            return nums[len / 2];
        }
    }

    /**
     * 数组长度
     * 偶数时,中位数为左侧数组的最大值,右侧数组的最小值
     * 奇数时,把中位数放入左侧数组中,即左侧数组的最大值为中位数
     * <p>
     * 将两个有序数组分割为2个部分:
     * 1.保证左边部分和右边部分相等(m+n为偶数情况),或者左边比右边多一个元素(m+n为奇数情况)
     * 2.左边所有元素的值小于等于右边所有元素的值
     * <p>
     * 假设:数组1长度m,数组2长度n
     * 当m+n为偶数时,sizeLeft = (m+n)/2
     * 当m+n为奇数时:sizeLeft = (m+n+1)/2
     * <p>
     * 由于m+n为偶数时,(m+n)/2 = (m+n+1)/2
     * 所以为了方便将上面的公式统一为 sizeLeft = (m+n+1)/2,这样就不用区分m+n的奇偶性,只需要确定一个数组的分割位置.
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        // 保证nums1的长度小于nums2
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;
        // 左边所有元素的个数
        int sizeLeft = (m + n + 1) / 2;
        // 在nums1的[0,m]里查找分割线
        int left = 0;
        int right = m;
        while (left < right) {
            // 定义数组1,右边第一个元素的下标
            int i = left + (right - left + 1) / 2;
            // 定义数组2,右边第一个元素的下标 通过 i+j = (m+n+1)/2 => i+j = sizeLeft => j = sizeLeft - i
            int j = sizeLeft - i;
            // nums1[i-1] <= nums2[j] && nums2[j-1] <= nums1[i]
            if (nums1[i - 1] > nums2[j]) {
                // 下一轮搜索区间[left, i - 1]
                right = i - 1;
            } else {
                // 下一轮搜索区间[i, right]
                left = i;
            }
        }
        int i = left;
        int j = sizeLeft - i;
        int leftMax1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int rightMax1 = i == m ? Integer.MAX_VALUE : nums1[i];
        int leftMax2 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int rightMax2 = j == n ? Integer.MAX_VALUE : nums2[j];

        if ((m + n) % 2 == 1) {
            return  Math.max(leftMax1, leftMax2);
        }else{
            int midLeft = Math.max(leftMax1, leftMax2);
            int midRight = Math.min(rightMax1, rightMax2);
            return (midLeft + midRight) / 2.0;
        }
    }
}
