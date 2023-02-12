package com.leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];

        Map<Integer, Integer> complementMap = new HashMap<>(nums.length);

        for(int i = 0 ;i < nums.length; i++) {
            int diff = target - nums[i];
            if(complementMap.get(diff) == null) {
                complementMap.put(nums[i], i);
            } else {
                ans[0] = complementMap.get(diff);
                ans[1] = i;
                break;
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        TwoSum obj = new TwoSum();

        int[] nums = new int[]{2,7,11,15};
        int[] ans = obj.twoSum(nums, 9);
        System.out.println("Answer " + ans[0] + " " + ans[1]);

        nums = new int[]{3,2,4};
        ans = obj.twoSum(nums, 6);
        System.out.println("Answer " + ans[0] + " " + ans[1]);

        nums = new int[]{3,3};
        ans = obj.twoSum(nums, 6);
        System.out.println("Answer " + ans[0] + " " + ans[1]);
    }
}
