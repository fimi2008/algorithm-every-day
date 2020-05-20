# 归并排序与随机快排

## 归并排序
>1)整体是递归，左边排好序+右边排好序+merge让整体有序
2)让其整体有序的过程里用了排外序方法
3)利用master公式来求解时间复杂度
4)当然可以用非递归实现
>[案例](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day03/MergeSort.java)

## 用常见面试题再深入理解一下归并排序的精髓
### 在一个数组虫，一个数左边比它小的数的总和，叫数的小和，所有数的小和累加起来，叫数组小和。我数组小和。
>例子: [1,3,4,2,5]
1左边比1小的数:没有
3左边比3小的数: 1
4左边比4小的数: 1、3
2左边比2小的数: 1
5左边比5小的数: 1、3、4、2
所以数组的小和为1+1+3+1+1+3+4+2=16
>[案例](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day03/ArraySmallSum.java)

### 求一个数组的降序对
[案例](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day03/OrderDesc.java)

## 快速排序
>Partition过程
给定一个数组arr，和一个整数num。请把小于等于num的数放在数组的左边,
大于num的数放在数组的右边。
要求额外空间复杂度0(1)，时间复杂度O(N)  
[案例](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day03/QuickSortQuestion.java)
[快速排序](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day03/QuickSort.java)