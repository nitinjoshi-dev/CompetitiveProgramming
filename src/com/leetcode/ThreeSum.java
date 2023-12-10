package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/3sum/description/
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // avoid duplicates
            for (int j = i + 1, k = nums.length - 1; j < k;) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while((j< k) && nums[j] == nums[j-1]) j++; //avoid duplicates
                    while((j< k) && nums[k] == nums[k+1]) k--; // avoid duplicates
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ThreeSum obj = new ThreeSum();
        int [] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> ans = obj.threeSum(nums);
        printAns(ans);
    }

    private static void printAns(List<List<Integer>> ans) {
        for(List<Integer> list : ans) {
            for(Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

}
