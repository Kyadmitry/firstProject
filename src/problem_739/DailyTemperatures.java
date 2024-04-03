package problem_739;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{13, 12, 15, 11, 9, 12, 16})));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<MyPair> stack = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek().value <= temperatures[i]) {
                stack.pop();
            }

            if (!stack.empty()) {
                result[i] = stack.peek().index - i;
            }
            stack.push(new MyPair(temperatures[i], i));
        }
        return result;
    }
}

class MyPair {
    int value;
    int index;

    MyPair(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
