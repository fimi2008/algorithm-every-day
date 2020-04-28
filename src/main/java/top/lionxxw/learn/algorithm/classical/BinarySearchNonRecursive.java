package top.lionxxw.learn.algorithm.classical;

/**
 * 二分查找算法（非递归）
 * 举例:
 * [1,3,5,7,9,20,22,88,102], 查询 20 的下标
 * <p>
 *
 * @author wangxiang
 * created on 2020/4/28 19:34
 */
public class BinarySearchNonRecursive {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 20, 22, 88, 102};
        int target = 20;
        int result = binarySearch(arr, target);
        if (result > 0) {
            System.out.println("数组下标:" + result);
        } else {
            System.out.println("未找到该数");
        }
    }

    private static int binarySearch(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                // 向左找
                right = mid - 1;
            } else {
                // 向右找
                left = mid + 1;
            }
        }
        return -1;
    }
}
