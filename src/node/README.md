# 算法学习笔记
## [1-认识复杂度、对数器、二分法与异或运算](https://github.com/fimi2008/algorithm-every-day/blob/master/src/node/lesson01.md)
## [2-链表结构、栈、队列、递归行为、哈希表](https://github.com/fimi2008/algorithm-every-day/blob/master/src/node/lesson02.md)
## [3-归并排序与随机快排](https://github.com/fimi2008/algorithm-every-day/blob/master/src/node/lesson03.md)
## [4-比较器与堆](https://github.com/fimi2008/algorithm-every-day/blob/master/src/node/lesson04.md)
## [5-trie、桶排序、排序总结](https://github.com/fimi2008/algorithm-every-day/blob/master/src/node/lesson05.md)

## 排序算法总结
| 排序算法 | 时间复杂度 | 空间复杂度 | 稳定性 |
| ---- | ---- | ---- | ---- |
| 选择排序 | O(N^2) | O(1) | 无 |
| 冒泡排序 | O(N^2) | O(1) | 有 |
| 插入排序 | O(N^2) | O(1) | 有 |
| 归并排序 | O(N*logN) | O(N) | 有 |
| 随机排序 | O(N*logN) | O(logN) | 无 |
| 堆排序 | O(N*logN) | O(1) | 无 |
| 计数排序 | O(N) | O(M) | 有 |
| 基数排序 | O(N) | O(N) | 有 |

>1)不基于比较的排序，对样本数据有严格要求，不易改写
2)基于比较的排序，只要规定好两个样本怎么比大小就可以直接复用
3)基于比较的排序，时间复杂度的极限是O(N\*logN)
4)时间复杂度O(N*logN)、额外空间复杂度低于O(N)、且稳定的基于比较的
排序是不存在的。
5)为了绝对的速度选快排、为了省空间选堆排、为了稳定性选归并

## 常见的坑
>1)归并排序的额外空间复杂度可以变成0(1)，“归并排序内部缓存法”，但是
将变得不再稳定。
2)“原地归并排序"是垃圾贴，会让时间复杂度变成O(N^2)
3)快速排序稳定性改进，“01 stable sort"，但是会对样本数据要求更多。

>在整型数组中，请把奇数放在数组左边，偶数放在数组右边，要求所有奇数
之间原始的相对次序不变，所有偶数之间原始相对次序不变。
时间复杂度做到O(N)，额外空间复杂度做到O(1)
>遇到这道题,改如何回答: 这是一个0,1标准的partition,原始的partition是小于等于某个数放左边,大于某个数放右边,
>快排的partition是做不到稳定性的,那么为什么快排是做不到稳定性的

## 工程上对排序的改进
>1)稳定性的考虑.
2)充分利用O(N*logN)和O(N^2)排序各自的优势
系统提供的排序是会先做个反射,会判断排序的元素是值传递还是引用传递的,如果是值传递的,会使用快排,
>如果是引用传递,会使用归并排序,为了保证排序的稳定性.