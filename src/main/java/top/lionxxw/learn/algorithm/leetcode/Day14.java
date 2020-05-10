package top.lionxxw.learn.algorithm.leetcode;

import javafx.scene.transform.Rotate;

import java.util.*;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/10 21:16
 */
public class Day14 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        Day14 demo = new Day14();
        TreeNode node = demo.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4));
        System.out.println("root = " + node.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        dfs(root, p, q);
//        return this.ans;
        this.putParent(root);

        /**
         * 思路
         *
         * 我们可以用哈希表存储所有节点的父节点，然后我们就可以利用节点的父节点信息从 p 结点开始不断往上跳，并记录已经访问过的节点，再从 q 节点开始不断往上跳，如果碰到已经访问过的节点，那么这个节点就是我们要找的最近公共祖先。
         *
         * 算法
         *
         * 从根节点开始遍历整棵二叉树，用哈希表记录每个节点的父节点指针。
         * 从 p 节点开始不断往它的祖先移动，并用数据结构记录已经访问过的祖先节点。
         * 同样，我们再从 q 节点开始不断往它的祖先移动，如果有祖先已经被访问过，即意味着这是 p 和 q 的深度最深的公共祖先，即 LCA 节点
         *
         * 复杂度分析
         *
         * 时间复杂度：O(N)，其中 NN 是二叉树的节点数。二叉树的所有节点有且只会被访问一次，从 p 和 q 节点往上跳经过的祖先节点个数不会超过 NN，因此总的时间复杂度为 O(N)。
         *
         * 空间复杂度：O(N) ，其中 NN 是二叉树的节点数。递归调用的栈深度取决于二叉树的高度，二叉树最坏情况下为一条链，此时高度为 NN，因此空间复杂度为 O(N)，哈希表存储每个节点的父节点也需要 O(N) 的空间复杂度，因此最后总的空间复杂度为 O(N)。
         */
        while (p != null) {
            set.add(p.val);
            p = parentMap.get(p.val);
        }
        while (q != null) {
            if (set.contains(q.val)) {
                return q;
            }
            q = parentMap.get(q.val);
        }
        return null;
    }


    private TreeNode ans;

    /**
     * 递归实现
     * 从left节点查询,存在p,q节点表示lson=true
     * 从right节点查询,存在q,q节点表示rson=true
     * 最近公共祖先一定满足如下条件:(lson&&rson) || ((x==p||x==q )&& (lson||rson))
     * lson&&rson 表示:说明左子树和右子树均包含 p 节点或 q 节点
     * ((x==p||x==q )&& (lson||rson)) 表示: x 恰好是 p 节点或 q 节点且它的左子树或右子树有一个包含了另一个节点的情况，因此如果满足这个判断条件亦可说明 x 就是我们要找的最近公共祖先
     * <p>
     * 复杂度分析
     * <p>
     * 时间复杂度：O(N)，其中 N 是二叉树的节点数。二叉树的所有节点有且只会被访问一次，因此时间复杂度为 O(N)。
     * <p>
     * 空间复杂度：O(N) ，其中 N 是二叉树的节点数。递归调用的栈深度取决于二叉树的高度，二叉树最坏情况下为一条链，此时高度为 N，因此空间复杂度为 O(N)。
     */
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            this.ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    private Map<Integer, TreeNode> parentMap = new HashMap<>();

    private Set<Integer> set = new HashSet<>();

    private void putParent(TreeNode root) {
        if (root.left != null) {
            parentMap.put(root.left.val, root);
            putParent(root.left);
        }
        if (root.right != null) {
            parentMap.put(root.right.val, root);
            putParent(root.right);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
