package com.leetcode;

//https://leetcode.com/problems/string-to-integer-atoi/
public class StringToInteger {

    public int myAtoi(String s) {
        long ans = 0;
        s = s.trim();
        int mulFactor = 1;
        boolean isFirst = true;
        int min = (int) Math.pow(-2, 31);
        int max = (int) (Math.pow(2, 31) - 1);
        for(int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            if(digit >= 0 && digit <= 9 ) {
                isFirst = false;
                ans = ans * 10 + digit;
                if(mulFactor == 1 && ans > max) {
                    return max;
                }
                else if (mulFactor == -1 && ans * -1 < min) {
                    return min;
                }
            } else if(isFirst) {
                if(digit == '-' - '0') {
                    mulFactor = -1;
                    isFirst = false;
                } else if (digit == '+' - '0') {
                    isFirst = false;
                } else if(digit == ' ' - '0') {
                    continue;
                } else {
                    return (int)ans * mulFactor;
                }
            } else {
                return (int)ans * mulFactor;
            }
        }
        return (int)ans * mulFactor;
    }

    public static void main(String[] args) {
        StringToInteger obj = new StringToInteger();
        int num = obj.myAtoi("");
        System.out.println("Number " + num);

        num = obj.myAtoi("42");
        System.out.println("Number " + num);

        num = obj.myAtoi("-42");
        System.out.println("Number " + num);

        num = obj.myAtoi("     422 is 3 my number");
        System.out.println("Number " + num);

        num = obj.myAtoi("words and 987");
        System.out.println("Number " + num);

        num = obj.myAtoi("-91283472332");
        System.out.println("Number " + num);

        num = obj.myAtoi("+12");
        System.out.println("Number " + num);

        num = obj.myAtoi("+-12");
        System.out.println("Number " + num);

        num = obj.myAtoi("-+12");
        System.out.println("Number " + num);

    }

}
