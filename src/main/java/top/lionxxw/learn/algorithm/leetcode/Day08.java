package top.lionxxw.learn.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

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
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
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
//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);

//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(4);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(6);

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(demo.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
//        return recurse(root, null, null);
        return helper(root);
    }

    /**
     * 判断节点是否满足验证二叉搜索树
     * 方法一:递归
     * 复杂度分析
     * <p>
     * 时间复杂度 : O(n)，其中 n 为二叉树的节点个数。在递归调用的时候二叉树的每个节点最多被访问一次，因此时间复杂度为 O(n)。
     * <p>
     * 空间复杂度 : O(n)，其中 n 为二叉树的节点个数。递归函数在递归过程中需要为每一层递归函数分配栈空间，
     * 所以这里需要额外的空间且该空间取决于递归的深度，即二叉树的高度。最坏情况下二叉树为一条链，树的高度为 n ，递归最深达到 n 层，故最坏情况下空间复杂度为 O(n) 。
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
        // 判断节点的值是否在上下界内
        if (lower != null && node.val <= lower) {
            return false;
        }
        if (upper != null && node.val >= upper) {
            return false;
        }
        // 将当前节点的值替换为下界,继续检查右边的子节点   将当前节点的值替换为上界,继续检查左边的子节点
        return recurse(node.right, node.val, upper) && recurse(node.left, lower, node.val);
    }

    /**
     * 方法二: 中序排序
     * 中序遍历是二叉树的一种遍历方式，它先遍历左子树，再遍历根节点，最后遍历右子树。而我们二叉搜索树保证了左子树的节点的值均小于根节点的值，根节点的值均小于右子树的值，因此中序遍历以后得到的序列一定是升序序列。
     * <p>
     * 复杂度分析
     * <p>
     * 时间复杂度 : O(n)，其中 n 为二叉树的节点个数。二叉树的每个节点最多被访问一次，因此时间复杂度为 O(n)。
     * <p>
     * 空间复杂度 : O(n)，其中 n 为二叉树的节点个数。栈最多存储 n 个节点，因此需要额外的 O(n) 的空间。
     *
     * @param root 二叉树根节点
     * @return true/false
     */
    private boolean helper(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Integer order = null;
        while (!stack.isEmpty() || root != null) {
            // 第一步先遍历左子树
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 order，说明不是二叉搜索树
            if (order != null && root.val <= order) {
                return false;
            }
            order = root.val;
            root = root.right;
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
