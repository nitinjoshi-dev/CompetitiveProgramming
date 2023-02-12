package com.leetcode;

//https://leetcode.com/problems/plus-one/
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int carry = 1;
        int sum;
        for (int i = digits.length - 1; i >= 0; i--) {
            sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }

        if(carry != 0) {
            int [] result = new int[digits.length + 1];
            result[0] = carry;
            for (int i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }
            return result;
        }
        return digits;
    }

    public static void main(String[] args) {
        PlusOne obj = new PlusOne();


        int[] digits = {1,2,3};
        int[] result = obj.plusOne(digits);
        printResult(result);

        int[] digits1 = {9,9,9};
        result = obj.plusOne(digits1);
        printResult(result);
    }

    private static void printResult(int[] result) {
        for (int digit : result) {
            System.out.print(digit);
        }
        System.out.println("----------------");
    }

}
