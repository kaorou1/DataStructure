public class QueueTest {
    public static void main(String[] args) {

        Queue<Integer> arrayQueue = new ArrayQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);

            //2, 5, 8
            if (i % 3 == 2) {
                arrayQueue.dequeue();
                System.out.println(arrayQueue);
            }
        }


    }

}
