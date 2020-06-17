package top.lionxxw.learn.algorithm.lesson.day08;

import java.util.ArrayList;
import java.util.List;

/**
 * 派对的最大快乐值
 * 这个公司现在要办party,你可以决定哪些员工来，哪些员工不来，规则:<br>
 * 1.如果某个员工来了，那么这个员工的所有直接下级都不能来<br>
 * 2.派对的整体快乐值是所有到场员工快乐值的累加<br>
 * 3.你的目标是让派对的整体快乐值尽量大<br>
 * 给定一棵多叉树的头节点boss，请返回派对的最大快乐值。<br>
 * <p>
 *
 * @author wangxiang
 * created on 2020/6/15 14:56
 */
public class MaxHappy {

    public static void main(String[] args) {
        int maxLevel = 4;
        int maxNexts = 7;
        int maxHappy = 100;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            Employee boss = genarateBoss(maxLevel, maxNexts, maxHappy);
            if (maxHappy1(boss) != getMaxHappy(boss)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }
    // for test
    public static Employee genarateBoss(int maxLevel, int maxNexts, int maxHappy) {
        if (Math.random() < 0.02) {
            return null;
        }
        Employee boss = new Employee((int) (Math.random() * (maxHappy + 1)));
        genarateNexts(boss, 1, maxLevel, maxNexts, maxHappy);
        return boss;
    }

    // for test
    public static void genarateNexts(Employee e, int level, int maxLevel, int maxNexts, int maxHappy) {
        if (level > maxLevel) {
            return;
        }
        int nextsSize = (int) (Math.random() * (maxNexts + 1));
        for (int i = 0; i < nextsSize; i++) {
            Employee next = new Employee((int) (Math.random() * (maxHappy + 1)));
            e.nexts.add(next);
            genarateNexts(next, level + 1, maxLevel, maxNexts, maxHappy);
        }
    }

    public static int maxHappy1(Employee boss) {
        if (boss == null) {
            return 0;
        }
        return process1(boss, false);
    }

    public static int process1(Employee cur, boolean up) {
        if (up) {
            int ans = 0;
            for (Employee next : cur.nexts) {
                ans += process1(next, false);
            }
            return ans;
        } else {
            int p1 = cur.happy;
            int p2 = 0;
            for (Employee next : cur.nexts) {
                p1 += process1(next, true);
                p2 += process1(next, false);
            }
            return Math.max(p1, p2);
        }
    }

    // 使用递归套路来解题
    public static int getMaxHappy(Employee boss) {
        if (boss == null) {
            return 0;
        }
        Info process = process(boss);
        return Math.max(process.yes, process.no);
    }

    public static Info process(Employee emp) {
        // 如果没有下级,最大的happy值为自己
        if (emp.nexts.isEmpty()) {
            return new Info(emp.happy, 0);
        }
        int yes = emp.happy;
        int no = 0;
        List<Employee> nexts = emp.nexts;
        for (Employee next : nexts) {
            // 获取每个下级员工.来和不来的happy值
            Info nextInfo = process(next);
            yes += nextInfo.no;
            // 不来需要计算来和不来的最大值
            no += Math.max(nextInfo.yes, nextInfo.no);
        }
        return new Info(yes, no);
    }

    public static class Employee {
        public int happy;
        public List<Employee> nexts;

        public Employee(int h) {
            happy = h;
            nexts = new ArrayList<>();
        }
    }

    public static class Info {
        // 员工来的最大happy值
        private int yes;
        // 员工不来的最大happy值
        private int no;

        public Info(int yes, int no) {
            this.yes = yes;
            this.no = no;
        }
    }
}
