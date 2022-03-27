package com.leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/contains-duplicate-ii/
public class ContainsDuplicateTwo {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> elements = new HashMap<>(nums.length);

        for(int i =0; i< nums.length; i++) {
            int element = nums[i];
            if(elements.get(element) != null && i - elements.get(element) <= k) {
                return true;
            }
            elements.put(element, i);
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateTwo obj = new ContainsDuplicateTwo();
        int [] nums = new int[]{1,2,3,4,5};
        boolean isDuplicatePresent = obj.containsNearbyDuplicate(nums, 2);
    }
}
