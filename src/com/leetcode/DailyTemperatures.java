package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/daily-temperatures/description/
//#MonotonicStack
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length - 1; i++) {
            if (temperatures[i] < temperatures[i + 1]) {
                answer[i] = 1;
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i + 1]) {
                    answer[stack.peek()] = i + 1 - stack.pop();
                }
            } else {
                stack.push(i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        DailyTemperatures obj = new DailyTemperatures();
        int[] ans = obj.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        printArray(ans);
    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
