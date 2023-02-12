package com.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.codechef.com/LRNDSA03/problems/DPAIRS
public class CodeChefDPAIRS {

    static java.io.OutputStream out = new java.io.BufferedOutputStream(System.out);

    static class FastReader {
        final String del;
        private final BufferedReader input;
        private StringTokenizer tokenizer;

        public FastReader() {
            input = new BufferedReader(new InputStreamReader(System.in));
            del = " ";
        }

        public FastReader(String delimiter) {
            input = new BufferedReader(new InputStreamReader(System.in));
            del = delimiter;
        }

        public String next() {
            if (tokenizer == null || !tokenizer.hasMoreTokens())
                try {
                    tokenizer = new StringTokenizer(input.readLine(), del);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public char nextChar() {
            return next().charAt(0);
        }

        public String nextLine() {
            String res = null;
            try {
                res = input.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return res;
        }
    }

    public static void main(String[] args) throws Exception {
        FastReader fastReader = new FastReader();
        int n = fastReader.nextInt();
        int m = fastReader.nextInt();
        int []a = new int[n];
        int []b = new int[m];
        StringBuffer ans = new StringBuffer();
        for(int i = 0 ; i < n ; i ++) {
            a[i] = fastReader.nextInt();
        }
        for(int i = 0 ; i < m ; i ++) {
            b[i] = fastReader.nextInt();
        }
        int min = a[0], max = b[0];
        int minIndex = 0, maxIndex = 0;
        for(int i = 1 ; i < n ; i ++) {
            if(a[i] < min) {
                min = a[i];
                minIndex = i;
            }
        }
        for(int i = 1 ; i < m ; i ++) {
            if(b[i] > max) {
                max = b[i];
                maxIndex = i;
            }
        }

        for(int i = 0 ; i < m ; i ++) {
            ans.append(minIndex + " " + i + "\n");
        }
        for(int i = 0 ; i < n ; i ++) {
            if(i != minIndex) {
                ans.append(i + " " + maxIndex + "\n");
            }
        }
        out.write(ans.toString().getBytes());
        out.flush();
    }
}
