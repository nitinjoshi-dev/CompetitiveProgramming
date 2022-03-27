package com.codechef;

import java.util.Arrays;
//https://www.codechef.com/LRNDSA01/problems/ZCO14003
public class CodeChefZCO14003 {

    static java.io.BufferedInputStream in = new java.io.BufferedInputStream(System.in);
    static java.io.OutputStream out = new java.io.BufferedOutputStream(System.out);


    static int readInt() throws Exception {
        int no = 0;
        //boolean minus = false;
        int a = 10;
        while (a == 10 || a == 32)
            a = in.read();
        while (a != 10 && a != 32 && a != -1) {
            no = no * 10 + (a - '0');
            a = in.read();
            if (a == 13) {
                a = in.read();
            }
        }
        return no;
    }

    static long readLong() throws Exception {
        long no = 0;
        //boolean minus = false;
        int a = 10;
        while (a == 10 || a == 32)
            a = in.read();
        while (a != 10 && a != 32 && a != -1) {
            no = no * 10 + (a - '0');
            a = in.read();
            if (a == 13) {
                a = in.read();
            }
        }
        return no;
    }

    public static void main(String[] args) throws Exception {

        int numberOfPotentialCustomers = readInt();
        long[] customerBudgets = new long[numberOfPotentialCustomers];
        for (int customerNumber = 0; customerNumber < numberOfPotentialCustomers; customerNumber++) {
            customerBudgets[customerNumber] = readLong();
        }
        Arrays.sort(customerBudgets);
        long maxProfit = 0;
        for (int customerNumber = 0; customerNumber < numberOfPotentialCustomers; customerNumber++) {
           long profit = customerBudgets[customerNumber] * (numberOfPotentialCustomers - customerNumber);
           if(profit > maxProfit) {
               maxProfit = profit;
           }
        }
        out.write((maxProfit + "\n").getBytes());

        out.flush();
    }
}
