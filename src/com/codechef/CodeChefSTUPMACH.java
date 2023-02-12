package com.codechef;

//https://www.codechef.com/LRNDSA02/problems/STUPMACH
public class CodeChefSTUPMACH {

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
        int testCase = readInt();
        do {
            int numberOfBoxes = readInt();
            long []capacities = new long[numberOfBoxes];
            long ans = 0;
            long minCapacity = Long.MAX_VALUE;
            int boxesWithMinValue = 0;
            for(int i = 0 ; i < numberOfBoxes; i++) {
                capacities[i] = readLong();
            }
            for(int i = 0 ; i < numberOfBoxes; i++) {
                long capacity = capacities[i];
                if(capacity < minCapacity) {
                    ans += (minCapacity * boxesWithMinValue);
                    minCapacity = capacity;
                    boxesWithMinValue = 1;
                } else {
                    boxesWithMinValue++;
                }
            }
            ans += minCapacity * boxesWithMinValue;
            out.write((ans + "\n").getBytes());
        }
        while (--testCase != 0);
        out.flush();
    }
}
