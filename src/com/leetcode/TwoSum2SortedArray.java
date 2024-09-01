package com.leetcode;

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
//#TwoPointer, #Array
public class TwoSum2SortedArray {
    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];
        int left = 0, right = numbers.length - 1;
        while(numbers[left] + numbers[right] != target) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) right--;
            else left++;
        }
        answer[0] = ++left;
        answer[1] = ++right;
        return answer;
    }

    public static void main(String[] args) {
        TwoSum2SortedArray obj = new TwoSum2SortedArray();
        int[] ans = obj.twoSum(new int[]{2, 7, 11, 15}, 9);
        printArray(ans);
        ans = obj.twoSum(new int[]{2,3,4}, 6);
        printArray(ans);
        ans = obj.twoSum(new int[]{-1,0}, -1);
        printArray(ans);
    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
