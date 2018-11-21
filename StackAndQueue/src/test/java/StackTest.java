public class StackTest {
    public static void main(String[] args) {

        Stack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);

            System.out.println(stack);
            if (i % 4 == 2) {
                stack.pop();
                System.out.println(stack);
            }

        }

    }
}
