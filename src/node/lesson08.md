# 8-二叉树的递归套路
>可以解决面试中绝大多数的二叉树问题尤其是树型dp问题
本质是利用递归遍历二叉树的便利性

>1)假设以X节点为头，假设可以向X左树和X右树要任何信息<br>
2)在上一步的假设下，讨论以X为头节点的树，得到答案的可能性(最重要)<br>
3)列出所有可能性后，确定到底需要向左树和右树要什么样的信息<br>
4)把左树信息和右树信息求全集，就是任何一棵子树都需要返回的信息S<br>
5)递归函数都返回S，每一棵子树都这么要求<br>
6)写代码，在代码中考虑如何把左树的信息和右树信息整合出整棵树的信息

## 二叉树的递归套路深度实践
1. 给定一棵二叉树的头节点head,返回这颗二叉树是不是平衡二叉树
[答案](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day08/IsBalanced.java)

2. 给定一棵二叉树的头节点head,任何两个节点之间都存在距离，返回整棵二叉树的最大距离
[答案](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day08/MaxDistance.java)

3. 给定一棵二叉树的头节点head,返回这颗二叉树中最大的二叉搜索子树的头节点
[答案](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day08/MaxSubBSTHead.java)

4. 派对的最大快乐值
>这个公司现在要办party,你可以决定哪些员工来，哪些员工不来，规则:<br>
  1.如果某个员工来了，那么这个员工的所有直接下级都不能来<br>
  2.派对的整体快乐值是所有到场员工快乐值的累加<br>
  3.你的目标是让派对的整体快乐值尽量大<br>
  给定一棵多叉树的头节点boss，请返回派对的最大快乐值。[答案](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day08/MaxHappy.java)<br>

5. 给定一棵二叉树的头节点head,返回这颗二叉树是不是满二叉树
[答案](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day08/IsFullTree.java)

6.给定一棵二叉树的头节点head,返回这颗二叉树中是不是完全二叉树
[答案](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day08/IsCBT.java)