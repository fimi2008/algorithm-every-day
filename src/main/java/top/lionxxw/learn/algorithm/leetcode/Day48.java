package top.lionxxw.learn.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 示例:
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 *
 * @author wangxiang
 * created on 2020/6/16 09:59
 */
public class Day48 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Day48 demo = new Day48();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String serialize = demo.serialize(root);
        System.out.println(serialize);
        TreeNode deserialize = demo.deserialize(serialize);
        System.out.println(deserialize);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        process(root, list);
        return list.toString();
    }

    private void process(TreeNode node, List<Integer> list) {
        if (node == null) {
            list.add(null);
            return;
        }
        list.add(node.val);
        process(node.left, list);
        process(node.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")){
            return null;
        }
        data = data.replaceAll("\\[","");
        data= data.replaceAll("]","");
        String[] arr = data.split(",");
        Queue<Integer> list = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            String val = arr[i].trim();
            if (val.equals("null")) {
                list.add(null);
            } else {
                list.add(Integer.parseInt(val));
            }
        }
        System.out.println(list);
        TreeNode head = preb(list);
        return head;
    }

    private static TreeNode preb(Queue<Integer> prelist) {
        Integer value = prelist.poll();
        if (value == null) {
            return null;
        }
        TreeNode head = new TreeNode(value);
        head.left = preb(prelist);
        head.right = preb(prelist);
        return head;
    }
}