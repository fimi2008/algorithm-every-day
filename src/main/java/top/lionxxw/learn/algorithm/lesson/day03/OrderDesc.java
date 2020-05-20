package top.lionxxw.learn.algorithm.lesson.day03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 求一个数组的降序对
 * 举例:{3,1,7,0,2}
 * 降序对:{3,1}{3,0},{1,0}{7,0}{7,2}{3,2}
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/18 17:36
 */
public class OrderDesc {

    static List<int[]> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = {3, 1, 7, 0, 2};
        System.out.println(getOrderDesc(arr));
        for (int[] res : result) {
            System.out.println(Arrays.toString(res));
        }
        System.out.println(Arrays.toString(arr));
    }

    public static int getOrderDesc(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        int res = 0;
        while (p1 <= mid && p2 <= r) {
            if (arr[p1] > arr[p2]) {
                for (int j = p2; j <= r; j++){
                    result.add(new int[]{arr[p1], arr[j]});
                }
                res += r - p2 + 1;
                help[i++] = arr[p1++];
            } else {
                help[i++] = arr[p2++];
            }
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return res;
    }
}
