package top.lionxxw.learn.algorithm.leetcode;

/**
 * 572. 另一个树的子树
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树
 * 示例 1:
 * 给定的树 s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * 给定的树 t：
 * <p>
 * 4
 * / \
 * 1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 2:
 * 给定的树 s：
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * /
 * 0
 * 给定的树 t：
 * <p>
 * 4
 * / \
 * 1   2
 * 返回 false。
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/7 18:51
 */
public class Day11 {

    public static void main(String[] args) {
//        TreeNode s = new TreeNode(3);
//        s.left = new TreeNode(4);
//        s.right = new TreeNode(5);
//        s.left.left = new TreeNode(1);
//        s.left.right = new TreeNode(2);
//
//        TreeNode t = new TreeNode(4);
//        t.left = new TreeNode(1);
//        t.right = new TreeNode(2);

        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);
        s.left.right.left = new TreeNode(0);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);
        Day11 demo = new Day11();
        System.out.println(demo.isSubtree(s, t));
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null){
            return true;
        }
        if (s == null){
            return false;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s, t);
    }

    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == t) {
            return true;
        }
        if (s == null || t == null){
            return false;
        }
        if (s.val != t.val){
            return false;
        }
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
