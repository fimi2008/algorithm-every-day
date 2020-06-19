package top.lionxxw.learn.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1028. 从先序遍历还原二叉树
 * 我们从二叉树的根节点 root 开始进行深度优先搜索。
 * <p>
 * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
 * 如果节点只有一个子节点，那么保证该子节点为左子节点。
 * 给出遍历输出 S，还原树并返回其根节点 root。
 * <p>
 * 示例 1：
 * 输入："1-2--3--4-5--6--7"
 * 输出：[1,2,5,3,4,6,7]
 * <p>
 * 示例 2：
 * 输入："1-2--3---4-5--6---7"
 * 输出：[1,2,5,3,null,6,null,4,null,7]
 * <p>
 * 示例 3：
 * 输入："1-401--349---90--88"
 * 输出：[1,401,null,349,88,90]
 * <p>
 *
 * @author wangxiang
 * created on 2020/6/18 10:00
 */
public class Day50 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        String str = "1-401--349---90--88";
        TreeNode treeNode = recoverFromPreorder(str);
        System.out.println(treeNode);
    }

    public static TreeNode recoverFromPreorder(String S) {
        if (S == null || "".equals(S)) {
            return null;
        }
        String[] arr = S.split("-");
        Deque<TreeNode> queue = new LinkedList<>();
        int level = 0;
        int pos = 0;
        while (pos < arr.length) {
            if (pos > 0){
                level = 1;
            }
            while ("".equals(arr[pos])) {
                ++level;
                ++pos;
            }
            int value = Integer.valueOf(arr[pos]);
            pos++;
            TreeNode node = new TreeNode(value);
            if (level == queue.size()) {
                if (!queue.isEmpty()) {
                    queue.peek().left = node;
                }
            } else {
                while (level != queue.size()) {
                    queue.pop();
                }
                queue.peek().right = node;
            }
            queue.push(node);
        }
        while (queue.size() > 1) {
            queue.pop();
        }
        return queue.peek();
    }
}
