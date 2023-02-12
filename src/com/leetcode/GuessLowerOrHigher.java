package com.leetcode;

//https://leetcode.com/problems/guess-number-higher-or-lower/
public class GuessLowerOrHigher {

    private int pickedNumber;

    public int guessNumber(int n) {
        int low = 1, high = n;
        int result = 1;
        while(low <= high) {
            result = low + ((high - low) / 2);
            int comparison = guess(result);
            if(comparison == 0)
                return result;
            if (comparison == -1) {
                high = result - 1;
            } else {
                low = result + 1;
            }
        }
        return result;
    }

    private int guess(int num) {
        if(num > pickedNumber)
            return -1;
        if(num < pickedNumber)
            return 1;
        return 0;

    }

    public static void main(String[] args) {
        GuessLowerOrHigher obj = new GuessLowerOrHigher();

        obj.pickedNumber = 6;
        System.out.println(obj.guessNumber(10));
        obj.pickedNumber = 1;
        System.out.println(obj.guessNumber(1));
        obj.pickedNumber = 1;
        System.out.println(obj.guessNumber(2));
        obj.pickedNumber = 10;
        System.out.println(obj.guessNumber(10));
        obj.pickedNumber = 2;
        System.out.println(obj.guessNumber(2));
    }
}
