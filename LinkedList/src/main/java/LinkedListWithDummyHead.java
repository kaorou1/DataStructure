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
        dummyHead = new Node();
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

    public void addLast(E e) {
        add(e, size);
    }

}
