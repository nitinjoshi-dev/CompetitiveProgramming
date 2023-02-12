package com.leetcode;

import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/search-insert-position/
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int num = nums[mid];
            if(num == target)
                return mid;
            if (num < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }

    public static void main(String[] args) {
        SearchInsertPosition obj = new SearchInsertPosition();

        List<Integer> nums = Arrays.asList(1,2,3,4,5);
        System.out.println(obj.searchInsert(nums.stream().mapToInt(i->i).toArray(), 5));

        nums = Arrays.asList(1,2,4,5);
        System.out.println(obj.searchInsert(nums.stream().mapToInt(i->i).toArray(), 3));
    }

}
