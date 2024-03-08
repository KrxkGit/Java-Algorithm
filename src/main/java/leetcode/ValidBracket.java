package leetcode;

import java.util.Stack;

public class ValidBracket {
    public ValidBracket() {
//        String s = "()";
        String s = "(]";
        System.out.println(isValid(s));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character character : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(character);
            } else {
                if (isLeft(character)) {
                    stack.push(character);
                } else {
                    Character wait_match = stack.pop();
                    if (!isMatched(character, wait_match)) {
                        return false;
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    protected boolean isMatched(Character characterAfter, Character characterBefore) {
        if (characterAfter == ')' && characterBefore == '(') {
            return true;
        } else if (characterAfter == ']' && characterBefore == '[') {
            return true;
        } else if (characterAfter == '}' && characterBefore == '{') {
            return true;
        } else {
            return false;
        }
    }
    protected boolean isLeft(Character character) {
        if (character == '(' || character == '[' || character == '{') {
            return true;
        } else {
            return false;
        }
    }
}
