package com.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://codeforces.com/problemset/problem/1734/D
public class SlimeEscape {

    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tok = new StringTokenizer("");
    private static java.io.OutputStream out = new java.io.BufferedOutputStream(System.out);


    private static String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    private static long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    public static void main(String[] args) throws Exception {
        int testCase = readInt();
        do {
            int n = readInt();
            int k = readInt() - 1;
            long []a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = readLong();
            }
            int left = k - 1;
            int right = k + 1;
            boolean isLeftValid = true, isRightValid = true;
            long leftSlimeHealth = a[k], rightSlimeHealth = a[k];
            String ans = "NO";
            while(true) {
                if (isLeftValid) {
                    if (left > -1) {
                        leftSlimeHealth += a[left--];
                        if (leftSlimeHealth < 0) {
                            isLeftValid = false;
                        }
                    } else {
                        ans = "YES";
                        break;
                    }
                }
                if (isRightValid) {
                    if (right < n) {
                        rightSlimeHealth += a[right++];
                        if (rightSlimeHealth < 0 ) {
                            isRightValid = false;
                        }
                    } else {
                        ans = "YES";
                        break;
                    }
                }
                if (!isLeftValid && !isRightValid) break;
            }
            out.write((ans + "\n").getBytes());
        } while (--testCase != 0);
        out.flush();
    }
}
