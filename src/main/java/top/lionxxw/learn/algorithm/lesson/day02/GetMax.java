package top.lionxxw.learn.algorithm.lesson.day02;

/**
 * 使用递归实现最大值
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/15 13:49
 */
public class GetMax {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 3, 4, 5, 2};
        System.out.println(getMax(arr));
    }

    /**
     * 时间复杂度:O(N)
     * T(N) = aT(N/b)+O(N^d) => T(N) = 2T(N/2)+O(N^0) = N
     * @param arr
     * @return
     */
    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    /**
     * arr[l..r]范围上的最大值
     */
    public static int process(int[] arr, int l, int r) {
        if (l == r) {
            // O(N^0)
            return arr[l];
        }
//        int mid = l + (r - l) / 2;
        // 计算中点
        int mid = l + ((r - l) >> 2);
        // T(N/2)
        int left = process(arr, l, mid);
        // T(N/2)
        int right = process(arr, mid + 1, r);
        return Math.max(left, right);
    }
}
