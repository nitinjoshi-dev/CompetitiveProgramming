package com.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

//https://www.codechef.com/LRNDSA04/problems/STACKS
public class CodeChefSTACKS {

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
        int testCases = fastReader.nextInt();
        do {
            int numberOfElements = fastReader.nextInt();
            long []elements = new long[numberOfElements];
            for(int i =0 ; i < numberOfElements ; i++) {
                elements[i] = fastReader.nextLong();
            }
            TreeSet<Pair> treeSet = new TreeSet<>();
            for(int i =0 ; i < numberOfElements ; i++) {
                Long element = elements[i];
                Pair pair = new Pair(i, element);
                Pair topElement = treeSet.higher(pair);
                if(topElement != null) {
                    treeSet.remove(topElement);
                }
                treeSet.add(pair);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(treeSet.size() + " ");
            for(Pair pair : treeSet) {
                sb.append(pair.value + " ");
            }
            sb.append("\n");
            out.write(sb.toString().getBytes());
        } while (--testCases != 0);
        out.flush();
    }
}
