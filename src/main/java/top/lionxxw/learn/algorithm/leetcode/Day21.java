package top.lionxxw.learn.algorithm.leetcode;

import java.util.*;

/**
 * 210. 课程表 II
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * <p>
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2:
 * <p>
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 说明:
 * <p>
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 提示:
 * <p>
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 拓扑排序也可以通过 BFS 完成。
 * <p>
 *
 * @author wangxiang
 * created on 2020/5/17 20:45
 */
public class Day21 {
    public static void main(String[] args) {
        Day21 demo = new Day21();
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] res = demo.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(res));
    }

    private Map<Integer, List<Integer>> edges;
    private int[] indeg;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new HashMap<>(numCourses);
        indeg = new int[numCourses];
        Arrays.fill(indeg, 0);
        for (int[] info : prerequisites) {
            List<Integer> courses = edges.get(info[1]);
            if (courses == null) {
                courses = new ArrayList<>();
            }
            courses.add(info[0]);
            edges.put(info[1], courses);
            indeg[info[0]] = ++indeg[info[0]];
        }
        Queue<Integer> queue = new ArrayDeque();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer u = queue.poll();
            res.add(u);
            if (edges.containsKey(u)){
                for (Integer cours : edges.get(u)) {
                    indeg[cours] = --indeg[cours];
                    if (indeg[cours] == 0){
                        queue.add(cours);
                    }
                }
            }
        }
        if (res.size() != numCourses){
            return new int[]{};
        }

        int[] r = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }
        return r;
    }
}
