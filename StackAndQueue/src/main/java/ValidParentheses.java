import java.util.Stack;

/**
 * leetcode的题目，匹配括号
 */
public class ValidParentheses {


    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                //如果是右括号，先判断栈中是否为空，为空直接返回false
                if (stack.isEmpty()) {
                    return false;
                }

                //如果不为空，进行括号匹配
                if (c == ')' && stack.pop() != '(') {
                    return false;
                }

                if (c == '}' && stack.pop() != '{') {
                    return false;
                }

                if (c == ']' && stack.pop() != '[') {
                    return false;
                }
            }


        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("{{}}"));
        System.out.println(new ValidParentheses().isValid("{}[]"));
        System.out.println(new ValidParentheses().isValid("{{}[]"));

    }

}
