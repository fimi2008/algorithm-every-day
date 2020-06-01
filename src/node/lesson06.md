# 6-链表相关面试题

## 链表问题
>面试时链表解题的方法论
1)对于笔试，不用太在乎空间复杂度，一切为了时间复杂度
2)对于面试，时间复杂度依然放在第一位，但是一定要找到空间最省的方法

## 快慢指针
>1)输入链表头节点，奇数长度返回中点，偶数长度返回上中点
2)输入链表头节点，奇数长度返回中点，偶数长度返回下中点
3)输入链表头节点，奇数长度返回中点前一个，偶数长度返回上中点前一个
4)输入链表头节点，奇数长度返回中点前一个，偶数长度返回下中点前一个
>[案例](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day06/LinkedListMid.java)

## 常见面试题
>给定一个单链表的头节点head,请判断该链表是否为回文结构。[案例](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day06/IsPalindromeList.java)
1)栈方法特别简单(笔试用)
2)改原链表的方法就需要注意边界了(面试用)

>将单向链表按某值划分成左边小、中间相等、右边大的形式 [案例](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day06/SmallerEqualBigger.java)
1)把链表放入数组里，在数组上做partition (笔试用)
2)分成小、中、大三部分，再把各个部分之间串起来(面试用)

>一种特殊的单链表节点类描述如下
 class Node {
 int value;
 Node next;
 Node rand;
 Node(int val) {value = val; }
 }
 rand指针是单链表节点结构中新增的指针，rand可能指向链表中的任意一个节点，也可能指向null。
 给定一个由Node节点类型组成的无环单链表的头节点head,请实现-个函数完成这 个链表的复制，并返回复制的新链表的头节点。
 [要求]
 时间复杂度O(N)，额外空间复杂度0(1) [案例](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day06/CopyListWithRandom.java)

>给定两个可能有环也可能无环的单链表，头节点head1和head2。
 请实现一个函数，如果两个链表相交，请返回相交的第一个节点。
 如果不相交，返回null
 [要求]
 如果两个链表长度之和为N，时间复杂度请达到O(N)，额外空间复
 杂度请达到O(1)。 [案例](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day06/FindFirstIntersectNode.java)

>能不能不给单链表的头节点，只给想要删除的节点，就能做到在链表上把这个点删掉?[案例](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day06/Test.java)
>答案:不可以,虽然可以通过实现值替换将需要删除的节点的属性替换至删除节点上,但是这个操作删除的不是原对象而是下一个节点对象.本题主要考内存模型的理解,