public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front;
    private int tail;
    private int size;

    public LoopQueue(int capacity) {
        //循环队列有一个元素不能用，用户传入8，需要维护一个长度为9的数组
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    /**
     * capacity代表的是可承载元素数量
     * data.length代表是数组的实际长度
     * size代表的是现在已经有多少个元素
     */
    public int getCapacity() {
        //返回的是数组长度-1，因为有一个元素不能用
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }


    @Override
    public void enqueue(E e) {
        //判断队列是否满的
        if ((tail + 1) % data.length == front) {
            resize(2 * getCapacity());
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }
        return data[front];
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            //i的偏移量为front
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder queueStr = new StringBuilder();
        queueStr.append(String.format("queue size=%d, capacity=%d  ", getSize(), getCapacity()));
        queueStr.append("front [");

        for (int i = front; i != tail; i = (i + 1) % data.length) {
            queueStr.append(data[i]);
            if (i != tail - 1) {
                queueStr.append(", ");
            }
        }



     /*   for (int i = 0; i < size; i++) {
            queueStr.append(data[(i + front) % data.length]);
            if (i != size - 1) {
                queueStr.append(", ");
            }
        }*/

        queueStr.append("] tail");
        return queueStr.toString();

    }
}
