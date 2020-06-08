package top.lionxxw.learn.algorithm.lesson.day07;

/**
 * 请把一段纸条竖着放在桌子上，然后从纸条的下边向，上方对折1次，压出折痕<br>
 * 后展开。此时折痕是凹’下去的，即折痕突起的方向指向纸条的背面。如果从<br>
 * 纸条的下边向，上方连续对折2次，压出折痕后展开，此时有三条折痕，从上到<br>
 * 下依次是下折痕、下折痕和上折痕。<br>
 * 给定一个输入参数N，代表纸条都从下边向.上方连续对折N次。请从上到下打<br>
 * 印所有折痕的方向。<br>
 * 例如:N=1时，打印: down N=2时，打印: down down up
 * <p>
 *
 * @author wangxiang
 * created on 2020/6/8 21:37
 */
public class PaperFolding {

    public static void printAllFolds(int N) {
        printProcess(1, N, "凹");
    }

    public static void printProcess(int i, int N, String val) {
        if (i > N) {
            return;
        }
        printProcess(i + 1, N, "凹");
        System.out.print(i + val + "\t");
        printProcess(i + 1, N, "凸");
    }

    public static void main(String[] args) {
        printAllFolds(3);
    }
}
