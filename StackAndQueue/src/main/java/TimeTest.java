import java.util.Random;

public class TimeTest {
    public static void main(String[] args) {
        int count = 1000000;

        System.out.println(testQueue(new ArrayQueue<Integer>(), count));
        System.out.println(testQueue(new LoopQueue<Integer>(), count));
    }

    private static Double testQueue(Queue<Integer> queue, int count) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            queue.enqueue(new Random().nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < count; i++) {
            queue.dequeue();

        }

        long end = System.currentTimeMillis();
        return (end - start) / 1000.0;
    }
}
