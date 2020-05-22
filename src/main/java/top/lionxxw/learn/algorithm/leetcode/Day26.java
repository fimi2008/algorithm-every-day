package top.lionxxw.learn.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/22 09:49
 */
public class Day26 {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        Day26 demo = new Day26();
        TreeNode treeNode = demo.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int perLen = preorder.length;
        int inLen = inorder.length;
        if (perLen != inLen) {
            throw new RuntimeException("Incorrect input data");
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, perLen - 1, map, 0, inLen - 1);
    }

    /**
     * @param preorder 前序遍历数组
     * @param preLeft 前序遍历的子区间左边界
     * @param preRight 前序遍历的子区间右边界
     * @param map 中序遍历数值与下标对应关系
     * @param inLeft 中序遍历的子区间左边界
     * @param inRight 中序遍历的子区间右边界
     * @return
     */
    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        // 如果左边界>右边界,则没有节点
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        /**
         * 前序遍历: 根 | 左子树 | 右子树
         * 中序遍历: 左子树 | 根 | 右子树
         * 前序遍历 根下标: preLeft | 左子树的左边界: preLeft + 1, 右子树的右边界: preRight
         * 中序遍历的根下标: pIndex | 左子树的左边界: inLeft, 左子树的右边界: pIndex - 1 | 右子树的左边界: pIndex + 1, 右子树的右边界: inRight
         * 综上得出:
         *  前序遍历的左子树右边界: pIndex-1-inLeft + preLeft + 1 = pIndex-inLeft+preLeft
         *  前序遍历的右子树左边界: pIndex-inLeft+preLeft + 1
         */
        Integer pIndex = map.get(rootVal);
        /**
         * 得出左子树
         * 前序遍历的区间:左子树的左边界: preLeft + 1 | 左子树右边界: pIndex-1-inLeft + preLeft + 1 = pIndex-inLeft+preLeft
         * 中序遍历的区间:左子树的左边界: inLeft | 左子树右边界: pIndex - 1
         */
        root.left = buildTree(preorder, preLeft + 1, pIndex - inLeft + preLeft, map, inLeft, pIndex - 1);
        /**
         * 得出右子树:
         * 前序遍历的区间:右子树的左边界:pIndex-inLeft+preLeft + 1 | 右子树的右边界:preRight
         * 中序遍历的区间:右子树的左边界:pIndex + 1| 右子树的右边界:inRight
         */
        root.right = buildTree(preorder, pIndex - inLeft + preLeft + 1, preRight, map, pIndex + 1, inRight);
        return root;
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
