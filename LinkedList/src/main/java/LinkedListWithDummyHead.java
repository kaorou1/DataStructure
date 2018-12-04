public class LinkedListWithDummyHead<E> {

    /**
     * 内部类：一个链表中的节点
     */
    private class Node {
        /**
         * 节点存储的数据
         */
        public E e;

        /**
         * 当前节点指向的下一个节点
         */
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * 虚拟头节点
     */
    private Node dummyHead;

    private int size;

    /**
     * 无参构造
     * 空的链表中需要一个虚拟头节点，存放null，指向原来的头节点。
     * 在没有元素的时候dummyHead指向null，也就是构造时
     * 在进行了一次add操作后dummyHead的next就有值了
     */
    public LinkedListWithDummyHead() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }



    /**
     * 向指定index位置插入元素e
     */
    public void add(E e, int index) {
        //index可以等于size，相当于给末尾添加元素
        //例如size=3，即index为 0 1 2
        //插入index=3, 即在插入后新元素的索引为3，即向末尾添加元素 0 1 2 3(新加的e)
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("input index is illegal");
        }

        /**
         * 加入了虚拟头节点后，就不需要对在头添加元素做特殊处理了
         * 但相应的在循环查找index-1的节点时要多一次了，因为起点比原来的推前了一个node
         */
        Node prev = dummyHead;
        //找到index的前一个节点,注意循环index次
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        //循环结束后，此时prev已经指向了index-1的节点

        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
        //与下面的写法等价
        //prev.next = new Node(e, prev.next);

        size++;
    }

    /**
     * 在链表头添加元素e
     */
    public void addFirst(E e) {
        add(e, 0);
    }

    /**
     * 在链表尾添加元素e
     */
    public void addLast(E e) {
        add(e, size);
    }

    /**
     * 获取指定index位置的元素
     */
    public E get(int index) {

        //不能等于size
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("input index is illegal");
        }

        //注意起始条件cur为dummyHead.next
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        //此时cur已经指向index位置的元素
        return cur.e;
    }

    /**
     * 获取链表头元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取链表尾元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改index位置处的元素
     */
    public void set(E e, int index) {
        //不能等于size
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("input index is illegal");
        }

        //注意起始条件cur为dummyHead.next
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        //此时cur已经指向index位置的元素
        cur.e = e;
    }

    /**
     * 查找链表中是否包含某个元素
     */
    public boolean contains(E e) {
//        Node cur = dummyHead.next;
//        while (cur != null) {
//            if (e.equals(cur.e)) {
//                return true;
//            }
//            cur = cur.next;
//        }
        //for循环的形式
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            if (e.equals(cur.e)) {
                return true;
            }
        }

        return false;
    }


    /**
     * 在指定Index位置删除元素并返回
     */
    public E del(int index) {

        //不能等于size，假设size为3，index只能取012
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("input index is illegal");
        }

        //需要找到待删除元素的前一个元素prev
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        //prev已经指向前一个元素

        Node delNode = prev.next;

        prev.next = delNode.next;
        delNode.next = null;

        size--;
        return delNode.e;
    }

    @Override
    public String toString() {

        StringBuilder linkedSrt = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            linkedSrt.append(cur.e);
            linkedSrt.append("——>");
            //开始忘了这个,会导致无限循环，直到溢出
            cur = cur.next;
        }
        linkedSrt.append("null");
        return linkedSrt.toString();
    }

}
