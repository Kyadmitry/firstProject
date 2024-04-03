package problem_20;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("(((([[[[]]]]))))"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();

        for (char ch: chars) {

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.empty()) {
                    return false;
                }
                if (stack.empty()) return false;
                char popped = stack.pop();
                if ((ch == ')' && popped != '(') ||
                        (ch == ']' && popped != '[') ||
                        (ch == '}' && popped != '{')) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
