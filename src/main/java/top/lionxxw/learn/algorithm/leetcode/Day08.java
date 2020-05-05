package top.lionxxw.learn.algorithm.leetcode;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 *  2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 *  5
 * / \
 * 1   4
 *    / \
 *   3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/5 23:17
 */
public class Day08 {

    public static void main(String[] args) {
        Day08 demo = new Day08();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
//        root.left =  new TreeNode(1);
//        root.right = new TreeNode(4);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(6);
        boolean validBST = demo.isValidBST(root);
        System.out.println(validBST);
    }

    public boolean isValidBST(TreeNode root) {
        return recurse(root, null, null);
    }

    /**
     * 判断节点是否满足验证二叉搜索树
     *
     * @param node  节点信息
     * @param lower 下限
     * @param upper 上限
     * @return 是否满足
     */
    private boolean recurse(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        // 判断节点的值是否在上下界内
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }
        // 将当前节点的值替换为下界,继续检查右边的子节点
        if (!recurse(node.right, val, upper)) {
            return false;
        }
        // 将当前节点的值替换为上界,继续检查左边的子节点
        if (!recurse(node.left, lower, val)) {
            return false;
        }
        return true;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
}
