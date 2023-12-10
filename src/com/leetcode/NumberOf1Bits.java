package com.leetcode;

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int weight = 0;
        String binaryString = Integer.toBinaryString(n);
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                weight++;
            }
        }
        return weight;
    }

    public int hammingWeightWithBitwiseManipulation(int n) {
        int ones = 0;
        while (n != 0) {
            ones = ones + (n & 1);
            n = n >>> 1; // shifts n to the right by 1 bit and fills leftmost bit with 0
        }
        return ones;
    }

    public int hammingWeightWithBrianKernighanAlgo(int n) {
        int setBitCount = 0;
        while (n != 0) {
            n &= (n - 1); // to clear the right most set bit
            ++setBitCount;
        }
        return setBitCount;
    }

    public static void main(String[] args) {
        NumberOf1Bits obj = new NumberOf1Bits();
        int hammingWeight = obj.hammingWeight(11);
        System.out.println("hammingWeight " + hammingWeight);

        hammingWeight = obj.hammingWeight(128);
        System.out.println("hammingWeight " + hammingWeight);

        hammingWeight = obj.hammingWeight(-3);
        System.out.println("hammingWeight " + hammingWeight);
    }
}
