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

## 特别注意点
> Java 程序员，别用 Stack？！[为什么?](https://mp.weixin.qq.com/s/Ba8jrULf8NJbENK6WGrVWg)
> 1.Java中的Stack继承Vector类,违反了OOP设计原则(Composition over inheritance 即组合优于继承),
> Stack和Vector应该是has-a的关系,不应该是is-a;
> 判断is-a和has-a的一个简单原则:判断一下，如果设计成继承关系的话，我们是否有可能把子类进行向上的父类转型？如果可能，则应该设计成继承关系，否则应该是组合关系。
> 2.在Stack类的说明上推荐写法:Deque<Integer> stack = new ArrayDeque<>(); 
> 3.其实使用Deque也是有问题,Deque 是双端队列,可以两端插入和删除,而Stack的数据结构只能在同一端操作,这是属于Java的历史遗留问题,至今无聊;
> 最简单的解决方法就是在封装一层,限制只能在一端进行插入和删除操作.

### 实现一个特殊的栈，在基本功能的基础上，再实现返回栈中最小元素的功能
> 1) pop、 push、 getMin操作的时间复杂度都是O(1)。<br>
> 2)设计的栈类型可以使用现成的栈结构。

### 如何用栈结构实现队列结构 [案例](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day02/StackImplementQueue.java)
### 如何用队列结构实现栈结构 [案例](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day02/QueueImplementStack.java)

## 递归
> 任何递归问题都可以改成非递归问题.
> 为什么? 因为递归是利用系统栈实现方法调用,可以使用代码模拟系统栈调用

### 递归公式: T(N) = aT(N/b)+O(N^d) 其中a,b,d 为常数
1. logba>d O(Nlogba)
2. logba<d O(N^d)
3. logba=d O(N^d*logN)

### 求数组arr[L. R]中的最大值，怎么用递归方法实现。
> 1)将[L. .R]范围分成左右两半。左: [L.Mid]右[Mid+1..R] <br>
> 2)左部分求最大值，右部分求最大值<br>
> 3)[L.R]范围.上的最大值，是max{左部分最大值，右部分最大值}<br>
> 注意: 2)是个递归过程，当范围上只有一个数，就可以不用再递归了  [案例](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day02/GetMax.java)