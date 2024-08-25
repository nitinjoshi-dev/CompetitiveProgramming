package com.leetcode;

import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Character> complimentaryMap = new HashMap<>(3);
        complimentaryMap.put('(', ')');
        complimentaryMap.put('[', ']');
        complimentaryMap.put('{', '}');
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (complimentaryMap.containsKey(c)) {
                stack.push(complimentaryMap.get(c));
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses obj = new ValidParentheses();
        System.out.println(obj.isValid("()"));
        System.out.println(obj.isValid("()[]{}"));
        System.out.println(obj.isValid("(]"));
        System.out.println(obj.isValid("([])"));
        System.out.println(obj.isValid("([)]"));
        System.out.println(obj.isValid("]"));
    }
}
