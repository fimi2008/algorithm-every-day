package top.lionxxw.learn.algorithm.leetcode;

/**
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/31 09:50
 */
public class Day35 {

    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    /**
     *  镜像二叉树:
     *  1.根节点相同
     *  2.左子节点==另一个镜像的右子节点,右子节点==镜像的左子节点
     */
    private boolean isSymmetric(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right ==null){
             return false;
        }
        if (left.val != right.val){
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
}
