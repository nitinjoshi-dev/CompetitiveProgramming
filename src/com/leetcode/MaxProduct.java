package com.leetcode;

//https://leetcode.com/problems/maximum-product-subarray/description/
public class MaxProduct {

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        int previousProduct = 1;

        //prefix product
        for (int i = 0; i < n; i++) {
            previousProduct *= nums[i];
            max = Math.max(previousProduct, max);
            if (previousProduct == 0) {
                previousProduct = 1;
            }
        }
        previousProduct = 1;
        //suffix product
        for (int i = n - 1; i > -1; i--) {
            previousProduct *= nums[i];
            max = Math.max(previousProduct, max);
            if (previousProduct == 0) {
                previousProduct = 1;
            }
        }
        //We could have calculated prefix and suffix product in one loop

        return max;
    }

    public int maxProductDifferentApproach(int[] nums) {
        int r = nums[0];
        int n = nums.length;

        // imax/imin stores the max/min product of
        // subarray that ends with the current number A[i]
        for (int i = 1, imax = r, imin = r; i < n; i++) {
            // multiplied by a negative makes big number smaller, small number bigger
            // so we redefine the extremums by swapping them
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }

            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);

            // the newly computed max value is a candidate for our global result
            r = Math.max(r, imax);
        }
        return r;
    }


    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        int[] nums = new int[]{2, 3, -2, 4};
        int product = maxProduct.maxProduct(nums);
        System.out.println("MaxProduct " + product);

        nums = new int[]{1};
        product = maxProduct.maxProduct(nums);
        System.out.println("MaxProduct " + product);

        nums = new int[]{5, 4, -1, 7, 8};
        product = maxProduct.maxProduct(nums);
        System.out.println("MaxProduct " + product);

        nums = new int[]{1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4};
        product = maxProduct.maxProduct(nums);
        System.out.println("MaxProduct " + product);

        nums = new int[]{-2, -1, 0, 1};
        product = maxProduct.maxProduct(nums);
        System.out.println("MaxProduct " + product);

        nums = new int[]{3, -1, 4};
        product = maxProduct.maxProduct(nums);
        System.out.println("MaxProduct " + product);

        nums = new int[]{3, -1, 4, -2};
        product = maxProduct.maxProduct(nums);
        System.out.println("MaxProduct " + product);

        nums = new int[]{2, -5, -2, -4, 3};
        product = maxProduct.maxProduct(nums);
        System.out.println("MaxProduct " + product);

        nums = new int[]{2, -5, -2, -4, 3, 0, -1, 2};
        product = maxProduct.maxProductDifferentApproach(nums);
        System.out.println("MaxProduct " + product);
    }
}
