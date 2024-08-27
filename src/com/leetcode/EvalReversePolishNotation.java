package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
public class EvalReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Map<String, java.util.function.BiFunction<Integer, Integer, Integer>> operator = new HashMap<>(4);
        operator.put("+", (a, b) -> a + b);
        operator.put("-", (a, b) -> a - b);
        operator.put("*", (a, b) -> a * b);
        operator.put("/", (a, b) -> a / b);
        Deque<Integer> stack = new ArrayDeque<>(tokens.length);
        for (String token : tokens) {
            if (operator.containsKey(token)) {
                int secondElement = stack.pop();
                int firstElement = stack.pop();
                stack.push(operator.get(token).apply(firstElement, secondElement));
            } else stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        EvalReversePolishNotation obj = new EvalReversePolishNotation();
        System.out.println(obj.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(obj.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(obj.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
