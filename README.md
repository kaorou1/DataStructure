# DataStructure
数据结构的学习记录

#### 有关for循环的一些小心得

```java
    //一共进行了index-1次循环操作
    for (int i = 0; i <= index; i++) {
        //do something
    }
    
    //这个用的多
    //一共进行了index次循环操作
    for (int i = 0; i < index; i++) {
        //do something
    }
    
    //不使用虚拟头结点的linkedlist
    //例如在给指定index插入元素e时，就是要在插入e完后，list.get(index) = e;
    //在链表实现时，需要获取到index的前一个节点
    prev = head;
    for (int i = 0; i < index - 1; i++) {
        prev = prev.next;
        //没开始循环前，prev指向index=0的节点（也就是head）
        //循环1次，prev指向index=1的节点
        //循环2次，prev指向index=2的节点
        //...
        //循环index-1次，prev指向index-1的节点，也就是index位置处的前一个节点
    }
```




#### 动态数组的时间复杂度分析

主要API

| 方法名                     | 简介                     | 时间复杂度 |
| -------------------------- | ------------------------ | ---------- |
| `void add(int index, E e)` | 指定索引添加元素         | O(n)       |
| `E remove(int index)`      | 指定索引删除元素         | O(n)       |
| `void set(int index, E e)` | 指定索引替换元素         | O(1)       |
| `int find(E e)`            | 查找数组中指定元素的索引 | O(n)       |
| `E get(int index) `        | 根据索引查找某个元素     | O(1)       |

**引起O(n)复杂度的原因是在增加和删除时要进行元素的移动，而不是resize引起的。**

对于resize()操作的均摊时间复杂度分析：

假设capacity = n，n+1次的addLast()，触发一次resize()，总共进行2n+1次基本操作。平均每次addLast()进行2次基本操作。

由于不会每次addLast()操作都会进行resize()，虽然resize()的时间复杂度为O(n)，但平摊到每次addLast()上，时间复杂度为O(1)。但要注意可能发生的复杂度震荡现象。

一般在size == capacity / 4时，才将capacity减半。可以消除复杂度震荡。

---------------

#### 栈

#### 数组队列与循环队列

主要API

| API                  | 简介         | 数组队列  | 循环队列  |
| -------------------- | ------------ | :-------- | --------- |
| `void enqueue(E e) ` | 入队         | O(1) 均摊 | O(1) 均摊 |
| `E dequeue()`        | 出队         | O(n)      | O(1) 均摊 |
| `E getFront()`       | 查看队首元素 | O(1)      | O(1)      |
| `int getSize()`      | 查看队列大小 | O(1)      | O(1)      |
| `boolean isEmpty()`  | 队列是否为空 | O(1)      | O(1)      |

**数组队列出队时，后面的所有元素都要向前移动一个位置，所以时间复杂度为O(n)** 