package com.leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/max-number-of-k-sum-pairs/
public class MaxKSumPairs {

    public int maxOperations(int[] nums, int k) {
        int numberOfOperations = 0;

        Map<Integer, Integer> complementMap = new HashMap<>(nums.length);
        for(int element : nums) {
            int diff = k - element;
            Integer complementCount = complementMap.get(diff);
            if(complementCount != null && complementCount > 0) {
                numberOfOperations++;
                complementMap.put(diff, complementCount - 1);
            } else {
                complementMap
                        .compute(element, (key, val) -> (val == null) ? 1 : val + 1);
            }
        }

        return numberOfOperations;
    }

    public static void main(String[] args) {
        MaxKSumPairs obj = new MaxKSumPairs();

        int[] nums = new int[]{1,2,3,4};
        int ans = obj.maxOperations(nums, 5);
        System.out.println("Ans " + ans);

        nums = new int[]{3,1,3,4,3};
        ans = obj.maxOperations(nums, 6);
        System.out.println("Ans " + ans);
    }
}
