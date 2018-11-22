public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;
    //private int size;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        this(10);
    }
    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        /*if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        } 判断为空已经在数组中完成了*/
        //由于是数组实现，所以在移除队首元素后后面的元素都会向前移动一位。

        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder queueStr = new StringBuilder();
        queueStr.append(String.format("queue size=%d, capacity=%d  ", getSize(), getCapacity()));
        queueStr.append("front [");
        for (int i = 0; i < getSize(); i++) {
            queueStr.append(array.get(i));
            if (i != getSize()-1) {
                queueStr.append(", ");
            }

        }
        queueStr.append("] tail");
        return queueStr.toString();

    }
}
