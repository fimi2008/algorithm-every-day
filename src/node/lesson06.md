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

>将单向链表按某值划分成左边小、中间相等、右边大的形式
1)把链表放入数组里，在数组上做partition (笔试用)
2)分成小、中、大三部分，再把各个部分之间串起来(面试用)