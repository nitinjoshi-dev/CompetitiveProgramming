package com.codechef;

import java.util.Arrays;
import java.util.Stack;

//https://www.codechef.com/LRNDSA02/problems/CHFQUEUE
public class CodeChefCHFQUEUE {

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

    public static void main(String[] args) throws Exception {

        long ans = 1;
        int numberOfChefs = readInt();
        int numberOfSeniority = readInt();
        int []chefs = new int[numberOfChefs];
        for (int i = 0; i < numberOfChefs; i++) {
            chefs[i] = readInt();
        }
        Stack<Integer> minFront = new Stack<>();
        for(int i = numberOfChefs - 1 ; i> -1 ; i--) {
            while(!minFront.empty() && chefs[i]<=chefs[minFront.peek()]){
                minFront.pop();
            }
            if(!minFront.empty()) {
                ans = (ans * (minFront.peek() - i + 1)) % 1000000007;
            }
            minFront.push(i);
        }
        out.write((ans + "\n").getBytes());


        out.flush();
    }
}
