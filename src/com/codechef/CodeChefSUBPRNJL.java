package com.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.codechef.com/LRNDSA03/problems/SUBPRNJL
public class CodeChefSUBPRNJL {
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

    static class Frequency{
        int element;
        int position;

        public Frequency(int element, int position) {
            this.element = element;
            this.position = position;
        }
    }

    public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        int testCases = fastReader.nextInt();
        do {
            int numberOfElements = fastReader.nextInt();
            int k = fastReader.nextInt();
            int[] elements = new int[numberOfElements];
            for (int i = 0; i < numberOfElements; i++) {
                elements[i] = fastReader.nextInt();
            }
            TreeSet<Frequency> orderedSet = new TreeSet<>((o1, o2) -> {
                if(o1.element == o2.element) {
                    return o1.position - o2.position;
                }
                return o1.element - o2.element;
            });
            int numberOfBeautifulSubArray = 0;
            for (int i = 0; i < numberOfElements; i++) {
                Map<Integer, Integer> frequencyMap =  new HashMap<>(numberOfElements);
                for (int j = i + 1; j < numberOfElements; j++) {
                    int element = elements[j];
                    int m = (int) Math.ceil(k / j - 1 + 1);
                    int k1 = k - 1 / m;
                    frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
                    orderedSet.add(new Frequency(elements[j], j));
                }
//                    Frequency frequency = orderedSet.
            }

        } while (--testCases != 0);
    }
}
