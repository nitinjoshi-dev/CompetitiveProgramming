package com.leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/contains-duplicate/
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> elements = new HashMap<>(nums.length);

        for(int element : nums) {
            if(elements.get(element) == null) {
                elements.put(element, true);
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate obj = new ContainsDuplicate();
        int [] nums = new int[]{1,2,3,4,5};
        boolean isDuplicatePresent = obj.containsDuplicate(nums);
    }
}
