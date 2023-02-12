package com.leetcode;

import java.util.Stack;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class BestTimeToBuyAndSellStock2 {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock2 b = new BestTimeToBuyAndSellStock2();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(b.maxProfit(prices));
        int[] prices2 = {1,2,3,4,5};
        System.out.println(b.maxProfit(prices2));
        int[] prices3 = {7,6, 4, 3,1};
        System.out.println(b.maxProfit(prices3));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];
        int length = prices.length - 1;
        for (int i = 0; i < length; i++) {
            if(prices[i] > prices[i + 1]) {
                maxProfit += Math.max(prices[i] - buy, 0);
                buy = prices[i + 1];
            }
        }
        maxProfit += prices[length] - buy;
        return maxProfit;
    }
}
