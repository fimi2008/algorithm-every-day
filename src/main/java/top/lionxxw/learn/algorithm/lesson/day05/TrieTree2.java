package top.lionxxw.learn.algorithm.lesson.day05;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀树
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/27 23:08
 */
public class TrieTree2 {

    public static void main(String[] args) {
        TrieTree2 trieTree = new TrieTree2();
        trieTree.insert("abc");
        trieTree.insert("abcd");
        trieTree.insert("abd");
        trieTree.insert("ksg");
        trieTree.insert("xxws");
        System.out.println(trieTree.search("ksg"));
        System.out.println(trieTree.search("ab"));
        System.out.println(trieTree.prefixNumber("ab"));
        System.out.println(trieTree.search("abd"));
        trieTree.delete("abd");
        System.out.println(trieTree.search("abd"));
        System.out.println(trieTree.prefixNumber("ab"));
    }

    private Node root;

    public TrieTree2() {
        this.root = new Node();
    }

    /**
     * 插入字符串
     *
     * @param words
     */
    public void insert(String words) {
        if (words == null) {
            return;
        }
        char[] chars = words.toCharArray();
        Node node = root;
        node.pass++;
        int index;
        for (char c : chars) {
            index = c;
            if (!node.nexts.containsKey(index)) {
                node.nexts.put(index, new Node());
            }
            node = node.nexts.get(index);
            node.pass++;
        }
        node.end++;
    }

    /**
     * 查询满足字符串的个数
     *
     * @param words
     * @return
     */
    public int search(String words) {
        if (words == null) {
            return 0;
        }
        char[] chars = words.toCharArray();
        Node node = root;
        int index;
        for (char c : chars) {
            index = c;
            if (!node.nexts.containsKey(index)) {
                return 0;
            }
            node = node.nexts.get(index);
        }
        return node.end;
    }

    /**
     * 查询满足pre前缀的字符串个数
     *
     * @param pre 前缀
     * @return
     */
    public int prefixNumber(String pre) {
        if (pre == null) {
            return 0;
        }
        char[] chars = pre.toCharArray();
        Node node = root;
        int index;
        for (char c : chars) {
            index = c;
            if (!node.nexts.containsKey(index)) {
                return 0;
            }
            node = node.nexts.get(index);
        }
        return node.pass;
    }

    public void delete(String words) {
        if (search(words) > 0) {
            char[] chars = words.toCharArray();
            Node node = root;
            node.pass--;
            int index;
            for (char c : chars) {
                index = c;
                if (--node.nexts.get(index).pass == 0) {
                    node.nexts.remove(index);
                    return;
                }
                node = node.nexts.get(index);
            }
            node.end--;
        }
    }

    class Node {
        private int pass;
        private int end;
        private Map<Integer, Node> nexts;

        public Node() {
            this.pass = 0;
            this.end = 0;
            this.nexts = new HashMap<>();
        }
    }
}
