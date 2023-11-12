package com.leetcode;

//https://leetcode.com/problems/product-of-array-except-self/
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int curr = 1;
        result[0] = 1;

        //creating prefix product till previous element i.e. i - 1 not containing self
        for (int i = 0; i < n; i++) {
            result[i] = curr;
            curr *= nums[i];
        }
        curr = 1;
        //creating suffix product till previous element i.e. i + 1 not containing self
        for (int i = n - 1; i > -1; i--) {
            result[i] *= curr;
            curr *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
        int[] nums = new int[]{1, 2, 3, 4};
        int[] result = obj.productExceptSelf(nums);
        obj.printResult(result);
    }


    private void printResult(int[] result) {
        for (int digit : result) {
            System.out.print(digit + ", ");
        }
        System.out.println();
        System.out.println("----------------");
    }

}
