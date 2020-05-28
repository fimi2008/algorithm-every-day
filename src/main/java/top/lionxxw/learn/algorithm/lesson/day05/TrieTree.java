package top.lionxxw.learn.algorithm.lesson.day05;

/**
 * 前缀树
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/27 23:08
 */
public class TrieTree {

    public static void main(String[] args) {
        TrieTree trieTree = new TrieTree();
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

    public TrieTree() {
        this.root = new Node();
    }

    /**
     * 插入字符串
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
            index = c - 'a';
            if (node.nexts[index] == null) {
                node.nexts[index] = new Node();
            }
            node = node.nexts[index];
            node.pass++;
        }
        node.end++;
    }

    /**
     * 查询满足字符串的个数
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
            index = c - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.end;
    }

    /**
     * 查询满足pre前缀的字符串个数
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
            index = c - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
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
                index = c - 'a';
                if (--node.nexts[index].pass == 0) {
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];
            }
            node.end--;
        }
    }

    class Node {
        private int pass;
        private int end;
        private Node[] nexts;

        public Node() {
            this.pass = 0;
            this.end = 0;
            // 创建小写a-z的26个分叉路
            this.nexts = new Node[26];
        }
    }
}
