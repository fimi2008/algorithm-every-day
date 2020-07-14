package top.lionxxw.learn.algorithm.leetcode;

/**
 * 124. 二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * 输出: 6
 * 示例 2:
 * <p>
 * 输入: [-10,9,20,null,null,15,7]
 * <p>
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 输出: 42
 * <p>
 *
 * @author wangxiang
 * created on 2020/6/21 20:11
 */
public class Day52 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    private static class Info {
        // 左+中
        int leftMax;
        // 右+中
        int rightMax;
        // 左+中+右
        int max;

        public Info(int leftMax, int rightMax, int max) {
            this.leftMax = leftMax;
            this.rightMax = rightMax;
            this.max = max;
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(4);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(11);
        head.left.left.left = new TreeNode(13);
        head.left.left.right = new TreeNode(4);
        head.left.left.left.left = new TreeNode(7);
        head.left.left.left.right = new TreeNode(2);
        head.left.left.left.right.right = new TreeNode(1);
        System.out.println(maxPathSum(head));
    }

    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Info info = process(root);
        return Math.max(Math.max(info.max, info.leftMax), info.rightMax);
    }

    private static Info process(TreeNode x) {
        if (x == null) {
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int leftMax = x.val;
        int rightMax = x.val;
        int max = x.val;
        if (leftInfo != null) {
            leftMax = Math.max(Math.max(leftInfo.leftMax, leftInfo.leftMax + x.val), leftInfo.max);
            max = Math.max(max, leftMax);
        }
        if (rightInfo != null) {
            rightMax = Math.max(Math.max(rightInfo.rightMax, rightInfo.rightMax + x.val), rightInfo.max);
            max = Math.max(max, rightMax);
        }
        max = Math.max(max, (leftInfo ==null? 0: leftInfo.leftMax) + (rightInfo == null?0 : rightInfo.rightMax) + x.val);
        return new Info(leftMax, rightMax, max);
    }
}
