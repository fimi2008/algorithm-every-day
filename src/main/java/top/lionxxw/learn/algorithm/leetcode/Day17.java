package top.lionxxw.learn.algorithm.leetcode;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/13 18:11
 */
public class Day17 {

    List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
        Day17 demo = new Day17();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(1);
        root.right.right.right = new TreeNode(2);
        List<List<Integer>> res = demo.bfs(root);
        for (List<Integer> item : res) {
            System.out.println(Arrays.toString(item.toArray()));
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return list;
        }
        dfs(root, 0);
        return list;
    }

    /**
     * BFS(广度优先搜索) 的应用一：层序遍历
     * 模式识别:一旦出现数 层次遍历,都可以用队列作为辅助结构
     */
    public List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root !=null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            // 得出当前层级的节点个数
            int len = queue.size();
            List<Integer> item = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                // 利用queue特性,先入先出,将当前层的节点都推出
                TreeNode node = queue.poll();
                item.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(item);
        }
        return res;
    }


    /**
     * 递归实现思路(深度优先搜索)
     * 时间复杂度:O(N)
     * 空间复杂度:O(N)
     * @param root  节点
     * @param level 层级
     */
    private void dfs(TreeNode root, int level) {
        // 每次进入一个新的层,创建一个新的列表
        if (list.size() == level) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        // 依次递归遍历左右树节点
        if (root.left != null) {
            dfs(root.left, level + 1);
        }
        if (root.right != null) {
            dfs(root.right, level + 1);
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
