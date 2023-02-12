package com.leetcode;

public class SubarrayGCD {

    public int subarrayGCD(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int gcd = nums[i];
            if(gcd == k) {
                count++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] < k) {
                    break;
                }
                gcd = gcd(nums[j], gcd);
                if (gcd == k)
                    count++;
            }
        }
        return count;
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        SubarrayGCD obj = new SubarrayGCD();

        System.out.println(obj.subarrayGCD(new int[]{9, 3, 1, 2, 6, 3}, 3));
        System.out.println(obj.subarrayGCD(new int[]{4}, 7));
        System.out.println(obj.subarrayGCD(new int[]{4, 8, 4, 3}, 4));


    }
}
