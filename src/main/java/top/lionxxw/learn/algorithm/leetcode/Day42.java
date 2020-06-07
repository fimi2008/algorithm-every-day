package top.lionxxw.learn.algorithm.leetcode;

import java.util.*;

/**
 * 126. 单词接龙 II
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * <p>
 * 示例 1:
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出:
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * <p>
 * 示例 2:
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 输出: []
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 * <p>
 *
 * @author wangxiang
 * created on 2020/6/7 15:59
 */
public class Day42 {

    public static void main(String[] args) {
        String[] world = {"hot", "dot", "dog", "lot", "log", "cog"};
        String beginWord = "hit";
        String endWord = "cog";
        List<List<String>> res = findLadders(beginWord, endWord, Arrays.asList(world));
        System.out.println(res);
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> wordIdMap = new HashMap<>();
        ArrayList<String> wordIdList = new ArrayList<>();
        // 图
        ArrayList<Integer>[] edges;
        int index = 0;
        for (String word : wordList) {
            if (!wordIdMap.containsKey(word)) {
                wordIdMap.put(word, index++);
                wordIdList.add(word);
            }
        }
        // 若endWord不在wordList中 则无解
        if (!wordIdMap.containsKey(endWord)) {
            return new ArrayList<>();
        }
        // 把beginWord也加入wordId中
        if (!wordIdMap.containsKey(beginWord)) {
            wordIdMap.put(beginWord, index++);
            wordIdList.add(beginWord);
        }
        // 初始化存边用的数组
        edges = new ArrayList[wordIdMap.size()];
        for (int i = 0; i < wordIdMap.size(); i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < wordIdMap.size(); i++) {
            for (int j = i + 1; j < wordIdMap.size(); j++) {
                // 若两者可以通过转换得到 则在它们间建一条无向边
                if (isDiffOneWord(wordIdList.get(i), wordIdList.get(j))) {
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }
        int dest = wordIdMap.get(endWord); // 目的ID
        List<List<String>> res = new ArrayList<>(); // 存答案
        int[] cost = new int[index]; // 到每个点的代价
        for (int i = 0; i < index; i++) {
            cost[i] = Integer.MAX_VALUE; // 每个点的代价初始化为无穷大
        }

// 将起点加入队列 并将其cost设为0
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        ArrayList<Integer> tmpBegin = new ArrayList<>();
        tmpBegin.add(wordIdMap.get(beginWord));
        q.add(tmpBegin);
        cost[wordIdMap.get(beginWord)] = 0;

        // 开始广度优先搜索
        while (!q.isEmpty()) {
            ArrayList<Integer> now = q.poll();
            int last = now.get(now.size() - 1); // 最近访问的点
            if (last == dest) { // 若该点为终点则将其存入答案res中
                ArrayList<String> tmp = new ArrayList<>();
                for (int id : now) {
                    tmp.add(wordIdList.get(id)); // 转换为对应的word
                }
                res.add(tmp);
            } else { // 该点不为终点 继续搜索
                for (int i = 0; i < edges[last].size(); i++) {
                    int to = edges[last].get(i);
                    // 此处<=目的在于把代价相同的不同路径全部保留下来
                    if (cost[last] + 1 <= cost[to]) {
                        cost[to] = cost[last] + 1;
                        // 把to加入路径中
                        ArrayList<Integer> tmp = new ArrayList<>(now);
                        tmp.add(to);
                        q.add(tmp); // 把这个路径加入队列
                    }
                }
            }
        }
        return res;
    }

    private static boolean isDiffOneWord(String str1, String str2) {
        int diff = 0;
        for (int i = 0; i < str1.length() && diff < 2; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                ++diff;
            }
        }

        return diff < 2;
    }


}
