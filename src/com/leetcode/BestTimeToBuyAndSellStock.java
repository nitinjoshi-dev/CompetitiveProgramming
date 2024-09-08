package com.leetcode;

import java.util.Stack;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//#SlidingWindow, #MonotonicStack
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        Stack<ProfitData> priceStack = new Stack<>();
        for(int price : prices) {
            int profitTillNow = 0;
            while(!priceStack.empty()) {
                ProfitData data = priceStack.peek();
                if(data.price > price) {
                    break;
                }
                priceStack.pop();
                if(profitTillNow < (data.priceTillNow + price - data.price)) {
                    profitTillNow = data.priceTillNow + price - data.price;
                }
            }
            if(profitTillNow > maxProfit) {
                maxProfit = profitTillNow;
            }
            priceStack.push(new ProfitData(price, profitTillNow));
        }

        return maxProfit;
    }

    class ProfitData {
        int price;
        int priceTillNow;

        public ProfitData(int price, int priceTillNow) {
            this.price = price;
            this.priceTillNow = priceTillNow;
        }
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock b = new BestTimeToBuyAndSellStock();
        int[] prices = {7,6, 4, 10, 7};
        System.out.println(b.maxProfit(prices));
    }

    //Simpler and better approach
    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        for (int p : prices) {
            min = Math.min(min, p);
            maxProfit = Math.max(maxProfit, p - min);
        }
        return maxProfit;
    }
}
