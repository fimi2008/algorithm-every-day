package top.lionxxw.learn.algorithm.lesson.day01;

/**
 * 案例
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/13 20:21
 */
public class EvenTimesOddTimes {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
        printOddTimesNumOne(arr);
    }

    /**
     * @param arr 中,只有一种树出现奇数次
     */
    public static void printOddTimesNumOne(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res ^= arr[i];
        }
        System.out.println("出现奇数次的数:" + res);
    }

    /**
     * @param arr arr 中,只有两种树出现奇数次
     */
    public static void printOddTimesNumTwo(int[] arr){
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res ^= arr[i];
        }
    }
}
