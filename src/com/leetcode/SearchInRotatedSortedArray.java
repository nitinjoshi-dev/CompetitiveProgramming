package com.leetcode;

import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int num = nums[mid];
            int lowNum = nums[low];
            int highNum = nums[high];
            if(num == target)
                return mid;
            else if (num < target) {
                if (lowNum <= num || target < lowNum) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (highNum >= num || target > highNum) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();

        List<Integer> elements = Arrays.asList(4,5,1,2,3);
        int elementToSearch = 3;
        int index = obj.search(elements.stream().mapToInt(i->i).toArray(), elementToSearch);
        System.out.println("Element " + elementToSearch + " is in index " + index);

        elementToSearch = 6;
        elements = Arrays.asList(4,6,1,2,3);
        index = obj.search(elements.stream().mapToInt(i->i).toArray(), elementToSearch);
        System.out.println("Element " + elementToSearch + " is in index " + index);

        elementToSearch = 1;
        elements = Arrays.asList(1,2,3,4,5);
        index = obj.search(elements.stream().mapToInt(i->i).toArray(), elementToSearch);
        System.out.println("Element " + elementToSearch + " is in index " + index);

        elementToSearch = 10;
        elements = Arrays.asList(4,5,1,2,3);
        index = obj.search(elements.stream().mapToInt(i->i).toArray(), elementToSearch);
        System.out.println("Element " + elementToSearch + " is in index " + index);

        elementToSearch = 0;
        elements = Arrays.asList(4,5,6,7,0,1,2);
        index = obj.search(elements.stream().mapToInt(i->i).toArray(), elementToSearch);
        System.out.println("Element " + elementToSearch + " is in index " + index);

        elementToSearch = 3;
        elements = Arrays.asList(4,5,6,7,0,1,2);
        index = obj.search(elements.stream().mapToInt(i->i).toArray(), elementToSearch);
        System.out.println("Element " + elementToSearch + " is in index " + index);

        elementToSearch = 8;
        elements = Arrays.asList(4,5,6,7,8,1,2,3);
        index = obj.search(elements.stream().mapToInt(i->i).toArray(), elementToSearch);
        System.out.println("Element " + elementToSearch + " is in index " + index);

        elementToSearch = 1;
        elements = Arrays.asList(5,1,2,3,4);
        index = obj.search(elements.stream().mapToInt(i->i).toArray(), elementToSearch);
        System.out.println("Element " + elementToSearch + " is in index " + index);
    }
}
