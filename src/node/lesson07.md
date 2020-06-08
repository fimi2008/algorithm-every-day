# 7-二叉树的基本算法

## 二叉树的先序、中序、后序遍历
>先序:任何子树的处理顺序都是，先头节点、再左子树、然后右子树<br>
中序:任何子树的处理顺序都是，先左子树、再头节点、然后右子树<br>
后序:任何子树的处理顺序都是，先左子树、再右子树、然后头节点<br>

## 递归方式实现二叉树的先序、中序、后序遍历
1)理解递归序(每个节点都会遍历3次)<br>
2)先序、中序、后序都可以在递归序的基础上加工出来<br>
3)第一次到达一个节点就打印就是先序、第二次打印即中序、第三次即后序
```
 /*
  *      1
  *     /  \
  *   2     3
  *  / \   / \
  * 4  5  6   7
  */
递归经过的节点顺序:
1->2->4->4->4->2->5->5->5->2->1->3->6->6->6->3->7->7->7->3->1
如果第一次经过节点就打印为前序:1->2->4->5->3->6->7
如果第二次经过节点就打印为中序:4->2->5->1->6->3->7
如果第三次经过节点就打印为后序:4->5->2->6->7->3->1
```
[递归实现二叉树的前序,中序,后序](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day07/RecursiveTraversalBT.java)
[非递归实现二叉树的前序,中序,后序](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day07/UnRecursiveTraversalBT.java)

## 实现二叉树的按层遍历
>1)其实就是宽度优先遍历，用队列[案例](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day07/LevelTraversalBT.java)<br>
2)可以通过设置flag变量的方式，来发现某一层的结束(看题目)[案例](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day07/TreeMaxWidth.java)<br>

## 二叉树的序列化和反序列化
>1)可以用先序或者中序或者后序或者按层遍历，来实现二叉树的序列化<br>
2)用了什么方式序列化，就用什么样的方式反序列化

## 如何设计一个打印整棵树的打印函数
> [案例](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day07/PrintBinaryTree.java)<br>

## 求二叉树最宽的层有多少个节点
> [案例](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day07/TreeMaxWidth.java)<br>

## 找一个节点的后继节点(中序遍历的后一个节点)
> [案例](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day07/SuccessorNode.java)<br>
```
// 节点数据结果如下
public static class Node {
	public int value;
	public Node left;
	public Node right;
	public Node parent;

	public Node(int data) {
		this.value = data;
	}
}
```