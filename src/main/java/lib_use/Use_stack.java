package lib_use;

import java.util.Stack;

public class Use_stack {
    public Use_stack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        print(stack);

        stack.pop();
        print(stack);

        System.out.println(stack.search(2)); // 以 1 为基数
    }
    private <T> void print(Stack<T> stack) {
        System.out.println();
        for (T item : stack) {
            System.out.printf("%d ", item);
        }
    }
}
