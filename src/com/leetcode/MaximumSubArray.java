package com.leetcode;

//https://leetcode.com/problems/maximum-subarray/description/
public class MaximumSubArray {

    public int maxSubArray2(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i = 0; i < nums.length; i ++) {
            currentSum += nums[i];
            sum = Math.max(sum, currentSum);
            if(currentSum < 0) {
                currentSum = 0;
            }
        }
        return sum;
    }
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int previousSum = 0;
        for(int i = 0; i < nums.length; i ++) {
            previousSum = Math.max(previousSum + nums[i], nums[i]);
            max = Math.max(previousSum, max);
        }
        return max;
    }

    public int maxSubArraySlidingWindow(int[] nums) {
        int maxSum = nums[0];
        int l = 0, r = 1;
        int sum = nums[l];
        while(r < nums.length) {
            if(sum <= 0) {
                sum -= nums[l];
                l++;
            } else {
                sum += nums[r];
                r++;
            }
            if (l == r) {
                sum += nums[r];
                r++;
            }
            if(sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubArray maximumSubArray = new MaximumSubArray();
        int [] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int maxSum = maximumSubArray.maxSubArray(nums);
        System.out.println("MaxSum " + maxSum);

        nums = new int[]{1};
        maxSum = maximumSubArray.maxSubArray(nums);
        System.out.println("MaxSum " + maxSum);

        nums = new int[]{5,4,-1,7,8};
        maxSum = maximumSubArray.maxSubArray(nums);
        System.out.println("MaxSum " + maxSum);

        nums = new int[]{1,2,-1,-2,2,1,-2,1,4,-5,4};
        maxSum = maximumSubArray.maxSubArray(nums);
        System.out.println("MaxSum " + maxSum);
    }
}
