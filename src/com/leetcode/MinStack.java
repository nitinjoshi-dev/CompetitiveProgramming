package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/min-stack/description/

/**
 * Along with inserting the actual data in stack, also store the min so far in stack
 * While popping up set the min to the min of the next element in stack
 *
 *
 * Other solution could be to store the min with modified value in stack like
 * push (2val - previous min) if val is new min.
 * while pop or top, return recent min if the value is less than min.
 * Why return min in case of top value is less than min is cause we store (2val - min) in stack
 * current val < previous min
 * current val - previous min < 0
 * 2val - previous min < val. Therefore, whenever stack top is less than min, we know that the value is min.
 * Also while popping, calculate previous min if current min is popped.
 *
*/
public class MinStack {

    class MinData {
        int min;
        int data;
        MinData(int data, int min) {
            this.data = data;
            this.min = min;
        }
    }

    private int min = Integer.MAX_VALUE;

    private Deque<MinData> stack;


    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        if(val < min) min = val;
        stack.push(new MinData(val, min));
    }

    public void pop() {
        stack.removeFirst();
        if (stack.isEmpty()) {
            min = Integer.MAX_VALUE;
            return;
        }
        min = stack.peek().min;
    }

    public int top() {
        return stack.getFirst().data;
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());

        obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-1);
        System.out.println(obj.getMin());
        System.out.println(obj.top());
        obj.pop();
        System.out.println(obj.getMin());
    }
}
