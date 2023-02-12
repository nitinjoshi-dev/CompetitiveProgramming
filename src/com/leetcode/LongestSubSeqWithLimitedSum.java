package com.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

//https://leetcode.com/problems/longest-subsequence-with-limited-sum/
public class LongestSubSeqWithLimitedSum {


    public int[] answerQueries(int[] nums, int[] queries) {
        int[] result = new int[queries.length];
        Arrays.sort(nums);
        for (int i = 0; i < queries.length; i++) {
            int sum = 0;
            int size = 0;
            for (int num : nums) {
                if(sum + num > queries[i]) {
                    break;
                }
                size++;
                sum = sum + num;
            }
            result[i] = size;
        }
        return result;
    }

    public int[] answerQueriesBinarySearch(int[] nums, int[] queries) {
        int[] result = new int[queries.length];
        int[] sumArray = new int[nums.length];
        Arrays.sort(nums);
        sumArray[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sumArray[i] = sumArray[i - 1] + nums[i];
        }

        for (int i = 0; i < queries.length; i++) {
            result[i] = Math.abs(Arrays.binarySearch(sumArray, queries[i]) + 1);
        }
        return result;
    }


    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4,5,2,1);
        List<Integer> queries = Arrays.asList(3,10,21);

        LongestSubSeqWithLimitedSum obj = new LongestSubSeqWithLimitedSum();
        int[] result = obj.answerQueriesBinarySearch(nums.stream().mapToInt(i->i).toArray(), queries.stream().mapToInt(i->i).toArray());
        System.out.println("Result -----------------------");
        for (int size : result) {
            System.out.println(size);
        }

        nums = Arrays.asList(2,3,4,5);
        queries = Arrays.asList(1);
        result = obj.answerQueriesBinarySearch(nums.stream().mapToInt(i->i).toArray(), queries.stream().mapToInt(i->i).toArray());
        System.out.println("Result -----------------------");
        for (int size : result) {
            System.out.println(size);
        }
    }


}
