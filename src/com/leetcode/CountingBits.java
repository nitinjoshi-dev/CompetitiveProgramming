package com.leetcode;

public class CountingBits {

    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bits[i] = hammingWeight(i);
        }
        return bits;
    }

    public int[] countBitsUsingDP(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i / 2];
            if (i % 2 == 1) bits[i]++;
        }
        return bits;
    }


    private int hammingWeight(int n) {
        int setBitCount = 0;
        while (n != 0) {
            n &= (n - 1); // to clear the right most set bit
            ++setBitCount;
        }
        return setBitCount;
    }

    public static void main(String[] args) {
        CountingBits obj = new CountingBits();
        int[] bits = obj.countBits(2);
        obj.print(bits);

        bits = obj.countBits(5);
        obj.print(bits);
    }

    public void print(int[] output) {
        for (int element : output) {
            System.out.print(element + ", ");
        }
        System.out.println();
    }
}
