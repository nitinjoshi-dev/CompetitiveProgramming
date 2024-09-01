package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/largest-rectangle-in-histogram/
//#MonotonicStack

/**
 * For each height, add it to the stack of height if the height is bigger than the previous height
 * If the height is smaller or equal than the previous height,
 * pop the stack until the height is smaller than the current height.
 * While popping, calculate the area of the rectangle with the popped height as the smallest height * number of popped up element.
 * Store the height with the number of popped up element in a separate stack.
 * Example:
 * heights = [1, 2, 1, 3]
 * push (height, # of popped up elements counter)
 * maxArea = max(maxArea, poppedUpElement * (popped))
 * push (1, 1) -> push (2, 1) -> pop (2, 1)(maxArea = 2*1) -> pop(1,1)(max area = 1 * ) -> push(1,3) -> push (3, 2)
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea2(int[] heights) {
        int maxArea = 0;
        Deque<Integer> heightStack = new ArrayDeque<>();
        Deque<Integer> popUpCounterStack = new ArrayDeque<>();

        for (int i = 0; i < heights.length; i++) {
            int popUpCounter = 0;
            while (!heightStack.isEmpty() && heightStack.peek() >= heights[i]) {
                popUpCounter += popUpCounterStack.pop();
                maxArea = Math.max(maxArea, heightStack.pop() * popUpCounter);
            }
            heightStack.push(heights[i]);
            popUpCounterStack.push(popUpCounter + 1);
        }

        int popUpCounter = 0;
        while (!heightStack.isEmpty()) {
            popUpCounter += popUpCounterStack.pop();
            maxArea = Math.max(maxArea, heightStack.pop() * popUpCounter);
        }

        return maxArea;
    }

    /**
     * Rather than using two stack, just keep one stack of position.
     * Stack contains left position of the rectangle.
     * If the height is bigger than the previous height, add it to the stack. As this is the left position of the rectangle starting from this position
     * If the height is smaller than the previous height, pop the calculate area. This position is the right of the rectangle.
     * Keep popping up unless the height in stack is smaller than the current height.
     *
     * Left position is current position for each rectangle.
     * Right position will come if there is an element which is smaller than current element or at the end of array length.
     *
     */
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Deque<Integer> s = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++){
            int h = (i == len ? 0 : heights[i]);
            if (s.isEmpty() || h >= heights[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram obj = new LargestRectangleInHistogram();
        System.out.println(obj.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(obj.largestRectangleArea(new int[]{2, 2, 5, 6, 2, 3}));
        System.out.println(obj.largestRectangleArea(new int[]{2, 4}));
        System.out.println(obj.largestRectangleArea(new int[]{2, 2}));
        System.out.println(obj.largestRectangleArea(new int[]{100, 1, 2, 1}));
    }
}
