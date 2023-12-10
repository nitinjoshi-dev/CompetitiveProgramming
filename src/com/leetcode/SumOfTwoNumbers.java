package com.leetcode;

//https://leetcode.com/problems/sum-of-two-integers/
public class SumOfTwoNumbers {
    public int getSum(int a, int b) {
        if(b == 0) return a;
        int carry = (a & b) << 1;
        int sum = a ^ b;
        return getSum(sum, carry);
    }

    public static void main(String[] args) {
        SumOfTwoNumbers obj = new SumOfTwoNumbers();
        int sum = obj.getSum(2, 3);
        System.out.println("sum " + sum);

        sum = obj.getSum(-2, -3);
        System.out.println("sum " + sum);

        sum = obj.getSum(-2, 3);
        System.out.println("sum " + sum);

        sum = obj.getSum(2, 3);
        System.out.println("sum " + sum);
    }
}
