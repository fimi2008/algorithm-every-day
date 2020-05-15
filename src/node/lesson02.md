# 2-链表结构、栈、队列、递归行为、哈希表

## 单向链表和双向链表最简单的练习
>1)[单链表](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day02/Node.java)
>和[双链表](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day02/DoubleNode.java)
>如何反转<br>
 2)把给定值都删除

## 栈和队列
### 逻辑概念
>栈:数据先进后出，犹如弹匣<br>
 队列:数据先进先出，好似排队，

### 栈和队列的实际实现
* 双向链表实现 [案例](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day02/DoubleEndsQueue.java)
* 数组实现 [案例](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day02/RingArray.java)

## 栈和队列的常见面试题
### 怎么用数组实现不超过固定大小的队列和栈?
   * 栈:正常使用 [案例](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day02/RingArray.java)
   * 队列:环形数组 [案例](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day02/RingArray.java)

### 实现一个特殊的栈，在基本功能的基础上，再实现返回栈中最小元素的功能
> 1) pop、 push、 getMin操作的时间复杂度都是O(1)。<br>
> 2)设计的栈类型可以使用现成的栈结构。

### 如何用栈结构实现队列结构 [案例](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day02/StackImplementQueue.java)
### 如何用队列结构实现栈结构 [案例](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day02/QueueImplementStack.java)
