package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class EvalRPN {
    enum Operator {
        Add,
        Sub,
        Multi,
        Div,
        Invalid;
    }
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new LinkedList<>();
        for (String s : tokens) {
            Operator operator = getOperator(s);
            if (operator == Operator.Invalid) { // 为操作数
                stack.push(s);
            } else { // 为操作符,出栈计算
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int res = doCalc(operator, b, a); // 注意 a, b 位置是互换的，这是逆波兰式表达 规则

                stack.push(String.valueOf(res));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    protected int doCalc(Operator operator, int a, int b) {
        switch (operator) {
            case Add -> {
                return a + b;
            }
            case Sub -> {
                return a - b;
            }
            case Multi -> {
                return a * b;
            }
            case Div -> {
                return a / b;
            }
            default -> {
                return -1;
            }
        }
    }

    protected Operator getOperator(String s) {
        switch (s) {
            case "+":
                return Operator.Add;
            case "-":
                return Operator.Sub;
            case "*":
                return Operator.Multi;
            case "/":
                return Operator.Div;
            default:
                return Operator.Invalid;
        }
    }
}
