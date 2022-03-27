package com.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//https://www.codechef.com/LRNDSA04/problems/EURON
public class CodeChefEURON {

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

    static class Pair implements Comparable<Pair> {
        int position;
        long value;

        public Pair(int position, long value) {
            this.position = position;
            this.value = value;
        }
        @Override
        public int compareTo(Pair o) {
            if(this.value == o.value) {
                return this.position - o.position;
            }
            return (int) (this.value - o.value);
        }
    }

    public static void main(String[] args) throws Exception {
        FastReader fastReader = new FastReader();
        int numberOfElements = fastReader.nextInt();
        long ans = 0;
        List<Pair> elements = new ArrayList<>(numberOfElements);
        for (int i = 0; i < numberOfElements; i++) {
            long element = fastReader.nextLong();
            Pair pair = new Pair(i, element);
            int position = Collections.binarySearch(elements, pair);
            if(position < 0) {
                position = (-1 * position) - 1;
            }
            ans += i - position;
            elements.add(position, pair);
        }
        out.write((ans + "\n").getBytes());
        out.flush();
    }
}
