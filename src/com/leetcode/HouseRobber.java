package com.leetcode;

//https://leetcode.com/problems/house-robber/
public class HouseRobber {

    public int rob(int[] nums) {
        int max = nums[0];
        int[] moneyStash = new int[nums.length + 1];
        for(int i = 1; i < moneyStash.length; i++) {
            if(i < 3) {
                moneyStash[i] = nums[i - 1];
            } else {
                moneyStash[i] = nums[i - 1] + Math.max(moneyStash[i-2], moneyStash[i-3]);
            }

            if(moneyStash[i] > max) {
                max = moneyStash[i];
            }
        }

        return max;
    }

    public int rob2(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        return dp[nums.length];
    }

    public int rob3(int[] nums) {
        int prev = 0;
        int curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int next = Math.max(curr, prev + nums[i]);
            prev = curr;
            curr = next;
        }
        return curr;
    }

    public static void main(String[] args) {
        HouseRobber obj = new HouseRobber();

        int[] nums = new int[]{1,2,3,1};
        int ans = obj.rob(nums);
        System.out.println(ans);

        nums = new int[]{2,7,9,3,1};
        ans = obj.rob(nums);
        System.out.println(ans);

        nums = new int[]{2, 1, 2, 4, 2, 5};
        ans = obj.rob(nums);
        System.out.println(ans);

        nums = new int[]{2, 1};
        ans = obj.rob2(nums);
        System.out.println(ans);
    }
}
