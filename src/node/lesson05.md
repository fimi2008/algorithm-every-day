# 5-trie、桶排序、排序总结
## 前缀树
>1)单个字符串中，字符从前到后的加到-棵多叉树上
2)字符放在路上，节点上有专属的数据项(常见的是pass和end值)
3)所有样本都这样添加，如果没有路就新建，如有路就复用
4)沿途节点的pass值增加1，每个字符串结束时来到的节点end值增加1
可以完成前缀相关的查询 [案例](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day05/TrieTree.java)

## 不基于比较的排序
>桶排序思想下的排序:[计数排序](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day05/CountSort.java) & [基数排序](https://github.com/fimi2008/algorithm-every-day/blob/master/src/main/java/top/lionxxw/learn/algorithm/lesson/day05/RadixSort.java)
1)桶排,序思想下的排序都是不基于比较的排序
2)时间复杂度为O(N)，额外空间负载度O(M)
3)应用范围有限，需要样本的数据状况满足桶的划分


### 计数排序和基数排序
>1)一般来讲， 计数排序要求，样本是整数，且范围比较窄
2). -般来讲，基数排序要求，样本是10进制的正整数
-旦要求稍有升级，改写代价增加是显而易见的

## 排序算法的稳定性
>稳定性是指同样大小的样本再排序之后不会改变相对次序
对基础类型来说，稳定性毫无意义
对非基础类型来说，稳定性有重要意义
有些排序算法可以实现成稳定的，而有些排序算法无论如何都实现不成稳定的
