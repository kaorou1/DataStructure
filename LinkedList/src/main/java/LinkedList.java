public class LinkedList<E> {

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
     * 头节点
     */
    private Node head;

    private int size;

    /**
     * 无参构造
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表头添加元素e
     */
    public void addFirst(E e) {
        Node node = new Node(e);
        node.next = head;
        head = node;

        // 和下面的写法等价
        // head = new Node(e, head);

        size++;
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

        if (index == 0) {
            //因为头节点没有prev，特殊处理
            addFirst(e);
        } else {
            Node prev = head;
            //找到index的前一个节点
            for (int i = 0; i < index - 1; i++) {
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

    }

    public void addLast(E e) {
        add(e, size);
    }

}
