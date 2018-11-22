public class Array<E> {

    private E[] data;

    /**
     * 数组中存放了多少个值，而不是整个数组的长度
     * 同时也是数组中第一个空元素的index
     */
    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 在指定的Index处插入元素e
     */
    public void add(int index, E e) {
        //扩容操作
        if (size == data.length) {
            resize(2 * data.length);
        }

        if (index < 0 || index >size) {
            throw new IllegalArgumentException("the index is illegal, Require index >= 0 and index <= size.");
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = e;
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 移除指定index的元素，并返回该元素
     */
    public E remove(int index) {



        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("the index is illegal, Require index >= 0 and index < size.");
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i+1];
        }

        size--;
        data[size] = null;

        //注意放的位置，要在移除元素之后，size--
        //缩容操作, 采用lazy策略，防止复杂度震荡
        //data.length最小为2，否则缩容后会产生一个size为0的数组
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return data[index];
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 查找指定索引的元素
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("the index is illegal, Require index >= 0 and index < size.");
        }
        return data[index];

    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size-1);
    }

    /**
     * 将指定位置的元素设置为e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("the index is illegal, Require index >= 0 and index < size.");
        }
        data[index] = e;
    }

    /**
     * 查找指定元素第一个出现位置的下标，没有则返回-1
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找指定的元素e是否存在于数组
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 扩容方法
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder arrString = new StringBuilder();
        arrString.append(String.format("the array size = %d, capacity = %d\n",size, data.length));
        arrString.append('[');
        for (int i = 0; i < size; i++) {
            arrString.append(data[i]);
            if (i != size - 1) {
                arrString.append(", ");
            }
        }
        arrString.append(']');
        return arrString.toString();
    }
}
