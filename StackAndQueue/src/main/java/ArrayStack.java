public class ArrayStack<E> implements Stack<E> {

    private Array<E> array = new Array<>();

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 返回栈顶元素，但不删除元素
     * @return
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder stackString = new StringBuilder();
        stackString.append(String.format("Stack : size = %d ", array.getSize()));
        stackString.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            stackString.append(array.get(i));
            if (i != array.getSize() - 1) {
                stackString.append(", ");
            }
        }
        stackString.append("] top");
        return stackString.toString();
    }
}
