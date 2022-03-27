package com.practice;

public class FibonacciElement {
    public static void main(String[] args) {
        System.out.println(fibonacciElement(1, 1, 5));
    }

    static int fibonacciElement(int firstElement, int secondElement, int count) {
        if(count == 0) {
            return firstElement;
        }
        int sum = firstElement + secondElement;
        return fibonacciElement(sum, firstElement, count - 1);
    }
}
